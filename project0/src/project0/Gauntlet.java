package project0;

import java.util.ArrayList;
import java.util.Iterator;

public class Gauntlet {
	
	private ArrayList<Project> listOfProjects;
	
	public Gauntlet(){
		listOfProjects = new ArrayList<Project>();
	}
	
	/**
	 * Creates a new Project and adds it to the list.
	 * @param name phrase describing the project
	 */
	public void addProject(String name){
		listOfProjects.add(new Project(name, listOfProjects.size()));
	}
	
	
	/**
	 * Displays all projects, regardless of completion.
	 */
	public void displayAll(){
		Iterator<Project> projects = listOfProjects.iterator();
		while(projects.hasNext()){
			System.out.println(projects.next());
		}
	}
	
	/**
	 * Displays all completed projects. 
	 */
	public void displayComplete(){
		Iterator<Project> projects = listOfProjects.iterator();
		while(projects.hasNext()){
			Project currentProject = projects.next();
			if(currentProject.getStatus()){
				System.out.println(currentProject);
			}
		}
	}
	
	/**
	 * Displays all incomplete projects.
	 */
	public void displayIncomplete(){
		Iterator<Project> projects = listOfProjects.iterator();
		while(projects.hasNext()){
			Project currentProject = projects.next();
			if(!currentProject.getStatus()){
				System.out.println(currentProject);
			}
		}
	}
	
	/**
	 * Returns the project at the index given.
	 * @param number index of a project
	 * @return the project at the given index
	 */
	public Project getProject(int number){
		return listOfProjects.get(number);
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
}
