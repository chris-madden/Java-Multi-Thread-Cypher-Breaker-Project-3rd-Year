package ie.gmit.sw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Buffer
{
	
	// Create a blocking queque to be used by producer and consumer
	public static final BlockingQueue<Resultable> queue = new ArrayBlockingQueue<Resultable>(100);

}// End class Buffer
