/**********************************************************
 * Program Name   : PigGamePanel
 * Author         : Jack Wilcox
 * Date           : 5/15/22
 * Course/Section : CSC - 264 - 302
 * Program Description: This Class holds all of the sub-panels
 *    and serves as the actual game of Pig. Nearly every single
 *    object that is a part of the game is defined in this Class as well
 *    as several variables that will keep track of game statistics.
 *    This Class also holds many private Classes that will be used
 *    as ActionListeners for the various button objects. This Class
 *    uses a BorderLayout to organize its sub-panels and has various
 *    formatting statements.
 *
 * Methods:
 * -------
 * Constructor - Creates many GUI objects and uses them to instantiate sub-panels
 * endGame     - Performs the necessary actions when a player has won the game and checks to see if the players want to play again
 *
 **********************************************************/

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.border.*;
 import java.util.Random;

public class PigGamePanel extends JPanel
{
	//Class Constants
	private final int MAX_TURN_POINTS   = 25;
	private final int MAX_GAME_POINTS   = 100;
	private final int PHRASE_ARRAY_SIZE = 10;
	private final int IMAGE_ARRAY_SIZE  = 6;

	//Class Variables
	private PigSubPanel dicePanel;       //Sub-panel that will hold the die objects and the game history button
	private PigSubPanel buttonPanel;     //Sub-panel that will hold the buttons for starting a game, rolling, and holding
	private PigSubPanel gameStatsPanel;  //Sub-panel that will hold the players' scores during the game
	private PigSubPanel sideImagePanel1; //One of the two side sub-panels that holds an image, this one goes on the left
	private PigSubPanel sideImagePanel2; //The other side sub-panel that holds an image, this one goes on the right
	private JLabel giantDie1;            //Label that holds the image of the first giant die
	private JLabel giantDie2;            //Label that holds the image of the second giant die
	private JLabel dieFaceLabel;         //Label that holds the result of both die rolls as an integer
	private JButton gameHistoryButton;   //Button that when pressed, shows the players the past game results
	private JLabel gameMessage;          //Label that tells the players whose turn it currently is
	private JButton startButton;         //Button that when pressed, will allow the players to type in their names and start the game
	private JButton rollButton;          //Button that when pressed, will roll the die for the player
	private JButton holdButton;          //Button that when pressed, will end the turn of the current player
	private JLabel scoresLabel;          //Label that holds the scores of the players for the current game
	private String[] pigPhrases;         //Holds phrases that are randomized to the pig side images
	private ImageIcon[] pigImages;       //Holds images that are chosen at random for the side panels
	private JLabel sideImageLabel1;      //Label that holds an image of a pig for the left side panel
	private JLabel pigNoiseLabel1;       //Label that holds text that is for a pig noise (Left side panel)
	private JLabel sideImageLabel2;      //Label that holds an image of a pig for the right side panel
	private JLabel pigNoiseLabel2;       //Label that holds text that is for a pig noise (Right side panel)
	private Die dieObj1;                 //First Die object that is used whenever the player rolls
	private Die dieObj2;                 //Second Die object that is used whenever the player rolls
	private int die1Result;              //Holds the roll result of the first Die object as an integer
	private int die2Result;              //Holds the roll result of the second Die object as an integer
	private String stringDie1Result;     //Holds the roll result of the first Die object as a String
	private String stringDie2Result;     //Holds the roll result of the second Die object as a String
	private String player1Name;          //Name of the first player
	private String player2Name;          //Name of the second player
	private int playerTurnPoints;        //Amount of points a player has gotten on their turn
	private int player1TotalPoints;      //Total points player 1 has
	private int player2TotalPoints;      //Total points player 2 has
	private String rollResult;           //String that contains the results of a player's roll
	private String gameResults;          //String that contains the results of a completed game
	private int gameChoice;              //Choice the player's make for if they want to play another game
	private String gameHistoryOutput;    //String that contains the results of each past game played (In the session, not all time)
	private String gameWinsOutput;       //String that contains the total wins for both players (In the session, not all time)
	private int gamesPlayed;             //Total number of games played
	private int player1Wins;             //Total number of wins for player 1
	private int player2Wins;             //Total number of wins for player 2
	private boolean playerFlag;          //Used to keep track of whose turn it is (True for player 1, False for player 2)
	private boolean isFirstRoll;         //Used to keep track of if it is the player's first roll for that turn
	private boolean isTurnOver;          //Used to keep track of whether or not the current player's turn is over
	private boolean isGameOver;          //Used to keep track of whether or not the game is over
	private JLabel dialogLabel;          //Label that holds the Strings that are to be included in Dialog Boxes

