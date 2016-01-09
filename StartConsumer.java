package ie.gmit.sw;

public class StartConsumer 
{
	
	public void consume()
	{
		
		(new Thread(new Consumer())).start();
		
	}
	
}// End class StartConsumer 

