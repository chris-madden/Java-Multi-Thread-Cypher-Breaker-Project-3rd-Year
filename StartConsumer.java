package ie.gmit.sw;

public class StartConsumer 
{
	
	private String text;
	
	
	
	public StartConsumer(String text) {

		this.text = text;
	}

	public void consume()
	{
			
		// Create new threads based on Consumer
		Thread t = new Thread(new Consumer(text));
		
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

