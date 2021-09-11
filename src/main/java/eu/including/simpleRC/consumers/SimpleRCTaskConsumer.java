package eu.including.simpleRC.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import eu.including.simpleRC.model.Goto;
import eu.including.simpleRC.model.MissionParameters;
import eu.including.simpleRC.model.Task;
import eu.including.simpleRC.model.TaskItems;
import eu.including.simpleRC.producers.GotoProducer;
import eu.including.simpleRC.producers.ManualTaskProducer;
import eu.including.uxv.Header;
import eu.including.uxv.Location;
import eu.including.uxv.commands.ManualTask;
import eu.including.uxv.commands.TaskResult;
import eu.including.uxv.commands.TaskResultType;

public class SimpleRCTaskConsumer implements Runnable,SimpleRCConsumersInterface {

	private final KafkaConsumer<String, TaskResult> consumer;
	private final String testbed;
	private final String resourceCategory;
	private final Integer partitionNumber;
	//private final ArrayList<Triplet<Double, Double, Float>> coordinates;
	List<MissionParameters> missionParameters;
	private final int threadId;
	private final Boolean[] stationsCheck;
	private final ManualTaskProducer manualTaskProducer;


	private boolean boringMode;
	private boolean repeatingMode;
	private final Double acceptedDistance;
	
	private int finalIndexNumber;

