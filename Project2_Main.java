package project_main;

/*
 * Author: Devin Schmidt
 * 
 * Class: CS-499	Date:3/30/2022
 * 
 * Description: Main function of program with methods to handle the service menu's.
 * 
 * 				This class is executed when the program is run
 * 
 * 				The method handleAppointments(String) is used to handle the interaction with the user while they are in 
 * 					the appointments section of the program. It will call the methods for displaying the proper menu and 
 * 					collecting user input as well as processing their choices. This method takes a String argument for 
 * 					the user name.
 * 
 *  			The method handleContacts(String) is used to handle the interaction with the user while they are in the 
 *  				Contacts section of the program. It will call the methods for displaying the proper menu and collecting
 *  				user input as well as processing their choices. This method takes a String argument for the user name.
 *  
 *  			The method handleTasks(String) is used to handle the interaction with the user while they are in the Tasks
 *  				section of the program. It will call the methods for displaying the proper menu and collecting user input
 *  				as well as processing their choices. This method takes a String argument for the user name.
 *  
 *  			The method handleMainMenu(String) is used to handle the interaction with the user while they are in the main
 *  				section of the program. It will call the methods for displaying the proper menu and collecting user input
 *  				as well as processing their choices. This method takes a String argument for the user name.
 * 
 */

import java.io.FileNotFoundException;

import services.*;


public class Project_Main {
	//VectorMap object to handle data storage and retrieval.
	static VectorMap userServices = new VectorMap();

	//Method to handle the interaction in the Appointments menu.
	public static void handleAppointments(String user) {
		////Variables for storing user input.
		int userSelect = 0;
		String userStringInput;
		//Project_ui object used to handle user interface.
		Project_ui ui = new Project_ui();
		
		//Loop until user selects to back out of appointment menu, option 5.
		while(userSelect != 5) {
			//Call methods to display menu and get input.
			ui.appointmentMenu();
			userSelect = ui.getMenuInput();
			
			//Logic tree to handle user selections.
			if(userSelect == 1) {
				//Displays the contents of the appointmentList.
				userServices.displayAppointmentList(user);
			} else if(userSelect == 2) {
				//Displays single appointment.
				System.out.println("Please enter appointment ID");
				userStringInput = ui.getFieldInput();
				userServices.displayAppointment(userStringInput, user);
			} else if(userSelect == 3) {
				//Adds a new appointment to the appointmentList.
				//String variables to store user data.
				String inputId = "";
				String inputDate = "";
				String inputDescription = "";
				int mode = 1;
				//boolean to verify creation
				boolean createCheck = false;
				
				//Prompt user for data, call Project_ui to capture input and store in variable.
				System.out.println("Input appointment ID (Required, 10 or less digets/characters): ");
				inputId = ui.getFieldInput();
				System.out.println("Input appointment Date (Required, format yyyy-MM-dd HH:mm): ");
				inputDate = ui.getFieldInput();
				System.out.println("Input appointment Description (Required, 50 or less characters): ");
				inputDescription = ui.getFieldInput();
				
				//Create appointment and store in list.
				createCheck = userServices.addAppointment(inputId, inputDate, inputDescription, user, mode);
				
				if(createCheck == true) {
					System.out.println("Appointment Created.");
					System.out.println();
				}
			} else if(userSelect == 4) {
				//Deletes an appointment from the appointmentList.
				
				//Prompt user for ID of appointment to remove and store input in variable.
				System.out.println("Enter appointment ID to remove: ");
				userStringInput = ui.getFieldInput();

				//call method in VectorMap object to remove appointment from list
				userServices.removeAppointment(userStringInput, user);

			} 
		}
	}
	
	//Method to handle interaction in the contacts menu.
	public static void handleContacts(String user) {
		//variables to store user input.
		int userSelect = 0;
		String userStringInput;
		//Project_ui object to access the Project_ui class.
		Project_ui ui = new Project_ui();
		
		//Loop until user selects option to go back, 5.
		while(userSelect != 5) {
			//Display contact menu and get user input.
			ui.contactMenu();
			userSelect = ui.getMenuInput();
			
			//Logic tree to handle menu choice.
			if(userSelect == 1) {
				//Display contents of entire list.
				//Call method to display user's list of contacts
				userServices.displayContactList(user);
			} else if(userSelect == 2) {
				//Display specific contact.
				//Prompt user for contact ID and get input.
				System.out.println("Please enter contact ID");
				userStringInput = ui.getFieldInput();
				
				//Call method to display single contact.
				userServices.displayContact(userStringInput, user);
			} else if(userSelect == 3) {
				//Add a contact to the list.
				//Variables to hold user input for field values.
				String inputId = "";
				String inputFirstName = "";
				String inputLastName = "";
				String inputPhoneNumber = "";
				String inputAddress = "";
				//boolean to verify creation
				boolean createCheck = false;
				
				//Prompt user for field values and store input in variables.
				System.out.println("Input contact ID (Required, 10 or less digets/characters): ");
				inputId = ui.getFieldInput();
				System.out.println("Input contact first name (Required, 10 or less characters): ");
				inputFirstName = ui.getFieldInput();
				System.out.println("Input contact last name (Required, 10 or less characters): ");
				inputLastName = ui.getFieldInput();
				System.out.println("Input contact phone number (Required, exactly 10 digets required. 10 x's for none): ");
				inputPhoneNumber = ui.getFieldInput();
				System.out.println("Input contact address(Required, 30 or less characters): ");
				inputAddress = ui.getFieldInput();
				
				//Call method to add contact to user's contact list.
				createCheck = userServices.addContact(inputId, inputFirstName, inputLastName, inputPhoneNumber, inputAddress, user);
				
				if(createCheck == true) {
					System.out.println("Contact created.");
					System.out.println();
				}
			} else if(userSelect == 4) {
				//Delete contact from the contactList.
				
				//Prompt user for ID of contact to remove and collect input.
				System.out.println("Enter contact ID to remove: ");
				userStringInput = ui.getFieldInput();
				
				//call method to remove contact from user's list
				userServices.removeContact(userStringInput, user);
			}
		}
	}
	
