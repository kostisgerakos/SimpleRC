package eu.including.simpleRC.producers;


import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import eu.including.uxv.Header;
import eu.including.uxv.commands.Goto;
import eu.including.uxv.commands.Location;
import eu.including.uxv.commands.ManualTask;

public class ManualTaskProducer {

	
	private String topic;
	//private Integer partition;
	private KafkaProducer producer;
	
	public ManualTaskProducer(String brokers, String schemaRegistry, String topic) {
		
		this.topic = topic;
		//this.partition = partition;
		final Properties props = new Properties();
		props.put("bootstrap.servers", brokers);
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    props.put("schema.registry.url", schemaRegistry);
		this.producer = new KafkaProducer<>(props);

	}
	public void sendMessage(Double latitude,Double longitude, String task, Integer step, Integer partition){
		ManualTask manualTask = new ManualTask(new Header("Resource Controller","Planner",(long) 10000000000L), step, latitude, longitude, task);
		ProducerRecord record = new ProducerRecord<>(topic,partition,"key", manualTask);
		producer.send(record);
		producer.flush();

	}
	
	public void sendMessage(ManualTask manualTask, Integer partition){
		//ManualTask manualTask = new ManualTask(new Header("Resource Controller","Planner",(long) 10000000000L), step, latitude, longitude, task);
		ProducerRecord record = new ProducerRecord<>(topic,partition,"key", manualTask);
		producer.send(record);
		producer.flush();

	}
}