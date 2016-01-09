package ie.gmit.sw;

public class Decrypt{

	//***** Decrypt a String cypherText using an integer key ***** 
	public String decrypt(String cypherText, int key){
		
		//Declare a 2D array of key rows and text length columns
		//The array is filled with chars with initial values of zero, i.e. '0'.
		char[][] matrix = new char[key][cypherText.length()];
		
		//Fill the array
		int targetRow = 0;
		int index = 0;
		
		do{
			
			int row = 0; //Used to keep track of rows		
			boolean down = true; //Used to zigzag
			
			//Loop over the plaintext
			for (int i = 0; i < cypherText.length(); i++)
			{ 
				
				if (row == targetRow)
				{
					
					//Add the next character in the plaintext to the array
					matrix[row][i] = cypherText.charAt(index); 
					index++;
					
				}// End if
				
				//If we are moving down the array
				if (down)
				{ 
					
					row++;
					
					//Reached the bottom
					if (row == matrix.length)
					{ 
						row = matrix.length - 2; //Move to the row above
						down = false; //Switch to moving up
					} 
					
				}else //We are moving up the array
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

			targetRow++;
			
		}while (targetRow < matrix.length);
		
		//printMatrix(matrix); //Output the matrix (debug)
		
		//Extract the cypher text
		//A string buffer allows a string to be built efficiently
		StringBuffer sb = new StringBuffer();
		
		int row = 0;
		
		//Used to zigzag
		boolean down = true;
		
		//Loop over each column in the matrix
		for (int col = 0; col < matrix[row].length; col++)
		{ 
			
			//Extract the character at the row/col position if it's not 0.
			sb.append(matrix[row][col]); 
			
			//If we are moving down the array
			if (down)
			{ 
				row++;
				
				//Reached the bottom
				if (row == matrix.length)
				{ 
					
					row = matrix.length - 2; //Move to the row above
					down = false; //Switch to moving up
					
				} 
				
			}else //We are moving up the array
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
		
		 //Convert the StringBuffer into a String and return it
		return sb.toString();
	}

}// End Decrypt
