package Algorithms;

import Algorithms.TestOST;
import Algorithms.FileWifiReader;

public class Simulation {
	
	public static void main(String[] args) {
		
		boolean b;
		TestOST g=new TestOST();
		FileWifiReader reader = new FileWifiReader();
		for(int i = 0; i < 500; i++){
			System.out.println((g.getSendPermission(reader.getWifiQuality())));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//main close

}
