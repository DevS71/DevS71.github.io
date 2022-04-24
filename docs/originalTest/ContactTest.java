package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Test case for the Contact class
 */

class ContactTest {
	//Variables to use for input
	String goodID = "0123456789";
	String goodFName = "DevinDevin";
	String goodLName = "Schmidt123";
	String goodPhNum = "0123456789";
	String goodAdd = "Address that is 30 characters0";
	String longID = "01123456789";
	String nullID = null;
	String longFName = "DevinDevin0";
	String nullFName = null;
	String longLName = "Schmidt1234";
	String nullLName = null;
	String shrtPhNum = "012345678";
	String longPhNum = "01123456789";
	String nullPhNum = null;
	String longAdd = "Address that is 31 characters01";
	String nullAdd = null;
	//Contact object to use in tests
	Contact contact = new Contact();
	
	@Test
	//method to test contact creation with bad ID Values
	void testBadIDContactCreation() {
		//Contact contact = new Contact();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(longID, goodFName, goodLName, goodPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(nullID, goodFName, goodLName, goodPhNum, goodAdd);
		});
		/*contact.createContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		assertTrue(contact.getConID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFName));
		assertTrue(contact.getLastName().equals(goodLName));
		assertTrue(contact.getPhoneNum().equals(goodPhNum));
		assertTrue(contact.getAddress().equals(goodAdd));*/
		
	}
	
	@Test
	//method to test contact creation with bad First Name Values
	void testBadFNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, longFName, goodLName, goodPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, nullFName, goodLName, goodPhNum, goodAdd);
		});
		/*contact.createContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		assertTrue(contact.getConID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFName));
		assertTrue(contact.getLastName().equals(goodLName));
		assertTrue(contact.getPhoneNum().equals(goodPhNum));
		assertTrue(contact.getAddress().equals(goodAdd));*/
		
	}
	
	@Test
	//method to test contact creation with bad last name values
	void testBadLNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFName, longLName, goodPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFName, nullLName, goodPhNum, goodAdd);
		});
		/*contact.createContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		assertTrue(contact.getConID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFName));
		assertTrue(contact.getLastName().equals(goodLName));
		assertTrue(contact.getPhoneNum().equals(goodPhNum));
		assertTrue(contact.getAddress().equals(goodAdd));*/
	}
	
	@Test
	//method to test contact creation with bad phone number values
	void testBadPhNumContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFName, goodLName, longPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFName, goodLName, nullPhNum, goodAdd);
		});
		/*contact.createContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		assertTrue(contact.getConID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFName));
		assertTrue(contact.getLastName().equals(goodLName));
		assertTrue(contact.getPhoneNum().equals(goodPhNum));
		assertTrue(contact.getAddress().equals(goodAdd));*/
	}
	
	@Test
	//method to test contact creation with bad address values
	void testBadAddressContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFName, goodLName, goodPhNum, longAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFName, goodLName, goodPhNum, nullAdd);
		});
		/*contact.createContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		assertTrue(contact.getConID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFName));
		assertTrue(contact.getLastName().equals(goodLName));
		assertTrue(contact.getPhoneNum().equals(goodPhNum));
		assertTrue(contact.getAddress().equals(goodAdd));*/
	}

	@Test
	//method to test contact creation with good values
	void testCreateContact() {
		//Contact contact = new Contact();
		contact.createContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		assertTrue(contact.getConID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFName));
		assertTrue(contact.getLastName().equals(goodLName));
		assertTrue(contact.getPhoneNum().equals(goodPhNum));
		assertTrue(contact.getAddress().equals(goodAdd));
		
	}

}
