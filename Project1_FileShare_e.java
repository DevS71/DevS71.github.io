package project_main;

/*
 * Author: Devin Schmidt
 * 
 * Class: CS-499	Date:3/31/2022
 * 
 * Description: Class to handle reading from and saving to disk. The class uses three files: Appointments.txt, Contacts.txt,
 * 					and Tasks.txt. It will save the objects one object per line in the file named for its type with each
 * 					value separated by a '~'. 
 * 
 * 				To use this class first create an instance of Project_FileShare "fileShare"
 * 
 * 				To load user data from disk call fileShare.getFile(AppointmentService, ContactService, TaskService). This
 * 					command will look for each of the three files and load them into the Linked List of the appropriate
 * 					service if the file exists and has data.
 * 
 * 				To save user data to disk call fileShare.saveFile(AppointmentService, ContactService, TaskService). This
 * 					command will take objects one at a time from the Linked Lists and write them to the appropriate file
 * 					one line at a time.
 * 
 */

import java.io.*;
import java.util.Scanner;

import appointments.AppointmentService;
import appointments.Appointment;
import contacts.ContactService;
import contacts.Contact;
import tasks.TaskService;
import tasks.Task;

public class Project_FileShare {
	
	//Method to retrieve data from the file source.
	public void getFile(AppointmentService appointment, ContactService contact, TaskService task) {
		//File variables for the three files to retrieve data from, one for each service.
		File appointmentFile = new File("Appointments.txt");
		File contactFile = new File("Contacts.txt");
		File taskFile = new File("Tasks.txt");
		
		//Check if the appointmentFile exists, if it does then read the contents into the appointmentList.
		if(appointmentFile.exists()) {
			//Using a try/catch block for i/o exceptions.
			try {
				//Scanner object to read file contents.
				Scanner appointmentScan = new Scanner(appointmentFile);
				//String to hold one line of data.
				String appointmentData;
				//Loop to read each line until the end of the file.
				while(appointmentScan.hasNextLine()) {
					appointmentData = appointmentScan.nextLine();
					//Split each string into the separate elements and store in an array.
					String nodeData[] = appointmentData.split("~");
					//Add the values in the array as an Appointment object.
					appointment.addAppointment(nodeData[0], nodeData[1], nodeData[2]);
				}
				appointmentScan.close();
			} catch (Exception e) {
				System.out.println("Error parsing appointment file");
			}
			
			
		}
		
		//Check if contactFile exists and read contents into contactList if it does.
		if(contactFile.exists()) {
			//Using a try/catch block to handle any exceptions that happen, such as failing to open file.
			try {
				//Scanner object to read file contents.
				Scanner contactScan = new Scanner(contactFile);
				//String to hold each line of data.
				String contactData;
				//Loop to read each line of file until the end.
				while(contactScan.hasNextLine()) {
					contactData = contactScan.nextLine();
					//Split the string into the contact fields and store in an array.
					String nodeData[] = contactData.split("~");
					//Add the values in the array as a contact object to the contactList.
					contact.addContact(nodeData[0], nodeData[1], nodeData[2], nodeData[3], nodeData[4]);
					
				}
				contactScan.close();
			} catch (Exception e) {
				System.out.println("Error parsing contacts file");
			}
			
		}
		
		//Check if taskFile exists and read contents into taskList if it does.
		if(taskFile.exists()) {
			//Using try/catch block to handle I/O exceptions.
			try {
				//Scanner object for reading file.
				Scanner taskScan = new Scanner(taskFile);
				//String to hold each line of data.
				String taskData;
				//Loop to read each line of file to the end.
				while(taskScan.hasNextLine()) {
					taskData = taskScan.nextLine();
					//Split string into an array as field components.
					String nodeData[] = taskData.split("~");
					//Add the array as a task object to the taskList.
					task.addTask(nodeData[0], nodeData[1], nodeData[2]);
					
				}
				taskScan.close();
			} catch (Exception e) {
				System.out.println("Error parsing tasks file");
			}
			
		}
		
	}
	
	//Method to save the three lists to disk as files. Creats the files if they do not exist.
	public void saveFile(AppointmentService appointment, ContactService contact, TaskService task) {
		//File objects to use for each list.
		File appointmentFile = new File("Appointments.txt");
		File contactFile = new File("Contacts.txt");
		File taskFile = new File("Tasks.txt");
		
		//Appointment/contact/task nodes to hold data from lists until it is stored on disk.
		Appointment appointmentNode = new Appointment();
		Contact contactNode = new Contact();
		Task taskNode = new Task();
		//Try/catch block to handle I/O exceptions.
		try {
			//PrintWriter object to write data to file.
			PrintWriter appointmentWriter = new PrintWriter(new FileOutputStream(appointmentFile, false));
			//Check if list contains data.
			if(appointment.appointmentList.size() > 0) {
				//Loop through list till the end and write data to file.
				for(int i = 0; i < appointment.appointmentList.size(); ++i) {
					appointmentNode = appointment.appointmentList.get(i);
					//Insert separators and write line.
					appointmentWriter.println(appointmentNode.getAppointmentID() + "~" + appointmentNode.getAppointmentDate() + "~" + appointmentNode.getAppointmentDescription());
				}
			}
			
			appointmentWriter.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error writing to appointments file.");
			System.out.println();
		}
		
		//Try/catch block to handle I/O exceptions.
		try {
			//PrintWriter object to write data to file.
			PrintWriter contactWriter = new PrintWriter(new FileOutputStream(contactFile, false));
			//Check if list contains data.
			if(contact.contactList.size() > 0) {
				//Loop through list till the end and write data to file.
				for(int i = 0; i < contact.contactList.size(); ++i) {
					contactNode = contact.contactList.get(i);
					//Insert separators and write line.
					contactWriter.println(contactNode.getContactID() + "~" + contactNode.getFirstName() + "~" + contactNode.getLastName() + "~" + contactNode.getPhoneNumber() + "~" + contactNode.getAddress());
				}
			}
			
			contactWriter.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error writing to contacts file.");
			System.out.println();
		}
		
		//Try/catch block to handle I/O exceptions.
		try {
			//PrintWriter object to write data to file.
			PrintWriter taskWriter = new PrintWriter(new FileOutputStream(taskFile, false));
			//Check if list contains data.
			if(task.taskList.size() > 0) {
				//Loop through list till the end and write data to file.
				for(int i = 0; i < task.taskList.size(); ++i) {
					taskNode = task.taskList.get(i);
					//Insert separators and write line.
					taskWriter.println(taskNode.getTaskID() + "~" + taskNode.getTaskName() + "~" + taskNode.getTaskDescription());
				}
			}
			
			taskWriter.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error writing to tasks file.");
			System.out.println();
		}
		
	}

}
