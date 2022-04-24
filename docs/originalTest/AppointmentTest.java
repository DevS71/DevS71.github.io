package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment_Service.Appointment;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Unit test for testing the functionality of the Appointment class
 */

class AppointmentTest {
	//Variables to use for testing
	String goodID = "0123456789";
	String goodDate = "2022-04-28 01:00";
	String goodDesc = "Description of no more than 50 characters 01234567";
	String badID = "01123456789";
	String badDate = "2021-02-14 01:00";
	String badDesc = "Description of no less than 51 characters 012345678";
	String shrtDate = "2021-02-28 01:0";
	String lngDate = "2021-02-28 01:004";
	
	//Appointment object to use in testing
	Appointment appoint = new Appointment();

	@Test
	//Test of Appointment creation with invalid ID
	void testInvalidIDAppCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(null, goodDate, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(badID, goodDate, goodDesc);
		});
	}
	
	@Test
	//Test of Appointment Creation with invalid date
	void testInvalidDateAppCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(goodID, null, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(goodID, badDate, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(goodID, shrtDate, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(goodID, lngDate, goodDesc);
		});
	}
	
	@Test
	//Test of Appointment Creation with invalid description
	void testInvalidDescAppCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(goodID, goodDate, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appoint.createAppoint(goodID, goodDate, badDesc);
		});
	}
	
	@Test
	//Test of valid Task Creation
	void testValidTaskCreation() {
		appoint.createAppoint(goodID, goodDate, goodDesc);
		assertTrue(appoint.getAppointID().equals(goodID));
		assertTrue(appoint.getAppointDate().equals(goodDate));
		assertTrue(appoint.getAppointDesc().equals(goodDesc));
	}

}
