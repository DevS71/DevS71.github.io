package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contacts.Contact;
import contacts.ContactService;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Unit test for the Contact Service Class functionality and interaction with Contact class.
 * 
 * 				To use this class run it as a Junit test. This will test the functionality of all the ContactService class 
 * 					with good and bad values to check for proper operation.
 * 
 * 				testInvalidIDContactCreate() verifies that a contact is not created with an invalid ID value.
 * 
 * 				testBadFNameContactCreation() verifies that a contact is not created with an invalid firstName value.
 * 
 * 				testBadLNameContactCreation() verifies that a contact is not created with an invalid lastName value.
 * 
 * 				testBadPhNumContactCreation() verifies that a contact is not created with an invalid phoneNumber value.
 * 
 * 				testBadAddressContactCreation() verifies that a contact is not created with an invalid address value.
 * 
 * 				testDuplicateIDCreation() verifies that a contact is not created if the ID value exists in the list.
 * 
 * 				testUpdateFirstName() verifies that when a firstName is updated the new name exists and the original does not.
 * 				
 * 				testUpdateLastName() verifies that when a lastName is updated the new name exists and the original does not.
 * 
 * 				testUpdatePhNum() verifies that when a phoneNumber is updated the new phoneNumber exists and the original does not.
 * 
 * 				testUpdateAddress() verifies that when an address is updated the new address exists and the original does not.
 * 
 * 				testRemoveContact() verifies that when a contact is removed from the list it is removed and other contacts in
 * 					the list are not.
 * 
 * 				testRemoveContactInvalidID() verifies that when an invalid ID is used no contact is removed from the list.
 * 
 * 				testContactCreation() verifies that when a contact is created it is added to the list.
 * 
 * 				testMultipleContactCreation() verifies that when multiple contacts are created they are each added to the list.
 * 
 * Enhanced 3/31/2022 for CS-499
 */

class ContactServiceTest {
	//Variables to use for input.
		String goodID = "0123456789";
		String goodFirstName = "DevinDevin";
		String goodLastName = "Schmidt123";
		String goodPhoneNumber = "0123456789";
		String goodAddress = "Address that is 30 characters0";
		String goodID2 = "1";
		String goodID3 = "12345";
		String goodFirstName2 = "D";
		String goodFirstName3 = "Devin";
		String goodLastName2 = "S";
		String goodLastName3 = "Schmi";
		String goodPhoneNumber2 = "9876543210";
		String goodPhoneNumber3 = "4567891230";
		String goodAddress2 = "2";
		String goodAddress3 = "123456";
		String longID = "01123456789";
		String longFirstName = "DevinDevin0";
		String longLastName = "Schmidt1234";
		String shortPhoneNumber = "012345678";
		String longPhoneNumber = "01123456789";
		String longAddress = "Address that is 31 characters01";
		
		//ContactServie object to use in testing.
		ContactService contactService = new ContactService();
		Contact contact = new Contact();

