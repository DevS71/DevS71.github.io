package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Test for Task class functionality
 */

class TaskTest {
	//Variables to use in testing
	String goodID = "0123456789";
	String goodName = "Name that is 20 char";
	String goodDesc = "Description that is 50 characters long and no more";
	String badID = "01123456789";
	String badName = "Name that is 21 chars";
	String badDesc = "Description that is 51 characters long and no less!";
	
	//Task object to use in testing
	Task task = new Task();

	@Test
	//Test Task Creation with Invalid ID
	void testInvalidIDTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(null, goodName, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(badID, goodName, goodDesc);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Name
	void testInvalidNameTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, null, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, badName, goodDesc);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Description
	void testInvalidDescTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, goodName, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.createTask(goodID, goodName, badDesc);
		});
	}
	
	@Test
	//Test Task Creation with Valid Parameters
	void testValidTaskCreation() {
		task.createTask(goodID, goodName, goodDesc);
		assertTrue(task.getTaskID().equals(goodID));
		assertTrue(task.getTaskName().equals(goodName));
		assertTrue(task.getTaskDesc().equals(goodDesc));
	}

}
