import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * Deals with operations that go to do with using the professionals details
 * which are stored in the Professional class. These operations would include:
 * adding item to linked list, deleting from linked list and so on.
 * 
 * @author Team 20
 * @Version April 2020
 *
 */
public class Hospital
{
	LinkedList<Professional> professionalObject;
	LinkedList<Integer> professionalsChosen;
	
	/**
	 * Constructor
	 */
	public Hospital()
	{
		professionalObject = new LinkedList<Professional>(); 
		professionalsChosen = new LinkedList<Integer>();
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
	
	public Professional getpro(int ID)
	{
		//Iterator of type Professional
	    Iterator<Professional> it = professionalObject.iterator();
	 
	    //checks if the ID is unique
		while(it.hasNext())
		{
			Professional nextProfessional = it.next();
			if(nextProfessional.getProfID()==ID)
			{
				return nextProfessional;
			}
		}
		return null;
	}
	
	/**
	 * deals with adding the chosen professional's ID to a linked list
	 * @param ID of the professional
	 */
	public void addChosenProfessionalToList(int ID)
	{
		//adds the details to the list
		professionalsChosen.add(ID);
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
	
	/**
	 * This method prints the list of professionals and then asks the user to
	 * choose which professional they want in their appointment and then adds
	 * them to a linked list
	 */
	public void chooseProfessionals()
	{
		Scanner chooseScanner = new Scanner(System.in);  // Create a Scanner object
		
		//prints the list of all professionals
		printProfessionalList();
	
		boolean choosing = true;
		
		//loops while the user chooses what professionals they want an appointment with
		while(choosing)
		{
			System.out.println("Choose health professionals that you would like an appointment with by their ID\r Enter 0 to quit");

			int professionalIDChosen = 0;
			
			do
			{
				try
				{
					//makes userInput to the user's input
					String profChosen = chooseScanner.nextLine();
		
					//converts user input to integer value
					professionalIDChosen = Integer.parseInt(profChosen);
				}
				catch(Exception e) 
				{
					System.out.println("Invalid input! try again");
					professionalIDChosen = -1;
				}
				
				if(professionalIDChosen == 0)
				{
					choosing = false;
					return;
				}
				
				//Iterator of type Professional
			    Iterator<Integer> it = professionalsChosen.iterator();
			 
			    //checks if the ID is unique
				while(it.hasNext())
				{
					int nextProfessional = it.next();
					
					//checks if list already contains that ID
					if(nextProfessional == professionalIDChosen)
					{
						professionalIDChosen = -1;
					}
				}
			}while(professionalIDChosen <0);
			
			//adds the chosen professional to a list
			addChosenProfessionalToList(professionalIDChosen);
		}
	}
	
	/**
	 * Prints the ID list of all professionals chosen by iterating through the 
	 * integer linked list
	 */
	public void printChosenProfessionals()
	{
		 Iterator<Integer> it = professionalsChosen.iterator();
		
		
		while(it.hasNext()) 
		{
	         System.out.println(it.next());
	    }
	}
	
	/**
	 * This method asks the user to input the start date that they want to start the search on and then
	 * return an array that contains day, month and year.
	 * @return intStartDate array composed of the date
	 */
	public int[] returnStartTime()
	{
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		int intStartDate[] = new int[3];
		
		Scanner chooseScanner = new Scanner(System.in);  // Create a Scanner object
		
		System.out.println("Enter start date in the dd/mm/yyyy format");
		
		boolean askingforDates = true;
		
		//loops while the user is entering the date
		while(askingforDates)
		{
			System.out.println("Enter the start date in the dd/mm/yyyy format");
			
			String startDate = chooseScanner.nextLine();
			intStartDate = dateToInt(startDate);
			
			//keeps on asking the user to re-input their date if it failed the validation 
			while((intStartDate[0] < day && intStartDate[1] <= month) || intStartDate[2] < year || intStartDate[0] > 31 || intStartDate[1] > 12 || intStartDate[1] < month)
			{
				System.out.println("Enter the start date in the dd/mm/yyyy format");
				
				startDate = chooseScanner.nextLine();
				intStartDate = dateToInt(startDate);
			}
			
			askingforDates = false;	
		}
	
		return intStartDate;
	}
	
	/**
	 * This method asks the user to input the start date that they want to start the search on and then
	 * return an array that contains day, month and year.
	 * @return intStartDate array composed of the date
	 */
	public int[] returnEndTime()
	{
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		int intEndDate[] = new int[3];
		
		Scanner chooseScanner = new Scanner(System.in);  // Create a Scanner object
		
		System.out.println("Enter end date in the dd/mm/yyyy format");
		
		boolean askingforDates = true;
		
		//loops while the user is entering the date
		while(askingforDates)
		{
			System.out.println("Enter end date in the dd/mm/yyyy format");
			
			//gets user input and then transfers it to an int array
			String startDate = chooseScanner.nextLine();
			intEndDate = dateToInt(startDate);
			
			//keeps on asking the user to re-input their date if it failed the validation 
			while((intEndDate[0] < day && intEndDate[1] <= month) || intEndDate[2] < year || intEndDate[0] > 31 || intEndDate[1] > 12 || intEndDate[1] < month)
			{
				System.out.println("Enter end date in the dd/mm/yyyy format");
				
				startDate = chooseScanner.nextLine();
				intEndDate = dateToInt(startDate);
			}
			
			askingforDates = false;	
		}
		return intEndDate;
	}
	
	/**
	 * Turns the string date to an int array
	 * @param date that was entered by the user
	 * @return intDate the int array of date (dd/mm/yyyy)
	 */
	public int[] dateToInt(String date)
	{
		int intDate[] = new int[3];
		String stringDate[] = new String[3];
		
		stringDate = date.split("/");

		try
		{
			for(int i = 0; i < 3; i++)
			{
				//converts string date to integer value
				intDate[i] = Integer.parseInt(stringDate[i]);
			}
		}
		catch(Exception e) 
		{
			System.out.println("Invalid input! try again");
			
		}	
		
		return intDate;
	}
	
		/**
	 * Asks the user who's appointments they want to see and the prints their diary
	 */
	public void printProfessionalsAppointments()
	{
		Scanner chooseScanner = new Scanner(System.in);  // Create a Scanner object
		
		System.out.println("Which professional's appointments would you like to see?");
		
		Node[] node = getpro(getProfessionalsID()).getDiary().getAllApointments();
		for(int i=0;i<node.length;i++)
		{
			System.out.println(node[i].getAppointment().getTreatmentType());
		}	
	}
}
