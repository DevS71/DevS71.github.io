package project_main;

/*
 * Author: Devin Schmidt
 * 
 * Class: CS-499	Date:3/30/2022
 * 
 * Description: Main function of program with methods to handle the service menu's. This class makes the method calls to
 * 					the service classes, File_Share class and ui class to operate the program. Contains 4 methods: handleAppointments(),
 * 					handleContacts(), handleTasks() and the main function.
 * 
 * 				handleAppointments() method calls the Project_ui class to display the appointments menu and collect user
 * 					input. it uses a while loop to call the appropriate method in the appointmentServices class to process 
 * 					the users request. The loop is exited and returned to main when the user selects back from the menu.
 * 
 * 				handleContacts() method calls the Project_ui class to display the contacts menu and collect user input. It
 * 					uses a while loop to call the appropriate method in the contactServices to process the users request 
 * 					until they select back from the menu.
 * 
 * 				handleTasks() method calls the Project_ui class to display the tasks menu and collect user input. It uses
 * 					a while loop to call the appropriate method in the taskServices class to process the users request until
 * 					they select back from the menu.
 * 
 * 				main(String[]) is called when the program is run. This method uses the Project_FileShare class, and the 
 * 					Project_ui class. The Project_FileShare class is used to load and save the files containing user data.
 * 					The Project_ui class is used to display the main menu and collect user input. The main method calls
 * 					the handleAppointments(), handleContacts(), and handleTasks() methods to accomplish user requests. The
 * 					main method uses a loop that displays the main menu, collects user inputs and calls the appropriate
 * 					handle method until the user selects exit from the menu. Upon exiting the loop the method saves data 
 * 					in the lists to disk.
 * 
 */

import java.io.FileNotFoundException;

import appointments.AppointmentService;
import contacts.ContactService;
import tasks.TaskService;



public class Project_Main {
	//AppointmentServic, ContactService, and TaskService objects used for data storage and access.
	static AppointmentService appointment = new AppointmentService();
	static ContactService contact = new ContactService();
	static TaskService task = new TaskService();
	