	/**********************************************************
	* Method Name    : Constructor
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Constructor will instantiate every
	*    object that appears in each sub-panel, as well as
	*    instantiate the sub-panels with their sizes and background colors.
	*	 Other variables and arrays will also be initialized here as well.
	*    The Constructor passes the instantiated objects to the Constructors
	*    of each sub-panel so that they can be created. The Constructor will
	*    also do various other things such as set the LayoutManager for the panel,
	*    set the size and color of the main panel, and set the size for
	*    Dialog Boxes that appear in the panel.
	*
	* BEGIN Constructor
	*    Set the Layout of the panel to BorderLayout
	*	 Set the size of all Dialog Boxes that appear in the panel
	*	 Create the two labels that hold images of the giant die
	*	 Create the label for the results of the die roll
	*	 Create the game history button and add a new ScoresButtonListener to it
	*	 Create the label for telling which player's turn it is
	*	 Create the start button and add a new StartButtonListener to it
	*	 Create the roll button and add a new RollButtonListener to it as well as a Tool Tip Text and Mnemonic
	*	 Create the hold button and add a new HoldButtonListener to it as well as a Tool Tip Text and Mnemonic
	*	 Create the label for keeping track of the player's score
	*	 Create a new array that will hold various phrases for the pig images
	*	 Populate the pig phrases array with hard-coded phrases
	*	 Create a new array that will hold various pig images
	*	 Populate the pig images array with hard-coded images
	*	 Create the two components for the left side panel, a randomly chosen image with a randomly chosen phrase and a pig noise label
	*	 Create the two components for the right side panel, a randomly chosen image with a randomly chosen phrase and a pig noise label
	*	 Instantiate the two Die objects
	*	 Set the game history output String to its default text
	*	 Set every other variable to a default value, which is either a 0 or an empty String
	*	 Set each boolean variable to its default value
	*	 Create the label that will be used to put text into Dialog Boxes, give it an appropriate font
	*	 Create the dice panel using the necessary objects, give it a color and size
	*	 Create the button panel using the necessary objects, give it a color, size, and border
	*	 Create the game stats panel using the necessary objects, give it a color, size, and border
	*	 Create the first side image panel using the necessary objects, give it a color, size, and border
	*	 Create the second side image panel using the necessary objects, give it a color, size, and border
	*	 Add all the sub-panels to the main panel with the correct placement in the BorderLayout
	*	 Set the background and preferred size for the main panel
	* END Constructor
	**********************************************************/

	public PigGamePanel()
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor  ********************/

		//Set the Layout of the panel to BorderLayout
		setLayout(new BorderLayout());

		//Set the size of all Dialog Boxes that appear in the panel
		UIManager.put("OptionPane.minimumSize", new Dimension(250, 200));

		//Create the two labels that hold images of the giant die
		giantDie1 = new JLabel(new ImageIcon("SideOne.png"));
		giantDie2 = new JLabel(new ImageIcon("SideOne.png"));

		//Create the label for the results of the die roll
		dieFaceLabel = new JLabel("1                  1");

		//Create the game history button and add a new ScoresButtonListener to it
		gameHistoryButton = new JButton("Game History");
		gameHistoryButton.addActionListener(new ScoresButtonListener());

		//Create the label for telling which player's turn it is
		gameMessage = new JLabel("");

		//Create the start button and add a new StartButtonListener to it
		startButton = new JButton("Press Here to Start!");
		startButton.addActionListener(new StartButtonListener());

		//Create the roll button and add a new RollButtonListener to it as well as a Tool Tip Text and Mnemonic
		rollButton = new JButton("Roll");
		rollButton.addActionListener(new RollButtonListener());
		rollButton.setToolTipText("You can also use Alt+Enter to roll!");
		rollButton.setMnemonic('\n');

		//Create the hold button and add a new HoldButtonListener to it as well as a Tool Tip Text and Mnemonic
		holdButton = new JButton("Hold");
		holdButton.addActionListener(new HoldButtonListener());
		holdButton.setToolTipText("You can also use Alt+Backspace to hold!");
		holdButton.setMnemonic('\b');

		//Create the label for keeping track of the player's score
		scoresLabel = new JLabel("Player 1: 0    ~~~~~~~~~~    Player 2: 0");

		//Create a new array that will hold various phrases for the pig images
		pigPhrases = new String[PHRASE_ARRAY_SIZE];

		//Populate the pig phrases array with hard-coded phrases
		pigPhrases[0] = "Don't roll in the mud too often like I do!";
		pigPhrases[1] = "They say pigs like carrots, but I personally LOVE a huge steak~";
		pigPhrases[2] = "This game would be a lot easier with a 12-sided die!";
		pigPhrases[3] = "You're not doin' too well and want my advice? Don't be a pig!";
		pigPhrases[4] = "I'll cheat to help you win....but only if you give me food!";
		pigPhrases[5] = "I'm a pig. I can't help but roll in the mud!";
		pigPhrases[6] = "Yeah, I can talk. It's not all \"OINKS\" and \"SQUEEEALS\"!";
		pigPhrases[7] = "I may not be able to fly, but at least I can roll in this sweet, sweet mud!";
		pigPhrases[8] = "I'm surprised you thought to come over here. I'm glad though, I get lonely...";
		pigPhrases[9] = "Did you know that the most points you can get in a single turn is 36?";