	@Test
	//Test Creation with InvalidID.
	void testInvalidIDContactCreate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(null, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(longID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});
	}
	
	@Test
	//Test Creation with Invalid First Name.
	void testInvalidFNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, null, goodLastName, goodPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, longFirstName, goodLastName, goodPhoneNumber, goodAddress);
		});
	}
	
	@Test
	//Test Creation with Invalid Last Name.
	void testInvalidLNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, null, goodPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, longLastName, goodPhoneNumber, goodAddress);
		});
	}
	
	@Test
	//Test Creation with Invalid Phone Number.
	void testInvalidPhNumContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, goodLastName, null, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, goodLastName, shortPhoneNumber, goodAddress);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, goodLastName, longPhoneNumber, goodAddress);
		});
	}
	
	@Test
	//Test Creation with Invalid Address.
	void testInvalidAddressContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, longAddress);
		});
	}
	
	@Test
	//Test for Duplicate ID Creation.
	void testDuplicateIDCreation() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(goodID, goodFirstName2, goodLastName2, goodPhoneNumber2, goodAddress2);
		});
	}
	
	@Test
	//Test for updating First Name.
	void testUpdateFirstName() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		//update first name
		contactService.updateFirstName(goodID, goodFirstName2);
		//verify update
		contact = contactService.getContact(goodID);
		assertTrue(contact.getFirstName().equals(goodFirstName2));
		assertFalse(contact.getFirstName().equals(goodFirstName));
	}
	
	@Test
	//Test for updating Last Name.
	void testUpdateLastName() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		//update last name
		contactService.updateLastName(goodID, goodLastName2);
		//verify update
		contact = contactService.getContact(goodID);
		assertTrue(contact.getLastName().equals(goodLastName2));
		assertFalse(contact.getLastName().equals(goodLastName));
	}
	
	@Test
	//Test for updating Phone Number.
	void testUpdatePhNum() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		//update phone number
		contactService.updatePhoneNumber(goodID, goodPhoneNumber2);
		//verify update
		contact = contactService.getContact(goodID);
		assertTrue(contact.getPhoneNumber().equals(goodPhoneNumber2));
		assertFalse(contact.getPhoneNumber().equals(goodPhoneNumber));
	}
	
	@Test
	//Test for updating Address.
	void testUpdateAddress() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		contactService.updateAddress(goodID, goodAddress2);
		contact = contactService.getContact(goodID);
		assertTrue(contact.getAddress().equals(goodAddress2));
		assertFalse(contact.getAddress().equals(goodAddress));
	}
	
	@Test
	//Test removal of contact from list.
	void testRemoveContact() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		contactService.addContact(goodID2, goodFirstName2, goodLastName2, goodPhoneNumber2, goodAddress2);
		contactService.removeContact(goodID);
		//verify second contact is still there
		int index = contactService.findContact(goodID2);
		assertTrue(index >= 0);
		//verify first contact is removed
		index = contactService.findContact(goodID);
		assertTrue(index == -1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact = contactService.getContact(goodID);
		});
	}
	
	@Test
	//Test removing contact that doesn't exist.
	void testRemoveContactInvalidID() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.removeContact(goodID2);
		});
	}
	
	@Test
	//Test single contact creation.
	void testContactCreation() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		//verify contact
		contact = contactService.getContact(goodID);
		assertTrue(contact.getContactID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFirstName));
		assertTrue(contact.getLastName().equals(goodLastName));
		assertTrue(contact.getPhoneNumber().equals(goodPhoneNumber));
		assertTrue(contact.getAddress().equals(goodAddress));
	}
	
	@Test
	//Test Multiple Contact Creation.
	void testMultipleContactCreation() {
		contactService.addContact(goodID, goodFirstName, goodLastName, goodPhoneNumber, goodAddress);
		contactService.addContact(goodID2, goodFirstName2, goodLastName2, goodPhoneNumber2, goodAddress2);
		contactService.addContact(goodID3, goodFirstName3, goodLastName3, goodPhoneNumber3, goodAddress3);
		//verify first contact
		contact = contactService.getContact(goodID);
		assertTrue(contact.getContactID().equals(goodID));
		assertTrue(contact.getFirstName().equals(goodFirstName));
		assertTrue(contact.getLastName().equals(goodLastName));
		assertTrue(contact.getPhoneNumber().equals(goodPhoneNumber));
		assertTrue(contact.getAddress().equals(goodAddress));
		//verify second contact
		contact = contactService.getContact(goodID2);
		assertTrue(contact.getContactID().equals(goodID2));
		assertTrue(contact.getFirstName().equals(goodFirstName2));
		assertTrue(contact.getLastName().equals(goodLastName2));
		assertTrue(contact.getPhoneNumber().equals(goodPhoneNumber2));
		assertTrue(contact.getAddress().equals(goodAddress2));
		//verify third contact
		contact = contactService.getContact(goodID3);
		assertTrue(contact.getContactID().equals(goodID3));
		assertTrue(contact.getFirstName().equals(goodFirstName3));
		assertTrue(contact.getLastName().equals(goodLastName3));
		assertTrue(contact.getPhoneNumber().equals(goodPhoneNumber3));
		assertTrue(contact.getAddress().equals(goodAddress3));
	}

}

