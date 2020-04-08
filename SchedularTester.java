
ppublic class SchedularTester 
{
	Hospital hospitalTest;
	
	
	 /**
     * initialisation code
     */
	private void init()
	{
		hospitalTest = new Hospital();
	}
		
	/**
	 * Process tests
	 */
	private void process()
	{
//		testAddToList();
//		testDeleteFromList();
//		testEditFromList();
		testEnteringBetweenDates();
	}
	
	
	/**
	 * Tests adding items to the list in different formats, amounts
	 */
	public void testAddToList()
	{
		
		//Tests adding one item to the list
		System.out.println("=================================\rTest: Adding one item to the list");
		Professional professionalDetails = new Professional(1, "Gary Smith", "Surgeon", "Hospital #1");
		hospitalTest.addProfessionalToList(professionalDetails);
		hospitalTest.printProfessionalList(); //prints list
		
		//Tests adding more than one item to the list
		System.out.println("=================================\rTest: Adding two more items to the list");
		professionalDetails = new Professional(2, "Betty Black", "Doctor", "Hospital #1");
		hospitalTest.addProfessionalToList(professionalDetails);
		professionalDetails = new Professional(3, "Bama Lam", "Nurse", "Hospital #2");
		hospitalTest.addProfessionalToList(professionalDetails);
		hospitalTest.printProfessionalList(); //prints list
		
		//Tests adding an item to list with a non-unique ID
		System.out.println("=================================\rTest: Adding an item to list with a non-unique ID");
		professionalDetails = new Professional(1, "Blue Rodger", "Pirate", "Ship");
		hospitalTest.addProfessionalToList(professionalDetails);
		hospitalTest.printProfessionalList(); //prints list
		
		
		//Tests adding incorrect data type, commented out due to it crashing as expected
//		System.out.println("=================================\rTest: Adding incorrect data type");
//		professionalDetails = new Professional("blue", "Blue Rodger", "Pirate", "Ship");
//		hospitalTest.addProfessionalToList(professionalDetails);
//		hospitalTest.printProfessionalList(); //prints list
	}
	
	//Tests deleting from list
	public void testDeleteFromList()
	{
		System.out.println("=================================\rTest: Deleting an item from list");
		hospitalTest.deleteProfessionalDetails();
		hospitalTest.printProfessionalList(); //prints list
	}
	
	/**
	 * Tests editing items in the list
	 */
	public void testEditFromList()
	{
		System.out.println("=================================\rTest: Editing item from list");
		hospitalTest.editProfessionals();
		hospitalTest.printProfessionalList(); //prints list
	}
	
	public void testEnteringBetweenDates()
	{
		hospitalTest.returnStartTime();
	}
	
	/**
	 * main method that deals with executing the code
	 * @param args
	 */
	public static void main(String[] args)
	{
		SchedularTester test = new SchedularTester();
		
		test.init();
		test.process();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