		//Create a new array that will hold various pig images
		pigImages = new ImageIcon[IMAGE_ARRAY_SIZE];

		//Populate the pig images array with hard-coded images
		pigImages[0] = new ImageIcon("PigMud1.jpg");
		pigImages[1] = new ImageIcon("PigMud2.jpg");
		pigImages[2] = new ImageIcon("PigMud3.jpg");
		pigImages[3] = new ImageIcon("PigMud4.jpg");
		pigImages[4] = new ImageIcon("PigMud5.jpg");
		pigImages[5] = new ImageIcon("PigMud6.jpg");

		//Create the two components for the left side panel, a randomly chosen image with a randomly chosen phrase and a pig noise label
		sideImageLabel1 = new JLabel(pigImages[(int) (Math.random() * 5)]);
		sideImageLabel1.setToolTipText(pigPhrases[(int) (Math.random() * 9)]);
		pigNoiseLabel1 = new JLabel("'OINK!'");

		//Create the two components for the right side panel, a randomly chosen image with a randomly chosen phrase and a pig noise label
		sideImageLabel2 = new JLabel(pigImages[(int) (Math.random() * 5)]);
		sideImageLabel2.setToolTipText(pigPhrases[(int) (Math.random() * 9)]);
		pigNoiseLabel2 = new JLabel("'SQUEEEAL!'");

		//Instantiate the two Die objects
		dieObj1 = new Die();
		dieObj2 = new Die();

		//Set the game history output String to its default text
		gameHistoryOutput  = "Game History: ";

		//Set every other variable to a default value, which is either a 0 or an empty String
		die1Result         = 0;
		die2Result         = 0;
		stringDie1Result   = "";
		stringDie2Result   = "";
		player1Name        = "";
		player2Name        = "";
		playerTurnPoints   = 0;
		player1TotalPoints = 0;
		player2TotalPoints = 0;
		rollResult         = "";
		gameResults        = "";
		gameChoice         = 0;
		gameWinsOutput     = "";
		gamesPlayed        = 0;
		player1Wins        = 0;
		player2Wins        = 0;

		//Set each boolean variable to its default value
		playerFlag  = true;
		isFirstRoll = true;
		isTurnOver  = false;
		isGameOver  = false;

		//Create the label that will be used to put text into Dialog Boxes, give it an appropriate font
		dialogLabel = new JLabel("");
		dialogLabel.setFont(new Font("Helvetica", Font.BOLD, 18));

		//Create the dice panel using the necessary objects, give it a color and size
		dicePanel = new PigSubPanel(giantDie1, giantDie2, dieFaceLabel, gameHistoryButton);
		dicePanel.setBackground(Color.blue);
		dicePanel.setPreferredSize(new Dimension (600, 50));

