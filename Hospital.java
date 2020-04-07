import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * Deals with operations that go to do with using the professionals details
 * which are stored in the Professional class. These operations would include:
 * adding item to linked list, deleting from linked list and so on.
 * 
 * @author Daniel Jakubek
 * @Version March 2020
 *
 */
public class Hospital
{
	LinkedList<Professional> professionalObject;
	
	/**
	 * Constructor
	 */
	public Hospital()
	{
		professionalObject = new LinkedList<Professional>(); 
	}
	
	/**
	 * deals with adding items to the linked list
	 * @param details about the professional (e.g. their name, profession and work location)
	 */
	public void addProfessionalToList(Professional details)
	{
		//adds the details to the list
		professionalObject.add(details);
	}
	
	/**
	 * deals with printing the whole linked list full of professionals
	 */
	public void printProfessionalList()
	{
		//checks if the list is empty
		if(professionalObject.isEmpty())
		{
			System.out.println("There are no professionals in the system");
		}
		else
		{
			//Iterator of type Professional
		    Iterator<Professional> it = professionalObject.iterator();
		 
			//Iterates through the list while it is not empty
			System.out.println("==========Porfessionals==========");
			while(it.hasNext())
			{
				Professional nextProfessional = it.next();
				System.out.println("ID: " + nextProfessional.getProfID() + "\rName: " + nextProfessional.getName() + "\rProfession: " +  nextProfessional.getProfession() + "\rWork Location " + nextProfessional.getWorkLocation());
				System.out.println("");
			}
		}
	}
	
	/**
	 * method that asks for user input for the professional's ID
	 * @return professionalID, the ID of the professional
	 */
	public int getProfessionalsID()
	{
		Scanner detailsScanner = new Scanner(System.in);  // Create a Scanner object
		
		String userProfID= "";
		int professionalID = 0;
		
		do
		{
			try
			{
				System.out.println("Enter Professional's ID");
				//makes userInput to the user's input
				userProfID = detailsScanner.nextLine();
	
				//converts user input to integer value
				professionalID = Integer.parseInt(userProfID);
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input! try again");
				professionalID = 0;
			}
			
			//Iterator of type Professional
		    Iterator<Professional> it = professionalObject.iterator();
		 
		    //checks if the ID is unique
			while(it.hasNext())
			{
				Professional nextProfessional = it.next();
				
				//checks if list already contains that ID
				if(nextProfessional.getProfID() == professionalID)
				{
					professionalID = 0;
				}
			}
			
		//loops as long as the the ID is unique and greater than one
		}while(professionalID <1);
		
		return professionalID;
	}
	
	/**
	 * Asks for the user input and then adds that input to the list
	 */
	public void askForDetails()
	{
		Scanner detailsScanner = new Scanner(System.in);  // Create a Scanner object
		
		int professionalID = getProfessionalsID();
		
		System.out.println("Enter Professionals Name: ");
		String professionalName = detailsScanner.nextLine(); // gets the professionals name
		
		System.out.println("Enter profession: ");
		String profession = detailsScanner.nextLine(); // gets the professionals profession
		
		System.out.println("Enter Work Location: ");
		String professionalsWorkLocation = detailsScanner.nextLine(); // gets the professionals work location
		
		//creates professionalDetails to store details of the professional
		Professional professionalDetails = new Professional(professionalID, professionalName, profession, professionalsWorkLocation);
		
		//adds the details of a professional to a linked list
		addProfessionalToList(professionalDetails);	
	}
	
	/**
	 * Asks for the professional they want to delete and then deletes them
	 */
	public void deleteProfessionalDetails()
	{
		Scanner deleteScanner = new Scanner(System.in);  // Create a Scanner object

		String userProfID= "";
		int professionalID = 0;
		
		do
		{
			try
			{
				System.out.println("Professional's ID to delete: ");
				//makes userInput to the user's input
				userProfID = deleteScanner.nextLine();
	
				//converts user input to integer value
				professionalID = Integer.parseInt(userProfID);
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input! try again");
				professionalID = 0;
			}
			
		//loops as long as the the ID is unique and greater than one
		}while(professionalID <1);
		
		//Iterator of type Professional
	    Iterator<Professional> it = professionalObject.iterator();
	 
		//Iterates through the list while it is not empty
		while(it.hasNext())
		{
			Professional nextProfessional = it.next();
			
			//removes the item if it is found
			if(nextProfessional.getProfID() == professionalID)
			{
				professionalObject.remove(nextProfessional);
			}
		}
	}
	
	/**
	 *Asks the user what professional they want to edit based on their ID. After that
	 *asks them what part they want to edit e.g. ID, name etc.
	 */
	public void editProfessionals()
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object

		String userProfID= "";
		int professionalID = 0;
		
		do
		{
			try
			{
				System.out.println("Professional to edit: ");
				//makes userInput to the user's input
				userProfID = editScanner.nextLine();
	
				//converts user input to integer value
				professionalID = Integer.parseInt(userProfID);
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input! try again");
				professionalID = 0;
			}
			
		//loops as long as the the ID is unique and greater than one
		}while(professionalID <1);
		
		
		//Iterator of type Professional
	    Iterator<Professional> it = professionalObject.iterator();
	 
		//Iterates through the list while it is not empty
		while(it.hasNext())
		{
			Professional nextProfessional = it.next();
			
			//removes the item if it is found
			if(nextProfessional.getProfID() == professionalID)
			{
				boolean editing = true;
				
				while(editing)
				{
					System.out.println("What would you like to edit?");
					System.out.print("\r 1:ID \r 2:Name \r 3:Profession \r 4: Work Location \r 5:Finished \r Option: ");
					
					String userChoice = editScanner.nextLine();
					//switch that checks the values of userChoice
					//Calls appropriate method from the Files class depending on the user choice
					switch(userChoice) 
					{
						 case "1":
						 {
							System.out.println("Enter Professional's ID: ");
							nextProfessional.setProfID(getProfessionalsID()); // sets the professionals ID
							break;
						 }
						 
						 case "2":
						 {
							System.out.println("Enter Professionals Name: ");
							nextProfessional.setName(editScanner.nextLine()); // sets the professionals name
							break;
						 }
						 case "3":
						 {
							System.out.println("Enter Professionals Profession: ");
							nextProfessional.setProfession(editScanner.nextLine()); // sets the professionals profession
							break;
						 }
						 case "4":
						 {
							System.out.println("Enter Professionals Work Location: ");
							nextProfessional.setWorkLocation(editScanner.nextLine()); // sets the work location
							break;
						 }
						 case "5":
						 {

							editing = false;
							break;
						 }
						 default: //Default, if user input does not match, sends error message
						 {
							 System.out.println("Invalid input. Please try again.");
							 break;
						 }
					 }
				}	
			}
		}
	}
}
