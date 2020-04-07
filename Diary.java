import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Diary {
	private Tree appTree;
	private Stack undoStack;
	private FileOutputStream fos;
	private PrintWriter pw;
	
	/**
	 * Default constructor for Diary class
	 */
	public Diary()
	{
		appTree = new Tree();
		undoStack = new Stack();
		
		try {
			fos = new FileOutputStream("Appointments.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find or create save file!");
			e.printStackTrace();
		}
		
		pw = new PrintWriter(fos);
	}
	/**
	 * Accessor method for appTree
	 * @return the tree
	 */
	public Tree getAppTree()
	{
		return appTree;
	}
	
	public Stack getStack()
	{
		return undoStack;
	}
	/**
	 * Adds an appointment to the tree
	 * @param id the ID of the new appointment
	 * @param appointment object reference for the appointment
	 */
	public void createAppointment(int id, Appointment appointment)
	{
		UndoableAdd add = new UndoableAdd(this.appTree, id, appointment);
		undoStack.push(add);
	}
	
	/**
	 * finds an appointment in the tree
	 * @param id the ID of the appointment being searched for
	 */
	public void findAppointment(int id)
	{
		appTree.findInTree(id);
	}
	
	/**
	 * deletes an appointment
	 * @param id the ID of the appointment being deleted
	 */
	public void deleteAppointment(int id, Appointment appointment)
	{
		UndoableDelete delete = new UndoableDelete(this.appTree, id, appointment);
		undoStack.push(delete);
	}
	
	public void saveAppointment()
	{
		//still needs to be implemented
		Node[] nodes = new Node[appTree.getTreeSize(appTree.getRoot())]; 
		appTree.printTree(appTree.getRoot(), nodes);
		
		for(int i=0;i<nodes.length;i++)
		{
			pw.println(nodes[i].getAppID()+nodes[i].getAppointment().getDate()+" "+
					nodes[i].getAppointment().getStartTime()+" "+nodes[i].getAppointment().getEndTime()+" "+
					nodes[i].getAppointment().getTreatmentTypeID()+" ");
		}
		
		pw.close();
	}
	
	public void restoreAppointment()
	{
		//still needs to be implemented
	}
	
	/**
	*Deals with editing appointments by asking the user what they want to eidt and then calling the
	*edit method from the other class
	*/
	public void editAppointment()
	{
		Scanner editScanner = new Scanner(System.in);  // Create a Scanner object
		
		int editID = editScanner.nextInt();
		
		
		appTree.editTree(editID);
		
	}
}
