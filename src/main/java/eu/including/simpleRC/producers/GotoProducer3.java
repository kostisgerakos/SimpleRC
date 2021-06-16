package eu.including.simpleRC.producers;


import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import eu.including.uxv.Header;
import eu.including.uxv.commands.Goto;
import eu.including.uxv.commands.Location;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

public class GotoProducer3 {

	final static GotoProducer3 rtlProd = new GotoProducer3();
	final static Integer partition = 2; 
	public static void main(String[] args) throws InterruptedException, ExecutionException, FileNotFoundException {
		final Properties props = new Properties();
		props.put("bootstrap.servers", "tara.di.uoa.gr:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    props.put("schema.registry.url", "http://tara.di.uoa.gr:8081");
		final KafkaProducer<String,GenericRecord> producer = new KafkaProducer<String,GenericRecord>(props);
		
		
		Double lat = 0.6631501685058574;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon =  0.4115732581134363;//Math.toRadians(2.1643223535599345);
		
		Double lat2 = 0.6631501685058574;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon2 =  0.4115732581134363;//Math.toRadians(2.1643223535599345);
		
		Double lat3 = 0.6631501685058574;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon3 =  0.4115732581134363;//Math.toRadians(2.1643223535599345);
		
		Double lat4 = 0.6631501685058574;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon4 =  0.4115732581134363;//Math.toRadians(2.1643223535599345);
		
		
		String topic = "VE_Sim_Haidari_Goto";
		
		Goto go = new Goto(new Header("Resource Controller","Planner",(long) 1551344229L),new Location(lat,lon, 0.0f, 0.0, 0.0, 0.0, 0.0f, 0.0f), 2.0f, 3600.0f);
	
		ProducerRecord<String,GenericRecord> record = new ProducerRecord<String,GenericRecord>(topic,partition,"key", go);



		producer.send(record);

		//producer.send(record10);

		
		producer.close();

	}

}