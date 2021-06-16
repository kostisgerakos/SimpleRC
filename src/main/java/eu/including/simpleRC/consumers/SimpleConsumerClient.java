package eu.including.simpleRC.consumers;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.BasicConfigurator;

import eu.including.uxv.commands.TaskResult;



public class SimpleConsumerClient {
	
	private final String bootstrap = "tara.di.uoa.gr:9092";
	private final String schema_registry = "http://tara.di.uoa.gr:8081";
	private final String group = "RC_consumer_task";
	private final String avroTopic = "VE_Sim_Haidari_TaskResult";

	public static void main(String[] args) {
		
		//Uncomment for debug and info messages
		//BasicConfigurator.configure();
		
		final SimpleConsumerClient client = new SimpleConsumerClient();

		final Properties avroProps = new Properties();
		avroProps.put("bootstrap.servers", client.bootstrap);
		avroProps.put("enable.auto.commit", "false");
		avroProps.put("group.id", client.group);
		avroProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		avroProps.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		avroProps.put("schema.registry.url", client.schema_registry);
		avroProps.put("specific.avro.reader", "true");
		avroProps.put("auto.offset.reset", "latest");


		final KafkaConsumer<String, TaskResult> avroConsumer = new KafkaConsumer<>(avroProps);
		avroConsumer.subscribe(Arrays.asList(client.avroTopic));
		
		while (true) {
			ConsumerRecords<String, TaskResult> records = avroConsumer.poll(1000);
			for (ConsumerRecord<String, TaskResult> record : records) {
				System.out.println("MESSAGE RECEIVED: in partition: "+ record.partition() +" for message: " + record.value());
			}				
		}
	}
}
