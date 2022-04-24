package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contacts.Contact;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Test case for the Contact class.
 * 
 * 				To use this class run it as a Junit test. This will test all methods of the Contact class with good and 
 * 					bad values to check for proper operation.
 * 
 * 				testBadIDContactCreation() verifies that a contact is not created with an invalid ID value.
 * 
 * 				testBadFNameContactCreation() verifies that a contact is not created with an invalid firstName value.
 * 
 * 				testBadLNameContactCreation() verifies that a contact is not created with an invalid lastName value.
 * 
 * 				testBadPhNumContactCreation() verifies that a contact is not created with an invalid phoneNumber value.
 * 
 * 				testBadAddressContactCreation() verifies that a contact is not created with an invalid address value.
 * 
 * 				testCreateContact() verifies that a contact is created with good values for all variables.
 * 
 * Enhanced 03/31/2022 for CS-499
 */

class ContactTest {
	//Variables to use for input.
	String goodID = "0123456789";
	String goodFirstName = "DevinDevin";
	String goodLastName = "Schmidt123";
	String goodPhoneNumber = "0123456789";
	String goodAddress = "Address that is 30 characters0";
	String longID = "01123456789";
	String nullID = null;
	String longFirstName = "DevinDevin0";
	String nullFirstName = null;
	String longLastName = "Schmidt1234";
	String nullLastName = null;
	String shortPhoneNumber = "012345678";
	String longPhoneNumber = "01123456789";
	String nullPhoneNumber = null;
	String longAddress = "Address that is 31 characters01";
	String nullAddress = null;
	//Contact object to use in tests
	Contact contact = new Contact();
	
	@Test
	//method to test contact creation with bad ID Values.
	void testBadIDContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(longID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(nullID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});	
	}
	
	@Test
	//method to test contact creation with bad First Name Values.
	void testBadFNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, longFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, nullFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});	
	}
	
	@Test
	//method to test contact creation with bad last name values.
	void testBadLNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFirstName, longLastName, goodPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFirstName, nullLastName, goodPhoneNumber, goodAddress);
		});
	}
	
	@Test
	//method to test contact creation with bad phone number values.
	void testBadPhNumContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFirstName, goodLastName, longPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFirstName, goodLastName, nullPhoneNumber, goodAddress);
		});
	}
	
	@Test
	//method to test contact creation with bad address values.
	void testBadAddressContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, longAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.createContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, nullAddress);
		});
	}

	@Test
	//method to test contact creation with good values.
	void testCreateContact() {
		contact.createContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		assertTrue(contact.getContactID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFirstName));
		assertTrue(contact.getLastName().equals(goodLastName));
		assertTrue(contact.getPhoneNumber().equals(goodPhoneNumber));
		assertTrue(contact.getAddress().equals(goodAddress));
		
	}

}

