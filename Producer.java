package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	private String encryptedMessage;
	private int key;
	private Map<String, Double> map;
	
	public Producer(String encryptedMessage, int key, Map<String, Double> map) 
	{
		super();
		this.encryptedMessage = encryptedMessage;
		this.key = key;
		this.map = map;
		
	}
	
	// Run method for thread
	public void run()
	{
		
		// Create decrypt object
		Decrypt decrypt = new Decrypt();
		TextScorer ts = new TextScorer(map);
		
		String decryptedText;
		double score = 0;
		
		// Store decrypted text in string
		decryptedText = decrypt.decrypt(encryptedMessage, key);
		
		// Score the decrypted text
		score = ts.getScore(decryptedText);
		
		// Create new result object, pass in 
		Resultable r = new Result(decryptedText, key, score);
				
		try
		{
			// Put the Resultable object into the BlockingQueue
			Buffer.queue.put(r);
			
		} catch (InterruptedException e) 
		{
			
			e.printStackTrace();
			
		}
		
	}// End run
	
}// End class Producer
