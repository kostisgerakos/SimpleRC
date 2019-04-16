package Algorithms;


import java.util.*;

public class OST {
	
	public double m0;
	public double m1;
	public double s0;
	public double s1;
	
	
public OST(double m0,  double s0, double m1,double s1) {
		
		this.m0 = m0;
		this.m1 = m1;
		this.s0 = s0;
		this.s1 = s1;
	}
	
	public double f0 ( int x) //εκθετικη1
	{
		double result;
		result=(1/Math.sqrt(2*Math.PI*Math.pow(this.s0, 2.0))) * Math.exp(-(Math.pow((x-this.m0), 2.0)/(2*Math.pow(this.s0,2))));
		
		return result;
		
	}
	
	public double f1 ( int x) //εκθετικη 2
	{
		double result;
		result=(1/Math.sqrt(2*Math.PI*Math.pow(this.s1, 2))) * Math.exp(-(Math.pow(x-this.m1, 2)/(2*Math.pow(this.s1,2))));
		
		return result;
		
	}
	
	public static int minIndex (List<Double> list) 
	{
		  return list.indexOf (Collections.min(list)); 
	}
	
	public static int maxIndex (List<Double> list) 
	{
		  return list.indexOf (Collections.max(list)); 
	}
	
	
	
	public static void main(String [ ] args)
	{
		System.out.println("foo");
	}
	
	
	
}
