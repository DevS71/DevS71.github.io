package contactService;

import java.util.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage structure to store Contact objects in memory
 */

public class ContactService {
	
	//create structure to store Contact objects in memory
	LinkedList<Contact> conList = new LinkedList<Contact>();
	
	//method to add contact to list
	public void addContact(String ID, String fName, String lName, String phNum, String mail) {
		//integer to check for duplicate Contact ID
		int index = -1;
		//Contact object to add to list
		Contact contact = new Contact();
		
		//search for duplicate Contact IDs
		index = findContact(ID);
		
		//if ID not found (index value of -1), create contact else fault
		if (index == -1) {
			contact.createContact(ID, fName, lName, phNum, mail);
			conList.add(contact);
		} else {
			throw new IllegalArgumentException("Invalid ID, ID already exists");
		}
	}
	
	//method for finding contact in list
	public int findContact(String ID) {
		//integer to return
		int index = -1;
		//Contact object to compare IDs
		Contact contact = new Contact();
		
		//loop to search list
		for(int i = 0; i < conList.size(); ++i) {
			contact = conList.get(i);
			//compare IDs
			if (ID.equals(contact.getConID())) {
				//if a match set index to i and break out of loop
				index = i;
				break;
			}
		}
		//returns -1 if contact not found, index of Contact in conList if found
		return index;
	}
	
	//method to return Contact from conList
	public Contact getContact(String ID) {
		//integer to find Contact location in list
		int index = -1;
		//Contact object to return
		Contact contact = new Contact();
		
		//find Contact location in list
		index = findContact(ID);
		//fault if contact not found in conList, index value of -1
		if (index == -1) {
			throw new IllegalArgumentException("Invalid ID, ID does not exist");
		} else {
			//set contact to object at index location
			contact = conList.get(index);
		}
		return contact;
	}
	
	//method for updating firstName of Contact
	public void updateFirstName(String ID, String name) {
		//Contact object to update
		Contact contact = new Contact();
		
		//get Contact from conList
		contact = getContact(ID);
		
		//update firstName field
		contact.setFirstName(name);
	}
	
	//method for updating lastName of Contact
	public void updateLastName(String ID, String name) {
		//Contact object to update
		Contact contact = new Contact();
		
		//get Contact from conList
		contact = getContact(ID);
		
		//update lastName field
		contact.setLastName(name);
	}
	
	//method for updating phonNum of Contact
	public void updatePhoneNum(String ID, String phNum) {
		//Contact object to update
		Contact contact = new Contact();
		
		//get Contact from conList
		contact = getContact(ID);
		
		//update phoneNum field
		contact.setPhoneNum(phNum);
	}
	
	//method for updating address of Contact
	public void updateAddress(String ID, String mail) {
		//Contact object to update
		Contact contact = new Contact();
		
		//get Contact from conList
		contact = getContact(ID);
		
		//update address field
		contact.setAddress(mail);
	}
	
	//method for removing Contact from conList
	public void removeContact(String ID) {
		//integer to hold index of Contact to remove
		int index = -1;
		
		//find Contact in list
		index = findContact(ID);
		
		//if Contact not found (index value of -1) fault, else remove
		if (index == -1) {
			throw new IllegalArgumentException("Invalid ID, ID does not exist");
		} else {
			conList.remove(index);
		}
	}

}