/**********************************************************
 * Program Name   : PigSubPanel
 * Author         : Jack Wilcox
 * Date           : 5/15/22
 * Course/Section : CSC - 264 - 302
 * Program Description: This Class features many different
 *    Constructors that will create sub-panels that appear
 *    in the main panel for the Pig Game. 4 Constructors
 *    are present for the 4 types of sub-panels. The Constructors
 *    will not create any of the objects in the sub-panel, but
 *    rather will add them to the panel and give them special
 *    features, such as a unique font.
 *
 * Methods:
 * -------
 * Constructor (1) - Creates a sub-panel that has 3 JLabel objects and 1 JButton object
 * Constructor (2) - Creates a sub-panel that has 1 JLabel object and 3 JButton object
 * Constructor (3) - Creates a sub-panel that has 1 JLabel object
 * Constructor (4) - Creates a sub-panel that has 2 JLabel objects
 *
 **********************************************************/

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

public class PigSubPanel extends JPanel
{
	//Class Constants

	//Class Variables

	/**********************************************************
	* Method Name    : Constructor (1)
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Constructor will create a
	*    sub-panel with 3 JLabel objects and a JButton object. The objects will
	*    be added to the panel in the correct order and will
	*    be given unique fonts, text colors, sizes, and visibility preferences.
	*
	* BEGIN Constructor (1)
	*    Add the die labels to the sub-panel
	*	 Set the die face label's font and text color
	*	 Add the die face label to the sub-panel
	*    Set the scores button's font, size, and visibility
	*    Add the scores button to the sub-panel
	* END Constructor (1)
	**********************************************************/

	public PigSubPanel(JLabel giantDie1, JLabel giantDie2, JLabel dieFaceLabel, JButton gameHistoryButton)
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor (1) ********************/

		//Add the die labels to the sub-panel
		add(giantDie1);
		add(giantDie2);

		//Set the die face label's font and text color
		dieFaceLabel.setFont(new Font("Cambria Math", Font.BOLD, 50));
		dieFaceLabel.setForeground(Color.white);

		//Add the die face label to the sub-panel
		add(dieFaceLabel);

		//Set the scores button's font, size, and visibility
		gameHistoryButton.setFont(new Font("Cambria Math", Font.PLAIN, 35));
		gameHistoryButton.setPreferredSize(new Dimension(350, 50));
		gameHistoryButton.setVisible(false);

		//Add the scores button to the sub-panel
		add(gameHistoryButton);

	} //END Constructor (1)

	/**********************************************************
	* Method Name    : Constructor (2)
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Constructor will create a
	*    sub-panel with 1 JLabel object and 3 JButton objects. The objects will
	*    be added to the panel in the correct order and will
	*    be given unique fonts, text colors, visibility preferences,
	*    and sizes.
	*
	* BEGIN Constructor (2)
	*    Set the game message label's font, text color, and visibility
	*	 Add the game message label to the sub-panel
	*	 Set the roll button's font, size, and visibility
	*	 Add the roll button to the sub-panel
	*	 Set the hold button's font, size, and visibility
	*	 Add the hold button to the sub-panel
	*	 Set the start button's font and size
	*	 Add the start button to the sub-panel
	* END Constructor (2)
	**********************************************************/

	public PigSubPanel(JLabel gameMessage, JButton rollButton, JButton holdButton, JButton startButton)
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor (2) ********************/

		//Set the game message label's font, text color, and visibility
		gameMessage.setFont(new Font("Cambria Math", Font.PLAIN, 36));
		gameMessage.setForeground(Color.white);
		gameMessage.setVisible(false);

		//Add the game message label to the sub-panel
		add(gameMessage);

		//Set the roll button's font, size, and visibility
		rollButton.setFont(new Font("Cambria Math", Font.PLAIN, 30));
		rollButton.setPreferredSize(new Dimension(300, 50));
		rollButton.setVisible(false);

		//Add the roll button to the sub-panel
		add(rollButton);

		//Set the hold button's font, size, and visibility
		holdButton.setFont(new Font("Cambria Math", Font.PLAIN, 30));
		holdButton.setPreferredSize(new Dimension(300, 50));
		holdButton.setVisible(false);

		//Add the hold button to the sub-panel
		add(holdButton);

		//Set the start button's font and size
		startButton.setFont(new Font("Cambria Math", Font.PLAIN, 30));
		startButton.setPreferredSize(new Dimension(300, 50));

		//Add the start button to the sub-panel
		add(startButton);

	} //END Constructor (2)

	/**********************************************************
	* Method Name    : Constructor (3)
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Constructor will create a
	*    sub-panel with 1 JLabel object. The object will
	*    be added to the panel will be given a unique font and text color.
	*
	* BEGIN Constructor (3)
	*    Set the scores label's font and text color
	*    Add the scores label to the sub-panel
	* END Constructor (3)
	**********************************************************/

	public PigSubPanel(JLabel scoresLabel)
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor (3) ********************/

		//Set the scores label's font and text color
		scoresLabel.setFont(new Font("Cambria Math", Font.PLAIN, 45));
		scoresLabel.setForeground(Color.white);

		//Add the scores label to the sub-panel
		add(scoresLabel);

	}  //END Constructor (3)

	/**********************************************************
	* Method Name    : Constructor (4)
	* Author         : Jack Wilcox
	* Date           : 5/15/22
	* Course/Section : CSC - 264 - 302
	* Program Description: This Constructor will create a
	*    sub-panel with 2 JLabel objects. The objects will
	*    be added to the panel in the correct order and will
	*    be given unique fonts, text colors.
	*
	* BEGIN Constructor (4)
	*    Add the side image label to the sub-panel
	*	 Set the pig noise label's font and text color
	*	 Add the pig noise label to the sub-panel
	* END Constructor (4)
	**********************************************************/

	public PigSubPanel(JLabel sideImageLabel, JLabel pigNoiseLabel)
	{
		//Local Constants

		//Local Variables

		/********************  Start Constructor (4) ********************/

		//Add the side image label to the sub-panel
		add(sideImageLabel);

		//Set the pig noise label's font and text color
		pigNoiseLabel.setFont(new Font("Goudy Stout", Font.ITALIC, 28));
		pigNoiseLabel.setForeground(Color.pink);

		//Add the pig noise label to the sub-panel
		add(pigNoiseLabel);

	}  //END Constructor (4)

} //END PigSubPanel