package ie.gmit.sw;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	
	// Main method
	public static void main(String[] args) throws Exception
	{
		
		// Create objects
		Scanner input = new Scanner(System.in);
		FileParser fp = new FileParser();
		Encrypt encrypt = new Encrypt();
		
		//RailFence rf = new RailFence();
		
		// Only need map for testing
		//Map<String, Double> map = new ConcurrentHashMap<String, Double>();
		
		// Variables
		String message, encryptedMessage;
		int key;
		
		// parse the file
		fp.parse("4grams.txt");
		
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
		
		// Close the Scanner
		input.close();

	}// End main

}
