package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointments.Appointment;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Unit test for testing the functionality of the Appointment class
 * 
 * 				To use this class run it as a Junit test. This will test the methods of the Appointment class with good and bad
 * 					values to check for proper operation. Any good date values need to be in the future as past values will 
 * 					cause a fault.
 * 
 * 				testInvalidIDAppCreation() verifies that an appointment will not be created with an invalid ID value.
 * 
 * 				testInvalidDateAppCreation() verifies that an appointment will not be created with an invalid date, this
 * 					includes in the past.
 * 
 * 				testInvalidDescAppCreation() verifies that an appointment will not be created with an invalid description value.
 * 
 * 				testValidTaskCreation() verifies that an appointment will be created when valid values are passed for all variables.
 * 
 * Enhanced 03/31/2022 for CS-499
 */

class AppointmentTest {
	//Variables to use for testing.
	String goodID = "0123456789";
	String goodDate = "2022-06-28 01:00";//Good dates must be in the future
	String goodDescription = "Description of no more than 50 characters 01234567";
	String badID = "01123456789";
	String badDate = "2021-02-14 01:00";
	String badDescription = "Description of no less than 51 characters 012345678";
	String shrtDate = "2021-02-28 01:0";
	String lngDate = "2021-02-28 01:004";
	
	//Appointment object to use in testing.
	Appointment appointment = new Appointment();

	@Test
	//Test of Appointment creation with invalid ID.
	void testInvalidIDAppCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(null, goodDate, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(badID, goodDate, goodDescription);
		});
	}
	
	@Test
	//Test of Appointment Creation with invalid date.
	void testInvalidDateAppCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(goodID, null, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(goodID, badDate, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(goodID, shrtDate, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(goodID, lngDate, goodDescription);
		});
	}
	
	@Test
	//Test of Appointment Creation with invalid description.
	void testInvalidDescAppCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(goodID, goodDate, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.createAppoint(goodID, goodDate, badDescription);
		});
	}
	
	@Test
	//Test of valid Task Creation.
	void testValidTaskCreation() {
		appointment.createAppoint(goodID, goodDate, goodDescription);
		assertTrue(appointment.getAppointmentID().equals(goodID));
		assertTrue(appointment.getAppointmentDate().equals(goodDate));
		assertTrue(appointment.getAppointmentDescription().equals(goodDescription));
	}

}
