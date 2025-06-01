/**
* Lead Author(s):
* @author mateo; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-05-26
*/
package RoadWorkPackage;

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
 * Responsibilities of class: Responsible for representing the details or fields of a single roadwork record.
 * (The functionality for the abstract class RoadWorker).
 */

public class RoadWorkerData extends RoadWorker
{
    private String objectID; // RoadWorkerData has-a objectID
    private String title; // RoadWorkerData has-a title

    /**
     * Holds the data and acts as a place to get the tile and ID's
     * @param objectID
     * @param title
     */
    public RoadWorkerData(String objectID, String title) 
    {
        super(objectID, title);
    }

    /**
     * Gets the ID
     * @return objectID
     */
    public String getObjectID() 
    {
        return objectID;
    }

    /**
     * Gets the Title
     * @return title
     */
    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() 
    {
        return "ID: " + objectID + ", Title: " + title;
    }

    /** 
     * Checks if the ID exactly matches the query.
     */
    public boolean idEquals(String query) 
    {
        return objectID != null && objectID.equals(query);
    }

    /**
     * Checks if the title contains the query (case-insensitive).
     */
    public boolean titleContains(String query) 
    {
        return title != null && title.toLowerCase().contains(query.toLowerCase());
    }
}
