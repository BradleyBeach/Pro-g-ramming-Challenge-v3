package project0;

import static org.junit.Assert.*;

import org.junit.*;

public class ProjectTest {

	@Test
	public void testAddNote() {
		Project testProj = new Project("test project", 1);
		testProj.addNote("This is a note.");
		assertNotNull("note not added", testProj.getNote() );
	}

	@Test
	public void testCreationStatus(){
		Project testProj = new Project("test project", 1);
		assertFalse("Started as complete. fail", testProj.getStatus());
	}
	
	@Test
	public void testChangeStatus() {
		Project testProj = new Project("test project", 1);
		testProj.changeStatus();
		assertTrue("Did not become finished", testProj.getStatus());
	}

	@Test
	public void testToString() {
		Project testProj = new Project("test project", 1);
		String real = testProj.toString();
		testProj.changeStatus();
		String real2 = testProj.toString();
		testProj.addNote("A NOTE HERE");
		String real3 = testProj.toString();
		//remember: two spaces in the empty notes, since one is on each side of a |
		String expected = "Project 1: test project | INCOMPLETE | None";
		String expected2 = "Project 1: test project | COMPLETE | None";
		String expected3 = "Project 1: test project | COMPLETE | A NOTE HERE";
		assertEquals("First test string mismatch.", expected, real);
		assertEquals("Second test string mismatch.", expected2, real2);
		assertEquals("Third test string mismatch.", expected3, real3);
	}

}
