package RoadWorkPackage;

import java.util.ArrayList;
import java.util.Hashtable;

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
 * Responsibilities of class: Responsible for splitting up the raw CSV lines into fields, storing them, and 
 * searching for records by ID or title.
 */

public class RoadWorkOrganizer 
{
	public RoadWorkFile file = new RoadWorkFile(); // RoadWorkOrganizer has-a file

	private ArrayList<String> organizedList = new ArrayList<>(); // RoadWorkOrganizer has-a organizedList
	private String[] hasharrayList = new String[4]; // RoadWorkOrganizer has-a hasharrayList
	private int hashIndex = 0; // RoadWorkOrganizer has-a hashIndex
	private Hashtable<String, String> workTable; // RoadWorkOrganizer has-a workTable
	private static Hashtable<String, String> workTableStore; // RoadWorkOrganizer has-a workTableStore
	
	// Maps each record's unique ID to its corresponding title for quick lookup and searching
	private Hashtable<String, String> titleLookupTable = new Hashtable<>(); // RoadWorkOrganizer has-a titleLookupTable

	private int lineCategory = 0; // RoadWorkOrganizer has-a lineCategory
	private boolean inQuotes = false; // RoadWorkOrganizer has-a inQuotes
	private String lineText; // RoadWorkOrganizer has-a s
	private String testid; // RoadWorkOrganizer has-a testid

	public RoadWorkOrganizer() 
	{
		//Sets the organized List to the list in getmyList
		this.organizedList = this.file.getmyList();
		workTable = new Hashtable<>();
		for (int i = 1; i < organizedList.size(); i++) 
		{
			lineText = organizedList.get(i);
			listStorter();
		}
		workTableStore = workTable;
	}

	/**
	 * Sorts out the list and gets, the objectID, title, startTime, and the phone number.
	 */
	public void listStorter() 
	{
		//Create new String Builder to search through line.
		StringBuilder reader = new StringBuilder();
		hashIndex = 0;
		int fieldCount = 0;
		String tempTitle = null;
		for (char readNumber : lineText.toCharArray()) 
		{
			//If the part being read has quotation marks...
			if (readNumber == '"') 
			{
				//Put it all as one part.
				inQuotes = !inQuotes;
			} 
			else if (readNumber == ',' && !inQuotes) 
			{
				lineCategory++;
				fieldCount++;
				//Using lineCategory, save the string in the case number.
				switch (lineCategory) 
				{
					case 1:
						testid = reader.toString();
						hasharrayList[hashIndex++] = reader.toString();
						break;
					case 3:
						hasharrayList[hashIndex++] = reader.toString();
						tempTitle = reader.toString();
						break;
					case 4:
						hasharrayList[hashIndex++] = reader.toString();
						break;
					case 8:
						hasharrayList[hashIndex++] = reader.toString();
						workTable.put(testid, arrayToString(hasharrayList, hashIndex));
						if (tempTitle != null) titleLookupTable.put(testid, tempTitle);
						// Reset array for next line
						for (int j = 0; j < hasharrayList.length; j++) hasharrayList[j] = null;
						hashIndex = 0;
						tempTitle = null;
						break;
				}
				reader.setLength(0);
			} 
			else 
			{
				reader.append(readNumber);
			}
		}
		lineCategory = 0;
	}

	// Helper to convert array to string representation
	private String arrayToString(String[] arr, int len) 
	{
		StringBuilder sb = new StringBuilder("[");
		for (int k = 0; k < len; k++) 
		{
			sb.append(arr[k]);
			if (k != len - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Get the data with the certain Id.
	 */
	public String searchId(String idNumber) 
	{
		String data = workTableStore.get(idNumber);
		return data;
	}

	/*
	 * Get data with the title
	 */
	public String searchTitle(String query) 
	{
		if (query == null || query.trim().isEmpty()) return "";
		//Create new String Builder to search through line.
		StringBuilder results = new StringBuilder();
		for (String id : titleLookupTable.keySet()) 
		{
			String t = titleLookupTable.get(id);
			if (t != null && t.toLowerCase().contains(query.toLowerCase())) 
			{
				String data = workTableStore.get(id);
				results.append("ID: ").append(id).append(" -> ").append(data).append("\n");
			}
		}
		if (results.length() == 0) return "";
		return results.toString();
	}
}