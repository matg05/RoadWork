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
 * Responsibilities of class: Sub class of Vehicle, SuperClass of GasCar, ElectricCar, and HybridCar 
 * 
 */
public abstract class RoadWorker
{
	private String id;
	//private Address address;
	private String name;
	
	public RoadWorker(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public abstract String getId();
	
	public abstract String getName();
	
	// Setters and Getters
	
	
	
	
	/**
	 * Purpose: To test thing and the code, may be remove at a future date.
	 * @param args
	 */
	public static void main(String[] args) 
	{
	    new RoadWorkerGUI();
	}
	
	
}