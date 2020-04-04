
public class UndoableDelete implements UndoableCommand {
	private Tree tree;
	private int id;
	private Appointment appointment;
	
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
	
	public void redo()
	{
		tree.delete(id);
	}
}
