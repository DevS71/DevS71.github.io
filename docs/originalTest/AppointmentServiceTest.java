package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment_Service.Appointment;
import appointment_Service.AppointmentService;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Unit test to check the functionality of the AppointmentService class and interaction with Appointment class
 */

class AppointmentServiceTest {
	String goodID = "0123456789";
	String goodDate = "2022-04-28 01:00";
	String goodDesc = "Description of no more than 50 characters 01234567";
	String goodID2 = "1";
	String goodID3 = "12345";
	String goodDate2 = "2022-04-28 01:45";
	String goodDate3 = "2022-04-28 01:30";
	String goodDesc2 = "D";
	String goodDesc3 = "Description";
	String badID = "01123456789";
	String badDate = "2021-02-14 01:00";
	String badDesc = "Description of no less than 51 characters 012345678";
	String shrtDate = "2021-02-28 01:0";
	String lngDate = "2021-02-28 01:004";
	
	//Appointment objects to use in testing
	AppointmentService service = new AppointmentService();
	Appointment appoint = new Appointment();

	@Test
	//Test for Appointment Creation with invalid ID
	void testInvalidIDAppointCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(null, goodDate, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(badID, goodDate, goodDesc);
		});
	}
	
	@Test
	//Test for Appointment Creation with duplicate ID
	void testDuplicateIDAppointCreation() {
		service.addAppoint(goodID, goodDate, goodDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, goodDate2, goodDesc2);
		});
	}
	
	@Test
	//Test for Appointment Creation with invalid date
	void testInvalidDateAppointCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, null, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, badDate, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, shrtDate, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, lngDate, goodDesc);
		});
	}
	
	@Test
	//Test for Appointment Creation with invalid description
	void testInvalidDescAppointCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, goodDate, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppoint(goodID, goodDate, badDesc);
		});
	}
	
	@Test
	//Test for Appointment Removal from list
	void testAppointRemval() {
		service.addAppoint(goodID, goodDate, goodDesc);
		service.addAppoint(goodID2, goodDate2, goodDesc2);
		service.removeAppoint(goodID);
		//check second appointment remains
		int index = service.findAppoint(goodID2);
		assertTrue(index >= 0);
		appoint = service.appointList.get(index);
		assertTrue(appoint.getAppointID().equals(goodID2));
		assertTrue(appoint.getAppointDate().equals(goodDate2));
		assertTrue(appoint.getAppointDesc().equals(goodDesc2));
		//check first appointment is removed
		index = service.findAppoint(goodID);
		assertTrue(index == -1);
	}
	
	@Test
	//Test removing appointment with an ID that does not exist
	void testAppointRemovalInvalidID() {
		service.addAppoint(goodID, goodDate, goodDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.removeAppoint(goodID2);
		});
	}
	
	@Test
	//Test appointment creation
	void testAppointmentCreation() {
		service.addAppoint(goodID, goodDate, goodDesc);
		//find appointment location in list
		int index = service.findAppoint(goodID);
		//retrieve appointment
		appoint = service.appointList.get(index);
		//verify appointment
		assertTrue(appoint.getAppointDate().equals(goodDate));
		assertTrue(appoint.getAppointDesc().equals(goodDesc));
		assertTrue(appoint.getAppointID().equals(goodID));
	}
	
	@Test
	//Test Multiple appointment creation
	void testMultipleAppointCreation() {
		service.addAppoint(goodID, goodDate, goodDesc);
		service.addAppoint(goodID2, goodDate2, goodDesc2);
		service.addAppoint(goodID3, goodDate3, goodDesc3);
		//verify first appointment
		int index = service.findAppoint(goodID);
		appoint = service.appointList.get(index);
		assertTrue(appoint.getAppointDate().equals(goodDate));
		assertTrue(appoint.getAppointDesc().equals(goodDesc));
		//verify second appointment
		index = service.findAppoint(goodID2);
		appoint = service.appointList.get(index);
		assertTrue(appoint.getAppointDate().equals(goodDate2));
		assertTrue(appoint.getAppointDesc().equals(goodDesc2));
		//verify third appointment
		index = service.findAppoint(goodID3);
		appoint = service.appointList.get(index);
		assertTrue(appoint.getAppointDate().equals(goodDate3));
		assertTrue(appoint.getAppointDesc().equals(goodDesc3));
	}

}

