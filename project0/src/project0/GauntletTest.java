package project0;

import static org.junit.Assert.*;

import org.junit.Test;

public class GauntletTest {
	
	String eol = System.getProperty("line.separator");
	
	private Gauntlet gauntPrep(){
		Gauntlet testGaunt = new Gauntlet();
		testGaunt.addProject("first");
		testGaunt.addProject("second");
		testGaunt.addProject("third");
		testGaunt.addProject("fourth");
		testGaunt.addProject("fifth");
		testGaunt.getProject(1).changeStatus(); //set "second" to complete
		testGaunt.getProject(3).changeStatus(); //set "fourth" to complete
		return testGaunt;
	}

	@Test
	public void testGetProject() {
		Gauntlet testGaunt = gauntPrep();
		assertEquals("Did not add Project correctly", new Project("third", 2), testGaunt.getProject(2));
	}
	
	@Test
	public void testAddProject() {
		Gauntlet testGaunt = gauntPrep();
		assertEquals("Did not add Projects", 5, testGaunt.getListOfProjects().size());
		assertEquals("Did not add Project correctly", new Project("first", 0), testGaunt.getProject(0));
	}

	@Test
	public void testDisplayAll() {
		Gauntlet testGaunt = gauntPrep();
		assertEquals("Did not display all", "Project 0: first | INCOMPLETE | None" +eol+ "Project 1: second | COMPLETE | None"+eol+"Project 2: third | INCOMPLETE | None"+eol+"Project 3: fourth | COMPLETE | None"+eol+"Project 4: fifth | INCOMPLETE | None"+eol+"", testGaunt.displayAll());
	}

	@Test
	public void testDisplayComplete() {
		Gauntlet testGaunt = gauntPrep();
		assertEquals("Did not display complete.", "Project 1: second | COMPLETE | None"+eol+"Project 3: fourth | COMPLETE | None"+eol+"", testGaunt.displayComplete());
	}

	@Test
	public void testDisplayIncomplete() {
		Gauntlet testGaunt = gauntPrep();
		assertEquals("Did not display incomplete.", "Project 0: first | INCOMPLETE | None"+eol+"Project 2: third | INCOMPLETE | None"+eol+"Project 4: fifth | INCOMPLETE | None"+eol+"", testGaunt.displayIncomplete());
	}

}