	//Method to handle the interaction in the Appointments menu.
	public static void handleAppointments() {
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
				appointment.displayList();
				continue;
			} else if(userSelect == 2) {
				//Displays single appointment.
				System.out.println("Please enter appointment ID");
				userStringInput = ui.getFieldInput();
				appointment.displayAppointment(userStringInput);
				continue;
			} else if(userSelect == 3) {
				//Adds a new appointment to the appointmentList.
				//String variables to store user data.
				String inputId = "";
				String inputDate = "";
				String inputDescription = "";
				
				//Prompt user for data, call Project_ui to capture input and store in variable.
				System.out.println("Input appointment ID (Required, 10 or less digets/characters): ");
				inputId = ui.getFieldInput();
				System.out.println("Input appointment Date (Required, format yyyy-MM-dd HH:mm): ");
				inputDate = ui.getFieldInput();
				System.out.println("Input appointment Description (Required, 50 or less characters): ");
				inputDescription = ui.getFieldInput();
				
				//Create appointment and store in list.
				appointment.addAppointment(inputId, inputDate, inputDescription);
				System.out.println("Appointment created.");
				System.out.println();
				continue;
			} else if(userSelect == 4) {
				//Deletes an appointment from the appointmentList.
				//Integer variable to check for valid appointment and store index of existing appointment.
				int validInputCheck = -1;
				
				//Prompt user for ID of appointment to remove and store input in variable.
				System.out.println("Enter appointment ID to remove: ");
				userStringInput = ui.getFieldInput();
				//Call method to find appointment in list and store result.
				validInputCheck = appointment.findAppointment(userStringInput);
				
				//Check if appointment exists (value of zero or greater) and delete if it does, or display error if it does not.
				if(validInputCheck >= 0) {
					appointment.removeAppointment(userStringInput);
					System.out.println("Appointment Removed.");
					System.out.println();
				} else {
					System.out.println("Invalid ID, or appointment does not exist.");
					System.out.println();
				}
			} 
		}
	}
	
	//Method to handle interaction in the contacts menu.
	public static void handleContacts() {
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
				contact.displayList();
				continue;
			} else if(userSelect == 2) {
				//Display specific contact.
				//Prompt user for contact ID and get input.
				System.out.println("Please enter contact ID");
				userStringInput = ui.getFieldInput();
				//Call method to display single contact.
				contact.displayContact(userStringInput);
				continue;
			} else if(userSelect == 3) {
				//Add a contact to the list.
				//Variables to hold user input for field values.
				String inputId = "";
				String inputFirstName = "";
				String inputLastName = "";
				String inputPhoneNumber = "";
				String inputAddress = "";
				
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
				
				//Add contact to contact list.
				contact.addContact(inputId, inputFirstName, inputLastName, inputPhoneNumber, inputAddress);
				System.out.println("Contact created.");
				System.out.println();
				continue;
			} else if(userSelect == 4) {
				//Delete contact from the contactList.
				//Variable to store index value of contact, verify that it exists.
				int validInputCheck = -1;
				
				//Prompt user for ID of contact to remove and collect input.
				System.out.println("Enter contact ID to remove: ");
				userStringInput = ui.getFieldInput();
				//Call method to find contact in list.
				validInputCheck = contact.findContact(userStringInput);
				
				//Check if contact exists (value greater than zero) and delete if it does or display error if it does not.
				if(validInputCheck >= 0) {
					contact.removeContact(userStringInput);
					System.out.println("Contact Removed.");
					System.out.println();
				} else {
					System.out.println("Invalid ID, or contact does not exist.");
					System.out.println();
				}
			}
		}
	}
	
	//Method to handle interactions within the task menu.
	public static void handleTasks() {
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
				//Display the entire contents of the task list.
				task.displayList();;
				continue;
			} else if(userSelect == 2) {
				//Display a single task from the list.
				//Prompt user for task ID and collect input.
				System.out.println("Please enter task ID");
				userStringInput = ui.getFieldInput();
				//Call method to display task.
				task.displayTask(userStringInput);
				continue;
			} else if(userSelect == 3) {
				//Add a task to the taskList.
				//Variables to hold user input for field values.
				String inputId = "";
				String inputName = "";
				String inputDescription = "";
				
				//Prompt user for field values and collect input.
				System.out.println("Input task ID (Required, 10 or less digets/characters): ");
				inputId = ui.getFieldInput();
				System.out.println("Input task name (Required, 20 or less characters): ");
				inputName = ui.getFieldInput();
				System.out.println("Input task description (Required, 50 or less characters): ");
				inputDescription = ui.getFieldInput();
				
				//Add task to task list.
				task.addTask(inputId, inputName, inputDescription);
				System.out.println("Appointment created.");
				System.out.println();
				continue;
			} else if(userSelect == 4) {
				//Delete a task from the taskList.
				//Variable to hold the index of task in list and check for its existance.
				int validInputCheck = -1;
				
				//Prompt user for task ID and collect input.
				System.out.println("Enter task ID to remove: ");
				userStringInput = ui.getFieldInput();
				//Call method to find task in taskList.
				validInputCheck = task.findTask(userStringInput);
				
				//Check if task exists (value of zero or greater) and delete if it does, display error if it does not.
				if(validInputCheck >= 0) {
					task.removeTask(userStringInput);
					System.out.println("Task Removed.");
					System.out.println();
				} else {
					System.out.println("Invalid ID, or task does not exist.");
					System.out.println();
				}
			}
		}
	}

	//Main method of program.
	public static void main(String[] args) throws FileNotFoundException {
		//variable to store user menu selection.
		int userSelect = 0;
		
		//Project_FileShare and Project_ui objects to use.
		Project_FileShare fileShare = new Project_FileShare();
		Project_ui ui = new Project_ui();
		
		//Call method to load existing data from disk.
		fileShare.getFile(appointment, contact, task);
		
		//Loop until user selects exit, option 4.
		while(userSelect != 4) {
			//Display main menu and collect input.
			ui.mainMenuSystem();
			userSelect = ui.getMenuInput();
			
			//Logic tree to handle user menu selection.
			if(userSelect == 1) {
				//Appointment selection, call handleAppointments method.
				handleAppointments();
			} else if (userSelect == 2) {
				//Contacts selection, call handleContacts method.
				handleContacts();
			} else if (userSelect == 3) {
				//Tasks selection, call handleTasks method.
				handleTasks();
			} else if (userSelect == 4) {
				//Exit program selection. 
				System.out.println("Saving data");
				//Save current state of appointment, contact and task lists to disk.
				fileShare.saveFile(appointment, contact, task);
				//Call method to close the scanner used by the Project_ui class.
				ui.scannerClose();
				System.out.println("Goodbye");
				break;
			} else {
				System.out.println("Please select a valid option");
				System.out.println();
				continue;
			}
		}
	}

}
