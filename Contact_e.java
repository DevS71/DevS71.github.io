package contacts;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage Contact objects. Contains variables for holding the ID, first name, last name, phone number
 * 					and address of the contact.
 * 
 * 				To access this class use a Contact object "contact".
 * 
 * 				To create a new contact, call contact.createContact(String, String, String, String, String) and pass a 
 * 					String for the ID (cannot be null or longer than 10 characters),
 * 					a String for the first name (Cannot be null or longer than 10 characters), 
 * 					a String for the last name (cannot be null or longer than 10 characters), 
 * 					a String for the phone number (cannot be null and must be exactly 10 characters), 
 * 					a String for the address (cannot be null or longer than 30 characters).
 * 
 * 				To set the first name call contact.setFirstName(String) and pass a String for the first name (Cannot be null or longer than 10 characters).
 * 
 * 				To set the last name call contact.setLastName(String) and pass a String for the last name (Cannot be null or longer than 10 characters).
 * 
 * 				To set the phone number call contact.setPhoneNum(String) and pass a String for the phone number (cannot be null and must be exactly 10 characters).
 * 
 * 				To set the address call contact.setAddress(String) and pass a String for the address (cannot be null or longer than 30 characters).
 * 
 * 				To retrieve the contact ID call contact.getContactID(), this returns a String.
 * 
 * 				To retrieve the first name call contact.getFirstName(), this returns a String.
 * 
 * 				To retrieve the last name call contact.getLastName(), this returns a String.
 * 
 * 				To retrieve the phone number call contact.getPhoneNumber(), this returns a String.
 * 
 * 				To retrieve the address call contact.getAddress(), this returns a String.
 * 
 * Enhanced on 3/28/2022 for CS-499
 */

public class Contact {
	
	//Fields for the Contact object
	String contactID;//variable to hold the contact ID
	String firstName;//variable to hold the first name of the contact
	String lastName;//variable to hold the last name of the contact
	String phoneNum;//variable to hold the phone number of the contact
	String address;//variable to hold the address of the contact
	
	//default constructor
	public Contact() {
		contactID = null;
		firstName = null;
		lastName = null;
		phoneNum = null;
		address = null;
	}
	
	//method to create Contact object
	public Contact createContact(String ID, String fName, String lName, String phNum, String mail) {
		//Contact object to return
		Contact contact = new Contact();
		//check that ID meets requirements, fault if it doesn't or create if it does.
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		} else {
			this.contactID = ID;
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
			throw new IllegalArgumentException("Invalid First Name");
		} else {
			this.firstName = name;
		}
	}
	
	//method for adding/updating lastName.
	public void setLastName(String name) {
		//check name meets requirements, fault if it doesn't or set field if it does.
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		} else {
			this.lastName = name;
		}
	}
	
	//method for setting/updating phoneNum
	public void setPhoneNum(String phNum) {
		//check phNum meets requirements, fault if it doesn't or set field if it does.
		if (phNum == null || phNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		} else {
			this.phoneNum = phNum;
		}
	}
	
	//method for setting/updating address
	public void setAddress(String mail) {
		//check that mail meets requirements, fault if it doesn't or set field if it does.
		if (mail == null || mail.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		} else {
			this.address = mail;
		}
	}
	
	//method to return conID for Contact
	public String getContactID() {
		return this.contactID;
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
		return this.phoneNum;
	}
	
	//method to return address for Contact
	public String getAddress() {
		return this.address;
	}
}
