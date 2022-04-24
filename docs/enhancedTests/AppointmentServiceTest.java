package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointments.Appointment;
import appointments.AppointmentService;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Unit test to check the functionality of the AppointmentService class and interaction with Appointment class
 * 
 * 				To use this class run it as a Junit test. This will test the methods of the AppointmentService class with
 * 					good and bad values to ensure proper operation. When run any variable with a good date value should be 
 * 					in the future as past dates will cause a fault.
 * 
 * 				testInvalidIDAppointCreation() verifies that an appointment will not be created with an invalid ID value.
 * 
 * 				testDuplicateIDAppointCreation() verifies that an appointment will not be created with an ID value that already
 * 					exists in the list.
 * 
 * 				testInvalidDateAppointCreation() verifies that an appointment will not be created with an invalid date, this
 * 					includes in the past.
 * 
 * 				testInvalidDescAppointCreation() verifies that an appointment will not be created with an invalid description value.
 * 
 * 				testAppointRemval() verifies removal of an appointment matching the ID value and that other appointments remain
 * 					in the list.
 * 
 * 				testAppointRemovalInvalidID() verifies that using an invalid ID, or one that doesn't exist, won't remove an 
 * 					appointment from the list.
 * 
 * 				testAppointmentCreation() verifies that using good values will create and add an appointment to the list.
 * 
 * 				testMultipleAppointCreation() verifies that multiple appointments are created and added to list with good values.
 * 
 * Enhanced 03/31/2022 for CS-499
 */

class AppointmentServiceTest {
	//Values to use during testing.
	String goodID = "0123456789";
	String goodDate = "2022-06-28 01:00";//Good dates must be in the future
	String goodDescription = "Description of no more than 50 characters 01234567";
	String goodID2 = "1";
	String goodID3 = "12345";
	String goodDate2 = "2022-07-28 01:45";//Good dates must be in the future
	String goodDate3 = "2022-08-28 01:30";//Good dates must be in the future
	String goodDescription2 = "D";
	String goodDescription3 = "Description";
	String badID = "01123456789";
	String badDate = "2021-02-14 01:00";
	String badDescription = "Description of no less than 51 characters 012345678";
	String shrtDate = "2021-02-28 01:0";
	String lngDate = "2021-02-28 01:004";
	
	//Appointment objects to use in testing.
	AppointmentService appointmentService = new AppointmentService();
	Appointment appointment = new Appointment();

	@Test
	//Test for Appointment Creation with invalid ID.
	void testInvalidIDAppointCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(null, goodDate, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(badID, goodDate, goodDescription);
		});
	}
	
	@Test
	//Test for Appointment Creation with duplicate ID.
	void testDuplicateIDAppointCreation() {
		appointmentService.addAppointment(goodID, goodDate, goodDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, goodDate2, goodDescription2);
		});
	}
	
	@Test
	//Test for Appointment Creation with invalid date.
	void testInvalidDateAppointCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, null, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, badDate, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, shrtDate, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, lngDate, goodDescription);
		});
	}
	
	@Test
	//Test for Appointment Creation with invalid description.
	void testInvalidDescAppointCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, goodDate, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(goodID, goodDate, badDescription);
		});
	}
	
	@Test
	//Test for Appointment Removal from list.
	void testAppointRemval() {
		appointmentService.addAppointment(goodID, goodDate, goodDescription);
		appointmentService.addAppointment(goodID2, goodDate2, goodDescription2);
		appointmentService.removeAppointment(goodID);
		//check second appointment remains
		int index = appointmentService.findAppointment(goodID2);
		assertTrue(index >= 0);
		appointment = appointmentService.appointmentList.get(index);
		assertTrue(appointment.getAppointmentID().equals(goodID2));
		assertTrue(appointment.getAppointmentDate().equals(goodDate2));
		assertTrue(appointment.getAppointmentDescription().equals(goodDescription2));
		//check first appointment is removed.
		index = appointmentService.findAppointment(goodID);
		assertTrue(index == -1);
	}
	
	@Test
	//Test removing appointment with an ID that does not exist.
	void testAppointRemovalInvalidID() {
		appointmentService.addAppointment(goodID, goodDate, goodDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.removeAppointment(goodID2);
		});
	}
	
	@Test
	//Test appointment creation.
	void testAppointmentCreation() {
		appointmentService.addAppointment(goodID, goodDate, goodDescription);
		//find appointment location in list.
		int index = appointmentService.findAppointment(goodID);
		//retrieve appointment.
		appointment = appointmentService.appointmentList.get(index);
		//verify appointment.
		assertTrue(appointment.getAppointmentDate().equals(goodDate));
		assertTrue(appointment.getAppointmentDescription().equals(goodDescription));
		assertTrue(appointment.getAppointmentID().equals(goodID));
	}
	
	@Test
	//Test Multiple appointment creation.
	void testMultipleAppointCreation() {
		appointmentService.addAppointment(goodID, goodDate, goodDescription);
		appointmentService.addAppointment(goodID2, goodDate2, goodDescription2);
		appointmentService.addAppointment(goodID3, goodDate3, goodDescription3);
		//verify first appointment.
		int index = appointmentService.findAppointment(goodID);
		appointment = appointmentService.appointmentList.get(index);
		assertTrue(appointment.getAppointmentDate().equals(goodDate));
		assertTrue(appointment.getAppointmentDescription().equals(goodDescription));
		//verify second appointment.
		index = appointmentService.findAppointment(goodID2);
		appointment = appointmentService.appointmentList.get(index);
		assertTrue(appointment.getAppointmentDate().equals(goodDate2));
		assertTrue(appointment.getAppointmentDescription().equals(goodDescription2));
		//verify third appointment.
		index = appointmentService.findAppointment(goodID3);
		appointment = appointmentService.appointmentList.get(index);
		assertTrue(appointment.getAppointmentDate().equals(goodDate3));
		assertTrue(appointment.getAppointmentDescription().equals(goodDescription3));
	}

}
