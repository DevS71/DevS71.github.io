package project_main;

/*
 * Author: Devin Schmidt
 * 
 * Class: CS-499	Date:3/30/2022
 * 
 * Description: Class to handle menu outputs and user inputs. This class contains four methods for menus, two for user
 * 					inputs (one handles integer input and one for Strings) and one to close the scanner object 
 * 					opened by the class.
 * 
 * 				To use this class create an instance of Project_ui "ui"
 * 
 * 				To display the main menu to screen call ui.mainMenuSystem(). This will output the main menu to screen.
 * 
 * 				To display the appointments menu call ui.appointmentMenu(). This will output the appointment menu to screen.
 * 
 * 				To display the contacts menu call ui.contactMenu(). This will output the contacts menu to screen.
 * 
 * 				To display the task menu call ui.taskMenu(). This will output the task menu to screen.
 * 
 * 				To collect integer input from the user call ui.getMenuInput(). This will capture the input from the user
 * 					as a String, test it to make sure its an integer (displays error message and prompts for re-input if not)
 * 					and cast the string to an integer and return the integer.
 * 
 * 				To collect String input from the user call ui.getFieldInput(). This will capture a line of input from System.in
 * 					and return it as a String.
 * 
 * 				To close the scanner object the class opens call ui.scannerClose(). This closes the open scanner used to 
 * 					capture user input and should be done before the program is terminated.
 * 
 */

import java.util.*;


public class Project_ui {
	//Scanner object to use for all methods.
	Scanner sc = new Scanner(System.in);
	
	//Method to display main menu.
	public void mainMenuSystem() {
		
		System.out.println("Please select a catagory:");
		System.out.println("1. Appointments");
		System.out.println("2. Contacts");
		System.out.println("3. Tasks");
		System.out.println("4. Exit");
	}
	
	//Method to display appointment sub-menu.
	public void appointmentMenu() {
		
		System.out.println("Please Select an option:");
		System.out.println("1. Display appointments");
		System.out.println("2. Find an appointment");
		System.out.println("3. Add an appointment");
		System.out.println("4. Delete an appointment");
		System.out.println("5. Back");
	}
	
	//Method to display contact sub-menu.
	public void contactMenu() {
		
		System.out.println("Please Select an option:");
		System.out.println("1. Display contacts");
		System.out.println("2. Find a contact");
		System.out.println("3. Add a contact");
		System.out.println("4. Delete a contact");
		System.out.println("5. Back");
	}
	
	//Method to display task sub-menu.
	public void taskMenu() {
		
		System.out.println("Please Select an option:");
		System.out.println("1. Display Tasks");
		System.out.println("2. Find a task");
		System.out.println("3. Add a task");
		System.out.println("4. Delete a task");
		System.out.println("5. Back");
	}
	
	//Method to retrieve input for menu system, this will be checked and converted to an integer.
	public int getMenuInput() {
		//Boolean variable to indicate if input is valid.
		boolean validInput = false;
		//Integer variable to store the user's choice.
		int userChoice = -1;
		//String to store the raw input from user.
		String userInput = "";
		//Loop to collect input from user until an integer is entered.
		while(validInput == false) {
			//Loop to wait for user input.
			while(!sc.hasNextLine()) {
				//Check for input and break out of inner loop.
				if(sc.hasNextLine()) {
					break;
				}
				
			}
			//Store input in string variable.
			userInput = sc.nextLine();
			System.out.println();
			//Try/catch block to handle exceptions that may occur during integer parsing.
			try {
				//Parse input from string to integer.
				userChoice = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				//Error message if input is not an integer.
				System.out.println("Please select an integer from the choices");
				System.out.println();
				userChoice = -1;
				continue;
			}
			//Check that user input is between one and five inclusive, bounds for all but main menu.
			if(userChoice < 1 || userChoice > 5) {
				//if out of bounds display error message and restart loop for input.
				System.out.println("Please select a valid choice");
				System.out.println();
				userChoice = -1;
				continue;
			} else {
				//Set boolean to true, ending loop at start of next cycle.
				validInput = true;
			}
		}
		//Return input as an integer.
		return userChoice;
	}
	
	//Method to retrieve user input as a string, for entering data.
	public String getFieldInput() {
		//String to hold and return user input.
		String userInput = "";
		//Loop to wait until user inputs data.
		while(!sc.hasNextLine()) {
			//Check for input and break loop if it exists.
			if(sc.hasNextLine()) {
				break;
			}
			
		}
		//Set variable to user input.
		userInput = sc.nextLine();
		System.out.println();
		
		//Return input as a string.
		return userInput;
	}
	
	//Method to close the class scanner.
	public void scannerClose() {
		sc.close();
	}

}
