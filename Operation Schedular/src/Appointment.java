/*
 * Appointment class
 * v0.1
 * Sameer Al Harbi
 */
public class Appointment {
	
	private int date;//in form ddmmyyyy
	private int startTime;
	private int endTime;
	
	private int treatmentTypeID;
	private int[] professionalsPresentIDs;
	private int appID;
	
	public Appointment()//constructor will fullfill the role of the generateAppID() method
	{
		//Check what is the largest current ID value and assign appID to it +1
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getTreatmentTypeID() {
		return treatmentTypeID;
	}

	public void setTreatmentTypeID(int treatmentTypeID) {
		this.treatmentTypeID = treatmentTypeID;
	}

	public int[] getProfessionalsPresentIDs() {
		return professionalsPresentIDs;
	}

	public void setProfessionalsPresentIDs(int[] professionalsPresentIDs) {
		this.professionalsPresentIDs = professionalsPresentIDs;
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}
	
	
	

}
