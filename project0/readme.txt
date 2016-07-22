README - Project Organizer

This is a short little java organizer I wrote in some spare time during the week of 7/18-7/22.
The purpose is to convert the Pro/g/ramming Challenge, v. 3, into a more workable format.
I ran the image through an online OCR (http://www.free-ocr.com/) to grab the text.
I cleaned that text up in g_v3.txt.

The program uses a command line interface.
Valid commands are HELP, DISPLAY, UPDATE, LOAD, and EXIT.
HELP prints those commands. When followed by a command, it details the purpose of the second.
DISPLAY allows for the display of all/complete/incomplete projects.
UPDATE lets you toggle the completion status of a project, or add a note.
LOAD is uses to pull in the data from g_v3.txt. It only needs done once (in fact, doing it twice just fills the list with duplicates).
EXIT saves and exits. It is the only way to save any changes made.

ProjectOrganizer is the main section and is just a glorified menu.
Gauntlet handles the collection of Projects, and actions to do with them.
Projects are objects with a name, number, status, and note. They're pretty cut and dry.

TODO when I find the time:
add "pick a random project"
clean up my random comments
finish the docs