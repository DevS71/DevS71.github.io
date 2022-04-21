package services;

/*
 * Author: Devin Schmidt
 * 
 * Date: 04/02/2022  Class: CS-499
 * 
 * Description: Class to store linked lists in a two dimensional vector, owner by service.
 * 
 * 				To use this class create a VectorMap() object "vectorMap"
 * 
 * 				To find a user in the user list, call vectorMap.findUser(String) and pass a String with the user name to find.
 * 
 * 				To add a user to the user list, call vectorMap.addUser(String) and pass a String with the user name to find.
 * 
 * 				To add an Appointment object to the appointment list for the user call vectorMap.addAppointment(String,
 * 					String, String, String, int) and pass a String for the appointment ID, a String for the appointment Date,
 * 					a String for the appointment description, a String with the user name, and an int for the mode (1 = new
 * 					appointment, 2 = loaded from file).
 * 
 * 				To remove an appointment from the list, call vectorMap.removeAppointment(String, String) and pass a String
 * 					for the appointment ID and a String for the user name.
 * 
 * 				To display the entire appointment list call vectorMap.displayAppointmentList(String) and pass a String for
 * 					the user name.
 * 
 * 				To display a single appointment call vectorMap.displayAppointment(String, String) and pass a String for the 
 * 					appointment ID and a String for the user name.
 * 
 * 				To add a contact to the contact list call vectorMap.addContact(String, String, String, String, String, String)
 * 					and pass a String for the contact ID, a String for the contact first name, a String for the contact last
 * 					name, a String for the contact phone number, a String for the contact address, and a String for the user
 * 					name.
 * 
 * 				To remove a contact from the contact list call vectorMap.removeContact(String, String) and pass a String for
 * 					the contact ID and a String for the user name.
 * 
 * 				To display the entire contact list call vectorMap.displayAppointmentList(String) and pass a String for the 
 * 					user name.
 * 
 * 				To display a single contact call vectorMap.displayContact(String, String) and pass a String for the contact ID
 * 					and a String for the user name.
 * 
 * 				To add a task to the task list call vectorMap.addTask(String, String, String, String) and pass a String for the 
 * 					task ID, a String for the task name, a String for the task description, and a String for the user name.
 * 
 * 				To remove a task from the task list call vectorMap.removeTask(String, String) and pass a String for the task
 * 					ID, and a String for the user name.
 * 
 * 				To display the entire task list call vectorMap.displayTaskList(String) and pass a String for the user name.
 * 
 * 				To display a single task call vectorMap.displayTask(String, String) and pass a String for the task ID, and
 * 					a String for the user name.
 * 
 * 		The following methods are private and can only be used by this class
 * 				
 * 				To load a list from the 2D vector call loadList(String, int) and pass a String for the user name, and an 
 * 					int for the list type (0 = Appointment, 1 = Contact, 2 = Task)
 * 
 * 				To find Node location in a list call findNode(String ID) and pass a String for the ID of the Node to find.
 */

import java.util.*;

import dataObjects.*;


public class VectorMap {
	
	//Vector to hold users, used to locate their assets.
	public Vector<String> users = new Vector<String>();
	//1st dimension of 2D vector, each owner is given an index
	public Vector<Vector<LinkedList<Node>>> owners = new Vector<Vector<LinkedList<Node>>>();
	//2nd dimension of 2d vector, holds services. Appointments = index 0, Contacts = index 1, Tasks = index 2.
	public Vector<LinkedList<Node>> services = new Vector<LinkedList<Node>>();
	//Linked list to hold the data, contained in the services vector, grouped by service type.
	public LinkedList<Node> nodes = new LinkedList<Node>();
	
	//Method to find user in system
	private int findUser(String user) {
		//Integer to store user position
		int owner = -1;
		//Loop to find user in array
		for(int i = 0; i < users.size(); ++i) {
			if(user.equals(users.get(i))) {
				owner = i;
				break;
			}
		}
		return owner;
	}
	
	//Method to add user into system
	public void addUser(String user) {
		//integer to store users position in system
		int owner = -1;
		//Add user to user vector
		users.add(user);
		//create new services vector for new user
		services = new Vector<LinkedList<Node>>();
		//add services vector to owners vector
		owners.add(services);
		//find user in system
		owner = findUser(user);
		
		//new linked lists for user, one for each service
		LinkedList<Node> addList1 = new LinkedList<Node>();
		LinkedList<Node> addList2 = new LinkedList<Node>();
		LinkedList<Node> addList3 = new LinkedList<Node>();
		//Add new linked lists to services vector
		owners.get(owner).add(addList1);
		owners.get(owner).add(addList2);
		owners.get(owner).add(addList3);
		
		
	}
	
