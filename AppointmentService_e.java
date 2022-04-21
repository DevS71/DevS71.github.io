package appointments;

import java.util.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage memory storage structure for Appointment objects. Sores Appointment objects in a
 * 				Linked List. Using this class, programmers can add an appointment, find an appointment, remove an appointment
 * 				display an appointment, and display the list.
 * 
 * 				To access this class, create an instance of the class "appointmentService"
 * 				
 * 				To add an appointment to the list, call appointmentService.addAppointment(String, String, String) and pass a String for the ID, a Date object 
 * 					for the date, and a String for the description.
 * 
 * 				To find an appointment in the list, call appointmentServic.findAppointment(String) and pass a String with the ID of the appointment.
 * 
 * 				To remove an appointment from the list, call appointmentService.removeAppointment(String) and pass a String with the ID of the appointment.
 * 
 * 				To display an appointment, call appointmentService.Appointment(String) and pass a String with the ID of the appointment.
 * 
 * 				To display the contents of the list, call appointmentService.displayList(). This takes no arguments and outputs each appointment
 * 					in the list to the display.
 * 
 * Enhanced on 3/28/2022 for CS-499
 */

public class AppointmentService {
	//Structure to store Appointment objects in memory
	public LinkedList<Appointment> appointmentList = new LinkedList<Appointment>();
	
	//method to add Appointment to appointList
	public void addAppointment(String ID, String date, String desc) {
		//integer to check for duplicate IDs, if found integer will reset to appointments index.
		int duplicateCheck = -1;
		//Appointment object to add to appointList
		Appointment appointment = new Appointment();
		
		//check appointList for duplicate ID, fault if found (value other than -1) or create new appointment if not.
		duplicateCheck = findAppointment(ID);
		if (duplicateCheck == -1) {
			appointment.createAppoint(ID, date, desc);
			appointmentList.add(appointment);
		} else {
			throw new IllegalArgumentException("Invalid ID, ID already exists");
		}
	}
	
	//method to find Appointment in appointList
	public int findAppointment(String ID) {
		//integer to store Appointment location in appointmentList
		int appointmentIndex = -1;
		//Appointment object used to compare to ID for match
		Appointment appointment = new Appointment();
		
		//Loop to look through appointList
		for (int i = 0; i < appointmentList.size(); ++i) {
			//set Appointment object to object at current location in appointmentList for comparison.
			appointment = appointmentList.get(i);
			//check ID against Appointment objects ID field, break out of loop and save location if match is found.
			if (ID.equals(appointment.getAppointmentID())) {
				appointmentIndex = i;
				break;
			}
		}
		//index returned will have a value of -1 if Appointment not found, or index location of object if found
		return appointmentIndex;
	}
	
	//method for removing an Appointment from appointList
	public void removeAppointment(String ID) {
		//integer value to find Appointment in appointmentList
		int appointmentIndex = -1;
		
		//find Appointment in appointList
		appointmentIndex = findAppointment(ID);
		
		//check if Appointment was found, fault if not found or delete if found.
		if (appointmentIndex == -1) {
			throw new IllegalArgumentException("Invalid ID, ID does not exist");
		} else {
			appointmentList.remove(appointmentIndex);
		}
	}
	
	//Method for displaying entire list.
	public void displayList() {
		//Loop to cycle through list and display appointments on screen.
		for(int i = 0; i < appointmentList.size(); ++i) {
			displayAppointment(appointmentList.get(i).getAppointmentID());
		}
		//Output message for empty list
		if(appointmentList.size() < 1) {
			System.out.println("No appointments available.");
			System.out.println();
		}
	}
	
	//Method for displaying a single appointment.
	public void displayAppointment(String ID) {
		//Appointment object to use for holding appointment.
		Appointment appointment = new Appointment();
		//Integer variable used to hold appointments location in list.
		int appointmentIndex = -1;
		//Method call to locate appointment in list.
		appointmentIndex = findAppointment(ID);
		//Check if found (value equal to or greater than zero), display appointment if found, error message if not.
		if(appointmentIndex >= 0) {
			appointment = appointmentList.get(appointmentIndex);
			System.out.println("Appointment ID: " + appointment.getAppointmentID());
			System.out.println("Appointment Date: " + appointment.getAppointmentDate());
			System.out.println("Appointment Description: " + appointment.getAppointmentDescription());
			System.out.println();
		} else {
			System.out.println("Invalid ID, or appointment does not exist");
			System.out.println();
		}
	}
	
}