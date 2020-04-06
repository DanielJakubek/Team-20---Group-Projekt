public class UndoableDelete implements UndoableCommand {
	private Tree tree;
	private int id;
	private Appointment appointment;
	
	/**
	 * Default constructor for the UndoableDelete class, initialises variables and carries out the required command
	 * @param tree the binary tree being edited
	 * @param id the ID of the node being deleted
	 * @param appointment the appointment object associated with the node
	 */
	public UndoableDelete(Tree tree, int id, Appointment appointment)
	{
		this.tree = tree;
		this.id = id;
		this.appointment = appointment;
		
		tree.delete(id);
	}
	
	public void undo()
	{
		tree.addToTree(id, appointment);
	}
}