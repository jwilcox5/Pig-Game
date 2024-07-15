/**********************************************************
 * Program Name   : PigDriver
 * Author         : Jack Wilcox
 * Date           : 5/15/22
 * Course/Section : CSC - 264 - 302
 * Program Description: This program will simulate the die
 *    game "Pig". How the game of Pig works is like this:
 *    In this game, 2 users compete against each other.
 *    On each turn, the current player rolls a pair of dice
 *    and accumulates points (the roll on the dice).
 *    The goal is to reach 100 points before your opponent does.
 *    Each player takes a turn. A player will roll the dice and
 *    accumulate points until they decide to stop. They may stop their
 *    turn at any point and give control of the dice to the other player.
 *    If, during a player’s turn, they roll a 1 (on either die) they
 *    forfeit all of their points for that turn (but keeps their points
 *    from previous turns). If the user rolls two 1s, then they forfeit
 *    their points for the entire game and has to start from 0. So, after
 *    each roll, the player must decide to give up the dice, or be a Pig
 *    and keep rolling the dice. Any time the user rolls a 1 (or 2 1s),
 *    they must forfeit the dice to their opponent thus possibly allowing the
 *    other player to win.  Set up the game so that once a player accumulates
 *    25 or more points on a single turn, they must give up the dice.
 *    Once the game is complete, allow the players the chance to play a new game.
 *
 * Methods:
 * -------
 * main - Sets up the main frame and instantiates all the panels that appear in the program
 *
 **********************************************************/

 import javax.swing.JFrame;
 import javax.swing.*;

public class PigDriver
{
    /**********************************************************
    * Method Name    : main
    * Author         : Jack Wilcox
    * Date           : 5/15/22
    * Course/Section : CSC - 264 - 302
    * Program Description: This method will set up all the GUI
    *    components that appear in the main frame. This includes
    *    the Pig Intro Panel and the Pig Game Panel. The two
    *    panels mentioned will be a part of a Layout Manager that
    *    will feature tabs allowing the users to go back and forth
    *    between the panels.
    *
    * BEGIN Pig Driver
    *    Initialize a new frame
    *    Initialize a new tabbed panel
    *    Set up the frame window
    *    Add the PigIntroPanel to the tabbed panel
	*	 Add the PigGamePanel to the tabbed panel
	*	 Add the tabbed panel to the frame
	*	 Display the window
    * END Pig Driver
    **********************************************************/

	public static void main (String [] args)
	{
		//Local Constants

		//Local Variables
		JFrame frame = new JFrame("Game of Pig"); //JFrame object that will hold all the panels, including the tabbed panel
		JTabbedPane tp = new JTabbedPane();       //JTabbedPane object that hold the multiple panels that are featured in the game

		/******************** Start main method *****************/

		//Set up the frame window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add the PigIntroPanel to the tabbed panel
		tp.addTab("Welcome!", new PigIntroPanel());

		//Add the PigPanel to the tabbed panel
		tp.addTab("Play The Game!", new PigGamePanel());

		//Add the tabbed panel to the frame
		frame.getContentPane().add(tp);

		//Display the window
		frame.pack();
      	frame.setVisible(true);

	} //END main method

} //END Final Project JHW