import java.util.Scanner;

public class mainMenu 
{

	Hospital hospital = new Hospital();
	
	/**
	 * the main method, deals with executing the code
	 * @param args
	 */
	public static void main(String[] args)
	{
		mainMenu d = new mainMenu();
		d.menu();
	}
	
	
	/**
	 * Main menu deals with getting the user input and then doing the corresponding operations.
	 */
	public void menu()
	{
		Scanner menuScanner = new Scanner(System.in);  // Create a Scanner object
		
		while(true)
		{
			System.out.println("1: Professional \r2: Exit");
			String userChoice = menuScanner.nextLine();
			
			switch(userChoice)
			{
				case "1":
				{
					professional();
					break;
				}
				case "2":
				{
					System.exit(0); //exits the program
					break;
				}
				default:
				{
					System.out.println("Invalid input!");
					break;
				}
			}
		}
	}
	
	/**
	 * This deals with the professional window. This executes anything that has to do with 
	 * dealing with the professionals.
	 */
	public void professional()
	{
		Scanner professioanlScanner = new Scanner(System.in);  // Create a Scanner object
		
		boolean professionalMenu = true;
		
		while(professionalMenu)
		{
			System.out.println("1: Add professional \r2: Edit professional \r3: Delete professional \r4: Print professional list \r5: Exit");
			System.out.println("Option:");

			String professionalChoice = professioanlScanner.nextLine();
			
			switch(professionalChoice)
			{
				case "1":
				{
					hospital.askForDetails();
					break;
				}
				case "2":
				{
					hospital.editProfessionals();
					break;
				}
				case "3":
				{
					hospital.deleteProfessionalDetails();
					break;
				}
				case "4":
				{
					hospital.printProfessionalList();
					break;
				}
				case "5":
				{
					professionalMenu = false;
					break;
				}
				default:
				{
					System.out.println("Invalid input!");
					break;
				}	
			}
		}
	}
}
