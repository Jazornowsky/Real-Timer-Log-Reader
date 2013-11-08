package net.damian.wojdat.RealTimeLogReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoggerCore {

	public static void main(String[] args) {

		BufferedReader file;
		String line;
		
		try {
			file = new BufferedReader(new FileReader("server_log.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		// Initial file read
		try {
			
			while((line = file.readLine()) != null) {
				
				System.out.println(line);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Continuous file read
		try {
			
			while(true) {
				
				while((line = file.readLine()) != null) {
					
					System.out.println(line);
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
