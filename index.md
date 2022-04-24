## Devin Schmidt's ePortfolio

An example of the projects that demonstrate the skills and abilitys I use in developing software.

Email Devin at devspit71@gmail.com

#### Table of Contents
1.	[Professional Self-Assessment](#1-professional-self-assessment)
2.	[Code Review](#2-code-review)
3.	[Project 1: Software Design and Engineering](#3-project-1-software-design-and-engineering)
4.	[Project 2: Data Structures and Algorithms](#4-project-2-data-structures-and-algorithms)
5.	[Project 3: Databases](#5-project-3-databases)

### 1. Profesional Self-Assessment
placeholder for file contents


### 2.Code Review
[Code Review video](https://youtu.be/1YjFPcJO0So)


### 3. Project 1: Software Design and Engineering
Placeholder for narrative, not complete yet

#### Enhanced Source Files for Project 1
1. [Project_Main.java](Project1_Main_e.java)
2. [Project_ui.java](Project1_ui_e.java)
3. [Project_FileShare.java](Project1_FileShare_e.java)
4. [Appointment.java](Appointment_e%20.java)
5. [AppointmentService.java](AppointmentService_e.java)
6. [Contact.java](Contact_e.java)
7. [ContactService.java](ContactService_e.java)
8. [Task.java](Task_e.java)
9. [TaskService.java](TaskService_e.java)

#### Original Source Files for Project 1
1. [Appointment.java](Appointment.java)
2. [AppointmentService.java](AppointmentService.java)
3. [Contact.java](Contact.java)
4. [ContactService.java](ContactService.java)
5. [Task.java](Task.java)
6. [TaskService.java](TaskService.java)


### 4. Project 2: Data Structures and Algorithms
The artifact I have submitted for week for is a re-work of the final project submitted for the CS-320 course. This project was a digital planner storing information for appointments, contacts, and a to-do list. The original work was created in February of 2021. This project was also used for my first enhancement, and I have built upon that for this one.

This artifact is included here because it showcases my ability to use different data structures to accomplish the projects goals. It also highlights my ability to create efficient and error free algorithms to perform the task. This artifact shows my ability to develop modular programs, allow for the re-use of components in other programs. This artifact was improved from the original by implementing a two-dimensional vector to hold the linked lists containing the data. It was further enhanced by creating a user-based system that stores different lists for different users.

In the enhancement of this project, I have completed some to the course outcomes. I employed a strategy to build a collaborative environment. I accomplished this through the use of in code comments placed in the file header that describes the purpose of the file and how to use it. These comments allow for other developers to easily implement, update, and maintain the software.

![Project 2 Header Comment](/docs/assets/images/Comment.jpg)

I also demonstrated the ability to use professional-quality communications that are developed for a specific audience. I accomplished this by creating a flow chart to demonstrate the program flow, showing how the program functions. This shows I can communicate appropriately with specific audiences with context.

![Project 2 Flow Chart](/docs/assets/images/Sub2_FlowChart.jpg)

I learned quite a bit working with the data structure involved in this project. I had never used a two-dimensional vector or array before. At first, I thought I might be able to use the different data objects I had originally developed. While this may be possible, I found it easier and more efficient to redesign the data object into one that filled all three rolls. I initially thought about making this a three-dimensional array but decided to use a linked list as the third dimension. This allowed me to re-use more of my original code and I believe it will help keep the memory footprint of the program down. The biggest challenge I had was in the implementation of the linked lists for the different services. I originally was using a single list that I would blank out, however it kept leaking data from one service to the next. I solved this by initializing the two-dimensional vector with three different linked lists when I added a new user. I was also having issues trying to use three different data objects in the data structure. It wanted to keep giving me warnings, so I designed a single data object to fill all three rolls.

#### Enhanced Source Files for Project 2
1. [Project_Main.java](Project2_Main.java)
2. [Node.java](Node.java)
3. [Vector_Map.java](VectorMap.java)
4. [Project_ui.java](Project2_ui.java)
5. [Project_FileShare](Project2_FileShare.java)

#### Original Source Files for Project 2 (The same files as project 1)
1. [Appointment.java](Appointment.java)
2. [AppointmentService.java](AppointmentService.java)
3. [Contact.java](Contact.java)
4. [ContactService.java](ContactService.java)
5. [Task.java](Task.java)
6. [TaskService.java](TaskService.java)


### 5. Project 3: Databases
The artifact I selected for the Database portion of my portfolio is the Python CRUD application I developed for CS-340 for the final project. As the enhancement for this project, I rewrote the program in Java. The reason I chose this project for inclusion in my portfolio is because it highlights my ability to manipulate a database and shows that I can do this in multiple languages. This artifact also shows several skills I have as a developer. It demonstrates my ability to design software in a modular fashion, with each class having its own role. It shows my ability to test user input and handle unexpected input. It highlights my skills designing software that it easy to read, and stable to run.

In completing this project, I accomplished some of the course outcomes. I was able to use a security mindset that anticipates adversarial exploits. I accomplished this by ensuring that user data is validated before using it. This was done by verifying user input before using it as data. For integer input I accepted a string as input, checked that it contained nothing but integers and then use the input. If this input isn’t integers, it will output a warning message.

![Integer Input Method](/docs/assets/images/Project3_IntInput.jpg)

I also demonstrate the ability to use well-founded techniques, skills, and tools to implement computer solutions that deliver value. I was able to accomplish this by creating robust and efficient code that delivers value. This is shown in how I use try/catch blocks when accessing the database to handle any exception that may occur during the connection.

![Project3 Try/Catch block](/docs/assets/images/Project3_tryCatch.jpg)

The process of rewriting this software was full of learning experiences. I first needed to learn how the mongo driver for Java functioned, in order to make calls to the database. The hardest part of this for me was any operation that performed writes. This part took several days of pouring through documentation and searching Stack Overflow for similar issues. I then had to learn the logging system the driver used. This was something I wasn’t prepared for, however without implementing this system the driver would issue warnings. This system was something I had never used or researched. To overcome this, I spent a fair amount of time reading the documentation to get this properly set up and configured. This was further hindered by the fact that the logging system uses two separate pieces of software to perform its task. In the end, all the issues I encountered were solved with proper research of both the documentation and similar problems others have encountered. 

#### Enhanced Source Files for Project 3
1. [Project_main.java](Project_Main.java)
2. [Rental.java](Rental.java)
3. [IO_System.java](IO_System.java)
4. [Search_Handler.java](Search_Handler.java)
5. [CollectionEdit_Handlers.java](CollectionEdit_Handlers.java)

#### Original Source Files for Project 3
1. [Mongo_db_Interface.py](Mongo_db_Interface.py)
2. [ProjectTwoDashboard.ipynb](ProjectTwoDashboard.ipynb.txt)
