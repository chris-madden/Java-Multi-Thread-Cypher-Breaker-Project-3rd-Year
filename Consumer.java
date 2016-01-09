package ie.gmit.sw;

public class Consumer implements Runnable{
	
	//private BlockingQueue<Resultable> queue;
	private double highestScore = -1000;
	private Resultable finalResult;// Problem here
	

	public Consumer() {
		
	}


	public void run()
	{
		
		while(!Buffer.queue.isEmpty())
		{
			
			try 
			{
				
				Resultable r = Buffer.queue.take();
				
				//System.out.println("Text: " + r.getPlainText() +  " Key: " + r.getKey() + " Score: " + r.getScore());
				
				double score = r.getScore();
				
				
				
				if(score > highestScore)
				{
					highestScore = score;
					
					finalResult = r;
					
					//System.out.println(highestScore);
				}
				
				
			} catch (Exception e)
			{
				
				e.printStackTrace();
				
			}// End try/catch
			
		}// End while
		
    }// End run
	
	public Resultable getFinalResult()
	{
		
		return finalResult;
	}
	
	public void results()
	{
		
		//System.out.println(finalResult.getPlainText() + " " + finalResult.getKey() + " " + finalResult.getScore());
		
		
	}

}// End class Consumer
