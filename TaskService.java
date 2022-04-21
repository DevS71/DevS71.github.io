package taskService;

import java.util.*;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage the structure to store Task objects in memory
 */

public class TaskService {
	//structure to stor Task objects
	LinkedList<Task> taskList = new LinkedList<Task>();
	
	//method to add Task to taskList
	public void addTask(String ID, String name, String desc) {
		//integer for searching taskList
		int index = -1;
		//Task object to create
		Task task = new Task();
		
		//search taskList for duplicate ID
		index = findTask(ID);
		//if not found index will have a value of -1
		if (index == -1) {
			//create and add Task
			task.createTask(ID, name, desc);
			taskList.add(task);
		} else {
			//fault for duplicate ID
			throw new IllegalArgumentException("Invalid ID, ID already in use");
		}
	}
	
	//method for finding a Task in taskList
	public int findTask(String ID) {
		//integer to hold the index of found Task and return
		int index = -1;
		//Task object for comparison during search
		Task task = new Task();
		
		//Loop to search List
		for (int i = 0; i < taskList.size(); ++i) {
			//set Task object to current index
			task = taskList.get(i);
			//Check for match with ID
			if (ID.equals(task.getTaskID())) {
				//set index to i and break out of loop
				index = i;
				break;
			}
		}
		//returns a -1 if task not found or the index of task in list if found
		return index;
	}
	
	//method to retrieve Task from taskList
	public Task getTask(String ID) {
		//integer to hold index of Task in taskList
		int index = -1;
		//Task object to return
		Task task = new Task();
		
		//search for Task in taskList
		index = findTask(ID);
		//if index is -1 task not found, fault
		if (index == -1) {
			throw new IllegalArgumentException("Invalid ID, ID not found");
		} else {
			//set Task object to task at index location
			task = taskList.get(index);
		}
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
		task.setTaskDesc(desc);
	}
	
	//method for removing Task from taskList
	public void removeTask(String ID) {
		//integer to hold index of task to remove
		int index = -1;
		
		//find Task in taskList
		index = findTask(ID);
		
		//if Task not found index = -1, fault
		if (index == -1) {
			throw new IllegalArgumentException("Invalid ID, ID not found");
		} else {
			//if task found remove from list
			taskList.remove(index);
		}
	}

}