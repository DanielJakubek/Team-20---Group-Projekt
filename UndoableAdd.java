public class UndoableAdd implements UndoableCommand {
	private Tree tree;
	private int id;
	private Appointment appointment;
	
	/**
	 * Default constructor for the UndoableDelete class, initialises variables and carries out the required command
	 * @param tree the binary tree being edited
	 * @param id the ID of the node being added
	 * @param appointment the appointment object associated with the new node
	 */
	UndoableAdd(Tree tree, int id, Appointment appointment)
	{
		this.tree = tree;
		this.id = id;
		this.appointment = appointment;
		//Calls the function that carries out the command
		tree.addToTree(id, appointment);
	}
	
	/**
	 * Deletes an element from the tree
	 */
	public void undo()
	{
		tree.delete(id);
	}
}