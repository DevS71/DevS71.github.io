package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.Task;
import tasks.TaskService;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Test for TaskService class functionality and interaction with Task class.
 * 
 * 				To use this class run it as a Junit test. This will perform tests on the TaskService class with good and 
 * 					bad input to check for proper operation.
 * 
 * 				testInvalidIDCreation() method presents an invalid ID value and tests that a task object will not be created.
 * 
 * 				testInvalidNameTaskCreation() method presents invalid name values and verifies that it will not create a task.
 * 
 * 				testInvalidDescTaskCreation() method presents invalid description and verifies that it will not create a task.
 * 
 * 				testDuplicateIDTaskCreation() creates two task objects with duplicate ID values to verify that the second task
 * 					will not be created.
 * 
 * 				testUpdateTaskName() method creates a task in the list and updates the name. Then verifies that there is a task
 * 					with the updated name and not the original.
 * 
 * 				testUpdateTaskDesc() creates a task in the list and updates the description. Then verifies that the task has 
 * 					the updated description and not the original.
 * 
 * 				testTaskRemoval() creates multiple tasks and deletes one. Then verifies that the deleted task is no longer in 
 * 					the list while the others are.
 * 
 * 				testInvalidIDTaskRemoval() verifies that a task will not be removed from the list if an invalid ID is used.
 * 
 * 				testTaskCreation() verifies that a task is created and added to list with good data.
 * 
 * 				testMultipleTaskCreation() verifies that multiple tasks can be created and added to the list.
 * 
 * Enhanced on 03/31/2022 for CS-499
 */

class TaskServiceTest {
	//Variables to use in testing.
	String goodID = "0123456789";
	String goodID2 = "1";
	String goodID3 = "12345";
	String goodName = "Name that is 20 char";
	String goodName2 = "N";
	String goodName3 = "Name ";
	String goodDescription = "Description that is 50 characters long and no more";
	String goodDescription2 = "D";
	String goodDescription3 = "Description";
	String badID = "01123456789";
	String badName = "Name that is 21 chars";
	String badDescription = "Description that is 51 characters long and no less!";
	
	//Task objects to use in testing.
	TaskService taskService = new TaskService();
	Task task = new Task();

	@Test
	//Test Task Creation with Invalid ID.
	void testInvalidIDCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(null, goodName, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(badID, goodName, goodDescription);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Name.
	void testInvalidNameTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(goodID, null, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(goodID, badName, goodDescription);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Description.
	void testInvalidDescTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(goodID, goodName, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(goodID, goodName, badDescription);
		});
	}
	
	@Test
	//Test Duplicate ID Creation.
	void testDuplicateIDTaskCreation() {
		taskService.addTask(goodID, goodName, goodDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(goodID, goodName2, goodDescription2);
		});
	}
	
	@Test
	//Test updating Task Name.
	void testUpdateTaskName() {
		taskService.addTask(goodID, goodName, goodDescription);
		//update name
		taskService.updateTaskName(goodID, goodName2);
		//verify update
		task = taskService.getTask(goodID);
		assertTrue(task.getTaskName().equals(goodName2));
		assertFalse(task.getTaskName().equals(goodName));
	}
	
	@Test
	//Test for updating Task Description.
	void testUpdateTaskDesc() {
		taskService.addTask(goodID, goodName, goodDescription);
		//update description
		taskService.updateTaskDesc(goodID, goodDescription2);
		//verify update
		task = taskService.getTask(goodID);
		assertTrue(task.getTaskDescription().equals(goodDescription2));
		assertFalse(task.getTaskDescription().equals(goodDescription));
	}
	
	@Test
	//Test for Task Removal.
	void testTaskRemoval() {
		taskService.addTask(goodID, goodName, goodDescription);
		taskService.addTask(goodID2, goodName2, goodDescription2);
		taskService.removeTask(goodID);
		//verify second task remains
		int index = taskService.findTask(goodID2);
		assertTrue(index >= 0);
		//verify first task removed
		index = taskService.findTask(goodID);
		assertTrue(index == -1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task = taskService.getTask(goodID);
		});
	}
	
	@Test
	//Test for removing Task using ID that does not exist.
	void testInvalidIDTaskRemoval() {
		taskService.addTask(goodID, goodName, goodDescription);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.removeTask(goodID2);
		});
	}
	
	@Test
	//Test for creating a Task.
	void testTaskCreation() {
		taskService.addTask(goodID, goodName, goodDescription);
		task = taskService.getTask(goodID);
		assertTrue(task.getTaskID().equals(goodID));
		assertTrue(task.getTaskName().equals(goodName));
		assertTrue(task.getTaskDescription().equals(goodDescription));
	}
	
	@Test
	//Test for creating multiple Tasks.
	void testMultipleTaskCreation() {
		taskService.addTask(goodID, goodName, goodDescription);
		taskService.addTask(goodID2, goodName2, goodDescription2);
		taskService.addTask(goodID3, goodName3, goodDescription3);
		//verify first Task
		task = taskService.getTask(goodID);
		assertTrue(task.getTaskName().equals(goodName));
		assertTrue(task.getTaskDescription().equals(goodDescription));
		//verify second Task
		task = taskService.getTask(goodID2);
		assertTrue(task.getTaskName().equals(goodName2));
		assertTrue(task.getTaskDescription().equals(goodDescription2));
		//verify third task
		task = taskService.getTask(goodID3);
		assertTrue(task.getTaskName().equals(goodName3));
		assertTrue(task.getTaskDescription().equals(goodDescription3));
	}

}
