package project0;

public class Project {
	
	private String name, note;
	private boolean status; //true = complete, false = incomplete
	private int number;
	
	public Project(String name, int number){
		this.name = name;
		this.number = number;
		this.status = false;
		this.note = "None";
	}
	
	/**
	 * 
	 * @param note details the user wishes to note down
	 */
	public void addNote(String note){ //think about replacing/appending/editing/etc.
		this.note = note;
	}
	
	/**
	 * Toggles the completion status of the project.
	 */
	public void changeStatus(){
		status = !status;
	}
	/**
	 * 
	 * @return any note associated with the project
	 */
	public String getNote(){
		return note;
	}
	
	/**
	 * 
	 * @return the completion status of the project
	 */
	public boolean getStatus(){
		return status;
	}
	
	public String toString(){
		String prefix = "Project " + number + ": " + name + " | ";
		if(status) prefix = prefix + "COMPLETE";
		else prefix = prefix + "INCOMPLETE";
		prefix = prefix + " | " + note;
		return prefix;
	}
}
