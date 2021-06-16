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


public class SimpleRCConsumers {

  private List<SimpleRCLocationConsumer> partitionConsumers;

  public SimpleRCConsumers(final String brokers,String schemaRegistry, String groupId,String testbed, Mission mission,//final ArrayList<Pair<Integer,ArrayList<Triplet<Double,Double,Float>>>> coordinatesPerPartition, 
		  final Quartet<Boolean,Boolean,Double,Boolean> functions,final GotoProducer gotoProducer) {

	
	int threadId = 0;  
	//Boolean[] stationsCheck = new Boolean[coordinatesPerPartition.size()]; 
	Boolean[] stationsCheck = new Boolean[mission.getResources().size()]; 
	Arrays.fill(stationsCheck, Boolean.FALSE);
	
    partitionConsumers = new ArrayList<>();
    //for (Pair<Integer, ArrayList<Triplet<Double, Double,Float>>> coordinatePerPartition : coordinatesPerPartition) {
    for (Resource resource:  mission.getResources()) {
    	SimpleRCLocationConsumer ncThread =
          //new SimpleRCLocationConsumer(brokers,schemaRegistry, groupId, testbed, coordinatePerPartition.getValue0(), coordinatePerPartition.getValue1(), functions, gotoProducer, eventBus, threadId , stationsCheck);
    	  new SimpleRCLocationConsumer(brokers,schemaRegistry, groupId, testbed, resource.getPartition(), resource.getMissionParameters(), functions, gotoProducer, threadId , stationsCheck);
      partitionConsumers.add(ncThread);
      System.out.println("Started consumer with id:"+ threadId +" for partition" + resource.getPartition());
      threadId++;
    }
  }
 


public void execute() {
    for (SimpleRCLocationConsumer ncThread : partitionConsumers) {
      Thread t = new Thread(ncThread);
      t.start();
    }
  }
 
 
}