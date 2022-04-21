package project_main;

/*
 *Author: Devin Schmidt 
 * 
 *Developed for: CS-499
 * 
 * Description: Class that handles outputing a menu system and user input
 * 
 * 				To use this class create a IO_System object "io"
 * 
 * 				To display the main menu call io.mainMenu().
 * 
 * 				To display the search menu call io.searchMenu().
 * 
 * 				To display the filter by category menu call io.filterFieldMenu().
 * 
 * 				To display the filter options menu call io.filteredOptionsMenu().
 * 
 * 				To collect only integer input call io.getMenuInput().
 * 
 * 				To collect String input call io.getFieldInput().
 * 
 * 				To close the scanner object used by the class call io.scannerClose().
 * 
 * 				To collect integer input that can contain a blank space (used for field value updates) call io.getNumberInput().
 * 
 */

import java.util.Scanner;

public class IO_System {
	
static Scanner sc = new Scanner(System.in);
	
	//Method to display main menu
	public static void mainMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Search for a rental");
		System.out.println("2. Edit rental record from database");
		System.out.println("3. Add a rental to the database");
		System.out.println("4. Remove a rental from the database");
		System.out.println("5. Exit");
	}
	
	//Method to display search menu
	public static void searchMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Find first record");
		System.out.println("2. Filter a search");
		System.out.println("3. Search by record id");
		System.out.println("4. Back");
	}
	
	//Method for selecting filter catagory
	public static void filterFieldMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Number of people");
		System.out.println("2. Number of bedrooms");
		System.out.println("3. Number of beds");
		System.out.println("4. Back");
	}
	
	//Method for displaying filter options
	public static void filteredOptionsMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Filter equal to");
		System.out.println("2. Filter a range");
		System.out.println("3. Back");
	}
	
	//Method to handle menu input
	public static int getMenuInput() {
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
			if(userChoice < 0) {
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
	public static String getFieldInput() {
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
	public static void scannerClose() {
		sc.close();
	}
	
	//Method to collect numeric input and accept an empty string, used for the edit method
	public static int getNumberInput() {
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
			
			//Check if user entered a blank line, if so return null
			if(userInput == "") {
				userChoice = -1;
				validInput = true;
				
			//Check for valid positive numeric input
			} else {
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
				if(userChoice < 0) {
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

		}
		//Return input as an integer or null
		return userChoice;
		
	}

}
