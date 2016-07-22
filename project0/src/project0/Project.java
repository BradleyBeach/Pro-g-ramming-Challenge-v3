package project0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
	
	public Project(String name, int number, boolean status, String note){
		this.name = name;
		this.number = number;
		this.status = status;
		this.note = note;
	}
	
	public Project(DataInputStream dataInput) {
		try {
			this.name = dataInput.readUTF();
			this.number = dataInput.readInt();
			this.status = dataInput.readBoolean();
			this.note = dataInput.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + number;
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (number != other.number)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public void toBinary(DataOutputStream dataOutput) {
		try {
			dataOutput.writeUTF(name);
			dataOutput.writeInt(number);
			dataOutput.writeBoolean(status);
			dataOutput.writeUTF(note);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}
