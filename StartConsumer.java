package ie.gmit.sw;

public class StartConsumer 
{
	
	public void consume()
	{
			
		// Create new threads based on Consumer
		Thread t = new Thread(new Consumer());
		
		// Start thread 
		t.start();
		
		try 
		{
			
			// Make sure threads finish 
			t.join();
			
			
		} catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
		
	}// End consume
	
}// End class StartConsumer 