	//method to add Appointment to appointList
	public boolean addAppointment(String ID, String date, String desc, String user, int mode) {
		
		//integer to check for duplicate IDs, if found integer will reset to appointments index.
		int duplicateCheck = -1;
		//boolean to verify creation
		boolean createCheck = false;
		//Appointment object to add to appointList
		Node appointment = new Node();
		
		//Method to load appropriate data
		loadList(user, 0);
		
		//check appointList for duplicate ID, fault if found (value other than -1) or create new appointment if not.
		duplicateCheck = findNode(ID);
		if (duplicateCheck == -1) {
			appointment.createAppoint(ID, date, desc, user, mode);
			if(appointment.getNodeID() != null) {
				nodes.add(appointment);
				createCheck = true;
			}	
		} else {
			System.out.println("Invalid ID, ID already exists. Appointment not created");
			System.out.println();
		}
		
		return createCheck;
	}
	
	//method for removing an Appointment from appointList
	public void removeAppointment(String ID, String user) {
		//integer value to find Appointment in appointmentList
		int appointmentIndex = -1;
		
		//Method to load appropriate data
		loadList(user, 0);
		
		//find Appointment in appointList
		appointmentIndex = findNode(ID);
		
		//check if Appointment was found, fault if not found or delete if found.
		if (appointmentIndex == -1) {
			System.out.println("Invalid ID, ID does not exist.");
			System.out.println();
		} else {
			nodes.remove(appointmentIndex);
			System.out.println("Appointment removed.");
			System.out.println();
		}
	}
	
	//Method for displaying entire list.
	public void displayAppointmentList(String user) {
		//Appointment object to use for holding current appointent.
		Node appointment = new Node();
		
		//Method to load appropriate data
		loadList(user, 0);
		
		//check if list has anything in it, if it does print contents
		if(nodes.size() > 0) {
			//Loop to cycle through list and display appointments on screen.
			for(int i = 0; i < nodes.size(); ++i) {
				appointment = nodes.get(i);
				System.out.println("Appointment ID: " + appointment.getNodeID());
				System.out.println("Appointment date: " + appointment.getAppointmentDate());
				System.out.println("Appointment description: " + appointment.getNodeDescription());
				System.out.println();
			}
		} else {
			System.out.println("No appointments saved in list.");
			System.out.println();
		}
	}
	
	//Method for displaying a single appointment.
	public void displayAppointment(String ID, String user) {
		//Appointment object to use for holding appointment.
		Node appointment = new Node();
		
		//Integer variable used to hold appointments location in list.
		int appointmentIndex = -1;
		
		//Method to load appropriate data
		loadList(user, 0);
		
		//Method call to locate appointment in list.
		appointmentIndex = findNode(ID);
		//Check if found (value equal to or greater than zero), display appointment if found, error message if not.
		if(appointmentIndex >= 0) {
			appointment = nodes.get(appointmentIndex);
			System.out.println("Appointment ID: " + appointment.getNodeID());
			System.out.println("Appointment Date: " + appointment.getAppointmentDate());
			System.out.println("Appointment Description: " + appointment.getNodeDescription());
			System.out.println();
		} else {
			System.out.println("Invalid ID, or appointment does not exist");
			System.out.println();
		}
	}
	
	//method to add contact to list
	public boolean addContact(String ID, String fName, String lName, String phNum, String mail, String user) {
		//integer to check for duplicate Contact ID
		int contactIndex = -1;

		//Contact object to add to list
		Node contact = new Node();
		
		//boolean to return
		boolean createCheck = false;
		
		//Method to load appropriate data
		loadList(user, 1);
		
		//search for duplicate Contact IDs
		contactIndex = findNode(ID);
		
		//if ID not found (index value of -1) create contact, or else fault if found.
		if (contactIndex == -1) {
			contact.createContact(ID, fName, lName, phNum, mail, user);
			if(contact.getNodeID() != null) {
				nodes.add(contact);
				createCheck = true;
			}
		} else {
			System.out.println("Invalid ID, ID already exists. Contact not created.");
			System.out.println();
		}
		
		return createCheck;
	}
	
	//method for removing Contact from conList
	public void removeContact(String ID, String user) {
		//integer to hold index of Contact to remove.
		int contactIndex = -1;
		
		//Method to load appropriate data
		loadList(user, 1);
		
		//find Contact in list.
		contactIndex = findNode(ID);
		
		//if Contact not found (index value of -1) fault, else remove contact from list.
		if (contactIndex == -1) {
			System.out.println("Invalid ID, ID does not exist.");
			System.out.println();
		} else {
			nodes.remove(contactIndex);
			System.out.println("Contact removed.");
			System.out.println();
		}
	}
	
	//Method to display entire list of contacts.
	public void displayContactList(String user) {
		//Contact object to use in displaying values.
		Node contact = new Node();
		
		//Method to load appropriate data
		loadList(user, 1);
		
		//check if list contains data and display list contents if it does
		if(nodes.size() > 0) {
			//Loop through list and display values of each contact object.
			for(int i = 0; i < nodes.size(); ++i) {
				contact = nodes.get(i);
				System.out.println("Contact ID: " + contact.getNodeID());
				System.out.println("Contact Name: " + contact.getFirstName() + " " + contact.getLastName());
				System.out.println("Contact Phone Number: " + contact.getPhoneNumber());
				System.out.println("Contact Address: " + contact.getAddress());
				System.out.println();
			}
		} else {
			System.out.println("No contacts saved in list.");
			System.out.println();
		}
	}
	
