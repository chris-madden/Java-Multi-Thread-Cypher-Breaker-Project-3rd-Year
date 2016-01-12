package ie.gmit.sw;

public class Consumer implements Runnable{

	private double highestScore = -1000;
	private Resultable finalResult, r;
	private String text;
	
	public Consumer(String text) {
		
		this.text = text;
		
	}

	public void run()
	{
		int key = 2; 
		
		while(key < (text.length() / 2))
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
			//System.out.println("Text: " + finalResult.getPlainText() +  " Key: " + finalResult.getKey() + " Score: " + finalResult.getScore());
			
			key++;
					
		}// End while
		
		System.out.println("Text = " + finalResult.getPlainText() + " Key = " + finalResult.getKey() + " Score = " + finalResult.getScore());
		
    }// End run

}// End class Consumer
