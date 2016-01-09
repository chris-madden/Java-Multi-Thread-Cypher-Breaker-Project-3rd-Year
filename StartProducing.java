package ie.gmit.sw;

import java.util.Map;

public class StartProducing 
{
	
	private String encryptedMessage;
	private Map<String, Double> map;
	
	public StartProducing(String encryptedMessage, Map<String, Double> map)
	{
		
		this.map = map;
		this.encryptedMessage = encryptedMessage;
		
	}// End constructor
	
	public void createThreads()
	{
		
		// Produce threads to start decrypting and score the quadgrams
		for(int key = 2; key < encryptedMessage.length() / 2; key++)
		{
			
			// Create new threads with a different key each time
			(new Thread(new Producer(encryptedMessage, key, map))).start();
			
		}// End for loop
		
	}// End createThreads

}// End class StartProducing
