
public class UndoableAdd implements UndoableCommand {
	private Tree tree;
	private int id;
	private Appointment appointment;
	
	UndoableAdd(Tree tree, int id, Appointment appointment)
	{
		this.tree = tree;
		this.id = id;
		this.appointment = appointment;
		
		tree.addToTree(id, appointment);
	}
	
	public void undo()
	{
		tree.delete(id);
	}
	
	public void redo()
	{
		tree.addToTree(id, appointment);
	}
}
