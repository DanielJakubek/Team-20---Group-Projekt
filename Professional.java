/**
 * This is a data store for the professionals.
 * 
 * @author Daniel Jakubek
 * @Version March 2020
 *
 */
public class Professional 
{
	private int profID;
	private String name;
	private String profession;
	private String workLocation;
	private Diary diary;
	
    /**
     * Constructor for objects of class Professional
     */
	public Professional(int theirID, String theName, String theProfession, String theWorkLocation)
	{
		// initialise instance variables
		profID = theirID;
		name = theName;
		profession =theProfession;
		workLocation = theWorkLocation;
		diary = new Diary();
	}

	/**
	 * @return the profID
	 */
	public int getProfID() {
		return profID;
	}

	/**
	 * @param profID the profID to set
	 */
	public void setProfID(int profID) {
		this.profID = profID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the workLocation
	 */
	public String getWorkLocation() {
		return workLocation;
	}

	/**
	 * @param workLocation the workLocation to set
	 */
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	
	public void createNewApp(String date, String startTime, String endTime, String treatmentType)
	{
		int id = 0;
		
		Appointment newApp = new Appointment(date,startTime,endTime,treatmentType);
		

		
		
		diary.createAppointment(id, newApp);
	}
}