	//Method to handle interactions within the task menu.
	public static void handleTasks(String user) {
		//Variables to store user input.
		int userSelect = 0;
		String userStringInput;
		//Project_ui object to handle user interface calls.
		Project_ui ui = new Project_ui();
		
		//Loop until user selects the back option, number 5.
		while(userSelect != 5) {
			//Display taskMenu and collect user input.
			ui.taskMenu();
			userSelect = ui.getMenuInput();
			
			//Logic tree to handle user menu choices.
			if(userSelect == 1) {
				//Call method to Display the entire contents of the task list.
				userServices.displayTaskList(user);
			} else if(userSelect == 2) {
				//Display a single task from the list.
				//Prompt user for task ID and collect input.
				System.out.println("Please enter task ID");
				userStringInput = ui.getFieldInput();
				//Call method to display task.
				userServices.displayTask(userStringInput, user);
			} else if(userSelect == 3) {
				//Add a task to the taskList.
				//Variables to hold user input for field values.
				String inputId = "";
				String inputName = "";
				String inputDescription = "";
				//boolean to verify creation
				boolean createCheck = false;
				
				//Prompt user for field values and collect input.
				System.out.println("Input task ID (Required, 10 or less digets/characters): ");
				inputId = ui.getFieldInput();
				System.out.println("Input task name (Required, 20 or less characters): ");
				inputName = ui.getFieldInput();
				System.out.println("Input task description (Required, 50 or less characters): ");
				inputDescription = ui.getFieldInput();
				
				//Call method to add task to user's task list.
				createCheck = userServices.addTask(inputId, inputName, inputDescription, user);
				
				if(createCheck == true) {
					System.out.println("Contact created.");
					System.out.println();
				}
			} else if(userSelect == 4) {
				//Delete a task from the taskList.
				
				//Prompt user for task ID and collect input.
				System.out.println("Enter task ID to remove: ");
				userStringInput = ui.getFieldInput();
				
				//Call method to remove task from user's task list
				userServices.removeTask(userStringInput, user);
			}
		}
	}
	
	//Method to handle main menu interactions
	public static void handleMainMenu(String user) {
		//variable to store user menu selection.
		int userSelect = 0;
		
		Project_ui ui = new Project_ui();
		
		//Loop until user selects exit, option 4.
		while(userSelect != 4) {
			//Display main menu and collect input.
			ui.mainMenuSystem();
			userSelect = ui.getMenuInput();
			
			//Logic tree to handle user menu selection.
			if(userSelect == 1) {
				//Appointment selection, call handleAppointments method.
				handleAppointments(user);
			} else if (userSelect == 2) {
				//Contacts selection, call handleContacts method.
				handleContacts(user);
			} else if (userSelect == 3) {
				//Tasks selection, call handleTasks method.
				handleTasks(user);
			} else if (userSelect == 4) {
				//Log user out. 
				System.out.println("Goodbye");
			} else {
				System.out.println("Please select a valid option");
				System.out.println();
			}
		}
	}
	
	//Method to handle the log in process
	static private String handleLogIn() {
		//Project_ui object to use
		Project_ui ui = new Project_ui();
		
		//Prompt for user name and return to caller
		System.out.println("Enter user name:");
		String user = ui.getFieldInput();
		
		return user;
	}

	//Main method of program.
	public static void main(String[] args) throws FileNotFoundException {
		//variable to store user menu selection.
		int userSelect = 0;
		String owner = null;
		
		//Project_FileShare and Project_ui objects to use.
		Project_FileShare fileShare = new Project_FileShare();
		Project_ui ui = new Project_ui();
		
		//Call method to load existing data from disk.
		fileShare.loadSystem(userServices);
		
		while(userSelect != 2) {
			ui.logInMenu();
			userSelect = ui.getMenuInput();
			
			if(userSelect == 1) {
				boolean foundUser = false;
				owner = handleLogIn();
				
				for(int i = 0; i < userServices.users.size(); ++i) {
					if(owner.equals(userServices.users.get(i))) {
						foundUser = true;
					}
				}
				
				if(foundUser == false) {
					userServices.addUser(owner);
					
				}
				
				handleMainMenu(owner);
			} else if (userSelect == 2) {
				System.out.println("Saving Data");
				fileShare.saveFile(userServices);
				System.out.println("Goodbye");
				ui.scannerClose();
			} else {
				System.out.println("Please chose a valid option");
				System.out.println();
			}
		}
	}
}
