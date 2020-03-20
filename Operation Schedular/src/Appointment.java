import java.util.Date;

public class Appointment {
	private Date date;
	private Date startTime;
	private Date endTime;
	private String treatmentType;
	private Professional[] profsPresent;
	private String appID;
	
	public Appointment()
	{
		
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getTreatmentType() {
		return treatmentType;
	}
	
	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}
	
	public Professional[] getProfsPresent() {
		return profsPresent;
	}
	
	public void setProfsPresent(Professional[] profsPresent) {
		this.profsPresent = profsPresent;
	}
	
	public String getAppID() {
		return appID;
	}
	
	public void setAppID(String appID) {
		this.appID = appID;
	}
	
	
}
