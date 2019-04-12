package eu.rawfie.relocator.simpleRC.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.javatuples.Triplet;

import com.google.common.eventbus.EventBus;

import eu.rawfie.relocator.simpleRC.producers.GotoProducer;
import eu.rawfie.uxv.Location;

public class SimpleRCLocationConsumer implements Runnable {

	private final KafkaConsumer<String, Location> consumer;
	private final String testbed;
	private final int partitionNumber;
	private final ArrayList<Triplet<Double, Double, Float>> coordinates;
	private final EventBus eventBus;
	private final int threadId;
	private final Boolean[] stationsCheck;
	private final GotoProducer gotoProducer;

	private boolean boringMode;
	private boolean repeatingMode;
	private final Double acceptedDistance;
	
	private int finalIndexNumber;

	public SimpleRCLocationConsumer(String brokers, String schemaRegistry, String groupId, String testbed,
			Integer partitionNumber, ArrayList<Triplet<Double, Double,Float>> coordinates, Triplet<Boolean,Boolean,Double> functions, GotoProducer gotoProducer, EventBus eventBus, int threadId,
			Boolean[] stationsCheck) {
		Properties prop = createConsumerConfig(brokers, schemaRegistry, groupId);
		this.consumer = new KafkaConsumer<>(prop);
		this.testbed = testbed;
		this.partitionNumber = partitionNumber;
		this.coordinates = coordinates;
		this.boringMode = functions.getValue0();
		this.repeatingMode = functions.getValue1();
		this.acceptedDistance = functions.getValue2();
		this.eventBus = eventBus;
		this.threadId = threadId;
		this.stationsCheck = stationsCheck;
		// this.gotoProducer = gotoProducer;
		this.finalIndexNumber = coordinates.size()-1;
		
		this.gotoProducer = gotoProducer;
		TopicPartition partition = new TopicPartition(this.testbed + "_Location", this.partitionNumber);
		consumer.assign(Arrays.asList(partition));
	}

	private static Properties createConsumerConfig(String brokers, String schemaRegistry, String groupId) {
		Properties props = new Properties();
		props.put("bootstrap.servers", brokers);
		props.put("enable.auto.commit", "false");
		props.put("group.id", groupId);
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", schemaRegistry);
		props.put("specific.avro.reader", "true");
		props.put("auto.offset.reset", "latest");

		return props;
	}

	@Override
	public void run() {
		int index = 0;
		// sending first
		gotoProducer.sendMessage(coordinates.get(index).getValue0(), coordinates.get(index).getValue1(),coordinates.get(index).getValue2(),partitionNumber);

			while (true) {
			final ConsumerRecords<String, Location> r = consumer.poll(1000);
			for (ConsumerRecord<String, Location> rr : r) {

				double lat1 = coordinates.get(index).getValue0() * (180 / 3.14);
				double long1 = coordinates.get(index).getValue1() * (180 / 3.14);
				double lat2 = rr.value().getLatitude() * (180 / 3.14);
				double long2 = rr.value().getLongitude() * (180 / 3.14);

				System.out.println("The distance is: " + distance(lat1, long1, lat2, long2));
				if (distance(lat1, long1, lat2, long2) <= acceptedDistance && coordinatesNotFinal(index)) {
					if (!boringMode) {
						index++;
						gotoProducer.sendMessage(coordinates.get(index).getValue0(), coordinates.get(index).getValue1(),
								coordinates.get(index).getValue2(),partitionNumber);
						System.out.println("Sending Goto to" + coordinates.get(index).getValue0() + ","
								+ coordinates.get(index).getValue1());
					} else {
						stationsCheck[threadId] = true;
						try {
							if (checkAll()) {
								while (stationsCheck[threadId] == true) {
									System.out.println("thread:" + threadId + " is waiting");
								}
							} else {
								Arrays.fill(stationsCheck, Boolean.FALSE);
							}
							System.out.println("Sending Goto to" + coordinates.get(index).getValue0() + ","
									+ coordinates.get(index).getValue1());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						index++;
						gotoProducer.sendMessage(coordinates.get(index).getValue0(), coordinates.get(index).getValue1(),
								coordinates.get(index).getValue2(),partitionNumber);
						System.out.println("Sending Goto to" + coordinates.get(index).getValue0() + ","
								+ coordinates.get(index).getValue1());
					}
				}

				else if (distance(lat1, long1, lat2, long2) <= acceptedDistance && !coordinatesNotFinal(index) && repeatingMode) {
					index = 0;
					gotoProducer.sendMessage(coordinates.get(index).getValue0(), coordinates.get(index).getValue1(),
							coordinates.get(index).getValue2(),partitionNumber);
					System.out.println("repeating cycle");
					System.out.println("Sending Goto to" + coordinates.get(index).getValue0() + ","
							+ coordinates.get(index).getValue1());

				}
				// eventBus.post(rr.toString());
				// System.out.println(rr.value() + ", by partition: " + rr.partition());
			}
		}

	}

	public synchronized boolean checkAll() throws InterruptedException {
		if (Arrays.asList(stationsCheck).contains(false)) {
			return true;
		} else {
			return false;
		}
		// notifyAll() for multiple producer/consumer threads
	}

	private boolean coordinatesNotFinal(int index) {
		if (index == coordinates.size() - 1) {
			return false;
		}
		return true;
	}

	// Pythagorean for small distances
	public static double distance(double lat1, double long1, double lat2, double long2) {
		double a = (lat1 - lat2) * distPerLat(lat1);
		double b = (long1 - long2) * distPerLng(lat1);
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	private static double distPerLng(double lat) {
		return 0.0003121092 * Math.pow(lat, 4) + 0.0101182384 * Math.pow(lat, 3) - 17.2385140059 * lat * lat
				+ 5.5485277537 * lat + 111301.967182595;
	}

	private static double distPerLat(double lat) {
		return -0.000000487305676 * Math.pow(lat, 4) - 0.0033668574 * Math.pow(lat, 3) + 0.4601181791 * lat * lat
				- 1.4558127346 * lat + 110579.25662316;
	}

	// Havershine for long distances
	public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

		final int R = 6371; // Radius of the earth
		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters
		double height = el1 - el2;
		distance = Math.pow(distance, 2) + Math.pow(height, 2);
		return Math.sqrt(distance);
	}

}