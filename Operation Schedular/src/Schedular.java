import java.util.ArrayList;
import java.util.List;

public class Schedular {
	
	private List<Professional> professionalsList;
	
	private Schedular()
	{
		professionalsList = new ArrayList<Professional>();
	}
	
	public void addProfessional(Professional p)
	{
		professionalsList.add(p);
	}
	
	public void deleteProfessional(Professional p)
	{
		professionalsList.remove(p);
	}
}
