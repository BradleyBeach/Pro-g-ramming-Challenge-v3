package project0;

import java.io.File;
import java.io.IOException;

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
		theGauntlet.loadFromFile();
		System.out.println("Complete load");
		System.out.println(theGauntlet.displayAll());
		theGauntlet.save(dataFile);
		System.out.println("Complete save");
		System.exit(0);
		
		//get input
		//get first word
		//check for command word: display, exit, update, or help
		//help (command) - gives details
		//display (all/complete/incomplete) - display them
		//update (status/note) (if note: the note) - update the project
		//exit - save and exit
		
		/** To Do:
		 * 
		 * 1. Make CLI
		 * 2. Rework loadFromFile() to not stick the extra "0 -" on the front on 000.
		 * 3. Test things. (loadFromFile() should probably delete existing file.)
		 * 4. Consider it a job well done.
		 * 
		 */
	}
	
}
