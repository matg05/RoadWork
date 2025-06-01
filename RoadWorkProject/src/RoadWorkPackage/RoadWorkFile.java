package RoadWorkPackage;

import java.io.*;
import java.util.*;

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
 * Responsibilities of class: Responsible for reading the CSV file from disk and storing each line for the program to use.
 */

public class RoadWorkFile 
{
	private ArrayList<String> myList = new ArrayList<>(); // RoadWorkFile has-a myList

	/**
	 * Reads the DOOOD.csv file and puts every line into a ArrayList.
	 */
	public RoadWorkFile() 
	{
		readFile();
	}

	private void readFile() {
		
		try {
			
			Scanner scanner = new Scanner(new File("DOOOD.csv"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				myList.add(line);
			}
			scanner.close();
		} catch (IOException e) 
		{
			System.out.println("Could not read file: DOOOD.csv");
		}
	}

	/**
	 * Allows other class to get the ArrayList created here.
	 * @return myList
	 */
	public ArrayList<String> getmyList() 
	{
		return myList;
	}
}