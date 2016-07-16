package project0;

public class Project {
	
	private String name, note;
	private boolean status;
	private int number;
	
	public void addNote(String note){ //think about replacing/appending/editing/etc.
		this.note = note;
	}
	
	public void changeStatus(){
		status = !status;
	}
	
	public String toString(){
		return null;
	}
}
