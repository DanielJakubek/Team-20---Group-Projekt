
public class Diary {
	private Tree appTree;
	private Stack undoStack;
	
	/**
	 * Default constructor for Diary class
	 */
	public Diary()
	{
		appTree = new Tree();
		undoStack = new Stack();
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
	}
	
	public void restoreAppointment()
	{
		//still needs to be implemented
	}
}

