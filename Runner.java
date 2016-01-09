package ie.gmit.sw;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	
	// Main method
	public static void main(String[] args) throws Exception
	{
		
		// Create objects
		Scanner input = new Scanner(System.in);
		FileParser fp = new FileParser();
		Encrypt encrypt = new Encrypt();
		Producer producer;
		Consumer consumer;
		StartProducing startProducing;
		BlockingQueue<Resultable> queue = new ArrayBlockingQueue<Resultable>(100);
		
		//RailFence rf = new RailFence();
		
		// Only need map for testing
		Map<String, Double> map;;
		
		// Variables
		String message, encryptedMessage;
		int key;
		
		// parse the file and store in map
		map = fp.parse("4grams.txt");
		
		/*// Testing that map is working
		try {
			
			map = fp.parse("4grams.txt");
			
			for(Map.Entry<String, Double>entry : map.entrySet())
			{
				System.out.println("Key: " + entry.getKey() + " " + "Value :" + entry.getValue());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//================== Take in message and key from user ======================
		
		//Prompt user
		System.out.println("Enter your message");
		System.out.println("==================");
		
		// Get message from user
		message = input.nextLine();
		
		//Prompt user
		System.out.println("\nEnter your key");
		System.out.println("=================");
		
		// Get key from user
		key = input.nextInt();
				
		// Encrypt the message with the key and store in String encryptedMessage
		encryptedMessage = encrypt.encrypt(message, key);	
		
		// Pass encrypted message and key to the producer
		producer = new Producer(encryptedMessage, key, map);
		
		// Create object to start threads
		StartProducing sp = new StartProducing(encryptedMessage, map);
		
		// Runs the threads for producing
		sp.createThreads();
		
		StartConsumer sc = new StartConsumer();
		
		sc.consume();
		
		
		
		System.out.println(Buffer.queue.size());
		
		consumer = new Consumer();
		
		consumer.results();
		
		/*Resultable resultable =  new ;
				
				consumer.getFinalResult();
		
		System.out.println(resultable.getKey());*/
		
		//System.out.println("Plain text: " + resultable.getPlainText() + " Key: " + resultable.getKey() + " Score: " + resultable.getScore());
		
		// Close the Scanner
		input.close();

	}// End main

}
