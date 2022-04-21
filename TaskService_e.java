package tasks;

import java.util.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage a Linked List of Task objects in memory. Developers can add a task, find a task, 
 * 					get a task, rename a task, change the task description, remove a task, display a task, 
 * 					and display the contents of the list.
 * 
 * 				To use this class create an instance ot the Task Service "taskService".
 * 
 * 				To add a task to the list call taskService.addTask(String, String, String) and pass a 
 * 					String for the ID (cannot be null or longer than 10 characters, must be unique to the list),
 * 					String for the task name (cannot be null or longer than 20 characters),
 * 					String for the task description (cannot be null or longer than 50 characters).
 * 
 * 				To find a task in the list call taskService.findTask(String) and pass a String for the ID. This method returns
 * 					an integer that represents the index of the task in the Linked List.
 * 
 * 				To retrieve a task from the list call taskService.getTask(String) and pass a String for the ID. This method
 * 					returns the task object that matches the task ID from the Linked List.
 * 
 * 				To change the name of the task call taskService.updateTaskName(String, String) and pass a String for the ID and
 * 					a String for the new name.
 * 
 * 				To change the description for a task call taskService.updateTaskDesc(String, String) and pass a String for the ID
 * 					and a String for the new description.
 * 
 * 				To remove a task from the list call taskService.removeTask(String) and pass in the ID for the task to remove.
 * 	
 * 				To display the contents of the list to the screen call taskService.displayList().
 * 
 * 				To display a single task on the screen call taskService.displayTask(String) and pass a String with the task ID.
 * 
 * Enhanced on 3/29/2022
 */

public class TaskService {
	//structure to store Task objects.
	public LinkedList<Task> taskList = new LinkedList<Task>();
	
	//method to add Task to taskList
	public void addTask(String ID, String name, String desc) {
		//integer for searching taskList
		int taskIndex = -1;
		//Task object to create
		Task task = new Task();
		
		//search taskList for duplicate ID, if not found create task or if found fault.
		taskIndex = findTask(ID);
		//If not found taskIndex will have a value of -1
		if (taskIndex == -1) {
			task.createTask(ID, name, desc);
			taskList.add(task);
		} else {
			throw new IllegalArgumentException("Invalid ID, ID already in use");
		}
	}
	
	//method for finding a Task in taskList
	public int findTask(String ID) {
		//integer to hold the index of found Task and return
		int taskIndex = -1;
		//Task object for comparison during search
		Task task = new Task();
		
		//Loop to search List for task
		for (int i = 0; i < taskList.size(); ++i) {
			//set Task object to current index
			task = taskList.get(i);
			//Check for match with ID, if found set taskIndex to index of task and break loop.
			if (ID.equals(task.getTaskID())) {
				taskIndex = i;
				break;
			}
		}
		//returns a -1 if task not found or the index of task in list if found
		return taskIndex;
	}
	
	//method to retrieve Task from taskList
	public Task getTask(String ID) {
		//integer to hold index of Task in taskList
		int taskIndex = -1;
		//Task object to return
		Task task = new Task();
		
		//search for Task in taskList
		taskIndex = findTask(ID);
		//if taskIndex is -1 task not found fault, if found get task at taskIndex value.
		if (taskIndex == -1) {
			throw new IllegalArgumentException("Invalid ID, ID not found");
		} else {
			task = taskList.get(taskIndex);
		}
		//Return task if found or empty task if none found.
		return task;
	}
	
	//method for updating task name
	public void updateTaskName(String ID, String name) {
		//Task object to hold task to be updated
		Task task = new Task();
		
		//retrieve task from list
		task = getTask(ID);
		
		//update taskName field
		task.setTaskName(name);
	}
	
	//method for updating task description
	public void updateTaskDesc(String ID, String desc) {
		//Task object to be updated
		Task task = new Task();
		
		//retrieve task from taskList
		task = getTask(ID);
		
		//update taskDesc field
		task.setTaskDescription(desc);
	}
	
	//method for removing Task from taskList
	public void removeTask(String ID) {
		//integer to hold index of task to remove
		int index = -1;
		
		//find Task in taskList
		index = findTask(ID);
		
		//if Task not found index = -1 fault, if found remove task from list.
		if (index == -1) {
			throw new IllegalArgumentException("Invalid ID, ID not found");
		} else {
			taskList.remove(index);
		}
	}
	
	//Method to display entire taskList
	public void displayList() {
		//Loop to cycle through taskList and display values of each task.
		for(int i = 0; i < taskList.size(); ++i) {
			displayTask(taskList.get(i).getTaskID());
		}
		//Output message for empty list
		if(taskList.size() < 1) {
			System.out.println("No tasks available.");
			System.out.println();
		}
	}
	
	//Method for displaying single task.
	public void displayTask(String ID) {
		//Integer variable to store index value of task in list if found.
		int findNode = -1;
		//Task object to hold requested task.
		Task task = new Task();
		//Call method to search taskList for task.
		findNode = findTask(ID);
		//Check if task is found (value of zero or greater in findNode) and display, or error message if not found.
		if(findNode >= 0) {
			task = taskList.get(findNode);
			System.out.println("Task ID: " + task.getTaskID());
			System.out.println("Task Name: " + task.getTaskName());
			System.out.println("Task Description: " + task.getTaskDescription());
			System.out.println();
		} else {
			System.out.println("Invalid ID or task does not exist.");
			System.out.println();
		}
	}
}
