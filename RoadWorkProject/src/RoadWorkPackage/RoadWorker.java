package RoadWorkPackage;

import java.awt.List;
import java.io.FileNotFoundException;
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
 * Responsibilities of class: Responsible for representing a generic road worker or record, providing common properties 
 * or methods to be searched through
 */

/**
 * Abstract Class for the title and objectID's.
 */
public abstract class RoadWorker
{
    protected String objectID; // RoadWorker has-a objectID
    protected String title; // RoadWorker has-a title

    public RoadWorker(String objectID, String title)
    {
        this.objectID = objectID;
        this.title = title;
    }

    public String getObjectID() 
    {
        return objectID;
    }

    public String getTitle() 
    {
        return title;
    }

}