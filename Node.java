package dataObjects;

/*
 * Author: Devin Schmidt
 * 
 * Class: CS-499	Date:4/3/2022
 * 
 * Description: Data object to store in the two-dimensional linked list structure.
 * 
 * 				To use this class create a Node() object "node"
 * 
 * 				To create a new Appointment Node call node.createAppointment(String, String, String, String, int) and pass a 
 * 					String for the ID value, a String for the date value, a String for the description value, a String for the
 * 					owner value, an int for node value (1 = new node, 2 = loaded from file).
 * 
 * 				To set the appointment date on a node call node.setAppointmentDate(String, int) and pass a String with the date
 * 					value (format must be YYYY-MM-DD HH:mm) and an integer for the mode (1 = new date (must be in the future) and
 * 					2 = loaded from file (can be in the past to avoid errors).
 * 
 * 				To get the appointment date call node.getAppointmentDate(). This returns a String with of the date value.
 * 
 * 				To create a new Task Node call node.createTask(String, String, String, String) and pass a String value for 
 * 					the task ID, a String value for the task name, a String value for the task description, and a String value
 * 					for the task owner.
 * 
 * 				To set the taskName of a node call node.setTaskName(String) and pass a String value for the new task name.
 * 	
 * 				To get the taskName of a node call node.getTaskName(), this returns a String with the taskName value.
 * 
 * 				To create a Contact Node call node.createContact(String, String, String, String, String, String) and pass
 * 					a String for the contact ID, a String for the contact first name, a String for the contact last name,
 * 					a String for the contact phone number, a String for the contact address, and a String for the contact
 * 					owner.
 * 
 * 				To set a contact node first name call node.setFirstName(String) and pass a String with the new first name.
 * 	
 * 				To set a contact node last name call node.setLastName(String) and pass a String with the new last name.
 * 
 * 				To set a contact node phone number call node.setPhoneNum(String) and pass a String with the new phone number.
 * 
 * 				To set a contact node address call node.setAddress(String) and pass a String with the new Address.
 * 
 * 				To get a contact first name call node.getFirstName(). This returns a String with the value of firstName.
 * 
 * 				To get a contact last name call node.getLastName(). This returns a String with the value of lastName.
 * 
 * 				To get a contact phone number call node.getPhoneNumber(). This returns a String with the value of phoneNummber.
 * 
 * 				To get a contact address call node.getAddress(). This returns a String with the value of address.
 * 
 * 				To set the node description call node.setNodeDescription(String) and pass a String with the new nodeDescription.
 * 
 * 				To get the node description call node.getNodeDescription(). This returns a String with the value of nodeDescription.
 * 
 * 				To get the node owner call node.getNodeOwner(). This returns a String with the value of owner.
 * 
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Node {
	
		//Fields for the Node object
		String owner;//variable for storing the username of node owner
		String nodeType;//variable for storing the type of node: appointment, contact, or task
		String nodeID;//variable for storing the node ID value, must be unique within owner/type collection
		String taskName;//variable for storing task name, this has different parameters than other name values
		String firstName;//variable for storing contacts first name
		String lastName;//variable for storing contacts last name
		String phoneNumber;//variable for storing contact phone number
		String address;//variable for storing contacts address
		Date appointmentDate; //variable for storing appoinment date, format is yyyy-MM-dd HH:mm
		String nodeDescription;//variable for storing node description
		
		//default constructor
		public Node() {
			owner = null;
			nodeType = null;
			nodeID = null;
			taskName = null;
			firstName = null;
			lastName = null;
			phoneNumber = null;
			address = null;
			appointmentDate = new Date();
			nodeDescription = null;
		}
		
		//method for creating Appointment object
		public Node createAppoint(String ID, String date, String desc, String user, int mode) {
			//Appointment object to create and return
			Node appointment = new Node();
			
			//check if ID meets requirements, fault if does not or create if requirements are met.
			if (ID == null || ID.length() > 10 || ID.length() < 1) {
				System.out.println("Invalid ID, contact not created.");
				System.out.println();
			} else {
				//Create Appointment
				this.owner = user;
				this.nodeType = "Appointment";
				this.nodeID = ID;
				setAppointmentDate(date, mode);
				setNodeDescription(desc);
			}
			return appointment;
		}
		
		//method for creating/updating appointDate
		public void setAppointmentDate(String strDate, int mode) {
			//object to format string into date
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			//date object to hold converted string
			Date newDate = new Date();
			//date object to compare newDate with current date
			Date currDate = new Date();
			
			//check strDate isn't null and is 16 characters, fault if not met or set if conditions are met.
			if (strDate == null || strDate.length() != 16) {
				System.out.println("Invalid date, cannot be null and must be 16 characters.");
				System.out.println();
				this.appointmentDate = currDate;
			} else {
				//try/catch block to catch parse exceptions
				try {
					//Parse date from string
					newDate = df.parse(strDate);
				} catch (ParseException e) {
					System.out.println("Error parsing date");
					System.out.println();
				}
				//check if mode is 1, if it is this is a new appointment and must check against current date
				if(mode == 1) {
					//check if newDate if before currDate, fault if it is set if it is not.
					if (newDate.before(currDate)) {
						System.out.println("Invalid date, cannot be in the past.");
						System.out.println();
						this.appointmentDate = currDate;
					} else {
						this.appointmentDate = newDate;
					}
				//if mode is not 1 then this is loaded from disk, date may be older than current set anyway to avoid errors
				} else {
					this.appointmentDate = newDate;
				}
			}
		}
		
		//method for returning appointDate as a string
		public String getAppointmentDate() {
			SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm");
			String stringDate = df.format(this.appointmentDate);
			return stringDate;
		}
		
		
		
		//method for creating Task node.
		public Node createTask(String ID, String name, String desc, String user) {
			//Task object to create and return
			Node task = new Node();
			
			//verify ID meets requirements, fault if it does not or create task if it does.
			if (ID == null || ID.length() > 10 || ID.length() < 1) {
				System.out.println("Invalid ID, task not created.");
				System.out.println();
			} else {
				this.owner = user;
				this.nodeType = "Task";
				this.nodeID = ID;
				setTaskName(name);
				setNodeDescription(desc);
			}
			
			return task;
		}
		
		//method for setting/updating taskName.
		public void setTaskName(String name) {
			//verify name meets requirements, fault if it does not or set field value if it does.
			if (name == null || name.length() > 20) {
				System.out.println("Invalid name, greater than 20 characters. Task not created.");
				System.out.println();
				this.taskName = "Generic Task Name";
			} else {
				this.taskName = name;
			}
		}
		
		//method for returning taskName.
		public String getTaskName() {
			return this.taskName;
		}
		
		//Method for creating contact node
		public Node createContact(String ID, String fName, String lName, String phNum, String mail, String user) {
			//Contact object to return
			Node contact = new Node();
			//check that ID meets requirements, fault if it doesn't or create if it does.
			if (ID == null || ID.length() > 10 || ID.length() < 1) {
				System.out.println("Invalid ID, cannot be null or greater than 10 characters. Contact not created.");
				System.out.println();
			} else {
				this.owner = user;
				this.nodeType = "Contact";
				this.nodeID = ID;
				setFirstName(fName);
				setLastName(lName);
				setPhoneNum(phNum);
				setAddress(mail);
			}
			
			return contact;
		}
		
		//method for adding/updating firstName.
		public void setFirstName(String name) {
			
			//check name meets requirements, fault if it doesn't or set field if it does.
			if (name == null || name.length() > 10) {
				System.out.println("Invalid firstname, cannot be null or longer than 10 characters.");
				System.out.println();
				this.firstName = "Invalid Name";
			} else {
				this.firstName = name;
			}
		}
		
		//method for adding/updating lastName.
		public void setLastName(String name) {
			//check name meets requirements, fault if it doesn't or set field if it does.
			if (name == null || name.length() > 10) {
				System.out.println("Invalid Last Name, cannot be null or greater than 10 characters.");
				System.out.println();
				this.lastName = "Invalid Name";
			} else {
				this.lastName = name;
			}
		}
		
		//method for setting/updating phoneNum
		public void setPhoneNum(String phNum) {
			//check phNum meets requirements, fault if it doesn't or set field if it does.
			if (phNum == null || phNum.length() != 10) {
				System.out.println("Invalid Phone Number, cannot be null and must be 10 digets.");
				System.out.println();
				this.phoneNumber = "xxxxxxxxxx";
			} else {
				this.phoneNumber = phNum;
			}
		}
		
		//method for setting/updating address
		public void setAddress(String mail) {
			//check that mail meets requirements, fault if it doesn't or set field if it does.
			if (mail == null || mail.length() > 30) {
				System.out.println("Invalid Address, cannot be null or longer than 30 characters.");
				System.out.println();
				this.address = "Invalid Address";
			} else {
				this.address = mail;
			}
		}
		
		//method for setting nodeDescription field
		public void setNodeDescription(String description) {
			//check if description meets requirements, fault if it doesn't or set if it does.
			if (description == null || description.length() > 50) {
				System.out.println("Invalid Description, cannot be null or longer than 50 characters.");
				System.out.println();
				this.nodeDescription = "Invalid Description";
			} else {
				this.nodeDescription = description;
			}
		}
		
		//method to return conID for Contact
		public String getNodeID() {
			return this.nodeID;
		}
		
		//method to return firstName for Contact
		public String getFirstName() {
			return this.firstName;
		}
		
		//method to return lastName for Contact
		public String getLastName() {
			return this.lastName;
		}
		
		//method to return phoneNum for Contact
		public String getPhoneNumber() {
			return this.phoneNumber;
		}
		
		//method to return address for Contact
		public String getAddress() {
			return this.address;
		}
		
		//method for returning appointDesc
		public String getNodeDescription() {
			return this.nodeDescription;
		}
		
		//Method to return node owner
		public String getNodeOwner() {
			return this.owner;
		}

}
