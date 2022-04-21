package appointments;

import java.util.Date;
import java.text.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class for creating and managing Appointment objects. Contains the variables for storing the ID, date and a 
 * 				description of the appointments purpose. Uses setters and getters to access those variables and their values.
 * 
 * 				To access this class use an appointment object "appointment"
 * 
 * 				To create an appointment object, call appointment.createAppointment(String, String, String) and pass a String for the ID (must be greater than 10 characters long),
 * 					a String for the date (must be in the format of YYYY-MM-dd HH:mm and not in the past),
 * 					and a String for the description of the appointment (must not be null or longer than 50 characters)
 * 
 * 				To set the date of an existing appointment object, call appointment.setAppointmentDate(String) and pass a String for the date
 * 					(must be in the format of YYYY-MM-dd HH:mm and not be in the past)
 * 
 * 				To get the date value of an appointment object call appointment.getAppointmentDate(), this returns a String.
 * 
 * 				To set the appointment description, call appointment.setAppointmentDescription(String) and pass a String for the description (must
 * 					not be null or longer than 50 characters).
 * 
 * 				To retrieve the appointment description call appointment.getAppointmentDescription(), this returns a String.
 * 
 * 				To retrieve the appointment ID call appointment.getAppointmentID(), this returns a string.
 * 
 * Enhanced on 3/29/2022 for CS-499
 */

public class Appointment {
	//Fields for the Appointment object
	String appointmentID;//Must be unique and not greater than 10 characters
	Date appointmentDate; //date format is yyyy-MM-dd HH:mm
	String appointmentDescription;//Must not be null or greater than 50 characters
	
	//Default constructor
	public Appointment() {
		appointmentID = null;
		appointmentDate = new Date();
		appointmentDescription = null;
	}
	
	//method for creating Appointment object
	public Appointment createAppoint(String ID, String date, String desc) {
		//Appointment object to create and return
		Appointment appointment = new Appointment();
		
		//check if ID meets requirements, fault if does not or create if requirements are met.
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		} else {
			//Create Appointment
			this.appointmentID = ID;
			setAppointmentDate(date);
			setAppointmentDescription(desc);
		}
		return appointment;
	}
	
	//method for creating/updating appointDate
	public void setAppointmentDate(String strDate) {
		//object to format string into date
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//date object to hold converted string
		Date newDate = new Date();
		//date object to compare newDate with current date
		Date currDate = new Date();
		
		//check strDate isn't null and is 16 characters, fault if not met or set if conditions are met.
		if (strDate == null || strDate.length() != 16) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		//Parse strDate into newDate, try/catch block to catch exceptions
		try {
			newDate = df.parse(strDate);
		} catch (ParseException e) {
			System.out.println("Date Parse Exception: " + e);
		}
		
		//check if newDate if before currDate, fault if it is set if it is not.
		if (newDate.before(currDate)) {
			throw new IllegalArgumentException("Invalid Date");
		} else {
			this.appointmentDate = newDate;
		}
	}
	
	//method for setting appointDesc field
	public void setAppointmentDescription(String desc) {
		//check if description meets requirements, fault if it doesn't or set if it does.
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		} else {
			this.appointmentDescription = desc;
		}
	}
	
	//method for returning appointID
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	//method for returning appointDate as a string
	public String getAppointmentDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm");
		String strDate = df.format(this.appointmentDate);
		return strDate;
	}
	
	//method for returning appointDesc
	public String getAppointmentDescription() {
		return this.appointmentDescription;
	}

}
