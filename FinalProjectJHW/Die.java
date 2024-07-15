/**********************************************************
 * Program Name   : Die
 * Author         : Jack Wilcox
 * Date           : 5/15/22
 * Course/Section : CSC - 264 - 302
 * Program Description: This Class simulates a die.
 *    The die has methods that allow it to be "rolled",
 *    choosing a random number between 1 and 6 inclusive.
 *    There are also methods that return the die's current face
 *    both as a number and as a string.
 *
 * Methods:
 * -------
 * Constructor - Sets the face of the die to 1
 * roll        - Rolls the die, choosing a number between 1 and 6 inclusive
 * getFace     - Returns the face of the die as a number
 * toString    - Returns the face of the die as a string
 *
 **********************************************************/

 import java.util.Random;

public class Die
{
	//Class Constants
	private final int SIDE_ONE   = 1;
	private final int SIDE_TWO   = 2;
	private final int SIDE_THREE = 3;
	private final int SIDE_FOUR  = 4;
	private final int SIDE_FIVE  = 5;
	private final int SIDE_SIX   = 6;

	//Class Variables
	private int dieFace; //The face of the die that is randomly chosen (1 - 6)

	/**********************************************************
	* Method Name    : Constructor
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: The Constructor of this class
	*    will set the die's face to the default, 1.
	*
	* BEGIN Constructor
	*    Set the face of the die to the default, 1
	* END Constructor
	**********************************************************/

	public Die()
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor  ********************/

		//Set the face of the die to the default, 1
		dieFace = 1;

	} //END Constructor

	/**********************************************************
	* Method Name    : roll
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This method will roll the die,
	*    which means it will choose a random number between
	*    1 and 6 inclusive.
	*
	* BEGIN roll
	*    Randomly choose the face of the die, which will be between 1 and 6 inclusive
	* END roll
	**********************************************************/

	public void roll()
	{
		//Local Constants

		//Local Variables

		/********************  Start roll  ********************/

		//Randomly choose the face of the die, which will be between 1 and 6 inclusive
		dieFace = (int) ((Math.random() * 6) + 1);

	} //END roll

	/**********************************************************
	* Method Name    : getFace
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This method will return the die's face
	*    as a number.
	*
	* BEGIN getFace
	*    Return the die's current face
	* END getFace
	**********************************************************/

	public int getFace()
	{
		//Local Constants

		//Local Variables

		/********************  Start getFace  ********************/

		//Return the die's current face
		return dieFace;

	} //END getFace

	/**********************************************************
	* Method Name    : toString
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This method will return the die's
	*    current face as a string.
	*
	* BEGIN toString
	*    Initialize the output string to an empty string
	*    IF (The face is one)
	*	    Set the output string to say that the face is one
	*	 ELSE IF (The face is two)
	*		Set the output string to say that the face is two
	*	 ELSE IF (The face is three)
	*		Set the output string to say that the face is three
	*	 ELSE IF (The face is four)
	*		Set the output string to say that the face is four
	*	 ELSE IF (The face is five)
	*		Set the output string to say that the face is five
	*	 ELSE (The face is six)
	*		Set the output string to say that the face is six
	*	 END IF
	*	 Return the output string
	* END toString
	**********************************************************/

	public String toString()
	{
		//Local Constants

		//Local Variables
		String dieOutput = ""; //Output string that will hold the die's face as a string

		/********************  Start toString  ********************/

		//IF (The face is one)
		if(dieFace == SIDE_ONE)
		{
			//Set the output string to say that the face is one
			dieOutput = "One";
		}

		//ELSE IF (The face is two)
		else if(dieFace == SIDE_TWO)
		{
			//Set the output string to say that the face is two
			dieOutput = "Two";
		}

		//ELSE IF (The face is three)
		else if(dieFace == SIDE_THREE)
		{
			//Set the output string to say that the face is three
			dieOutput = "Three";
		}

		//ELSE IF (The face is four)
		else if(dieFace == SIDE_FOUR)
		{
			//Set the output string to say that the face is four
			dieOutput = "Four";
		}

		//ELSE IF (The face is five)
		else if(dieFace == SIDE_FIVE)
		{
			//Set the output string to say that the face is five
			dieOutput = "Five";
		}

		//ELSE (The face is six)
		else
		{
			//Set the output string to say that the face is six
			dieOutput = "Six";

		} //END IF

		//Return the output string
		return dieOutput;

	} //END toString

} //END Die