import java.util.Date;

public class Appointment {
	private String date;
	private String startTime;
	private String endTime;
	
	private String treatmentType;
	private Professional[] profsPresent;
	private String appID;
	
	public Appointment()
	{
		
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
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