package Algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileWifiReader  {
//	Reads integers from the file named wifiquality.txt and stores
//	them. Use getWifiQuality() to read the next integer. If there 
//	are no more integers, 0 will be returned.
	ArrayList<String> q = new ArrayList<String>();
	
	public FileWifiReader() {
		BufferedReader reader;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader("wifiquality.txt"));
			while((line=reader.readLine()) != null){
				q.add(line);
//				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getWifiQuality(){
		int quality;
		
		if(!q.isEmpty() && new Scanner(q.get(0)).hasNextInt()){
			quality =Integer.parseInt(q.get(0));
			q.remove(0);
		}else quality = 0;
		
		return quality;
	}
	
	public double getQualityNormalized(double PLi,double RTTi, double TTLi)
	{
		double q,PL_curr,RTT_curr,TTL_curr;
		double minRTT=  23.9560;
		double maxRTT=171.4970;
		double minPL=0;
		double maxPL=30;
		
		double minTTL= 19874;
		double maxTTL= 20005; 

		 PL_curr= Math.abs((( maxPL - PLi ) / ( minPL - maxPL)));
		 RTT_curr=Math.abs((( maxRTT - RTTi) / ( minRTT - maxRTT)));
		 TTL_curr=Math.abs((( TTLi-minTTL) / ( maxTTL - minTTL  ))); 
		 q=(0.4*PL_curr+0.4*RTT_curr+ 0.2*TTL_curr)*100;
		
		return q;
		
	}
	
	
}
