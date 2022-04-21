package contacts;

import java.util.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage structure to store Contact objects in memory. Uses a Linked List to store the contact objects.
 * 
 * 				To access this class create an instance of the class "contactService".
 * 
 * 				To add a contact to the list call contactService.addContact(String, String, String, String, String) and pass
 * 					a String for the id, a String for the first name, a String for the Last Name, a String for the phone number
 * 					and a String for the address.
 * 
 * 				To find a contact in the list call contactService.findContact(String) and pass a String with the ID, this
 * 					returns an integer with the index of the contact in the list.
 * 	
 * 				To retrieve a contact from the list, call contactService.getContact(String) and pass a String with the ID, this
 * 					returns a contact object.
 * 	
 * 				To update the first name of a contact call contactService.updateFirstName(String, String) and pass a 
 * 					String with the ID and a String with the new first name.
 * 
 * 				To update the last name of a contact call contactService.updateLastName(String, String) and pass a 
 * 					String with the ID and a String with the new last name.
 * 
 * 				To update the phone number of a contact call contactService.updatePhoneNumber(String, String) and pass a
 * 					String with the ID and a String with the new last name.
 * 
 * 				To update the address of a contact call contactService.updateAddress(String, String) and pass a String with
 * 					the ID and a String with the new address.
 * 
 * 				To remove a contact from the list call contactService.removeContact(String) and pass a String with the ID.
 * 
 * 				To display the entire list call contactService.displayList(). This will output every contact to the display.
 * 
 * 				To display a single contact call contactService.displayContact(String) and pass a String with the ID. This
 * 					will output the contact to the display.
 * 
 * 				
 * Enhanced on 3/28/2022 for CS-499
 */

public class ContactService {
	
	//create structure to store Contact objects in memory
	public LinkedList<Contact> contactList = new LinkedList<Contact>();
	
	//method to add contact to list
	public void addContact(String ID, String fName, String lName, String phNum, String mail) {
		//integer to check for duplicate Contact ID
		int contactIndex = -1;
		//Contact object to add to list
		Contact contact = new Contact();
		
		//search for duplicate Contact IDs
		contactIndex = findContact(ID);
		
		//if ID not found (index value of -1) create contact, or else fault if found.
		if (contactIndex == -1) {
			contact.createContact(ID, fName, lName, phNum, mail);
			contactList.add(contact);
		} else {
			throw new IllegalArgumentException("Invalid ID, ID already exists");
		}
	}
	
	//method for finding contact in list
	public int findContact(String ID) {
		//integer to return
		int contactIndex = -1;
		//Contact object to compare IDs
		Contact contact = new Contact();
		
		//loop to search list
		for(int i = 0; i < contactList.size(); ++i) {
			contact = contactList.get(i);
			//compare IDs, set return variable to index if found and break out of loop.
			if (ID.equals(contact.getContactID())) {
				contactIndex = i;
				break;
			}
		}
		//returns -1 if contact not found, index of Contact in contactList if found.
		return contactIndex;
	}
	
	//method to return Contact from conList
	public Contact getContact(String ID) {
		//integer to find Contact location in list
		int contactIndex = -1;
		//Contact object to return
		Contact contact = new Contact();
		
		//find Contact location in list
		contactIndex = findContact(ID);
		//fault if contact not found in conList, index value of -1 or set contact to object from list to return.
		if (contactIndex == -1) {
			throw new IllegalArgumentException("Invalid ID, ID does not exist");
		} else {
			contact = contactList.get(contactIndex);
		}
		//return contact object.
		return contact;
	}
	
	//method for updating firstName of Contact.
	public void updateFirstName(String ID, String name) {
		//Contact object to update.
		Contact contact = new Contact();
		
		//get Contact from conList.
		contact = getContact(ID);
		
		//update firstName field.
		contact.setFirstName(name);
	}
	
	//method for updating lastName of Contact.
	public void updateLastName(String ID, String name) {
		//Contact object to update.
		Contact contact = new Contact();
		
		//get Contact from conList.
		contact = getContact(ID);
		
		//update lastName field.
		contact.setLastName(name);
	}
	
	//method for updating phonNumber of Contact.
	public void updatePhoneNumber(String ID, String phNum) {
		//Contact object to update.
		Contact contact = new Contact();
		
		//get Contact from conList.
		contact = getContact(ID);
		
		//update phoneNumber field.
		contact.setPhoneNum(phNum);
	}
	
	//method for updating address of Contact.
	public void updateAddress(String ID, String mail) {
		//Contact object to update.
		Contact contact = new Contact();
		
		//get Contact from contactList.
		contact = getContact(ID);
		
		//update address field.
		contact.setAddress(mail);
	}
	
	//method for removing Contact from conList
	public void removeContact(String ID) {
		//integer to hold index of Contact to remove.
		int contactIndex = -1;
		
		//find Contact in list.
		contactIndex = findContact(ID);
		
		//if Contact not found (index value of -1) fault, else remove contact from list.
		if (contactIndex == -1) {
			throw new IllegalArgumentException("Invalid ID, ID does not exist");
		} else {
			contactList.remove(contactIndex);
		}
	}
	
	//Method to display entire list of contacts.
	public void displayList() {
		//Loop through list and display values of each contact object.
		for(int i = 0; i < contactList.size(); ++i) {
			displayContact(contactList.get(i).getContactID());
		}
		//Output message for empty list
		if(contactList.size() < 1) {
			System.out.println("No contacts available.");
			System.out.println();
		}
	}
	
	//Method for displaying a single contact.
	public void displayContact(String ID) {
		//Integer variable to hold index of contact.
		int findNode = -1;
		//Contact object to hold contact found in list.
		Contact contact = new Contact();
		//Get the index of the requested contact.
		findNode = findContact(ID);
		//Check if contact found in list and display if found (value of zero or greater), or display error message if not found.
		if(findNode >= 0) {
			contact = contactList.get(findNode);
			System.out.println("Contact ID: " + contact.getContactID());
			System.out.println("Contact Name: " + contact.getFirstName() + " " + contact.getLastName());
			System.out.println("Contact Phone Number: " + contact.getPhoneNumber());
			System.out.println("Contact Address: " + contact.getAddress());
			System.out.println();
		} else {
			System.out.println("Invalid ID or contact does not exist.");
			System.out.println();
		}
	}

}
