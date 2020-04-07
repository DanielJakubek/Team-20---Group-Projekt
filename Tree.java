import java.sql.Date;
import java.util.Scanner;

public class Tree {
	private Node root;
	private int iterator;
	private int treeSize;
	
	/**
	 * Default constructor for the tree class
	 */
	public Tree()
	{
		root = null;
	}
	
	/**
	 * Accessor method for the root node
	 * @return the root node of the tree
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/**
	 * Mutator method for the root node
	 * @param root the root node of the tree
	 */
	public void setRoot(Node root)
	{
		this.root = root;
	}
	
	/**
	 * Determines if a tree is empty by checking if the root node is null
	 * @return returns true if the tree is empty, false if it is not
	 */
	public boolean isTreeEmpty()
	{
		if (this.root == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * searched the tree for a node with the specified ID
	 * @param searchID the desired ID
	 * @return if a node with the matching ID exists, it will return that node, otherwise it will return null
	 */
	public Node findInTree(int searchID)
	{
		Node currentNode = new Node();
		boolean found = false;
		
		currentNode = root;
		
		while(currentNode != null && !found)
		{
			if(currentNode.getAppID() == searchID)
			{
				found = true;
			}
			else
			{
				if(searchID < currentNode.getAppID())
				{
					currentNode = currentNode.getRight();
				}
				else
				{
					currentNode = currentNode.getLeft();
				}
			}
		}
		if(found)
		{
			return currentNode;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * adds a new node to the tree, if there are no other nodes in the tree, it will set the new node as the root
	 * @param id the Appointment ID for the new node
	 * @param appointment the appointment associated with the new node
	 */
	public void addToTree(int id, Appointment appointment)
	{
		Node newNode = new Node(id, appointment);
		
		Node current = new Node();
		Node previous = new Node();
		boolean found = false;
		
		if(this.isTreeEmpty())
		{
			//if the tree is empty, set the new node to be the root
			this.root = newNode;
		}
		else
		{
			if(findInTree(newNode.getAppID()) == null)
			{
				current = root;
				previous = null;
			}
			while(current != null  && !found)
			{
				previous = current;
				if(newNode.getAppID() < current.getAppID())
				{
					current = current.getLeft();
				}
				else
				{
					current = current.getRight();
				}
			}
			if(findInTree(newNode.getAppID()) == null)
			{
				if(newNode.getAppID() < previous.getAppID())
				{
					previous.setLeft(newNode);
				}
				else
				{
					previous.setRight(newNode);
				}
			}
		}
	}
	
	/**
	 * intermediary method that will call the main delete method
	 * @param value the ID of the node
	 */
	public void delete(int value) {
	    root = delete(root, value);
	}

	/**
	 * deletes a node from the tree
	 * @param current the starting node
	 * @param value the ID of the node to be deleted
	 * @return
	 */
	public Node delete(Node current, int value) {
	    if (current == null) {
	        return null;
	    }

	    if (value == current.getAppID()) {
	        // No children
	        if (current.getLeft() == null && current.getRight() == null) {
	            return null;
	        }

	        // Only 1 child
	        if (current.getRight() == null) {
	            return current.getLeft();
	        }
	        if (current.getLeft() == null) {
	            return current.getRight();
	        }

	        // Two children
	        Node smallestValue = minValue(current.getRight());
	        current.setAppID(smallestValue.getAppID());
	        current.setRight(delete(current.getRight(), smallestValue.getAppID()));
	        return current;
	    }
	    if (value < current.getAppID()) {
	        current.setLeft(delete(current.getLeft(), value));
	        return current;
	    }

	    current.setRight(delete(current.getRight(), value));
	    return current;
	}
	
	/**
	 * finds the minimum value in a subtree
	 * @param node the starting node
	 * @return the node with the minimum value
	 */
	public Node minValue(Node node)
	{
		Node minNode = node;
		while (node.getLeft() != null)
		{
			minNode = node.getLeft();
			node = node.getLeft();
		}
		return minNode;
	}
	
	/**
	 * a recursive function that performs an in-order traversal of the tree and prints out the relevant data for each node
	 * @param node the node where the traversal begins
	 */
	public void printTree(Node node)
	{
		if(node != null)
		{
			printTree(node.getLeft());
			System.out.println("\nID: " + node.getAppID());			
			printTree(node.getRight());
		}
	}
	
	/**
	 * a recursive function that performs an in-order traversal of the tree and returns an array with each node
	 * @param node the node where the traversal begins
	 */
	public Node[] printTree(Node node, Node[] nodes)
	{
		if(node != null)
		{
			printTree(node.getLeft(), nodes);
			nodes[iterator] = node;
			iterator++;
			printTree(node.getRight(), nodes);
		}
		return nodes;
	}
	
	/**
	 * a recursive function that performs an in-order traversal of the tree and counts each node
	 * @param node the node where the traversal begins
	 */
	public int getTreeSize(Node node)
	{
		if(node != null)
		{
			printTree(node.getLeft());
			treeSize++;			
			printTree(node.getRight());
		}
		return treeSize;
	}
	
	/**
	 * Gets user input on what appointment to edit and then asks
	 * what aspect of the appointment to edit
	 * @param editID the ID of the appointment that is to be edited
	 */
	public void editTree(int editID)
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object
		
		if(isTreeEmpty())
		{
			System.out.println("The tree is empty, cannot edit");
		}
		
		if(findInTree(editID) == null)
		{
			System.out.println("There is no such appointment");
		}
		else
		{
			boolean editing = true;
			Node currentNode = new Node();
			currentNode = findInTree(editID);
			
			while(editing)
			{
				System.out.println("What would you like to edit?");
				System.out.print("\r 1:Date \r 2:Start Time \r 3:End Time \r 4: Treatment Type \r 5: Professionals Present \r "
						+ "\r 6: Appointment ID \r 7:Finished \r Option: ");
				
				String userChoice = editScanner.nextLine();
				
				//switch that checks the values of userChoice
				//Calls appropriate method from the Files class depending on the user choice
				switch(userChoice) 
				{
					 case "1":
					 {
						//sets node's date
						currentNode.setDate(editDate());
						break;
					 }
					 
					 case "2":
					 {
						currentNode.setStartTime(editStartTime());
						break;
					 }
					 case "3":
					 {
						currentNode.setEndTime(editEndTime());
						break;
					 }
					 case "4":
					 {
						currentNode.setTreatmentType(editTreatmentType());
						break;
					 }
					 case "5":
					 {

						editing = false;
						break;
					 }
					 case "6":
					 {
						 
						 int newAppID = 0;
						 
						 try
							{
								System.out.println("Professional to edit: ");
								//makes userInput to the user's input
								String newStringID = editScanner.nextLine();
					
								//converts user input to integer value
								newAppID = Integer.parseInt(newStringID);
							}
							catch(Exception e) 
							{
								System.out.println("Invalid input! try again");
							}

						 currentNode.setAppID(newAppID);
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
	
	/**
	 * Edits the date of a node
	 * @return newDate combination of newDay, newMonth and newYear
	 */
	public String editDate()
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object
		
		int intDate[] = {0,0,0};
		String newDay = "";
		String newMonth="";
		String newYear="";
		
		do
		{
			try
			{
				System.out.println("Enter the new Day: ");
				//makes userInput to the user's input
				newDay = editScanner.nextLine();
				
				System.out.println("Enter the new Month: ");
				//makes userInput to the user's input
				newMonth = editScanner.nextLine();
				
				System.out.println("Enter the new Year: ");
				//makes userInput to the user's input
				newYear = editScanner.nextLine(); 
				
				//turns string to Int
				intDate[0] = Integer.parseInt(newDay);
				intDate[1] = Integer.parseInt(newYear);
				intDate[2] = Integer.parseInt(newMonth);
				
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input! try again");
				intDate[0] = 500;
			}
			
			}while (intDate[0] < 0 && intDate[0]>32);
		
		String newDate = (newDay + "/" + newMonth + "/" + newYear);
		
		return newDate;
	}
	
	/**
	 * Edits the start time
	 * @return newSqlStartTime the new time appointment starts at
	 */
	public String editStartTime()
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object
		
		int intHours[] = {0,0};
		String newHour = "";
		String newMinute="";
		
		do
		{
			try
			{
				System.out.println("Enter the new start Hour: ");
				//makes userInput to the user's input
				newHour = editScanner.nextLine();
				
				System.out.println("Enter the new start Minutes: ");
				//makes userInput to the user's input
				newMinute = editScanner.nextLine();
				
				//turns string to Int
				intHours[0] = Integer.parseInt(newHour);
				intHours[1] = Integer.parseInt(newMinute);
				
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input! try again");
				intHours[0] = 500;
			}
			
			}while (intHours[0] < 0 && intHours[0]>24);
		
		String newHours = (newHour + ":" + newMinute);
		
		return newHours;
	}
	
	/**
	 * Edits the end time
	 * @return newSqlStartTime the new time appointment ends at
	 */
	public String editEndTime()
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object
		
		int intHours[] = {0,0};
		String newHour = "";
		String newMinute="";
		
		do
		{
			try
			{
				System.out.println("Enter the new end Hour: ");
				//makes userInput to the user's input
				newHour = editScanner.nextLine();
				
				System.out.println("Enter the new end Minutes: ");
				//makes userInput to the user's input
				newMinute = editScanner.nextLine();
				
				//turns string to Int
				intHours[0] = Integer.parseInt(newHour);
				intHours[1] = Integer.parseInt(newMinute);
				
			}
			catch(Exception e) 
			{
				System.out.println("Invalid input! try again");
				intHours[0] = 500;
			}
			
			}while (intHours[0] < 0 && intHours[0]>24);
		
		String newHours = (newHour + ":" + newMinute);
		
		return newHours;
	}
	
	/**
	 * Edits the treatment type
	 * @return newTreatmentType the new treatment type
	 */
	public String editTreatmentType()
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object
		
		System.out.println("Enter the new treatment Type: ");

		//makes userInput to the user's input
		String newTreatmentType = editScanner.nextLine();

		System.out.println("Invalid input! try again");

		return newTreatmentType;
	}
	
}
