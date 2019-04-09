package eu.rawfie.relocator.simpleRC;

import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import com.google.common.eventbus.EventBus;


import eu.rawfie.relocator.simpleRC.consumers.SimpleRCConsumers;
import eu.rawfie.relocator.simpleRC.producers.GotoProducer;

public class simpleRC {

	public static void main(String[] args) {
		
        EventBus eventBus = new EventBus();
		//static properties for now
		String brokers = "localhost:9092";
		String schemaRegistry = "http://localhost:8081";
		String groupId = "RelocateRC";
		String testbed = "testbed";
		
		GotoProducer gotoProducer = new GotoProducer(brokers, schemaRegistry, testbed + "_Goto");
		Triplet<Boolean,Boolean,Double> functions = new Triplet<Boolean,Boolean,Double>(true, false, 2.0); //boringMode,repeatingMode,acceptedDistance

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
		
		
		
		
		SimpleRCConsumers partitonConsumerGroup = new SimpleRCConsumers(brokers, schemaRegistry,
				groupId, testbed, coordinatedPerPartition,functions, gotoProducer, eventBus);
		partitonConsumerGroup.execute();
	}

}
