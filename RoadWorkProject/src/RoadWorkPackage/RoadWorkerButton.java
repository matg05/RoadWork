package RoadWorkPackage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Lead Author(s):
 * @author Thomas Woods
 * @author Mateo Guerrero
 * 
 * Other contributors: N/A
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 1.0 4/17/2025
 * 
 * Responsibilities of class: Responsible for creating a customized search button used in the GUI.
 */

public class RoadWorkerButton extends JButton 
{
	/**
	 * Button Class
	 */
    public RoadWorkerButton() 
    {
        super("Search");
        setBackground(Color.WHITE);
        setFont(new Font("SansSerif", Font.ITALIC, 24));
    }
}