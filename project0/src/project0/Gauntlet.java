package project0;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Gauntlet {
	
	private ArrayList<Project> listOfProjects;
	private String eol = System.getProperty("line.separator");
	
	public Gauntlet(){
		listOfProjects = new ArrayList<Project>();
	}
	
	/**
	 * Creates a new Project and adds it to the list.
	 * @param name phrase describing the project
	 */
	public void addProject(String name){
		getListOfProjects().add(new Project(name, getListOfProjects().size()));
	}
	
	
	/**
	 * 
	 * @return String of all projects, regardless of completion
	 */
	public String displayAll(){
		Iterator<Project> projects = getListOfProjects().iterator();
		String display = "";
		while(projects.hasNext()){
			display = display + projects.next() + eol;
		}
		return display;
	}
	
	/**
	 * 
	 * @return String of all complete projects
	 */
	public String displayComplete(){
		Iterator<Project> projects = getListOfProjects().iterator();
		String display = "";
		while(projects.hasNext()){
			Project currentProject = projects.next();
			if(currentProject.getStatus()){
				display = display + currentProject + eol;
			}
		}
		return display;
	}
	
	/**
	 * 
	 * @return String of all incomplete projects
	 */
	public String displayIncomplete(){
		Iterator<Project> projects = getListOfProjects().iterator();
		String display = "";
		while(projects.hasNext()){
			Project currentProject = projects.next();
			if(!currentProject.getStatus()){
				display = display + currentProject + eol;
			}
		}
		return display;
	}
	
	/**
	 * Returns the project at the index given.
	 * @param number index of a project
	 * @return the project at the given index
	 */
	public Project getProject(int number){
		return getListOfProjects().get(number);
	}
	/*projects [Project]
			-
			getAll() : display [Project]
			getComplete() : display [Project]
			getIncomplete() : display [Project]
			getProject(number): Project
			getRandomIncomplete(): Project
			writeToFile():
			readFromFile(): (or is this how we init)*/

	/**
	 *  Only used for testing
	 * @return the list of projects
	 */
	public ArrayList<Project> getListOfProjects() {
		return listOfProjects;
	}
	
	public void load(File dataFile) throws IOException{
		//A binary file is known and supplied
		//read Length from top of file
		//for length, 
		InputStream input = new FileInputStream(dataFile);
		DataInputStream dataInput = new DataInputStream(input);
		int projectCount = dataInput.readInt();
		for(int i = 0; i< projectCount; i++){
			listOfProjects.add(new Project(dataInput));
		}
		dataInput.close();
	}
	
	public void save(File dataFile) throws IOException{
		OutputStream output = new FileOutputStream(dataFile);
		DataOutputStream dataOutput = new DataOutputStream(output);
		Iterator<Project> projects = getListOfProjects().iterator();
		dataOutput.writeInt(listOfProjects.size());
		while(projects.hasNext()){
			projects.next().toBinary(dataOutput);
		}
	}
	
	public void loadFromFile() throws IOException{
		FileReader programmingChallenge = new FileReader("C:\\Users\\BBeac_000\\Desktop\\Learning\\g_v3.txt");
		BufferedReader textReader = new BufferedReader(programmingChallenge);
		String line;
		while((line = textReader.readLine()) != null){
			System.out.println(line);
			listOfProjects.add(new Project(line.substring(5), listOfProjects.size()));
		}
		
	}
}
