
public class Tester {

	private Diary diary;
	
	public Tester()
	{
		diary = new Diary();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tester test = new Tester();
		test.runTests();
	}
	
	public void runTests()
	{
		//generic test appointments with no actual data	
		Appointment app1 = new Appointment();
		Appointment app2 = new Appointment();
		Appointment app3 = new Appointment();
		Appointment app4 = new Appointment();
		Appointment app5 = new Appointment();
		Appointment app6 = new Appointment();
		
		
		diary.getStack().pop().undo();
		diary.getAppTree().printTree(diary.getAppTree().getRoot());
		
		
		/*
		diary.createAppointment(6, app2);
		diary.createAppointment(2, app3);
		diary.createAppointment(3, app4);
		
		diary.getAppTree().printTree(diary.getAppTree().getRoot());
		System.out.println("=================");
		diary.getStack().pop().undo();
		diary.getAppTree().printTree(diary.getAppTree().getRoot());
		System.out.println("=================");
		diary.getStack().pop().undo();
		diary.getAppTree().printTree(diary.getAppTree().getRoot());
		*/
	}

}
