
public class Diary {
	private Tree appTree;
	private ChangeManager manager;
	//private Stack undoStack; 
	
	/**
	 * Default constructor for Diary class
	 */
	public Diary()
	{
		appTree = new Tree();
	}
	
	/**
	 * Adds an appointment to the tree
	 * @param id the ID of the new appointment
	 * @param appointment object reference for the appointment
	 */
	public void createAppointment(int id, Appointment appointment)
	{
		appTree.addToTree(id, appointment);
		manager.addChangeable(new CommandLineChanger("appTree.addToTree(id, appointment)") );
	}
	
	/**
	 * finds an appointment in the tree
	 * @param id the ID of the appointment being searched for
	 */
	public void findAppointment(int id)
	{
		appTree.findInTree(id);
		manager.addChangeable(new CommandLineChanger("appTree.findInTree(id)") );
		//not sure if this needs to be included in the undo feature since it doesn't change any data
	}
	
	/**
	 * deletes an appointment
	 * @param id the ID of the appointment being deleted
	 */
	public void deleteAppointment(int id)
	{
		appTree.delete(id);
		manager.addChangeable(new CommandLineChanger("appTree.delete(id)") );
	}
	
	public void saveAppointment()
	{
		//still needs to be implemented
	}
	
	public void restoreAppointment()
	{
		//still needs to be implemented
	}
	
public static class CommandLineChanger implements Changeable{

		

		private final String val;

		public CommandLineChanger(String v){

			super();

			this.val = v;

		}

		

		public void undo(){

			System.out.println(val + " undone");

		}

		

		public void redo(){

			System.out.println(val + " redone");

		}

	}
}