	public SimpleRCTaskConsumer(String brokers, String schemaRegistry, String groupId, String testbed,String resourceCategory, Integer partitionNumber, 
			//ArrayList<Triplet<Double, Double,Float>> coordinates, 
			List<MissionParameters> missionParameters,
			Quartet<Boolean,Boolean,Double,Boolean> functions, ManualTaskProducer manualTaskProducer, int threadId,
			Boolean[] stationsCheck) {
		Properties prop = createConsumerConfig(brokers, schemaRegistry, groupId);
		this.consumer = new KafkaConsumer<>(prop);
		this.testbed = testbed;
		this.resourceCategory = resourceCategory;
		this.partitionNumber = partitionNumber;
		//this.coordinates = coordinates;
		this.missionParameters = missionParameters;
		this.boringMode = functions.getValue0();
		this.repeatingMode = functions.getValue1();
		this.acceptedDistance = functions.getValue2();
		this.threadId = threadId;
		this.stationsCheck = stationsCheck;
		// this.gotoProducer = gotoProducer;
		
		//this.finalIndexNumber = coordinates.size()-1;
		this.finalIndexNumber = missionParameters.size()-1;
		
		this.manualTaskProducer = manualTaskProducer;
		TopicPartition partition = new TopicPartition(this.testbed + "_TaskResult", this.partitionNumber);
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
		Task task = missionParameters.get(index).getTask();
		Goto goTo = missionParameters.get(index).getGotoCommand();
		Integer producedStep = 11;
		
		if (task.getTaskItems().isEmpty()) {
			
			System.out.println("Entered");

			while (task.getTaskItems().isEmpty()) {
				// for sychronizing with other timesteps
				stationsCheck[threadId] = true;
				try {
					if (checkAll()) {
						while (stationsCheck[threadId] == true) {
							System.out.println("thread:" + threadId + " is waiting");
						}
					} else {
						Arrays.fill(stationsCheck, Boolean.FALSE);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Exited");

				index++;
				task = missionParameters.get(index).getTask();
				goTo = missionParameters.get(index).getGotoCommand();
				producedStep = producedStep + 10;
				System.out.println("Moving to next Timestep");
			}
		}
		
		if (!task.getTaskItems().isEmpty()) {
			
			int taskItemIndex = 0;
			
	/*		System.out.println(goTo.getLatitude());
			
			System.out.println("----");
			System.out.println(goTo.getLongitude());
			System.out.println("----");

			System.out.println( task.getTaskItems().get(taskItemIndex).getTaskMessage());
			System.out.println("----");*/

			
			ManualTask manualTask = new ManualTask(
					new Header("ResourceController", "rc", (long) System.currentTimeMillis() / 1000), producedStep,
					goTo.getLatitude(), goTo.getLongitude(), task.getTaskItems().get(taskItemIndex).getTaskMessage());
			manualTaskProducer.sendMessage(manualTask, this.partitionNumber);
			
			// if not operator

			while (true) {
				final ConsumerRecords<String, TaskResult> r = consumer.poll(1000);
				for (ConsumerRecord<String, TaskResult> rr : r) {

					TaskResultType result = rr.value().getResult();
					Integer consumedStep = rr.value().getStep();

					System.out.println("The task result is: " + result.toString());
					if ((result == TaskResultType.COMPLETED || result == TaskResultType.FAILED)
							&& consumedStep == producedStep && taskItemNotFinal(taskItemIndex,task.getTaskItems())) {
						
						System.out.println("Entered_1");

						
						taskItemIndex++;
						producedStep++;

						manualTask = new ManualTask(
								new Header("ResourceController", "rc", (long) System.currentTimeMillis() / 1000), producedStep,
								goTo.getLatitude(), goTo.getLongitude(), task.getTaskItems().get(taskItemIndex).getTaskMessage());
						
						manualTaskProducer.sendMessage(manualTask, this.partitionNumber);
						

					}
					else if ((result == TaskResultType.COMPLETED || result == TaskResultType.FAILED)
							&& consumedStep == producedStep){
						/*if (!boringMode) {

						} else {
							
						}*/
						
						System.out.println("Entered_2");
						Integer minusForStep = taskItemIndex;
						
						taskItemIndex = 0;
						
						index++;
						task = missionParameters.get(index).getTask();
						goTo = missionParameters.get(index).getGotoCommand();
						producedStep = (producedStep + 10) - minusForStep;
						System.out.println("Moving to next Timestep");
					
							/*stationsCheck[threadId] = true;
							try {
								if (checkAll()) {
									while (stationsCheck[threadId] == true) {
										System.out.println("thread:" + threadId + " is waiting");
									}
								} else {
									Arrays.fill(stationsCheck, Boolean.FALSE);
								}
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Exited");*/

							if (task.getTaskItems().isEmpty()) {
								
								System.out.println("Entered");

								while (task.getTaskItems().isEmpty()) {
									// for sychronizing with other timesteps
									stationsCheck[threadId] = true;
									try {
										if (checkAll()) {
											while (stationsCheck[threadId] == true) {
												System.out.println("thread:" + threadId + " is waiting");
											}
										} else {
											Arrays.fill(stationsCheck, Boolean.FALSE);
										}
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.out.println("Exited");

									index++;
									task = missionParameters.get(index).getTask();
									goTo = missionParameters.get(index).getGotoCommand();
									producedStep = producedStep + 10;
									System.out.println("Moving to next Timestep");
								}
							}
							
							if (!task.getTaskItems().isEmpty()) {
								stationsCheck[threadId] = true;
								try {
									if (checkAll()) {
										while (stationsCheck[threadId] == true) {
											System.out.println("the fuckity is " + stationsCheck.length);
											System.out.println("thread:" + threadId + " is waiting");
										}
									} else {
										Arrays.fill(stationsCheck, Boolean.FALSE);
									}
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("Exited");
								manualTask = new ManualTask(
										new Header("ResourceController", "rc", (long) System.currentTimeMillis() / 1000), producedStep,
										goTo.getLatitude(), goTo.getLongitude(), task.getTaskItems().get(taskItemIndex).getTaskMessage());

								manualTaskProducer.sendMessage(manualTask, this.partitionNumber);
							}
							
							/*manualTask = new ManualTask(
									new Header("ResourceController", "rc", (long) System.currentTimeMillis() / 1000), producedStep,
									goTo.getLatitude(), goTo.getLongitude(), task.getTaskItems().get(taskItemIndex).getTaskMessage());

							manualTaskProducer.sendMessage(manualTask, this.partitionNumber);
						*/
						
						
						
						/*stationsCheck[threadId] = true;
						try {
							if (checkAll()) {
								while (stationsCheck[threadId] == true) {
									System.out.println("thread:" + threadId + " is waiting");
								}
							} else {
								Arrays.fill(stationsCheck, Boolean.FALSE);
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						index++;
						task = missionParameters.get(index).getTask();
						goTo = missionParameters.get(index).getGotoCommand();
						producedStep = producedStep + 10;
						System.out.println("Moving to next Timestep_2 with index: "+ index + "and taskItemIndex " + taskItemIndex+ "with id"+ threadId);*/
						

					}
					
			/*		if (!task.getTaskItems().isEmpty()) {
						manualTask = new ManualTask(
								new Header("ResourceController", "rc", (long) System.currentTimeMillis() / 1000), producedStep,
								goTo.getLatitude(), goTo.getLongitude(), task.getTaskItems().get(taskItemIndex).getTaskMessage());

						manualTaskProducer.sendMessage(manualTask, this.partitionNumber);}
					else {
						index++;
						task = missionParameters.get(index).getTask();
						goTo = missionParameters.get(index).getGotoCommand();
						producedStep = producedStep + 10;
						System.out.println("Moving to next Timestep_2 with index: "+ index + "and taskItemIndex " + taskItemIndex+ "with id"+ threadId);
					}*/

				}
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
	
	private boolean taskItemNotFinal(int index,List<TaskItems> taskItems) {
		if (index == taskItems.size() - 1) {
			return false;
		}
		return true;
	}
	

/*	private boolean coordinatesNotFinal(int index) {
		if (index == coordinates.size() - 1) {
			return false;
		}
		return true;
	}*/
	
	public static Float convertToFloat(Double doubleValue) {
	    return doubleValue == null ? null : doubleValue.floatValue();
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