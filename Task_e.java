package tasks;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage Task object. The class contains variables that hold values for the ID, task name,
 * 					and task description along with methods to retrieve and set the values of the variables.
 * 
 * 				To access this class use a Task object "task"
 * 
 * 				To create a task, call task.createTask(String, String, String) passing
 * 					a String for the ID (cannot be null or longer than 10 characters),
 * 					a String for the task name (cannot be null or longer than 20 characters),
 * 					a String for the task description (cannot be null or longer than 50 characters).
 * 
 * 				To set a task name call task.setTaskName(String) passing a String for the task name.
 * 
 * 				To set a task description call task.setTaskDescription(String) passing a String for the task description.
 * 
 * 				To retrieve a task ID call task.getTaskID(), this returns a String.
 * 
 * 				To retrieve a task name call task.getTaskName(), this returns a String.
 * 
 * 				To retrieve a task description call task.getTaskDescription(), this returns a String.
 * 
 * Enhanced on 03/29/2022 for CS-499
 */

public class Task {
	//Fields for Task object
	String taskID;
	String taskName;
	String taskDescription;
	
	//default constructor
	public Task() {
		taskID = null;//Must not be null or greater than 10 characters
		taskName = null;//Must not be null or greater than 20 characters
		taskDescription = null;//Must not be null or greater than 50 characters
	}
	
	//method for creating Task object.
	public Task createTask(String ID, String name, String desc) {
		//Task object to create and return
		Task task = new Task();
		
		//verify ID meets requirements, fault if it does not or create task if it does.
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		} else {
			this.taskID = ID;
			setTaskName(name);
			setTaskDescription(desc);
		}
		
		return task;
	}
	
	//method for setting/updating taskName.
	public void setTaskName(String name) {
		//verify name meets requirements, fault if it does not or set field value if it does.
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		} else {
			this.taskName = name;
		}
	}
	
	//method for setting/updating taskDescription.
	public void setTaskDescription(String desc) {
		//verify description meets requirements, fault if it does not or set field value if it does.
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		} else {
			this.taskDescription = desc;
		}
	}
	
	//method for returning taskID.
	public String getTaskID() {
		return this.taskID;
	}
	
	//method for returning taskName.
	public String getTaskName() {
		return this.taskName;
	}
	
	//method for returning taskDesc.
	public String getTaskDescription() {
		return this.taskDescription;
	}
}
