package Algorithms;

import java.util.ArrayList;

import Algorithms.DMLogic;
import Algorithms.OST;



public class TestOST implements DMLogic{
	
	OST ost = new OST(-26.1728,2.95569,-83.021 ,3.44657);

	int   changeIndex=0;

	ArrayList<Double> Z = new ArrayList<Double>(); //κραταει το log(f1/f2)
	ArrayList<Double> OS = new ArrayList<Double>(); //krataei to Gain function
	ArrayList<Integer> Change = new ArrayList<Integer>(); //change
	ArrayList<Double> CumSum = new ArrayList<Double>(); //change
	double sum=0.0;
	double b=100.0;
	boolean sendPermission = true;
	     
	int i = 0;
	
	public boolean getSendPermission(int q){
		if(q==0){// Disconnected
			resetGame();
			sendPermission = false;
			System.out.println(q + (sendPermission? "TRUE":"FALSE"));
			System.out.println("********************************");
			return sendPermission;
		}
		
		int C_INCREASE=10000; //ρυθμος αυξησης
		int C_DECREASE=-10000; //ρυθμος μειωσης to - ειναι οταν παμε σε κακο σημα
		
	    int result,OS_size;	    
	    double q0,q1,t;
 
	    q0=ost.f0 (q);
	    q1=ost.f1(q);
	    Z.add(Math.log((q0/q1)));
	    sum+=Math.log((q0/q1));
	    OS.add(sum);
	    	     
	    //  t=sum-OS.;
	    result=OST.minIndex(OS);
	    OS_size=OS.size();
	    	     
	    if(i>1)
	    {
	    	
	    	//prepei na ginei reset to game gia q==0.0
	    	 		
	    	if(Math.abs(OS.get(OS.size()-1))<(Math.abs(OS.get(OS.size()-2))+b))
	    	{
	    		Change.add(C_INCREASE);
	    	    result=OST.maxIndex(OS.subList(changeIndex, OS_size));
	    	    t=sum-OS.get(result);
	    	    
	    	    	 		
	    	    //C=[C C1];
	    	    // t=sum2-max(ST1(change:i));
	    	    }
	    	    else
	    	    {
	    	    	Change.add(C_DECREASE);
	    	    	result=OST.minIndex(OS.subList(changeIndex, OS_size));
	    	 		t=sum-OS.get(result);//TODO: does not get used, should it or it should get removed?
	    	    }
	    	CumSum.add(t);	
	    // grafoume se ena arxeio timew q,OS,Cumsume, 
	    	  //  if(Change.size()-changeIndex>2) {
	    	if(Change.size()-changeIndex>1) {
	    		int numb1,numb2;
	    	    	numb1=Change.get(Change.size()-2);
	    	    	numb2=Change.get(Change.size()-1);
		    	    if(numb1!=numb2)
		    	    {
		    	    	System.out.println(" ---------- Change Happened -------------");//+Change.get(Change.size()-1) +" "+Change.get(Change.size()-1));
		    	    	//TODO:clear arrays, need to reset sum? something else? maybe reset everything?
		    	   
		    	    	//grafoume se ena arxeio dedicated thesi change
		    	    	resetGame();
		    	    	i=-1;
		    	    	sendPermission = !sendPermission;
		    	    }
	    	    }
	    }

	    	 	//System.out.println(result+" "+OS.get(result));
	    	 //	System.out.println("Z="+Z.get(Z.size()-1));
	    	   
	    i++;	
	    System.out.println(q + (sendPermission? "TRUE":"FALSE"));
	   System.out.println(OS.size());
	    if(OS.size()>1)
	    { System.out.println(Math.abs(OS.get(OS.size()-1))+" / "+(Math.abs(OS.get(OS.size()-2))+b));

	    }  
	    if (Change.size()>1) {
			System.out.println(Change.get(Change.size()-1)+"/"+Change.get(Change.size()-2));
	    }
	 //   System.out.println( q +" : "+ "OS="+OS.get(OS.size()-1)+ " size "+ OS.size());
	    System.out.println("********************************");
	  
		return sendPermission;
	}
	
	void resetGame(){
		sum=0.0;
    	changeIndex=0;
		Z = new ArrayList<Double>();
    	OS = new ArrayList<Double>();
    	Change = new ArrayList<Integer>();
    	CumSum=new ArrayList<Double>();
    	i = 0;
	}
	
	
	
}

