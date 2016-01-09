package ie.gmit.sw;

public class Encrypt 
{
	
	//***** Encrypt a String called cypherText using an integer key ***** 
	public String encrypt(String cypherText, int key)
	{
		
		//Declare a 2D array of key rows and text length columns
		//The array is filled with chars with initial values of zero, i.e. '0'.
		char[][] matrix = new char[key][cypherText.length()]; 
		
		//Fill the array
		int row = 0; //Used to keep track of rows
		boolean down = true; //Used to zigzag
		
		//Loop over the plaintext
		for (int i = 0; i < cypherText.length(); i++)
		{ 
			
			//Add the next character in the plaintext to the array
			matrix[row][i] = cypherText.charAt(i); 
			
			//If we are moving down the array
			if (down)
			{ 
				
				row++;
				
				// Reached the bottom
				if (row == matrix.length)
				{ 
					row = matrix.length - 2; //Move to the row above
					down = false; //Switch to moving up
				} 
				
			}else // We are moving up the array
			{ 
				row--;
				
				//Reached the top
				if (row == -1)
				{ 
					row = 1; //Move to the first row
					down = true; //Switch to moving down
				}
				
			}// End if/else
			
		}// End for
		
		//printMatrix(matrix); //Output the matrix (debug)
		
		//Extract the cypher text
		StringBuffer sb = new StringBuffer(); //A string buffer allows a string to be built efficiently
		
		//Loop over each row in the matrix
		for (row = 0; row < matrix.length; row++)
		{ 
			
			//Loop over each column in the matrix
			for (int col = 0; col < matrix[row].length; col++)
			{ 
				
				//Extract the character at the row/col position if it's not 0.
				if (matrix[row][col] > '0') sb.append(matrix[row][col]); 
				
			}
		}// End for
		
		//Convert the StringBuffer into a String and return it
		return sb.toString(); 
		
	}// End encrypt

}// End class Encrypt
