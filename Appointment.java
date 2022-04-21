package appointment_Service;

import java.util.Date;
import java.text.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class for creating and managing Appointment objects
 */

public class Appointment {
	//Fields for the Appointment object
	String appointID;
	Date appointDate; //date format is yyyy-MM-dd HH:mm
	String appointDesc;
	
	//Default constructor
	public Appointment() {
		appointID = null;
		appointDate = new Date();
		appointDesc = null;
	}
	
	//method for creating Appointment object
	public Appointment createAppoint(String ID, String date, String desc) {
		//Appointment object to create and return
		Appointment appoint = new Appointment();
		
		//check if ID meets requirements
		if (ID == null || ID.length() > 10) {
			//fault if ID out of specification
			throw new IllegalArgumentException("Invalid ID");
		} else {
			//Create Appointment
			this.appointID = ID;
			setAppointDate(date);
			setAppointDesc(desc);
		}
		return appoint;
	}
	
	//method for creating/updating appointDate
	public void setAppointDate(String strDate) {
		//object to format string into date
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//date object to hold converted string
		Date newDate = new Date();
		//date object to compare newDate with current date
		Date currDate = new Date();
		
		//check strDate isn't null and is 16 characters
		if (strDate == null || strDate.length() != 16) {
			//fault if strDate out of specifications
			throw new IllegalArgumentException("Invalid Date");
		}
		
		//Parse strDate into newDate, try/catch block to catch exceptions
		try {
			newDate = df.parse(strDate);
		} catch (ParseException e) {
			System.out.println("Date Parse Exception: " + e);
		}
		
		//check if newDate if before currDate
		if (newDate.before(currDate)) {
			//throw exception if before current date
			throw new IllegalArgumentException("Invalid Date");
		} else {
			//set appointDate
			this.appointDate = newDate;
		}
	}
	
	//method for setting appointDesc field
	public void setAppointDesc(String desc) {
		//check if desc meets requirements
		if (desc == null || desc.length() > 50) {
			//fault if desc out of specifications
			throw new IllegalArgumentException("Invalid Description");
		} else {
			//set appointDesc field
			this.appointDesc = desc;
		}
	}
	
	//method for returning appointID
	public String getAppointID() {
		return this.appointID;
	}
	
	//method for returning appointDate as a string
	public String getAppointDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm");
		String strDate = df.format(this.appointDate);
		return strDate;
	}
	
	//method for returning appointDesc
	public String getAppointDesc() {
		return this.appointDesc;
	}

}