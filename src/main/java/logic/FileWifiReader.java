package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileWifiReader implements WifiQualityReader {
//	Reads integers from the file named wifiquality.txt and stores
//	them. Use getWifiQuality() to read the next integer. If there 
//	are no more integers, 0 will be returned.
	ArrayList<String> q = new ArrayList<String>();
	
	public FileWifiReader() {
		BufferedReader reader;
		String line;
	    String cvsSplitBy = ",";

		try {
			//reader = new BufferedReader(new FileReader("Q_all.csv"));
		//	reader = new BufferedReader(new FileReader("Medium_Q_all.csv"));
			reader = new BufferedReader(new FileReader("Q_diff2_kafka.csv"));
			while((line=reader.readLine()) != null){
				
	                // use comma as separator
	                String[] qual = line.split(cvsSplitBy);
	                
	                q.add(qual[0]);
	            
				
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
	public Double getWifiQuality(){
		double quality;
		
		if(!q.isEmpty() && new Scanner(q.get(0)).hasNextDouble()){
			quality =Double.parseDouble(q.get(0));
			q.remove(0);
		}else 
			quality = -10.0;
		
		return quality;
	}
	
	public boolean isEmpty(){
		return q.isEmpty();
	}
}
