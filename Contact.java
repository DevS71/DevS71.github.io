package contactService;


/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage Contact objects
 */

public class Contact {
	
	//Fields for the Contact object
	String conID;
	String firstName;
	String lastName;
	String phoneNum;
	String address;
	
	//default constructor
	public Contact() {
		conID = null;
		firstName = null;
		lastName = null;
		phoneNum = null;
		address = null;
	}
	
	//method to create Contact object
	public Contact createContact(String ID, String fName, String lName, String phNum, String mail) {
		//Contact object to return
		Contact contact = new Contact();
		//check that ID meets requirements
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		} else {
			this.conID = ID;
			setFirstName(fName);
			setLastName(lName);
			setPhoneNum(phNum);
			setAddress(mail);
		}
		
		return contact;
	}
	
	//method for adding/updating firstName
	public void setFirstName(String name) {
		
		//check name meets requirements
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		} else {
			//set firstName field
			this.firstName = name;
		}
	}
	
	//method for adding/updating lastName
	public void setLastName(String name) {
		//check name meets requirements
		if (name == null || name.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		} else {
			this.lastName = name;
		}
	}
	
	//method for setting/updating phoneNum
	public void setPhoneNum(String phNum) {
		//check phNum meets requirements
		if (phNum == null || phNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		} else {
			this.phoneNum = phNum;
		}
	}
	
	//method for setting/updating address
	public void setAddress(String mail) {
		//check that mail meets requirements
		if (mail == null || mail.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		} else {
			this.address = mail;
		}
	}
	
	//method to return conID for Contact
	public String getConID() {
		return this.conID;
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
	public String getPhoneNum() {
		return this.phoneNum;
	}
	
	//method to return address for Contact
	public String getAddress() {
		return this.address;
	}
}
