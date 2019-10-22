package logic;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;



public class LDS_all {
	
	public static int badcounter;
	public static double thesh;
	public static int change;
	public  static double x_star;
	public static boolean stopped;
	public static double position_stopped;
	public static boolean active;
	public static double sum=0.0;
	public static double t;
	public static int r_star;
	
	
	public LDS_all(int badcounter, double thesh, int change, double x_star, boolean stopped, double position_stopped,
			boolean active, double sum, double t, int r_star) {
		super();
		this.badcounter = badcounter;
		this.thesh = thesh;
		this.change = change;
		this.x_star = x_star;
		this.stopped = stopped;
		this.position_stopped = position_stopped;
		this.active = active;
		this.sum = sum;
		this.t = t;
		this.r_star = r_star;
	}


	public static void main(String[] args) {
		
	//	double thesh=1.0;
		ArrayList<Double> L1 = new ArrayList<Double>(); //κραταει το log(f1/f2)
		ArrayList<Double> ST1 = new ArrayList<Double>(); //krataei to Gain function
		ArrayList<Double> ST3 = new ArrayList<Double>(); //krataei to Gain function
		ArrayList<Boolean> C = new ArrayList<Boolean>(); //change
		ArrayList<Integer> index = new ArrayList<Integer>(); //change

		int CLUSTERS=60;
		ArrayList<Integer> changes = new ArrayList<Integer>(); //change
	
	
	
		
		WifiQualityReader reader = new FileWifiReader();
		double[] q= new double[500];
		int i;
	
		
		
		
		LDS_all LDS=new LDS_all(0, 1.0, 0, 0.0, false, -1.0,true, 0.0, 0.0, 0);
		
		
		for(i=0;i<500;i++)
			q[i]=reader.getWifiQuality();
		
		double[] Os;
		Os=LDS_ost(CLUSTERS,10);
		r_star=arrayMin(Os);
		System.out.println(r_star);
		i=0;
	//	double[] result=new double[3]; //f
	
		boolean r;
		while(i<q.length)
		{
			
			r=DecisionMake(i,  q[i], L1, ST1 ,ST3,changes, C, index , Os);
			System.out.println(r);
//			if(r==false)
//			{
//				if (stopped=false)
//					System.out.println("+++++++++++++++Wake up+++++++++++++++++++++++++++");
//				else
//					System.out.println("-----------------------Sleeeeppppppp--------------");
//			}
				
				
			
			i=i+1;
		}
		
		for (int l=0;l<index.size();l++)
		{
			System.out.println("change : "+index.get(l));
		}
		System.out.println(index.size());
	}
	
	
	public static boolean DecisionMake(int round, double q_i, ArrayList<Double> L1,ArrayList<Double> ST1 ,
			ArrayList<Double> ST3,ArrayList<Integer> changes,ArrayList<Boolean> C,ArrayList<Integer> index ,double[] Os)
	{
		double q_curr,n,L, f0q,f0temp,f1q,f1temp;; //insert
		
		double m0=81.5669;
		double s0=10.3309;
		double m1=36.5990;
		double s1=7.3819;
		int MAXTHRESHOLD=30;
		
		int i=round;
		
		double[] result=new double[3];
		q_curr=Math.pow(10, -9);
		f0temp=f(q_i,m0,s0);
		f1temp=f(q_i,m1,s1);
		
		if(f0temp>0.0)
			f0q=f0temp;
		else
			f0q=q_curr;
		
		if(f1temp>0.0)
			f1q=f1temp;
		else
			f1q=q_curr;
		
		n=f0q/f1q;
		L=Math.log(n);
		L1.add(L);
		sum=sum+L;
		ST1.add(sum);
		t=sum-Collections.min(ST1);
		int change=0;
		
		if(changes.size()>0)
			change=changes.get(changes.size()-1);
		
		if ((i-change)>1)
		{
			if (active==false)
			{
				if (badcounter==MAXTHRESHOLD)
				{	active=true;
					changes.add(i);
					badcounter=0;
					sum=0.0;
					index.add(i);
					
					
				}
				result=LDS_function(badcounter, r_star,q_i,  x_star);
				//System.out.println("xstar "+x_star+ " r_star "+r_star+ " badcounter "+ badcounter + "q_i" + q_i);
				x_star=result[0];
				if (result[1]==1.0)
						stopped=true;
				else
						stopped=false;
							
				position_stopped=result[2];
				if (stopped==true)
				{
					active=true;
					stopped=false;
					position_stopped=-1.0;
					System.out.println("LDS STOPPED ˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆ");
					x_star=0.0;
				}
				badcounter=badcounter+1;
				C.add(active);
				
			}
			else
			{
				active=whichState(ST1.get(i),ST1.get(i-1),thesh);
				t=sum-Collections.max(ST1.subList(change, i));
				System.out.println(t);
				C.add(active);
			}
		}
		if((i-change)>3)
		{
			if(CH(C,C.size()-1)==true)
			{
				changes.add(i);
				badcounter=0;
				if (active==false)
				{
					System.out.println("Change %%%%%%%%%% "+active+" -> active");
					r_star=arrayMin(Os);
					
				}
				System.out.println(i);
				sum=0.0;
				index.add(i);
				change=i;
			}
			
		}
		ST3.add(t);
		
		return active;
	}
	
