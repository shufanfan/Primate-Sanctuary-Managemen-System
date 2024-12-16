# Primate-Sanctuary-Management-System

Overview of the Project

This project is an application for the Primate Sanctuary management. In the application, users can be able to register new monkeys into the sanctuary. All monkeys must go straight into isolation when they first enter the sanctuary. The user should get notified if there is no room for new monkeys (because maximum capacity of the isolation cages is 20) After receiving medical attention in the Isolation, monkeys can be moved to the right enclosure based on their species. The application can produce a list for every enclosure which shows each individual monkey that is currently housed there. (for each monkey, include their name, sex, and favourite food) Also, the application can produce an alphabetical list(by name) of all the monkeys housed in the sanctuary.

The list of all features in the application

Functionality: the main tasks that the program is design to replace all the paper records with computer records where people can keep track of the individual animals that are in the sanctuary.
The application is designed following the MVC architecture guidelines. The model encapsulates the logic of the application. There are four Java classes in the model. They represent the Monkey, isolation, enclosure and the sanctuary.
The controller "talks" to the model and the view.
The model and the view do not "talk" to each other.
GUI is built using Java Swing.
Input: The users need enter the name, weight and age; For the rest, the users will be given multiple choices. The users just need to select the correct on from the choices.
Output: The users will see two lists in the interface. One is for every enclosure which shows each individual monkey that is currently housed there. (for each monkey, include their name, sex, and favourite food). The other is an alphabetical list(by name) of all the monkeys housed in the sanctuary.
Supported platform: macOS
The instructions to run the JAR file && interact with the program

For macOS platform:

download the res/project5.jar file
click on the downloaded file
choose Open With -> JavaLauncher(default)
When you open the file for the first time, the system will may notify you that "macOS cannot verify the developer of project5.jar. Are you sure you want to open it?"
You need to click open button to open the file.
Done!

Original design: You can see it in the UML document.

Limitations of the project

If the name is empty, it can still be added into lists.
When transferring monkeys from isolation to enclosure, the user need to enter the monkey's name again.
Citations:

https://www.codecademy.com/article/mvc-architecture-for-full-stack-app
https://www.google.com/search?q=how+can+i+create+a+jar+in+intellij+java&sca_esv=4773a9d9c9d3b242&sca_upv=1&sxsrf=ACQVn0_4rxTdx7wZFTm3cUWkTbGghrLMaw%3A1713212557632&ei=jYwdZrOXJtqI0PEPjf-SyAo&oq=how+can+i+create+a+jar+in+intellin+java&gs_lp=Egxnd3Mtd2l6LXNlcnAiJ2hvdyBjYW4gaSBjcmVhdGUgYSBqYXIgaW4gaW50ZWxsaW4gamF2YSoCCAAyBhAhGAoYCkirOVCxCVjoKnABeAGQAQCYAfUCoAHDDKoBBzEuNi4xLjG4AQHIAQD4AQGYAgqgAtoMwgIKEAAYRxjWBBiwA8ICDBAhGAoYoAEYwwQYCsICChAhGAoYoAEYwwTCAggQIRigARjDBMICCBAAGIAEGKIEmAMAiAYBkAYKkgcHMi42LjEuMaAH9xg&sclient=gws-wiz-serp#fpstate=ive&vld=cid:f6a887e8,vid:3Xo6zSBgdgk,st:0
