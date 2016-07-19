First goal: throw together a quick little program to help me manage the list.
functionality ideas: list finished/unfinished challenges. suggest random unfinished challenge.

Initial thoughts: make a quick "task" class having status (bool), notes (String), number (int), task (String). give it toString, toFile. have things get stored in a file, as an excuse to remember how to read/write files. 

use cases:
1. look at list
2. set a project to complete
3. user selects to close program
4. written to file

same as above but 2 is "writes a note on a project"

1. asks for random project
2. program returns a project from the "incomplete" list

class diagrams:

Gauntlet:
projects [Project]
-
getAll() : [Project]
getComplete() : [Project]
getIncomplete() : [Project]
getProject(name): Project, getProject(number): Project
writeToFile():
readFromFile(): (or is this how we init)

Project:
name, notes: String
status: bool
number: int
-
toString(): String
addNote():
changeStatus():