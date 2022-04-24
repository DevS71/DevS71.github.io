package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.Task;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Test for Task class functionality
 * 
 * 				To use this class run it as a Junit test. This will test the Task class by presenting it with good and bad
 * 					input to check for proper operation.
 * 
 * 				testInvalidIDTaskCreation() method presents invalid ID values to the task objects and verifies it will not 
 * 					create these object.
 * 
 * 				testInvalidNameTaskCreation() method presents invalid name values and verifies that it will not create a task.
 * 
 * 				testInvalidDescTaskCreation() method presents invalid description and verifies that it will not create a task.
 * 
 * 				testValidTaskCreation() method presents valid data for all variables and verifies that a task will be created.
 * 
 * Enhanced on 03/31/2022 for CS-499
 */

class TaskTest {
	//Variables to use in testing.
	String goodID = "0123456789";
	String goodName = "Name that is 20 char";
	String goodDescription = "Description that is 50 characters long and no more";
	String badID = "01123456789";
	String badName = "Name that is 21 chars";
	String badDescription = "Description that is 51 characters long and no less!";
	
	//Task object to use in testing.
	Task task = new Task();

	@Test
	//Test Task Creation with Invalid ID.
	void testInvalidIDTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(null, goodName, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(badID, goodName, goodDescription);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Name.
	void testInvalidNameTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, null, goodDescription);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, badName, goodDescription);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Description.
	void testInvalidDescTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, goodName, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, goodName, badDescription);
		});
	}
	
	@Test
	//Test Task Creation with Valid Parameters.
	void testValidTaskCreation() {
		task.createTask(goodID, goodName, goodDescription);
		assertTrue(task.getTaskID().equals(goodID));
		assertTrue(task.getTaskName().equals(goodName));
		assertTrue(task.getTaskDescription().equals(goodDescription));
	}

}

