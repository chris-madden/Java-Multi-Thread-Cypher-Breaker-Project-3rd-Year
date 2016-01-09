package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	
	private Map<String, Double> map;
	
	// Method used to take content from 4grams.txt and place in concurrent hashmap
	public Map<String, Double> parse(String file) throws Exception{
		
		// Variables 
		String quadgram, line = "";
		Double value;
	
		// Create concurrent hashmap
		map = new ConcurrentHashMap<String, Double>();
		
		try{
			
				// Read the text file that the user has entered
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				// Go through file line by line
				while((line = br.readLine()) != null){
					
					// Split each line into the key and value
					String[] quadgramArray = line.split(" ");
					
					// Store key in String
					quadgram = quadgramArray[0];
					
					// Store value in double 
					value = Double.parseDouble(quadgramArray[1]);
							
					// Put values into hashmap
					map.put(quadgram,  value);
					
				}
		
				// Close the buffered reader
				br.close();
		
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}
		
		return map;
		
	}// End method parse

}// End class FileParser