	public static boolean CH(ArrayList<Boolean> C, int m)
	{
		boolean a=false;
		
		if (C.get(m)!= C.get(m-1) && C.get(m)!= C.get(m-2)  )
			a=true;
		else 
			a=false;
			
		return a;
	}
	
	public static double[] LDS_function(int k, int r_star,double q_curr, double x_star)
	{
		double y[]= new double[3];
		double position_stopped=-1.0;
		double stopped=0.0;
		double x_current;
		
		if (k<r_star)
		{
			x_current=q_curr;
			if (x_current>x_star)
			{
				//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$"+ x_current+ " : "+x_star);
				x_star=x_current;
			}
		}
		else
		{
			x_current=q_curr;
			if (x_current>x_star)
			{
				x_star = x_current;
				System.out.println( x_current+ " : "+x_star);
				stopped=1.0;
				position_stopped=k;
			}
			
		}
		
		
		
		y[0]=x_star;
		y[1]=stopped;
		y[2]=position_stopped;
		return y;
		
	}
	
	public static boolean whichState(double State1, double State2, double thesh)
	{
		boolean State;
		if (State1>(State2+thesh))
			State=true;
		else 
			State = false;
		return State;
	}
	
	
	public static double f ( double x, double m0, double s0) //εκθετικη1
	{
		double result;
		result=(1/Math.sqrt(2*Math.PI*Math.pow(s0, 2.0))) * Math.exp(-(Math.pow((x-m0), 2.0)/(2*Math.pow(s0,2))));
		
		return result;
		
	}
	
	public static double[] LDS_ost(double r, double gamma)
	{
		
		double y[] = new double[(int)r];
		
		for(int i=0;i<r;i++)
		    y[i] = LDS((double)i,gamma,r);
		
		return y;
	}
	
	public static double LDS(double x, double gamma, double N)
	{
		double y;
		double sum=0.0;
		int i;
		int k=(int)x;
		for (i=k;i<N;i++)			
		{
			sum=sum+(1/x);
			
		}
		y = (sum + x * (2 * gamma / N) / (1 - (gamma / N)) - ((1 + gamma) / 1 - gamma / N));
		
		return y;
	}
	
	public static int arrayMin(double[] arr1) {
        int i = 0;
        int position =1;
        double min = Double.MAX_VALUE;
        if (arr1 == null) {
            return 0; // What if 0 is the minimum value? What do you want to do in this case?
        } else {
            while (i < arr1.length) {
                if (arr1[i] < min) {
                  min = arr1[i];
                  position=i;
                }
                i++;
            }
        }
        return position;
    }
	

}
