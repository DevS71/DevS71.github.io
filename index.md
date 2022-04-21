## Devin Schmidt's ePortfolio

An example of the projects that demonstrate the skills and abilitys I use in developing software.

#### Table of Contents
1.	[Professional Self-Assessment](https://devs71.github.io#1-professional-self-assessment)
2.	[Code Review](https://devs71.github.io#2-code-review)
3.	[Project 1: Software Design and Engineering](https://devs71.github.io#3-project-1-software-design-and-engineering)
4.	[Project 2: Data Structures and Algorithms](https://devs71.github.io#4-project-2-data-structures-and-algorithms)
5.	[Project 3: Databases](https://devs71.github.io#5-project-3-databases)

### 1. Profesional Self-Assessment
placeholder for file contents


### 2.Code Review
placeholder for link to code review

### 3. Project 1: Software Design and Engineering
Placeholder for narrative, not complete yet

placehoder for links to class files

### 4. Project 2: Data Structures and Algorithms
The artifact I have submitted for week for is a re-work of the final project submitted for the CS-320 course. This project was a digital planner storing information for appointments, contacts, and a to-do list. The original work was created in February of 2021. This project was also used for my first enhancement, and I have built upon that for this one.

This artifact is included here because it showcases my ability to use different data structures to accomplish the projects goals. It also highlights my ability to create efficient and error free algorithms to perform the task. This artifact shows my ability to develop modular programs, allow for the re-use of components in other programs. This artifact was improved from the original by implementing a two-dimensional vector to hold the linked lists containing the data. It was further enhanced by creating a user-based system that stores different lists for different users.

In the enhancement of this project, I have met the course requirements I set out to meet. I have designed and evaluated computing solutions to solve the problem. In this project I use a 2D vector to store linked lists. The first vector axis is assigned to the user and the second vector axis is assigned to the service. By looking up a cell at (user, service) a linked list containing the data of the type requested for the user is loaded. This solution provides a good compromise between memory usage and speed for this project. This project also demonstrates the ability to use techniques, skills, and tools to implement computer solutions that deliver value and accomplish industry goals. This project uses multiple classes that can be re-used in other projects and easily edited. This solution accomplishes the industry goal of re-usability and ensures easy maintenance of the project. This project also meets the goal of being designed with a security mindset. This project does not pass user entered values as commands to any function, checks user entered values for the correct input, and is designed to handle exceptions without crashing the program. This program also separates the data stored by user and only allows the user to view their data. These features serve to protect the user and the system.

I learned quite a bit working with the data structure involved in this project. I had never used a two-dimensional vector or array before. At first, I thought I might be able to use the different data objects I had originally developed. While this may be possible, I found it easier and more efficient to redesign the data object into one that filled all three rolls. I initially thought about making this a three-dimensional array but decided to use a linked list as the third dimension. This allowed me to re-use more of my original code and I believe it will help keep the memory footprint of the program down. The biggest challenge I had was in the implementation of the linked lists for the different services. I originally was using a single list that I would blank out, however it kept leaking data from one service to the next. I solved this by initializing the two-dimensional vector with three different linked lists when I added a new user. I was also having issues trying to use three different data objects in the data structure. It wanted to keep giving me warnings, so I designed a single data object to fill all three rolls.

#### Enhanced Source Files for Project 2
1. [Project_Main.java](https://github.com/DevS71/DevS71.github.io/blob/main/Project2_Main.java)
2. [Node.java](https://github.com/DevS71/DevS71.github.io/blob/main/Node.java)
3. [Vector_Map.java](https://github.com/DevS71/DevS71.github.io/blob/main/VectorMap.java)
4. [Project_ui.java](https://github.com/DevS71/DevS71.github.io/blob/main/Project2_ui.java)
5. [Project_FileShare](https://github.com/DevS71/DevS71.github.io/blob/main/Project2_FileShare.java)

#### Original Source Files for Project 2


### 5. Project 3: Databases
The artifact I selected for the Database portion of my portfolio is the Python CRUD application I developed for CS-340 for the final project. As the enhancement for this project, I rewrote the program in Java. The reason I chose this project for inclusion in my portfolio is because it highlights my ability to manipulate a database and shows that I can do this in multiple languages. This artifact also shows several skills I have as a developer. It demonstrates my ability to design software in a modular fashion, with each class having its own role. It shows my ability to test user input and handle unexpected input. It highlights my skills designing software that it easy to read, and stable to run.

In completing this project, I have met all of my planned outcomes for the course. I have employed strategies for building collaborative environments. I accomplished this through the use of commenting my code so that other developers can easily understand, implement, and edit. I have demonstrated the ability to design, develop, and deliver professional-quality communications. This was achieved in this enhancement with the header to each class file. These headers describe the purpose of the class and how to use it, allowing any developer to easily implement it. I have shown the ability to design and evaluate computing solutions to solve a given problem. This program displays this outcome through the use of the Java object that stores the record values and the use of Vectors to store lists of the search results as values. I have demonstrated the ability to use techniques, skills, and tools to implement a computing solution. This program demonstrates that with the modular design, using classes that can be re-used accomplishes the industry goal of re-useability and adds value to the product. I have also developed a security mindset that anticipates exploits. This is demonstrated by not passing user entered data directly to any database commands and the programs ability to handle exceptions without crashing. 

The process of rewriting this software was full of learning experiences. I first needed to learn how the mongo driver for Java functioned, in order to make calls to the database. The hardest part of this for me was any operation that performed writes. This part took several days of pouring through documentation and searching Stack Overflow for similar issues. I then had to learn the logging system the driver used. This was something I wasn’t prepared for, however without implementing this system the driver would issue warnings. This system was something I had never used or researched. To overcome this, I spent a fair amount of time reading the documentation to get this properly set up and configured. This was further hindered by the fact that the logging system uses two separate pieces of software to perform its task. In the end, all the issues I encountered were solved with proper research of both the documentation and similar problems others have encountered. 


#### Enhanced Source Files for Project 3
1. [Project_main.java](https://github.com/DevS71/DevS71.github.io/blob/main/Project_Main.java)
2. [Rental.java](https://github.com/DevS71/DevS71.github.io/blob/main/Rental.java)
3. [IO_System.java](https://github.com/DevS71/DevS71.github.io/blob/main/IO_System.java)
4. [Search_Handler.java](https://github.com/DevS71/DevS71.github.io/blob/main/Search_Handler.java)
5. [CollectionEdit_Handlers.java](https://github.com/DevS71/DevS71.github.io/blob/main/CollectionEdit_Handlers.java)

#### Original Source Files for Project 3
1. [Mongo_db_Interface.py](https://github.com/DevS71/DevS71.github.io/blob/main/Mongo_db_Interface.py)
2. [ProjectTwoDashboard.ipynb](https://github.com/DevS71/DevS71.github.io/blob/main/ProjectTwoDashboard.ipynb.txt)
