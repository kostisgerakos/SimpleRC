package eu.including.simpleRC.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;


import eu.including.simpleRC.model.Mission;
import eu.including.simpleRC.model.Resource;
import eu.including.simpleRC.producers.GotoProducer;
import eu.including.simpleRC.producers.ManualTaskProducer;


public class SimpleRCConsumers {

  private List<SimpleRCTaskConsumer> partitionConsumers;

  public SimpleRCConsumers(final String brokers,String schemaRegistry, String groupId,String testbed, Mission mission,//final ArrayList<Pair<Integer,ArrayList<Triplet<Double,Double,Float>>>> coordinatesPerPartition, 
		  final Quartet<Boolean,Boolean,Double,Boolean> functions,final GotoProducer gotoProducer, final ManualTaskProducer manualTaskProducer) {

	
	int threadId = 0;  
	//Boolean[] stationsCheck = new Boolean[coordinatesPerPartition.size()]; 
	
	//Must make different thread tables for operators and other resources
	Boolean[] stationsCheck = new Boolean[mission.getResources().size()-1]; 
	Arrays.fill(stationsCheck, Boolean.FALSE);
	
    partitionConsumers = new ArrayList<>();
    //for (Pair<Integer, ArrayList<Triplet<Double, Double,Float>>> coordinatePerPartition : coordinatesPerPartition) {
    for (Resource resource:  mission.getResources()) {
    	if(resource.getResourceType().equals("Operator")) { 	
    	//threadId = resource.getPartition();
    	SimpleRCTaskConsumer ncThread =
          //new SimpleRCLocationConsumer(brokers,schemaRegistry, groupId, testbed, coordinatePerPartition.getValue0(), coordinatePerPartition.getValue1(), functions, gotoProducer, eventBus, threadId , stationsCheck);
    	  new SimpleRCTaskConsumer(brokers,schemaRegistry, groupId, testbed, resource.getResourceType(), resource.getPartition(), resource.getMissionParameters(), functions, manualTaskProducer, threadId , stationsCheck);
      partitionConsumers.add(ncThread);
      System.out.println("Started consumer with id:"+ threadId +" for partition" + resource.getPartition());
      threadId++;
    	}
    }
  }
 


public void execute() {
    for (SimpleRCTaskConsumer ncThread : partitionConsumers) {
      Thread t = new Thread(ncThread);
      t.start();
    }
  }
 
 
}