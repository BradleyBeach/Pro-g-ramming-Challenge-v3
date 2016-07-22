package project0;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProjectOrganizer {

	public static void main(String args[]) throws IOException{
		Gauntlet theGauntlet = new Gauntlet();
		//get data from storage file
		File dataFile = new File("GauntletData.txt");
		if(!dataFile.exists()){
			dataFile.createNewFile();
		} else{
			//TODO if a crash occurs after making file but before writing to GD.txt, crashes
			theGauntlet.load(dataFile);
		}
		
		System.out.println("Welcome to the Gauntlet");
		System.out.println("Enter a command. HELP for help.");
		Scanner in = new Scanner(System.in);
		while(true){
			String command = in.nextLine();
			String[] commandWords = command.split(" ", 4);
			
			switch(commandWords[0]){
			case "load":
				loadCommand(commandWords, theGauntlet);
				break;
			case "help":
				helpCommand(commandWords);
				break;
			case "display":
				displayCommand(commandWords, theGauntlet);
				break;
			case "update":
				updateCommand(commandWords, theGauntlet);
				break;
			case "exit":
				in.close();
				exitCommand(commandWords, theGauntlet, dataFile);
			}
		}
		
		/** To Do:
		 * 
		 * 1. Make CLI
		 * 2. Rework loadFromFile() to not stick the extra "0 -" on the front on 000.
		 * 3. Test things. (loadFromFile() should probably delete existing file.)
		 * 4. Consider it a job well done.
		 * 
		 */
	}

	private static void loadCommand(String[] commandWords, Gauntlet theGauntlet) {
		if(commandWords.length != 1)
		{
			System.out.println("Load does not currently take any arguments. Anyway...");
		}
		try {
			System.out.println("Loading from file...");
			theGauntlet.loadFromFile();
			System.out.println("Load complete.");
		} catch (IOException e) {
			System.out.println("File not found. Can't load.");
		}
		
	}

	private static void exitCommand(String[] commandWords, Gauntlet theGauntlet, File dataFile) {
		if(commandWords.length != 1)
		{
			System.out.println("Exit does not currently take any arguments. Anyway...");
		}
		try {
			theGauntlet.save(dataFile);
		} catch (IOException e) {
			System.out.println("Exit error. File doesn't exist. You work can't be saved.");
			System.out.println("Please don't randomly move or delete files...");
		}
		System.out.println("Exit complete");
		System.exit(0);
	}

	private static void updateCommand(String[] commandWords, Gauntlet theGauntlet) {
		
		Integer proj;
		try{
			proj = new Integer(commandWords[1]);
		} catch (NumberFormatException e) {
			System.out.println("Update error: update must be followed by a project number.");
			return;
		}
		switch(commandWords.length){
		case 3:
			if(commandWords[2].equals("status")){
				theGauntlet.getProject(proj).changeStatus();
			} else {
				System.out.println("Invalid command. Use \"help update\" for help.");
				return;
			}
			break;
		case 4:
			if(commandWords[2].equals("note")){
				theGauntlet.getProject(proj).addNote(commandWords[3]);
			} else {
				System.out.println("Invalid command. Use \"help update\" for help.");
			}
			break;
		default:
			System.out.println("Invalid command. Use \"help update\" for help.");
		}
		
	}

	private static void displayCommand(String[] commandWords, Gauntlet theGauntlet) {
		if(commandWords.length != 2){
			System.out.println("Invalid display command.");
			return;
		}
		switch(commandWords[1]){
		case "all":
			System.out.println("Displaying all projects:");
			System.out.println(theGauntlet.displayAll());
			break;
		case "complete":
			System.out.println("Displaying all complete projects:");
			System.out.println(theGauntlet.displayComplete());
			break;
		case "incomplete":
			System.out.println("Displaying all incomplete projects:");
			System.out.println(theGauntlet.displayIncomplete());
			break;
		default:
			System.out.println("Invalid display command: Only valid selectors are all/complete/incomplete");
		}
	}

	private static void helpCommand(String[] commandWords) {
		switch(commandWords.length){
		case 1:
			System.out.println("HELP COMMANDS");
			System.out.println("help, update, display, exit");
			System.out.println("Enter help followed by any command for more details.");
			break;
		case 2:
			switch(commandWords[1]){
			case "update":
				System.out.println("UPDATE COMMAND");
				System.out.println("Format: update projectNumber status/note (noteContent)");
				System.out.println("\"update 1 status\" would toggle the status on Project 1");
				System.out.println("\"update 1 note Hello World\" would set P1's note to \"Hello World\" ");
				break;
			case "display":
				System.out.println("DISPLAY COMMAND");
				System.out.println("Format: display all/complete/incomplete");
				System.out.println("\"display complete\" displays all completed projects");
				System.out.println("The other options work similarly");
				break;
			case "exit":
				System.out.println("EXIT COMMAND");
				System.out.println("Format: exit");
				System.out.println("Saves and exits the system.");
				break;
			case "load":
				System.out.println("LOAD COMMAND");
				System.out.println("Format: load");
				System.out.println("Loads project data from a text file.");
				System.out.println("Currently, uses hardcoded file.");
				System.out.println("This command does not need frequent use. The program saves and loads from its own file on start/end.");
				break;
			default:
				System.out.println("Invalid help request: that is not a command");
			}
		}
		
	}
}
