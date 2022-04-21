package project_main;

/*
 * Author: Devin Schmidt
 * 
 * Class: CS-499	Date:3/31/2022
 * 
 * Description: Class to handle reading from and saving to disk
 * 
 * 				To use this class create a Project_FileShare object "fileShare"
 * 
 * 				To load the saved data into the 2D vector data structure call fileShare.loadSystem(VectorMap) and pass
 * 					a VectorMap object.
 * 
 * 				To save the current values contained in the data structure to disk call fileShare.saveFile(VectorMap) and 
 * 					pass the VectorMap object containing the values to save.
 * 
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import services.*;
import dataObjects.*;


public class Project_FileShare {
	//Method to load the file values into the 2D vector as Linked lists
	public void loadSystem(VectorMap system) {
		//File variables to use
		File userFile = new File("Users.txt");
		File appointmentFile = new File("Appointments.txt");
		File contactFile = new File("Contacts.txt");
		File taskFile = new File("Tasks.txt");
		//Check if userFile exists before reading
		if(userFile.exists()) {
			//use try/catch block for i/o errors
			try {
				//Scanner object to read file
				Scanner userScanner = new Scanner(userFile);
			
				//Loop to read through file to the end
				while(userScanner.hasNextLine()) {
					system.addUser(userScanner.nextLine());
				}
				//close scanner
				userScanner.close();
			} catch (Exception e) {
				System.out.println("Error parsing appointment file");
			}
		}
		
		//Check if the appointmentFile exists, if it does then read the contents into the appointmentList.
		if(appointmentFile.exists()) {
			//Set mode on create appointment to avoid issues loading old dates
			int mode = 2;
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
					system.addAppointment(nodeData[0], nodeData[1], nodeData[2], nodeData[3], mode);
				}
				//close scanner
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
					system.addContact(nodeData[0], nodeData[1], nodeData[2], nodeData[3], nodeData[4], nodeData[5]);
					
				}
				//close scanner
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
					system.addTask(nodeData[0], nodeData[1], nodeData[2], nodeData[3]);
					
				}
				//close scanner
				taskScan.close();
			} catch (Exception e) {
				System.out.println("Error parsing tasks file");
			}
		}
	}
	
	
	
	//Method to save the three lists to disk as files. Creats the files if they do not exist.
	public void saveFile(VectorMap system) {
		//File objects to use for each list.
		File userFile = new File("Users.txt");
		File appointmentFile = new File("Appointments.txt");
		File contactFile = new File("Contacts.txt");
		File taskFile = new File("Tasks.txt");
		
		//Appointment/contact/task nodes to hold data from lists until it is stored on disk.
		Node appointmentNode = new Node();
		Node contactNode = new Node();
		Node taskNode = new Node();
		
		//Try/catch block to handle I/O exceptions.
		try {
			//PrintWriter object to write to file
			PrintWriter userWriter = new PrintWriter(new FileOutputStream(userFile, false));
			//check if vector contains data
			if(system.users.size() > 0) {
				//Loop to traverse vector and save contents
				for(int i = 0; i < system.users.size(); ++i) {
					userWriter.println(system.users.get(i));
				}
			}
			//close PrintWriter
			userWriter.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error writing to file.");
			System.out.println();
		}
		
		//Try/catch block to handle I/O exceptions.
		try {
			//PrintWriter objects to write data to file.
			PrintWriter appointmentWriter = new PrintWriter(new FileOutputStream(appointmentFile, false));
			PrintWriter contactWriter = new PrintWriter(new FileOutputStream(contactFile, false));
			PrintWriter taskWriter = new PrintWriter(new FileOutputStream(taskFile, false));
			
			for(int i = 0; i < system.users.size(); ++i) {
				system.nodes = new LinkedList<Node>();
				system.nodes = system.owners.get(i).get(0);
				for(int j = 0; j < system.nodes.size(); ++j) {
					appointmentNode = system.nodes.get(j);
					appointmentWriter.println(appointmentNode.getNodeID() + "~" + appointmentNode.getAppointmentDate()
					+ "~" + appointmentNode.getNodeDescription() + "~" + appointmentNode.getNodeOwner());
				}
				system.nodes = new LinkedList<Node>();
				system.nodes = system.owners.get(i).get(1);
				for(int j = 0; j < system.nodes.size(); ++j) {
					contactNode = system.nodes.get(j);
					contactWriter.println(contactNode.getNodeID() + "~" + contactNode.getFirstName() + "~" 
					+ contactNode.getLastName() + "~" + contactNode.getPhoneNumber() + "~" + contactNode.getAddress() + "~" + contactNode.getNodeOwner());
				}
				system.nodes = new LinkedList<Node>();
				system.nodes = system.owners.get(i).get(2);
				for(int j = 0; j < system.nodes.size(); ++j) {
					taskNode = system.nodes.get(j);
					taskWriter.println(taskNode.getNodeID() + "~" + taskNode.getTaskName() + "~" 
					+ taskNode.getNodeDescription() + "~" + taskNode.getNodeOwner());
				}
			}
			//close PrintWriters
			appointmentWriter.close();
			contactWriter.close();
			taskWriter.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Error writing to appointments file.");
			System.out.println();
		}
	}
}