		//Create the button panel using the necessary objects, give it a color, size, and border
		buttonPanel = new PigSubPanel(gameMessage, rollButton, holdButton, startButton);
		buttonPanel.setBackground(Color.red);
		buttonPanel.setPreferredSize(new Dimension (200, 100));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));

		//Create the game stats panel using the necessary objects, give it a color, size, and border
		gameStatsPanel = new PigSubPanel(scoresLabel);
		gameStatsPanel.setBackground(Color.red);
		gameStatsPanel.setPreferredSize(new Dimension (200, 100));
		gameStatsPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));

		//Create the first side image panel using the necessary objects, give it a color, size, and border
		sideImagePanel1 = new PigSubPanel(sideImageLabel1, pigNoiseLabel1);
		sideImagePanel1.setBackground(Color.red);
		sideImagePanel1.setPreferredSize(new Dimension(350, 200));
		sideImagePanel1.setBorder(BorderFactory.createLineBorder(Color.blue, 5));

		//Create the second side image panel using the necessary objects, give it a color, size, and border
		sideImagePanel2 = new PigSubPanel(sideImageLabel2, pigNoiseLabel2);
		sideImagePanel2.setBackground(Color.red);
		sideImagePanel2.setPreferredSize(new Dimension(350, 200));
		sideImagePanel2.setBorder(BorderFactory.createLineBorder(Color.blue, 5));

		//Add all the sub-panels to the main panel with the correct placement in the BorderLayout
		add(dicePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
        add(gameStatsPanel, BorderLayout.NORTH);
        add(sideImagePanel1, BorderLayout.WEST);
        add(sideImagePanel2, BorderLayout.EAST);

		//Set the background and preferred size for the main panel
      	setPreferredSize(new Dimension(1400, 600));

	} //END Constructor

	/**********************************************************
	* Method Name    : endGame
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This method will be called when the
	*    game has won by either of the players. A message will
	*    appear telling the player that they have won and then
	*    another message will appear asking the players if they
	*    want to play again. If they choose to play again, the game
	*    will be reset so that a new game can be started. If they
	*    choose to not play again, an ending panel will appear telling
	*    the players to close out of the window. Sub-panels and other objects
	*    will be removed and resized in order to create the congratulations and
	*    ending screens.
	*
	* BEGIN endGame
	*    Increment the games played counter by one
	*	 Hide both the roll and hold buttons
	*	 Change the font of the game message label
	*	 IF (Player 1 has won the game)
	*	    Set the game message label to say that player 1 has won
	*	    Increment player 1's total wins by one
	*	 ELSE (Player 2 has won the game)
	*	    Set the game message label to say that player 2 has won
	*	    Increment player 2's total wins by one
	*	 END IF
	*	 Hide the games stats panel
	*	 Increase the size of the dice panel to fill the empty space
	*	 Set the dice panel icons to images of pigs
	*	 Hide the die roll results label
	*	 Add the results of the game to the game history String
	*	 Store the current wins of the players to the game wins String
	*	 Store the results of the game to the game results String
	*	 Display the game results in a Dialog Box
	*	 Show a Dialog Box asking the players if they want to play again and grab their choice
	*	 IF (The players want to play another game)
	*	    Set the player flag to the player who lost the previous game
	*	    Set the game over variable to false
	*	    Uncover the game stats panel
	*	    Set the dice panel back to its original size
	*	    Set the dice panel icons to their original default images
	*	    Uncover the die roll results label and set it to the original default text
	*       Reset the player scores label to zero
	*	    Reset all the player's points and turn points to zero
	*	    Set the game message label to its original font
	*	    IF (Player 1 is going first)
	*	       Set the game message label to say that player 1 goes first
	*	    ELSE (Player 2 is going first)
	*		   Set the game message label to say that player 2 goes first
	*	    END IF
	*	    Uncover the roll button
	*	    Uncover and disable the hold button
	*	 ELSE (The players don't want to play another game)
	*	    Hide all the panels except the dice panel
	*	    Increase the size of the dice panel to fill the empty space
	*	    Hide one of the dice panel icons
	*	    Remove the image from the other dice panel icon and change it to an ending message with a font and text color
    *    END IF
	* END endGame
	**********************************************************/

	public void endGame()
	{
		//Local Constants

		//Local Variables

		/********************  Start endGame  ********************/

		//Increment the games played counter by one
		gamesPlayed++;

		//Hide both the roll and hold buttons
		rollButton.setVisible(false);
		holdButton.setVisible(false);

		//Change the font of the game message label
		gameMessage.setFont(new Font("Britannic Bold", Font.BOLD, 80));

		//IF (Player 1 has won the game)
		if(playerFlag)
		{
			//Set the game message label to say that player 1 has won
			gameMessage.setText("We have a winner: " + player1Name + "!!!");

			//Increment player 1's total wins by one
			player1Wins++;
		}

		//ELSE (Player 2 has won the game)
		else
		{
			//Set the game message label to say that player 2 has won
			gameMessage.setText("We have a winner: " + player2Name + "!!!");

			//Increment player 2's total wins by one
			player2Wins++;

		} //END IF

		//Hide the games stats panel
		gameStatsPanel.setVisible(false);

		//Increase the size of the dice panel to fill the empty space
		dicePanel.setPreferredSize(new Dimension (600, 150));

		//Set the dice panel icons to images of pigs
		giantDie1.setIcon(new ImageIcon("Pig1.jpg"));
		giantDie2.setIcon(new ImageIcon("Pig2.jpg"));

		//Hide the die roll results label
		dieFaceLabel.setVisible(false);

		//Add the results of the game to the game history String
		gameHistoryOutput += "\n" + "Game " + gamesPlayed + " - " + player1Name + ": " + player1TotalPoints + ", " +
							 player2Name + ": " + player2TotalPoints;

		//Store the current wins of the players to the game wins String
		gameWinsOutput = "\n" + "Wins - " + player1Name + ": " + player1Wins + ", " +
						 player2Name + ": " + player2Wins;

		//Store the results of the game to the game results String
		gameResults = "***The Game is Over***\n\n" +
					  "GAME RESULTS:\n\n" +
					  player1Name + ": " + player1TotalPoints + " Points\n" +
					  player2Name + ": " + player2TotalPoints + " Points";

		//Display the game results in a Dialog Box
		dialogLabel.setText("<html><pre>" + gameResults + "</pre></html>");
		JOptionPane.showMessageDialog(null, dialogLabel);

		//Show a Dialog Box asking the players if they want to play again and grab their choice
		dialogLabel.setText("Want to Play Again?");
		gameChoice = JOptionPane.showConfirmDialog(null, dialogLabel);

		//IF (The players want to play another game)
		if(gameChoice == JOptionPane.YES_OPTION)
		{
			//Set the player flag to the player who lost the previous game
			playerFlag = !playerFlag;

			//Set the game over variable to false
			isGameOver = false;

			//Uncover the game stats panel
			gameStatsPanel.setVisible(true);

			//Set the dice panel back to its original size
			dicePanel.setPreferredSize(new Dimension (600, 50));

			//Set the dice panel icons to their original default images
			giantDie1.setIcon(new ImageIcon("SideOne.png"));
			giantDie2.setIcon(new ImageIcon("SideOne.png"));

			//Uncover the die roll results label and set it to the original default text
			dieFaceLabel.setVisible(true);
			dieFaceLabel.setText("1                  1");

			//Reset the player scores label to zero
			scoresLabel.setText(player1Name + ": 0    ~~~~~~~~~~    " + player2Name + ": 0");

			//Reset all the player's points and turn points to zero
			playerTurnPoints = 0;
			player1TotalPoints = 0;
			player2TotalPoints = 0;

			//Set the game message label to its original font
			gameMessage.setFont(new Font("Cambria Math", Font.PLAIN, 36));

			//IF (Player 1 is going first)
			if(playerFlag)
			{
				//Set the game message label to say that player 1 goes first
				gameMessage.setText(player1Name + " is Going!");
			}

			//ELSE (Player 2 is going first)
			else
			{
				//Set the game message label to say that player 2 goes first
				gameMessage.setText(player2Name + " is Going!");

			} //END IF

			//Uncover the roll button
			rollButton.setVisible(true);

			//Uncover and disable the hold button
			holdButton.setVisible(true);
			holdButton.setEnabled(false);
		}

		//ELSE (The players don't want to play another game)
		else
		{
			//Hide all the panels except the dice panel
			buttonPanel.setVisible(false);
			gameStatsPanel.setVisible(false);
			sideImagePanel1.setVisible(false);
			sideImagePanel2.setVisible(false);

			//Increase the size of the dice panel to fill the empty space
			dicePanel.setPreferredSize(new Dimension(1400, 600));

			//Hide one of the dice panel icons
			giantDie2.setVisible(false);

			//Remove the image from the other dice panel icon and change it to an ending message with a font and text color
			giantDie1.setIcon(null);
			giantDie1.setText("Thanks for Playing! Please close out of the Window");
			giantDie1.setFont(new Font("Cambria Math", Font.PLAIN, 56));
			giantDie1.setForeground(Color.white);

		} //END IF

	} //END endGame

	/**********************************************************
	* Class Name     : StartButtonListener
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Listener Class is tied to the
	*    Start Button. The Listener implements the ActionListener Class.
	*    There is one method that is called whenever the button is pressed.
	*
	* Methods:
	* -------
	* actionPerformed - Starts the game by asking the players for their names
	*
	**********************************************************/

	private class StartButtonListener implements ActionListener
	{
		//Class Constants

		//Class Variables

		/**********************************************************
		* Method Name    : actionPerformed
		* Author         : Jack Wilcox
		* Date           : 5/15/22
		* Course/Section : CSC - 264 - 302
		* Program Description: This method will be called whenever
		*    the Start Button is pressed. The players will be asked
		*    to input their names that will be used during the game.
		*    After the names have been entered, the Start Button will
		*    be made invisible and the Roll, Hold, and Game History
		*    Buttons will be made visible.
		*
		* BEGIN actionPerformed
		*    Set the start button's visibility to false
		*	 Show a Dialog Box asking the first player to input their name
		*	 Show a Dialog Box asking the second player to input their name
		*    IF (Player 1 fails to enter a name)
		*	    Set player 1's name to the default name
		*	 END IF
		*	 IF (Player 2 fails to enter a name)
		*		Set player 2's name to the default name
		*	 END IF
		*	 Update the scores label to include the players' chosen names
		*	 Update the game message label to say that player 1 is going and set its visibility to true
        *    Set the game history button's visibility to true
		*	 Set the roll button's visibility to true
		*	 Set the hold button's visibility to true and disable its function
		* END actionPerformed
		**********************************************************/

		public void actionPerformed(ActionEvent event)
		{
			//Local Constants

			//Local Variables

			/********************  Start actionPerformed  ********************/

			//Set the start button's visibility to false
			startButton.setVisible(false);

			//Show a Dialog Box asking the first player to input their name
			dialogLabel.setText("Enter Your Name Player 1: ");
			player1Name = JOptionPane.showInputDialog(dialogLabel);

			//Show a Dialog Box asking the second player to input their name
			dialogLabel.setText("Enter Your Name Player 2: ");
			player2Name = JOptionPane.showInputDialog(dialogLabel);

			//IF (Player 1 fails to enter a name)
			if(player1Name == null)
			{
				//Set player 1's name to the default name
				player1Name = "Player 1";

			} //END IF

			//IF (Player 2 fails to enter a name)
			if(player2Name == null)
			{
				//Set player 2's name to the default name
				player2Name = "Player 2";

			} //END IF

			//Update the scores label to include the players' chosen names
			scoresLabel.setText(player1Name + ": 0    ~~~~~~~~~~    " + player2Name + ": 0");

			//Update the game message label to say that player 1 is going and set its visibility to true
			gameMessage.setText(player1Name + " is Going!");
			gameMessage.setVisible(true);

			//Set the game history button's visibility to true
			gameHistoryButton.setVisible(true);

			//Set the roll button's visibility to true
			rollButton.setVisible(true);

			//Set the hold button's visibility to true and disable its function
			holdButton.setVisible(true);
			holdButton.setEnabled(false);

		} //END actionPerformed

	} //END StartButtonListener

	/**********************************************************
	* Class Name     : ScoreButtonListener
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Listener Class is tied to the
	*    Game History Button. The Listener implements the ActionListener Class.
	*    There is one method that is called whenever the button is pressed.
	*
	* Methods:
	* -------
	* actionPerformed - Shows the history of past games and the wins for each player
	*
	**********************************************************/

	private class ScoresButtonListener implements ActionListener
	{
		//Class Constants

		//Class Variables

		/**********************************************************
		* Method Name    : actionPerformed
		* Author         : Jack Wilcox
		* Date           : 5/15/22
		* Course/Section : CSC - 264 - 302
		* Program Description: This method will be called whenever
		*    the Game History Button is pressed. It will show the
		*    previous games results as well as the wins that each
		*    player has accumulated.
		*
		* BEGIN actionPerformed
		*    Show the game history and game wins in a Dialog Box
		* END actionPerformed
		**********************************************************/

		public void actionPerformed(ActionEvent event)
		{
			//Local Constants

			//Local Variables

			/********************  Start actionPerformed  ********************/

			//Show the game history and game wins in a Dialog Box
			dialogLabel.setText("<html><pre>" + gameHistoryOutput + "          " + gameWinsOutput + "</pre></html>");
			JOptionPane.showMessageDialog(null, dialogLabel);

		} //END actionPerformed

	} //END ScoreButtonListener

	/**********************************************************
	* Class Name     : RollButtonListener
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Listener Class is tied to the
	*    Roll Button. The Listener implements the ActionListener Class.
	*    There is one method that is called whenever the button is pressed.
	*
	* Methods:
 	* -------
 	* actionPerformed - Rolls the die for the player and determines both the points the player receives and if their turn will continue
 	*
	**********************************************************/

	private class RollButtonListener implements ActionListener
	{
	    //Class Constants

		//Class Variables

		/**********************************************************
		* Method Name    : actionPerformed
		* Author         : Jack Wilcox
		* Date           : 5/15/22
		* Course/Section : CSC - 264 - 302
		* Program Description: This method will be called whenever
		*    the Roll Button is pressed. It will "roll" the die
		*    for the player and determine how many points the player will
		*    get or if their turn has ended. Dialog Boxes will appear
		*    showing the result of the turn, such as telling you
		*    if the turn is over or exactly how many points you got
		*    It will also enable and disable the Hold Button as it needs to
		*    If the player's turn has ended, it will tell the other
		*    player to take their turn. This method will also do miscellaneous
		*    things such as change the side pig images as the players roll.
		*
		* BEGIN actionPerformed
		*    IF (It's the player's first roll)
		*       Set the player's points for that turn to zero
		*	 END IF
		*	 Randomly chose a new pig image for both side images
		*	 Roll both die objects
		*	 Store the result of the rolls as integers
		*	 Store the result of the rolls as Strings
		*	 Change the die icons according to the face that was rolled on each one
		*	 Set the label under the die icons to the according numbers that were rolled
		*	 IF (At least a single one was rolled)
		*		Change the two side images to images of pigs laughing
		*		IF (Two ones were rolled)
		*	       Show a Dialog Box that tells the player they rolled two ones and they lose all their points
		*		   IF (It's Player 1's turn)
		*		      Set player 1's total points to zero
		*		   ELSE (It's Player 2's turn)
		*			  Set player 2's total points to zero
		*		   END IF
        *       ELSE (Only a single one was rolled)
		*		   Show a Dialog Box that tells the player they rolled a one and their turn is over
		*		   IF (It's Player 1's turn)
		*		      Remove the points player 1 got that turn from their total score
		*		   ELSE (It's Player 2's turn)
		*			  Remove the points player 2 got that turn from their total score
		*		   END IF
		*		END IF
		*		Set the player's turn over variable to true
		*	 ELSE (No ones were rolled)
		*		Add the result of the roll to the player's points for that turn
		*		Store the results of that player's roll as a String
		*		Display the results of the player's roll in a Dialog Box
		*		IF (It's Player 1's turn)
		*		   Add the results of the roll to player 1's total points
		*		ELSE (It's Player 2's turn)
		*		   Add the results of the roll to player 2's total points
		*		END IF
		*		Set the player's first roll variable to false
		*		IF (The player has rolled more than the maximum number of points per turn)
		*		   Set the player's turn over variable to true
		*		END IF
		*		IF (Either player has rolled the number of points required to win the game)
		*		   Set the game over variable to true
		*		END IF
		*	 END IF
		*	 Set the scores label to show the updated scores after the most recent turn
		*	 IF (One of the players has won the game)
		*       Call the method to end the game
		*	 ELSE IF (The current player's turn is not over)
		*		Enable the hold button so that the player can choose to take another turn or not
		*	 ELSE (The current player's turn is over)
		*		Set the total turn points to zero
		*		Set the player flag to the other player
		*		Disable the hold button
		*		IF (It's Player 1's turn next)
		*		   Set the game message label to say that player 1 is going next
		*          Set the Dialog Box text to show that player 1 is going next
		*		ELSE (It's Player 2's turn next)
		*		   Set the game message label to say that player 2 is going next
		*          Set the Dialog Box text to show that player 2 is going next
		*		END IF
		*       Display the Dialog Box to show who is going next
		*		Set the player's turn over variable to false
	    *    END IF
		* END actionPerformed
		**********************************************************/

		public void actionPerformed(ActionEvent event)
		{
			//Local Constants

			//Local Variables

			/********************  Start actionPerformed  ********************/

			//IF (It's the player's first roll)
			if(isFirstRoll)
			{
				//Set the player's points for that turn to zero
				playerTurnPoints = 0;

			} //END IF

			//Randomly chose a new pig image for both side images
			sideImageLabel1.setIcon(pigImages[(int) (Math.random() * 5)]);
			sideImageLabel2.setIcon(pigImages[(int) (Math.random() * 5)]);

			//Roll both die objects
			dieObj1.roll();
			dieObj2.roll();

			//Store the result of the rolls as integers
			die1Result = dieObj1.getFace();
			die2Result = dieObj2.getFace();

			//Store the result of the rolls as Strings
			stringDie1Result = dieObj1.toString();
			stringDie2Result = dieObj2.toString();

			//Change the die icons according to the face that was rolled on each one
			giantDie1.setIcon(new ImageIcon("Side" + stringDie1Result + ".png"));
			giantDie2.setIcon(new ImageIcon("Side" + stringDie2Result + ".png"));

			//Set the label under the die icons to the according numbers that were rolled
			dieFaceLabel.setText(die1Result + "                  " + die2Result);

			//IF (At least a single one was rolled)
			if(die1Result == 1 || die2Result == 1)
			{
				//Change the two side images to images of pigs laughing
				sideImageLabel1.setIcon(new ImageIcon("PigLaughing1.jpg"));
				sideImageLabel2.setIcon(new ImageIcon("PigLaughing2.jpg"));

				//IF (Two ones were rolled)
				if(die1Result == 1 && die2Result == 1)
				{
					//Show a Dialog Box that tells the player they rolled two ones and they lose all their points
					dialogLabel.setText("<html><pre>You rolled two 1s!\nYou lose all your points and your turn is over!!</pre></html>");
					JOptionPane.showMessageDialog(null, dialogLabel);

					//IF (It's Player 1's turn)
					if(playerFlag)
					{
						//Set player 1's total points to zero
						player1TotalPoints = 0;
					}

					//ELSE (It's Player 2's turn)
					else
					{
						//Set player 2's total points to zero
						player2TotalPoints = 0;

					} //END IF
				}

				//ELSE (Only a single one was rolled)
				else
				{
					//Show a Dialog Box that tells the player they rolled a one and their turn is over
					dialogLabel.setText("<html><pre>You rolled a 1!\nYour turn is over!!</pre></html>");
					JOptionPane.showMessageDialog(null, dialogLabel);

					//IF (It's Player 1's turn)
					if(playerFlag)
					{
						//Remove the points player 1 got that turn from their total score
						player1TotalPoints -= playerTurnPoints;
					}

					//ELSE (It's Player 2's turn)
					else
					{
						//Remove the points player 2 got that turn from their total score
						player2TotalPoints -= playerTurnPoints;

					} //END IF

				} //END IF

				//Set the player's turn over variable to true
				isTurnOver = true;
			}

			//ELSE (No ones were rolled)
			else
			{
				//Add the result of the roll to the player's points for that turn
				playerTurnPoints += die1Result + die2Result;

				//Store the results of that player's roll as a String
				rollResult = "You rolled a " + die1Result + " and a " + die2Result + "!" +
							 "\nYou got " + (die1Result + die2Result) + " points!" +
							 "\nTotal Points this Turn: " + playerTurnPoints;

				//Display the results of the player's roll in a Dialog Box
				dialogLabel.setText("<html><pre>" + rollResult + "</pre></html>");
				JOptionPane.showMessageDialog(null, dialogLabel);

				//IF (It's Player 1's turn)
				if(playerFlag)
				{
					//Add the results of the roll to player 1's total points
					player1TotalPoints += die1Result + die2Result;
				}

				//ELSE (It's Player 2's turn)
				else
				{
					//Add the results of the roll to player 2's total points
					player2TotalPoints += die1Result + die2Result;

				} //END IF

				//Set the player's first roll variable to false
				isFirstRoll = false;

				//IF (The player has rolled more than the maximum number of points per turn)
				if(playerTurnPoints >= MAX_TURN_POINTS)
				{
					//Set the player's turn over variable to true
					isTurnOver = true;

				} //END IF

				//IF (Either player has rolled the number of points required to win the game)
				if(player1TotalPoints >= MAX_GAME_POINTS || player2TotalPoints >= MAX_GAME_POINTS)
				{
					//Set the game over variable to true
					isGameOver = true;

				} //END IF

			} //END IF

			//Set the scores label to show the updated scores after the most recent turn
			scoresLabel.setText(player1Name + ": " + player1TotalPoints + "    ~~~~~~~~~~    " +
			player2Name + ": " + player2TotalPoints);

			//IF (One of the players has won the game)
			if(isGameOver)
			{
				//Call the method to end the game
				endGame();
			}

			//ELSE IF (The current player's turn is not over)
			else if(!isTurnOver)
			{
				//Enable the hold button so that the player can choose to take another turn or not
				holdButton.setEnabled(true);
			}

			//ELSE (The current player's turn is over)
			else
			{
				//Set the total turn points to zero
				playerTurnPoints = 0;

				//Set the player flag to the other player
				playerFlag = !playerFlag;

				//Disable the hold button
				holdButton.setEnabled(false);

				//IF (It's Player 1's turn next)
				if(playerFlag)
				{
					//Set the game message label to say that player 1 is going next
					gameMessage.setText(player1Name + " is Going!");

					//Set the Dialog Box text to show that player 1 is going next
					dialogLabel.setText("<html><pre>" + player1Name + "'s Turn!" + "</pre></html>");
				}

				//ELSE (It's Player 2's turn next)
				else
				{
					//Set the game message label to say that player 2 is going next
					gameMessage.setText(player2Name + " is Going!");

					//Set the Dialog Box text to show that player 2 is going next
					dialogLabel.setText("<html><pre>" + player2Name + "'s Turn!" + "</pre></html>");

				} //END IF

				//Display the Dialog Box to show who is going next
				JOptionPane.showMessageDialog(null, dialogLabel);

				//Set the player's turn over variable to false
				isTurnOver = false;

			} //END IF

		} //END actionPerformed

	} //END RollButtonListener

	/**********************************************************
	* Class Name     : HoldButtonListener
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Listener Class is tied to the
	*    Hold Button. The Listener implements the ActionListener Class.
	*    There is one method that is called whenever the button is pressed.
	*
	* Methods:
	* -------
	* actionPerformed - Ends the player's turn voluntarily, keeping all the points they accumulated
	*
	**********************************************************/

	private class HoldButtonListener implements ActionListener
	{
		//Class Constants

		//Class Variables

		/**********************************************************
		* Method Name    : actionPerformed
		* Author         : Jack Wilcox
		* Date           : 5/15/22
		* Course/Section : CSC - 264 - 302
		* Program Description: This method will be called whenever
		*    the Hold Button is pressed. All the method does is
		*    end the current player's turn and pass play on to
		*    the other player without any penalties for the
		*    current player. Since the Hold Button is disabled
		*    at the beginning of a player's turn, this means that
		*    the player has to roll at least once before being
		*    given the option to hold. The Hold Button will also
		*    disable itself after being pressed.
		*
		* BEGIN actionPerformed
		*    IF (Player 1 just ended their turn)
		*	    Set the game message label to say that player 2 is going
		*       Set the Dialog Box text to show that player 2 is going next
		*    ELSE (Player 2 just ended their turn)
		*		Set the game message label to say that player 1 is going
		*       Set the Dialog Box text to show that player 1 is going next
		*	 END IF
		*    Display the Dialog Box to show who is going next
		*	 Set the player flag to the other player
		*	 Set the player's first roll variable to true
		*	 Disable the hold button
		* END actionPerformed
		**********************************************************/

		public void actionPerformed(ActionEvent event)
		{
			//Local Constants

			//Local Variables

			/********************  Start actionPerformed  ********************/

			//IF (Player 1 just ended their turn)
			if(playerFlag)
			{
				//Set the game message label to say that player 2 is going
				gameMessage.setText(player2Name + " is Going!");

				//Set the Dialog Box text to show that player 2 is going next
				dialogLabel.setText("<html><pre>" + player2Name + "'s Turn!" + "</pre></html>");
			}

			//ELSE (Player 2 just ended their turn)
			else
			{
				//Set the game message label to say that player 1 is going
				gameMessage.setText(player1Name + " is Going!");

				//Set the Dialog Box text to show that player 1 is going next
				dialogLabel.setText("<html><pre>" + player1Name + "'s Turn!" + "</pre></html>");

			} //END IF

			//Display the Dialog Box to show who is going next
			JOptionPane.showMessageDialog(null, dialogLabel);

			//Set the player flag to the other player
			playerFlag = !playerFlag;

			//Set the player's first roll variable to true
			isFirstRoll = true;

			//Disable the hold button
			holdButton.setEnabled(false);

		} //END actionPerformed

	} //END HoldButtonListener

} //END PigGamePanel