	public void displayContact(String ID, String user) {
		//Integer variable to hold index of contact.
		int findContactNode = -1;
		
		//Contact object to hold contact found in list.
		Node contact = new Node();
		
		//Method to load appropriate data
		loadList(user, 1);
		
		findContactNode = findNode(ID);
		//Check if contact found in list and display if found (value of zero or greater), or display error message if not found.
		if(findContactNode >= 0) {
			contact = nodes.get(findContactNode);
			System.out.println("Contact ID: " + contact.getNodeID());
			System.out.println("Contact Name: " + contact.getFirstName() + " " + contact.getLastName());
			System.out.println("Contact Phone Number: " + contact.getPhoneNumber());
			System.out.println("Contact Address: " + contact.getAddress());
			System.out.println();
		} else {
			System.out.println("Invalid ID or contact does not exist.");
			System.out.println();
		}
	}
	
	//method to add Task to taskList
	public boolean addTask(String ID, String name, String desc, String user) {
		//integer for searching taskList
		int taskIndex = -1;
		//Task object to create
		Node task = new Node();
		//boolean to return if creation successfull
		boolean createCheck = false;
		
		//Method to load appropriate data
		loadList(user, 2);
		
		//search taskList for duplicate ID, if not found create task or if found fault.
		taskIndex = findNode(ID);
		//If not found taskIndex will have a value of -1
		if (taskIndex == -1) {
			task.createTask(ID, name, desc, user);
			if(task.getNodeID() != null) {
				nodes.add(task);
				createCheck = true;
			}
		} else {
			System.out.println("Invalid ID, ID already in use. Task not created.");
			System.out.println();
		}
		
		return createCheck;
	}
	
	//method for removing Task from taskList
	public void removeTask(String ID, String user) {
		//integer to hold index of task to remove
		int index = -1;
		
		//Method call to load appropriate data
		loadList(user, 2);
		
		//find Task in taskList
		index = findNode(ID);
		
		//if Task not found index = -1 fault, if found remove task from list.
		if (index == -1) {
			System.out.println("Invalid ID, ID not found");
			System.out.println();
		} else {
			nodes.remove(index);
			System.out.println("Task removed.");
			System.out.println();
		}
	}
	
	//Method to display entire taskList
	public void displayTaskList(String user) {
		//Task object to hold current task
		Node task = new Node();
		
		//Method call to load appropriate data
		loadList(user, 2);
		
		if(nodes.size() > 0) {
			//Loop to cycle through taskList and display values of each task.
			for(int i = 0; i < nodes.size(); ++i) {
				task = nodes.get(i);
				System.out.println("Task ID: " + task.getNodeID());
				System.out.println("Task name: " + task.getTaskName());
				System.out.println("Task Description: " + task.getNodeDescription());
				System.out.println();
			}
		} else {
			System.out.println("No tasks saved to list.");
			System.out.println();
		}
	}
	
	//Method for displaying single task.
	public void displayTask(String ID, String user) {
		//Integer variable to store index value of task in list if found.
		int findNode = -1;
		//Task object to hold requested task.
		Node task = new Node();
		
		loadList(user, 2);
		
		//Call method to search taskList for task.
		findNode = findNode(ID);
		//Check if task is found (value of zero or greater in findNode) and display, or error message if not found.
		if(findNode >= 0) {
			task = nodes.get(findNode);
			System.out.println("Task ID: " + task.getNodeID());
			System.out.println("Task Name: " + task.getTaskName());
			System.out.println("Task Description: " + task.getNodeDescription());
			System.out.println();
		} else {
			System.out.println("Invalid ID or task does not exist.");
			System.out.println();
		}
	}
	
	private void loadList(String user, int type) {
		//integer to find user in system
		int owner = -1;
		//find owner in system
		owner = findUser(user);
		
		if(owner == -1) {
			System.out.println("Invalid User, Please log in on an authorized account.");
			System.out.println();
		} else {
			nodes = new LinkedList<Node>();
			nodes = owners.get(owner).get(type);
			}
	}
	
	//method to find Node in List
	private int findNode(String ID) {
		//integer to store Node location in List
		int nodeIndex = -1;
		//Node object used to compare to ID for match
		Node node = new Node();
		
		if(nodes.size() > 0) {
			for (int i = 0; i < nodes.size(); ++i) {
				//set Node object to object at current location in appointmentList for comparison.
				node = nodes.get(i);
				//check ID against Node objects ID field, break out of loop and save location if match is found.
				if (ID.equals(node.getNodeID())) {
					nodeIndex = i;
					break;
				}
			}
		}
		//index returned will have a value of -1 if Appointment not found, or index location of object if found
		return nodeIndex;
	}

}
