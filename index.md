## Devin Schmidt's ePortfolio

An example of the projects that demonstrate the skills and abilitys I use in developing software.

#### Table of Contents
1.	[Professional Self-Assessment](https://github.com/DevS71/DevS71.github.io/index.md#-1-Professional-Self-Assessment)
2.	Code Review
3.	Project 1: Software Design and Engineering
4.	Project 2: Data Structures and Algorithms
5.	[Project 3: Databases](https://devs71.github.io#5-project-3-databases)

### 1. Profesional Self-Assessment
placeholder for file contents


### 2.Code Review
placeholder for link to code review

### 3. Project 1: Software Design and Engineering
placholder for narrative text

placehoder for links to class files

### 4. Project 2: Data Structures and Algorithms
placeholder for narrative text

placeholder for links to class files

### 5. Project 3: Databases
The artifact I selected for the Database portion of my portfolio is the Python CRUD application I developed for CS-340 for the final project. As the enhancement for this project, I rewrote the program in Java. The reason I chose this project for inclusion in my portfolio is because it highlights my ability to manipulate a database and shows that I can do this in multiple languages. This artifact also shows several skills I have as a developer. It demonstrates my ability to design software in a modular fashion, with each class having its own role. It shows my ability to test user input and handle unexpected input. It highlights my skills designing software that it easy to read, and stable to run.

In completing this project, I have met all of my planned outcomes for the course. I have employed strategies for building collaborative environments, CS-499-01. I accomplished this through the use of commenting my code so that other developers can easily understand, implement, and edit. I have demonstrated the ability to design, develop, and deliver professional-quality communications, CS-499-02. This was achieved in this enhancement with the header to each class file. These headers describe the purpose of the class and how to use it, allowing any developer to easily implement it. I have shown the ability to design and evaluate computing solutions to solve a given problem, CS-499-03. This program displays this outcome through the use of the Java object that stores the record values and the use of Vectors to store lists of the search results as values. I have demonstrated the ability to use techniques, skills, and tools to implement a computing solution, CS-499-04. This program demonstrates that with the modular design, using classes that can be re-used accomplishes the industry goal of re-useability and adds value to the product. I have also developed a security mindset that anticipates exploits, CS-499-05. This is demonstrated by not passing user entered data directly to any database commands and the programs ability to handle exceptions without crashing. 

The process of rewriting this software was full of learning experiences. I first needed to learn how the mongo driver for Java functioned, in order to make calls to the database. The hardest part of this for me was any operation that performed writes. This part took several days of pouring through documentation and searching Stack Overflow for similar issues. I then had to learn the logging system the driver used. This was something I wasn’t prepared for, however without implementing this system the driver would issue warnings. This system was something I had never used or researched. To overcome this, I spent a fair amount of time reading the documentation to get this properly set up and configured. This was further hindered by the fact that the logging system uses two separate pieces of software to perform its task. In the end, all the issues I encountered were solved with proper research of both the documentation and similar problems others have encountered. 


#### Enhanced Source Files for this Project
[Project_main.java](https://github.com/DevS71/DevS71.github.io/blob/main/Project3_Main_Java)
'''
/*
 *Author: Devin Schmidt 
 * 
 *Developed for: CS-499
 * 
 * Description: The main method for a program that access and performs CRUD operations on a MongoDB database
 * 
 * 				This file is executed every time the program is run.
 * 
 * 				The main method handles all operations, calls for the appropriate output of menus, collection of inputs, and calls
 * 					to the proper classes for searching and editing the collection.
 */

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.apache.log4j.PropertyConfigurator;


public class Project_Main {

	

	public static void main(String[] args) {
		
		//Configure log4j to log errors to console
		PropertyConfigurator.configure("log4j.properties");
		
		String dataBase = "sample_airbnb";//Value to pass for accessing database
		int menu_select = 0;//variable for user input at main menu
		int filter_menu_select = 0;//variable for user input at search filter selection menu
		int submenu_select = 0;//variable for user input at search type
		int subfilter_menu_select = 0;//variable for user input at the equal or range selection menu
		int top_of_range = 0;//variable for the user input of upper bounds of range, also used for equals searches
		int bottom_of_range = 0;//variable for the lower bounds of ranged search
		String user_field_input = "";//variable to hold user input as a string
		String field = "";//variable to hold the field selected by the user
		
		try {
			//Connection String for accessing cloud based database
			String uri = "mongodb+srv://DevS71:MooseNSquirle@cluster0.dycft.mongodb.net/sample_geospatial?retryWrites=true&w=majority";
			
			//Create the codec provider and registry to use
			CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
	        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
	        
	        //Create the client to use
	        MongoClient mongoClient = MongoClients.create(uri);
	        
	        //Loop over main menu until user selects to exit
	        while(menu_select != 5) {
	        	//Call the main menu system and get user input
	        	IO_System.mainMenu();
	        	menu_select = IO_System.getMenuInput();
	        	
	        	//if user selects one from main menu, call search menu and get input
	        	if(menu_select == 1) {
	    			IO_System.searchMenu();
	    			submenu_select = IO_System.getMenuInput();
	    			
	    			//if user selects one from search menu, return first record found in database
	    			if(submenu_select == 1) {
	    				Search_Handler.findFirstRecord(mongoClient, dataBase, pojoCodecRegistry);
	    				
	    			//if user selects two from search menu perform a filtered search
	    			} else if(submenu_select == 2) {
	    				//Call filtered field menu and get user input
	    				IO_System.filterFieldMenu();
	    				filter_menu_select = IO_System.getMenuInput();
	    				
	    				while(filter_menu_select != 4) {
	    					//If user selects one from filter menu, set field to accommodates and change filter_menu_select to four
		    				if(filter_menu_select == 1) {
		    					field = "accommodates";
		    					filter_menu_select = 4;
		    				} else if(filter_menu_select == 2) {
		    					field = "bedrooms";
		    					filter_menu_select = 4;
		    				} else if(filter_menu_select == 3) {
		    					field = "beds";
		    					filter_menu_select = 4;
		    				} else if (filter_menu_select == 4) {
		    					continue;
		    				} else {
		    					//if user selects from out of range, print warning and re-prompt for input
		    					System.out.println("Invalid selection, please select a valid option.");
		    					IO_System.filterFieldMenu();
			    				filter_menu_select = IO_System.getMenuInput();
		    				}
		    				
		    				//Call filter options menu and collect input
		    				IO_System.filteredOptionsMenu();
		    				subfilter_menu_select = IO_System.getMenuInput();
		    				
		    				while(subfilter_menu_select !=3) {
		    					//if user selects one, filter by value equal to input
		    					if(subfilter_menu_select == 1) {
		    						//Prompt for value and collect input
		    						System.out.println("Enter value to match:");
		    						top_of_range = IO_System.getMenuInput();
		    						//Call method for search and set subfilter_menu_select to 3
		    						Search_Handler.singleQueryEquals(mongoClient, dataBase, pojoCodecRegistry, field, top_of_range);
		    						subfilter_menu_select = 3;
		    						
		    					} else if(subfilter_menu_select == 2) {
		    						//Prompt for upper and lower range and collect input
		    						System.out.println("Enter maximum value for range:");
		    						top_of_range = IO_System.getMenuInput();
		    						System.out.println("Enter minimum value for range:");
		    						bottom_of_range = IO_System.getMenuInput();
		    						//Call method for search and set subfilter_menu_select to 3
		    						Search_Handler.singleQueryRange(mongoClient, dataBase, pojoCodecRegistry, field, top_of_range, bottom_of_range);
		    						subfilter_menu_select = 3;
		    						
		    					} else if(subfilter_menu_select == 3) {
		    						continue;
		    					} else {
		    						//if selection value out of range, warn and re-prompt for selection
		    						System.out.println("Invalid selection, please select from available options.");
		    						//Call filter options menu and collect input
		    	    				IO_System.filteredOptionsMenu();
		    	    				subfilter_menu_select = IO_System.getMenuInput();
		    					}
		    				}
		    				
	    				}
	    			//If user selects 3 from search menu find record by id
	    			} else if(submenu_select == 3) {
	    				//Prompt user for id and collect input
	    				System.out.println("Enter id to search for:");
	    				user_field_input = IO_System.getFieldInput();
	    				//Call method to search collection by id
	    				Search_Handler.queryIdEquals(mongoClient, dataBase, pojoCodecRegistry, user_field_input);
	    				
	    			//If user selects four from search menu, continue back to main menu
	    			} else if(submenu_select == 4) {
	    				continue;
	    				
	    			//If user selects an option not on the menu, display error message and back up to main menu
	    			} else {
	    				System.out.println("Invalid selection, backing up to main menu");
	    			}
	 		
    			//if user selects two from main menu, edit a record		
    			} else if(menu_select == 2) {
        			//prompt user for id of record to edit and collect input
        			System.out.println("Enter Id to edit");
        			user_field_input = IO_System.getFieldInput();
        		
        			//Call method to edit records
        			CollectionEdit_Handlers.editRecordValues(mongoClient, dataBase, pojoCodecRegistry, user_field_input);
        		
        		//if user selects 3 from main menu, add a record to the database
        		} else if(menu_select == 3) {
        			//Call method to add a record to database
        			CollectionEdit_Handlers.addRentalFile(mongoClient, dataBase, pojoCodecRegistry);
        		
        		//If user selects 4 from main menu, delete a record from the database
        		} else if(menu_select == 4) {
        			//Prompt user for id to delete and collect input
        			System.out.println("Enter Id to delete:");
        			user_field_input = IO_System.getFieldInput();
        		
        			//Call method to delete record from database
        			CollectionEdit_Handlers.removeRecord(mongoClient, dataBase, pojoCodecRegistry, user_field_input);
        		} else if(menu_select == 5) {
        			continue;
        			
        		//If user selects an invalid option, display warning and re-start loop
        		} else {
        		System.out.println("Invalid option, please select a valid choice.");
        		}
        	}
        
		 //catch and handle exceptions   
		} catch(Exception e) {
			System.out.println("Failed to load database. Exception: " + e);
		}
		//close the scanner used for input
		IO_System.scannerClose();
	}
}

'''
placeholder for links to class files

