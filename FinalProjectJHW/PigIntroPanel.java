/**********************************************************
 * Program Name   : PigIntroPanel
 * Author         : Jack Wilcox
 * Date           : 5/15/22
 * Course/Section : CSC - 264 - 302
 * Program Description: This Class serves as the intro panel
 *    for the Pig Game. This panel will tell the players about
 *    the rules of the game and will be one of the tabs of the
 *    Layout Manager.
 *
 * Methods:
 * -------
 * Constructor - Sets up and adds all the objects that will appear in the panel including their size, color, and special features.
 *
 **********************************************************/

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

public class PigIntroPanel extends JPanel
{
	//Class Constants

	//Class Variables
	private JLabel welcomeLabel;   //Label that features a welcome message for the players
	private JLabel pigLabel1;      //Label that features an image of a pig
	private JLabel pigLabel2;      //Label that features another image of a pig
	private JLabel playerLabel;    //Label that features a message indicating the game is for two players
	private JLabel howToPlayLabel; //Label that serves as a heading for the "How to Play" section of the panel
	private JLabel rulesLabel1;    //First Label that explains the rules of the game
	private JLabel rulesLabel2;    //Second Label that explains the rules of the game
	private JLabel rulesLabel3;    //Third Label that explains the rules of the game
	private JLabel rulesLabel4;    //Fourth Label that explains the rules of the game
	private JLabel rulesLabel5;    //Fifth Label that explains the rules of the game
	private JLabel rulesLabel6;    //Sixth Label that explains the rules of the game
	private JLabel pigLabel3;      //Label that features yet another image of a pig
	private JLabel pigLabel4;      //Label that features one final image of a pig
	private JLabel endingLabel;    //Label that features a message telling the players to enjoy the game

	/**********************************************************
	* Method Name    : Constructor
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Constructor will set up all the
	*    objects in the panel and add them in the correct order.
	*    The Constructor will also make sure each object has the correct
	*    size, color, and font. Finally, the Constructor will set the size
	*    and color of the actual panel.
	*
	* BEGIN Constructor
	*   Set the layout of the panel to the FlowLayout
	*	Create the welcome label and set its font and size
	*	Create the two pig labels with their respective images
	*	Create the player label and set its font and size
	*	Create the how to play label and set its font and size
	*	Create the first rules label and set its font and size
	*	Create the second rules label and set its font and size
	*	Create the third rules label and set its font and size
	*	Create the fourth rules label and set its font and size
	*	Create the fifth rules label and set its font and size
	*	Create the sixth rules label and set its font and size
	*   Create two more pig labels with their respective images
	*	Create the ending label and set its font and size
	*	Add every object to the panel in the correct order
	*	Set the background color for the panel
	*	Set the background and preferred size for the panel
	* END Constructor
	**********************************************************/

	public PigIntroPanel()
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor  ********************/

		//Set the layout of the panel to the FlowLayout
		setLayout(new FlowLayout());

		//Create the welcome label and set its font and size
		welcomeLabel = new JLabel("Welcome to the Game of Pig!");
		welcomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 50));

		//Create the two pig labels with their respective images
		pigLabel1 = new JLabel(new ImageIcon("Pig1.jpg"));
		pigLabel2 = new JLabel(new ImageIcon("Pig2.jpg"));

		//Create the player label and set its font and size
		playerLabel = new JLabel("This Game is for Two Players. Find a Friend so you can play against them and see who's the best!");
		playerLabel.setFont(new Font("Helvetica", Font.PLAIN, 30));

		//Create the how to play label and set its font and size
		howToPlayLabel = new JLabel("How To Play:");
		howToPlayLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

		//Create the first rules label and set its font and size
		rulesLabel1 = new JLabel("- Players will take their turn by rolling the dice. The players will accumulate points from the rolls." +
		                         " The player who gets 100 points first is declared the winner.                              ");
		rulesLabel1.setFont(new Font("Helvetica", Font.BOLD, 16));

		//Create the second rules label and set its font and size
		rulesLabel2 = new JLabel("- A turn is defined as the player rolling the dice until they stop or are forced to stop. When the" +
		                         " player's turn is over, the die are handed over to the other player.                          ");
		rulesLabel2.setFont(new Font("Helvetica", Font.BOLD, 16));

		//Create the third rules label and set its font and size
		rulesLabel3 = new JLabel("- The player's turn can be ended by voluntarily giving up their turn, rolling at least a single one," +
		                         " or accumulating 25 points or more in a single turn.                                                ");
		rulesLabel3.setFont(new Font("Helvetica", Font.BOLD, 16));

		//Create the fourth rules label and set its font and size
		rulesLabel4 = new JLabel("- If the player rolls a single one, they lose all the points they received that round and must give" +
		                         " up their turn, but they keep any points they had before starting that turn.        ");
		rulesLabel4.setFont(new Font("Helvetica", Font.BOLD, 16));

		//Create the fifth rules label and set its font and size
		rulesLabel5 = new JLabel("- If the player rolls two ones, they lose ALL their points and must give up their turn.            " +
		                         "                                                                                                   " +
		                         "                                                       ");
		rulesLabel5.setFont(new Font("Helvetica", Font.BOLD, 16));

		//Create the sixth rules label and set its font and size
		rulesLabel6 = new JLabel("- The player has to roll at least once for their turn, but after that they can roll as many times" +
		                         " as they want (Like a Pig), until they roll a one or inevitably roll 25 or more points.");
		rulesLabel6.setFont(new Font("Helvetica", Font.BOLD, 16));

		//Create two more pig labels with their respective images
		pigLabel3 = new JLabel(new ImageIcon("PigLaughing1.jpg"));
		pigLabel4 = new JLabel(new ImageIcon("PigLaughing2.jpg"));

		//Create the ending label and set its font and size
		endingLabel = new JLabel("Those are the rules! Hope you have fun!!");
		endingLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

		//Add every object to the panel in the correct order
		add(pigLabel1);
		add(welcomeLabel);
		add(pigLabel2);
		add(playerLabel);
		add(howToPlayLabel);
		add(rulesLabel1);
		add(rulesLabel2);
		add(rulesLabel3);
		add(rulesLabel4);
		add(rulesLabel5);
		add(rulesLabel6);
		add(pigLabel3);
		add(endingLabel);
		add(pigLabel4);

		//Set the background color for the panel
		setBackground(Color.green);

		//Set the background and preferred size for the panel
      	setPreferredSize(new Dimension(1400, 600));

	} //END Constructor

} //END PigIntroPanel