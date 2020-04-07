import java.util.Date;

public class Node {
	private Appointment appointment;
	private int appID;
	private Node right;
	private Node left;
	
	/**
	 * Default constructor for the Node class
	 */
	public Node()
	{
		appointment = null;
		appID = 0;
		right = null;
		left = null;
	}
	
	/**
	 * Alternative constructor for the Node class
	 * @param ID the ID for the appointment
	 * @param newAppointment reference to the appointment object
	 */
	public Node(int ID, Appointment newAppointment)
	{
		appID = ID;
		appointment = newAppointment;
	}

	/**
	 * Accessor method for the appointment field
	 * @return reference to the appointment object
	 */
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	 * Mutator method for the appointment field
	 * @param appointment reference to the appointment object
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	/**
	 * Accessor method for the appID
	 * @return the ID for the appointment
	 */
	public int getAppID() {
		return appID;
	}

	/**
	 * Mutator method for appID
	 * @param appID the ID for the appointment
	 */
	public void setAppID(int appID) {
		this.appID = appID;
	}

	/**
	 * Accessor method for the right node
	 * @return the current node's right child node 
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Mutator method for the right child node
	 * @param right the current node's right child node
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Accessor method for the left node
	 * @return the current node's left child node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Mutator method for the left node
	 * @param left the current node's left child node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 * Mutator method for the date
	 * @param date of the appointment
	 */
	public void setDate(String date)
	{
		appointment.setDate(date);
	}
	
	public void setStartTime(String startTime) 
	{
		appointment.setStartTime(startTime);
	}
	
	public void setEndTime(String endTime) {
		appointment.setEndTime(endTime);
	}
	
	public void setTreatmentType(String treatmentType) {
		appointment.setTreatmentType(treatmentType);
	}
	
	public void setAppID(String appID) {
		appointment.setAppID(appID);
	}
	
	public void setProfsPresent(Professional[] profsPresent) {
		appointment.setProfsPresent(profsPresent);
	}
	
	
	
	
	
	
	
	
	
	
}
