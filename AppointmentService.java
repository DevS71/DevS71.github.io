package appointment_Service;

import java.util.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage memory storage structure for Appointment objects
 */

public class AppointmentService {
	//Structure to store Appointment objects in memory
	public LinkedList<Appointment> appointList = new LinkedList<Appointment>();
	
	//method to add Appointment to appointList
	public void addAppoint(String ID, String date, String desc) {
		//integer to check for duplicate IDs
		int index = -1;
		//Appointment object to add to appointList
		Appointment appoint = new Appointment();
		
		//check appointList for duplicate ID
		index = findAppoint(ID);
		//check that ID was not found in list, index will have a value of -1 if not found
		if (index == -1) {
			//ID not found, create and add appointment
			appoint.createAppoint(ID, date, desc);
			appointList.add(appoint);
		} else {
			//ID duplicated, fault
			throw new IllegalArgumentException("Invalid ID, ID already exists");
		}
	}
	
	//method to find Appointment in appointList
	public int findAppoint(String ID) {
		//integer to store Appointment location in appointList
		int index = -1;
		//Appointment object used to compare to ID for match
		Appointment appoint = new Appointment();
		
		//Loop to look through appointList
		for (int i = 0; i < appointList.size(); ++i) {
			//set Appointment object to object at current location in appointList
			appoint = appointList.get(i);
			//check ID against Appointment objects ID field
			if (ID.equals(appoint.getAppointID())) {
				//if matched set index and break out of loop
				index = i;
				break;
			}
		}
		//index returned will have a value of -1 if Appointment not found, location of object if found
		return index;
	}
	
	//method for removing an Appointment from appointList
	public void removeAppoint(String ID) {
		//integer value to find Appointment in appointList
		int index = -1;
		
		//find Appointment in appointList
		index = findAppoint(ID);
		
		//check if Appointment was found, index will have a -1 value if not in list
		if (index == -1) {
			//not found fault
			throw new IllegalArgumentException("Invalid ID, ID does not exist");
		} else {
			//Appointment found, remove from appointList
			appointList.remove(index);
		}
	}
	
}
