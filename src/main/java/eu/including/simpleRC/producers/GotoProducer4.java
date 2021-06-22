package eu.including.simpleRC.producers;


import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.BasicConfigurator;

import eu.including.uxv.Header;
import eu.including.uxv.commands.Goto;
import eu.including.uxv.commands.Location;
import eu.including.uxv.commands.ManualTask;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

public class GotoProducer4 {

	final static GotoProducer4 rtlProd = new GotoProducer4();
	final static Integer partition = 15; 
	public static void main(String[] args) throws InterruptedException, ExecutionException, FileNotFoundException {
		
		BasicConfigurator.configure();

		final Properties props = new Properties();
		props.put("bootstrap.servers", "tara.di.uoa.gr:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    props.put("schema.registry.url", "http://tara.di.uoa.gr:8081");
		final KafkaProducer<String,GenericRecord> producer = new KafkaProducer<String,GenericRecord>(props);
		

		
		Double lat = 37.96453635226926;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon =  23.611046257446716;//Math.toRadians(2.1643223535599345);
		String command ="Approach_incident_scene_search_ship_containers_and_secure_scene";
		
		Double lat2 = 37.96294802981784;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon2 =  23.609976967714136;//Math.toRadians(2.1643223535599345);
		String command2 ="Develop_decontamination_lines";
		
		Double lat3 = 37.96294802981784;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon3 =  23.61019920617388;//Math.toRadians(2.1643223535599345);
		String command3 ="";
		
		Double lat4 = 37.96307998390331;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon4 =  23.61039366482616;//Math.toRadians(2.1643223535599345);
		String command4 ="Approach_the_container";
		
		Double lat5 = 37.96303136924024;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon5 =  23.6105325638635;//Math.toRadians(2.1643223535599345);
		String command5 ="Enter_the_container_for_further_check";
		
		Double lat6 = 37.964577533844476;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon6 =  23.61110439614113;//Math.toRadians(2.1643223535599345);
		String command6 ="Activation_for_casualty_care_purposes";
		
		Double lat7 = 37.96451212781326;//Math.toRadians(41.80940313621358);0.6631501685058574,"longitude":0.4115732581134363
		Double lon7 =  23.61116737972674;//Math.toRadians(2.1643223535599345);
		String command7 ="End_of_exercise";
		
	
		
		String topic = "hmod_ManualTask";
		
		
		ManualTask task1 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),411,lat,lon,command);
		//ManualTask task2 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),21,lat2,lon2,command2);

		//ManualTask task3 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),31,lat3,lon3,command3);

		// ManualTask task4 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),41,lat4,lon4,command4);
		
		// ManualTask task5 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),51,lat5,lon5,command5);
		ManualTask task6 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),461,lat5,lon5,command5);
		ManualTask task7 = new ManualTask(new Header("Resource Controller","Planner",(long) 1551344229L),471,lat5,lon5,command5);


		//Goto go = new Goto(new Header("Resource Controller","Planner",(long) 1551344229L),new Location(lat,lon, 0.0f, 0.0, 0.0, 0.0, 0.0f, 0.0f), 2.0f, 3600.0f);
	
		ProducerRecord<String,GenericRecord> record = new ProducerRecord<String,GenericRecord>(topic,partition,"key", task7);



		producer.send(record);
		producer.flush();


		//producer.send(record10);

		
		producer.close();

	}

}