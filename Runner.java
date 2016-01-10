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
		Map<String, Double> map;;
		
		// Variables
		String message, encryptedMessage;
		int key;
		
		// parse the file and store in map
		map = fp.parse("4grams.txt");
		
		//================== Take in message and key from user ======================
		
		//Prompt user
		System.out.println("Enter your message");
		System.out.println("==================");
		
		// Get message from user
		message = input.nextLine();
		
		// Force text to uppercase 
		message = message.toUpperCase();
		
		System.out.println(message);
		
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
		
		// Create StartConsumer object
		StartConsumer sc = new StartConsumer();
		
		// Start thread to take objects from BlockingQueue
		sc.consume();
	
		// Create consumer object
		consumer = new Consumer();
		
		// Get the best result
		consumer.getFinalResult();
		
		// Close the Scanner
		input.close();

	}// End main

}// End class Runner
