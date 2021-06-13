package eu.including.relocator.simpleRC.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import com.google.common.eventbus.EventBus;

import eu.including.relocator.simpleRC.producers.GotoProducer;


public class SimpleRCConsumers {

  private List<SimpleRCLocationConsumer> partitionConsumers;

  public SimpleRCConsumers(final String brokers,String schemaRegistry, String groupId,String testbed, final ArrayList<Pair<Integer,ArrayList<Triplet<Double,Double,Float>>>> coordinatesPerPartition, 
		  final Quartet<Boolean,Boolean,Double,Boolean> functions,final GotoProducer gotoProducer ,final EventBus eventBus) {

	
	int threadId = 0;  
	Boolean[] stationsCheck = new Boolean[coordinatesPerPartition.size()]; 
	Arrays.fill(stationsCheck, Boolean.FALSE);
	
    partitionConsumers = new ArrayList<>();
    for (Pair<Integer, ArrayList<Triplet<Double, Double,Float>>> coordinatePerPartition : coordinatesPerPartition) {
    	SimpleRCLocationConsumer ncThread =
          new SimpleRCLocationConsumer(brokers,schemaRegistry, groupId, testbed, coordinatePerPartition.getValue0(), coordinatePerPartition.getValue1(), functions, gotoProducer, eventBus, threadId , stationsCheck);
      partitionConsumers.add(ncThread);
      System.out.println("Started consumer with id:"+ threadId +" for partition" + coordinatePerPartition.getValue0());
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