package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Unit test for the Contact Service Class functionality and interaction with Contact class
 */

class ContactServiceTest {
	//Variables to use for input
		String goodID = "0123456789";
		String goodFName = "DevinDevin";
		String goodLName = "Schmidt123";
		String goodPhNum = "0123456789";
		String goodAdd = "Address that is 30 characters0";
		String goodID2 = "1";
		String goodID3 = "12345";
		String goodFName2 = "D";
		String goodFName3 = "Devin";
		String goodLName2 = "S";
		String goodLName3 = "Schmi";
		String goodPhNum2 = "9876543210";
		String goodPhNum3 = "4567891230";
		String goodAdd2 = "2";
		String goodAdd3 = "123456";
		String longID = "01123456789";
		String longFName = "DevinDevin0";
		String longLName = "Schmidt1234";
		String shrtPhNum = "012345678";
		String longPhNum = "01123456789";
		String longAdd = "Address that is 31 characters01";
		
		//ContactServie object to use in testing
		ContactService contact = new ContactService();
		Contact con = new Contact();

	@Test
	//Test Creation with InvalidID
	void testInvalidIDContactCreate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(null, goodFName, goodLName, goodPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(longID, goodFName, goodLName, goodPhNum, goodAdd);
		});
	}
	
	@Test
	//Test Creation with Invalid First Name
	void testInvalidFNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, null, goodLName, goodPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, longFName, goodLName, goodPhNum, goodAdd);
		});
	}
	
	@Test
	//Test Creation with Invalid Last Name
	void testInvalidLNameContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, null, goodPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, longLName, goodPhNum, goodAdd);
		});
	}
	
	@Test
	//Test Creation with Invalid Phone Number
	void testInvalidPhNumContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, goodLName, null, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, goodLName, shrtPhNum, goodAdd);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, goodLName, longPhNum, goodAdd);
		});
	}
	
	@Test
	//Test Creation with Invalid Address
	void testInvalidAddressContactCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, goodLName, goodPhNum, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName, goodLName, goodPhNum, longAdd);
		});
	}
	
	@Test
	//Test for Duplicate ID Creation
	void testDuplicateIDCreation() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.addContact(goodID, goodFName2, goodLName2, goodPhNum2, goodAdd2);
		});
	}
	
	@Test
	//Test for updating First Name
	void testUpdateFirstName() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		//update first name
		contact.updateFirstName(goodID, goodFName2);
		//verify update
		con = contact.getContact(goodID);
		assertTrue(con.getFirstName().equals(goodFName2));
		assertFalse(con.getFirstName().equals(goodFName));
	}
	
	@Test
	//Test for updating Last Name
	void testUpdateLastName() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		//update last name
		contact.updateLastName(goodID, goodLName2);
		//verify update
		con = contact.getContact(goodID);
		assertTrue(con.getLastName().equals(goodLName2));
		assertFalse(con.getLastName().equals(goodLName));
	}
	
	@Test
	//Test for updating Phone Number
	void testUpdatePhNum() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		//update phone number
		contact.updatePhoneNum(goodID, goodPhNum2);
		//verify update
		con = contact.getContact(goodID);
		assertTrue(con.getPhoneNum().equals(goodPhNum2));
		assertFalse(con.getPhoneNum().equals(goodPhNum));
	}
	
	@Test
	//Test for updating Address
	void testUpdateAddress() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		contact.updateAddress(goodID, goodAdd2);
		con = contact.getContact(goodID);
		assertTrue(con.getAddress().equals(goodAdd2));
		assertFalse(con.getAddress().equals(goodAdd));
	}
	
	@Test
	//Test removal of contact from list
	void testRemoveContact() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		contact.addContact(goodID2, goodFName2, goodLName2, goodPhNum2, goodAdd2);
		contact.removeContact(goodID);
		//verify second contact is still there
		int index = contact.findContact(goodID2);
		assertTrue(index >= 0);
		//verify first contact is removed
		index = contact.findContact(goodID);
		assertTrue(index == -1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			con = contact.getContact(goodID);
		});
	}
	
	@Test
	//Test removing contact that doesn't exist
	void testRemoveContactInvalidID() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.removeContact(goodID2);
		});
	}
	
	@Test
	//Test single contact creation
	void testContactCreation() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		//verify contact
		con = contact.getContact(goodID);
		assertTrue(con.getConID().equals(goodID));
		assertTrue(con.getFirstName().equals(goodFName));
		assertTrue(con.getLastName().equals(goodLName));
		assertTrue(con.getPhoneNum().equals(goodPhNum));
		assertTrue(con.getAddress().equals(goodAdd));
	}
	
	@Test
	//Test Multiple Contact Creation
	void testMultipleContactCreation() {
		contact.addContact(goodID, goodFName, goodLName, goodPhNum, goodAdd);
		contact.addContact(goodID2, goodFName2, goodLName2, goodPhNum2, goodAdd2);
		contact.addContact(goodID3, goodFName3, goodLName3, goodPhNum3, goodAdd3);
		//verify first contact
		con = contact.getContact(goodID);
		assertTrue(con.getConID().equals(goodID));
		assertTrue(con.getFirstName().equals(goodFName));
		assertTrue(con.getLastName().equals(goodLName));
		assertTrue(con.getPhoneNum().equals(goodPhNum));
		assertTrue(con.getAddress().equals(goodAdd));
		//verify second contact
		con = contact.getContact(goodID2);
		assertTrue(con.getConID().equals(goodID2));
		assertTrue(con.getFirstName().equals(goodFName2));
		assertTrue(con.getLastName().equals(goodLName2));
		assertTrue(con.getPhoneNum().equals(goodPhNum2));
		assertTrue(con.getAddress().equals(goodAdd2));
		//verify third contact
		con = contact.getContact(goodID3);
		assertTrue(con.getConID().equals(goodID3));
		assertTrue(con.getFirstName().equals(goodFName3));
		assertTrue(con.getLastName().equals(goodLName3));
		assertTrue(con.getPhoneNum().equals(goodPhNum3));
		assertTrue(con.getAddress().equals(goodAdd3));
	}
	
	

}

