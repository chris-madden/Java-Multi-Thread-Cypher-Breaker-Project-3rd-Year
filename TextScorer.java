package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;

public class TextScorer {
	
	private Map<String, Double> map = new HashMap<String, Double>();
	
	public TextScorer(Map<String, Double> m)
	{
		this.map = m;
	}
	
	/*public void testMapContent()
	{
		
		for(Map.Entry<String, Double>entry : map.entrySet())
		{
			System.out.println("Key: " + entry.getKey() + " " + "Value :" + entry.getValue());
		}
		
	}*/
	
	public double getScore(String text)
	{
		
		double score = 0f;

		for (int i = 0; i < text.length(); i++)
		{
			
			if (i +  QuadGramMap.GRAM_SIZE <= text.length() - 1)
			{
				
				score += computeLogScore(text.substring(i, i + QuadGramMap.GRAM_SIZE));
				
			}// End if
			
		}// End for loop
		
		return score;
		
	}// End getScore
	
	public double computeLogScore(String quadgram){
		
		if (map.containsKey(quadgram)){
			
			
			double frequency = map.get(quadgram);
			double total = (double) map.size();
			double probability = (double) (frequency/total);
			
			return Math.log10(probability);
			
		}else{
		
			return 0f;
		}// End if/else
		
	}// End computeLogScore
	
}// End TextScorer
