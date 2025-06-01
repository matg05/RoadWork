package RoadWorkPackage;

import javax.swing.*;

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
 * Responsibilities of class: Where the main method is located to run the program.
 */

public class Main 
{
	/*
	 * Where program starts.
	 */
    public static void main(String[] args) 
    {
            RoadWorkOrganizer organizer = new RoadWorkOrganizer();
            new RoadWorkerGUI(organizer);
    }
}