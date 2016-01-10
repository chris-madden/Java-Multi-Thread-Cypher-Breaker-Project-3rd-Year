package ie.gmit.sw;

public class Consumer implements Runnable{

	private double highestScore = -1000;
	private Resultable finalResult, r;
	
	public Consumer() {
		
	}

	public void run()
	{
		
		while(true)
		{
			
			try 
			{
				
				// Take the next object from the queue
				r = Buffer.queue.take();
			
				
			} catch (InterruptedException e)
			{
				
				e.printStackTrace();
			}
			
			// Store the score from the Resultable object in variable score
			double score = r.getScore();
			
			// If score is higher than current highest score
			if(score > highestScore)
			{
				// Store the new score as the highest score
				highestScore = score;
				
				// Keep track of the best result object
				finalResult = r;
		
			}// End if
			
			// Print out the contents of Resultable object for each thread
			System.out.println("Text: " + r.getPlainText() +  " Key: " + r.getKey() + " Score: " + r.getScore());
					
		}// End while
		
    }// End run
	
	// Return the object with the best result
	public Resultable getFinalResult()
	{
		
		return finalResult;
		
	}// End getFinalResult

}// End class Consumer
