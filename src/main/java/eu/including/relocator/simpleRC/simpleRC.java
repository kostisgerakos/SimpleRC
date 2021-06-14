package eu.including.relocator.simpleRC;

import java.io.IOException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;

import eu.including.json.DdlScript;
import eu.including.relocator.simpleRC.consumers.SimpleRCConsumers;
import eu.including.relocator.simpleRC.producers.GotoProducer;

public class simpleRC {

	public static void main(String[] args) {
		
		String json = "{\"data\":[{\"location\":[{\"timestep\":0.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.657844,38.017445,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.657548957008363,38.01951030094147,31.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6561327506485,38.01806190807343,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65783863558197,38.02020767528534,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.661186032432557,38.01698902446747,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.661186032432557,38.01698902446747,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.661186032432557,38.01698902446747,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.661186032432557,38.01698902446747,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662258916038514,38.020400794334414,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662258916038514,38.020400794334414,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662258916038514,38.020400794334414,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662258916038514,38.020400794334414,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662258916038514,38.020400794334414,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"sensor1;1\"},{\"sensorsActDeact\":\"sensor2;1\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[{\"command\":\"a1_Message\",\"duration\":2},{\"command\":\"v3_Message\",\"duration\":3},{\"command\":\"g5_Message\",\"duration\":7}],[{\"command\":\"a1_Message\",\"duration\":2},{\"command\":\"v3_Message\",\"duration\":3},{\"command\":\"g5_Message\",\"duration\":7}],[{\"command\":\"a1_Message\",\"duration\":2},{\"command\":\"v3_Message\",\"duration\":3},{\"command\":\"g5_Message\",\"duration\":7}],[{\"command\":\"a1_Message\",\"duration\":2},{\"command\":\"v3_Message\",\"duration\":3},{\"command\":\"g5_Message\",\"duration\":7}],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":1.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.657844,38.017445,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.657688431877137,38.01873782474518,31.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.656175665992738,38.01676371891022,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65783863558197,38.02020767528534,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662666611808778,38.016602786369326,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662666611808778,38.016602786369326,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662666611808778,38.016602786369326,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.662666611808778,38.016602786369326,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66181903376007,38.01927426654816,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66181903376007,38.01927426654816,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66181903376007,38.01927426654816,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66181903376007,38.01927426654816,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66181903376007,38.01927426654816,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":2.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.657844,38.017445,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65834289087677,38.018147738761904,31.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65909390940094,38.015862496681216,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65783863558197,38.02020767528534,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664039902824403,38.01667788822174,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664039902824403,38.01667788822174,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664039902824403,38.01667788822174,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664039902824403,38.01667788822174,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":3.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.657844,38.017445,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65931921495819,38.0176971276474,31.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.660177521842957,38.01577666599274,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65783863558197,38.02020767528534,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.665434651512147,38.018115552253725,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.665434651512147,38.018115552253725,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.665434651512147,38.018115552253725,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.665434651512147,38.018115552253725,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"sensor1;0\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":4.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.657844,38.017445,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65931921495819,38.0176971276474,31.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.660177521842957,38.01577666599274,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.65783863558197,38.02020767528534,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664436869758607,38.019113334007265,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664436869758607,38.019113334007265,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664436869758607,38.019113334007265,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.664436869758607,38.019113334007265,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.66132550730133,38.018137009925844,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"sensor2;1\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[],[{\"command\":\"G3_Message\",\"duration\":2}],[{\"command\":\"G3_Message\",\"duration\":2}],[{\"command\":\"G3_Message\",\"duration\":2}],[{\"command\":\"G3_Message\",\"duration\":2}],[{\"command\":\"G3_Message\",\"duration\":2}]]}]}],\"nodeNames\":[{\"nodeName\":\"sensor1\"},{\"nodeName\":\"sensor2\"},{\"nodeName\":\"operators1\"},{\"nodeName\":\"Backpacks\"},{\"nodeName\":\"operators4\"},{\"nodeName\":\"operators2\"},{\"nodeName\":\"operators3\"},{\"nodeName\":\"operators5\"},{\"nodeName\":\"operators1\"},{\"nodeName\":\"operators2\"},{\"nodeName\":\"operators3\"},{\"nodeName\":\"operators4\"},{\"nodeName\":\"operators5\"}],\"Area\":\"Haidari_geofence_area\"}";
		
		ObjectMapper objectMapper = new ObjectMapper();

		try {
		    DdlScript script = objectMapper.readValue(json, DdlScript.class);

		    System.out.println("area = " + script.getArea());
		    //for first json inside location
		    System.out.println(script.getData().get(0).getLocation().get(0).getTimestep());
		    //for second json inside location
		    System.out.println(script.getData().get(0).getLocation().get(1).getTasks().get(5).get(0).getCommand());
		} catch (IOException e) {
		    e.printStackTrace();
		}
		/*
        EventBus eventBus = new EventBus();
		//static properties for now
		String brokers = "localhost:9092";
		String schemaRegistry = "http://localhost:8081";
		String groupId = "RelocateRC";
		String testbed = "testbed";
		
		//operations
		Boolean boringMode = true;
		Boolean repeatingMode = false;
		Double acceptedDistance = 2.0;
		Boolean indoor = true;
		
		GotoProducer gotoProducer = new GotoProducer(brokers, schemaRegistry, testbed + "_Goto");
		Quartet<Boolean,Boolean,Double,Boolean> functions = new Quartet<Boolean,Boolean,Double,Boolean>(boringMode, repeatingMode, acceptedDistance, indoor); //boringMode,repeatingMode,acceptedDistance,indoor

		Integer partition1 = 1;
		Integer partition2 = 2;
	

		ArrayList<Triplet<Double,Double,Float>> coordinates1 =new ArrayList<Triplet<Double,Double,Float>>();
		ArrayList<Triplet<Double,Double,Float>> coordinates2 =new ArrayList<Triplet<Double,Double,Float>>();

		
		coordinates1.add(Triplet.with(Math.toRadians(37.99562583619493),Math.toRadians(23.58124716716269),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.9957996252333),Math.toRadians(23.581488293512365),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.995816561350345),Math.toRadians(23.581043608392527),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.995816561272555),Math.toRadians(23.58102755601206),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.99579538621159),Math.toRadians(23.58055076646017),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.995765741402295),Math.toRadians(23.580143537624313),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.99567239905363),Math.toRadians(23.57969350446044),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.99554528673035),Math.toRadians(23.580298942116794),50.0f));
		coordinates1.add(Triplet.with(Math.toRadians(37.99553249799149),Math.toRadians(23.58078643191118),50.0f));
		
		coordinates2.add(Triplet.with(Math.toRadians(37.99562583619493),Math.toRadians(23.58124716716269),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.9957996252333),Math.toRadians(23.581488293512365),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.995816561350345),Math.toRadians(23.581043608392527),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.995816561272555),Math.toRadians(23.58102755601206),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.99579538621159),Math.toRadians(23.58055076646017),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.995765741402295),Math.toRadians(23.580143537624313),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.99567239905363),Math.toRadians(23.57969350446044),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.99554528673035),Math.toRadians(23.580298942116794),70.0f));
		coordinates2.add(Triplet.with(Math.toRadians(37.99553249799149),Math.toRadians(23.58078643191118),70.0f));

	
		ArrayList<Pair<Integer,ArrayList<Triplet<Double,Double,Float>>>> coordinatedPerPartition =new ArrayList<Pair<Integer,ArrayList<Triplet<Double,Double,Float>>>>();
		coordinatedPerPartition.add(Pair.with(partition1, coordinates1));
	    coordinatedPerPartition.add(Pair.with(partition2, coordinates2));
		
		
		
		
		SimpleRCConsumers partitonConsumerGroup = new SimpleRCConsumers(brokers, schemaRegistry,groupId, testbed, coordinatedPerPartition,functions, gotoProducer, eventBus);
		partitonConsumerGroup.execute();*/
	}

}
