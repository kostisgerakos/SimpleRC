package eu.rawfie.relocator.simpleRC.producers;


import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import eu.rawfie.uxv.Header;
import eu.rawfie.uxv.commands.Goto;
import eu.rawfie.uxv.commands.Location;

public class GotoProducer {

	
	private String topic;
	//private Integer partition;
	private KafkaProducer producer;
	
	public GotoProducer(String brokers, String schemaRegistry, String topic) {
		
		this.topic = topic;
		//this.partition = partition;
		final Properties props = new Properties();
		props.put("bootstrap.servers", brokers);
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    props.put("schema.registry.url", schemaRegistry);
		this.producer = new KafkaProducer<>(props);

	}
	public void sendMessage(Double latitude,Double longitude, Float height, Integer partition){
		Goto goTo = new Goto(new Header("Resource Controller","Planner",(long) 10000000000L),new Location(latitude,longitude,height, 0.0, 0.0, 0.0, 0.0f, 0.0f), 2.0f, 3600.0f);
		ProducerRecord record = new ProducerRecord<>(topic,partition,"key", goTo);
		producer.send(record);
	}
}