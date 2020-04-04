
public class Diary {
	private Tree appTree;
	
	/**
	 * Default constructor for Diary class
	 */
	public Diary()
	{
		appTree = new Tree();
	}
	
	public Tree getAppTree()
	{
		return appTree;
	}
	/**
	 * Adds an appointment to the tree
	 * @param id the ID of the new appointment
	 * @param appointment object reference for the appointment
	 */
	public void createAppointment(int id, Appointment appointment)
	{
		UndoableAdd add = new UndoableAdd(this.appTree, id, appointment);		
	}
	
	/**
	 * finds an appointment in the tree
	 * @param id the ID of the appointment being searched for
	 */
	public void findAppointment(int id)
	{
		appTree.findInTree(id);
		//manager.addChangeable(new CommandLineChanger("appTree.findInTree(id)") );
		//not sure if this needs to be included in the undo feature since it doesn't change any data
	}
	
	/**
	 * deletes an appointment
	 * @param id the ID of the appointment being deleted
	 */
	public void deleteAppointment(int id, Appointment appointment)
	{
		UndoableDelete delete = new UndoableDelete(this.appTree, id, appointment);
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

