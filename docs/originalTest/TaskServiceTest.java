package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;
import taskService.TaskService;

/*
 * Name Devin Schmidt
 * 
 * Class CS-320-T3228
 * 
 * Date 02/14/2021
 * 
 * Description Test for TaskService class functionality and interaction with Task class
 */

class TaskServiceTest {
	//Variables to use in testing
	String goodID = "0123456789";
	String goodID2 = "1";
	String goodID3 = "12345";
	String goodName = "Name that is 20 char";
	String goodName2 = "N";
	String goodName3 = "Name ";
	String goodDesc = "Description that is 50 characters long and no more";
	String goodDesc2 = "D";
	String goodDesc3 = "Description";
	String badID = "01123456789";
	String badName = "Name that is 21 chars";
	String badDesc = "Description that is 51 characters long and no less!";
	
	//Task objects to use in testing
	TaskService service = new TaskService();
	Task task = new Task();

	@Test
	//Test Task Creation with Invalid ID
	void testInvalidIDCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(null, goodName, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(badID, goodName, goodDesc);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Name
	void testInvalidNameTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(goodID, null, goodDesc);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(goodID, badName, goodDesc);
		});
	}
	
	@Test
	//Test Task Creation with Invalid Description
	void testInvalidDescTaskCreation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(goodID, goodName, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(goodID, goodName, badDesc);
		});
	}
	
	@Test
	//Test Duplicate ID Creation
	void testDuplicateIDTaskCreation() {
		service.addTask(goodID, goodName, goodDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(goodID, goodName2, goodDesc2);
		});
	}
	
	@Test
	//Test updating Task Name
	void testUpdateTaskName() {
		service.addTask(goodID, goodName, goodDesc);
		//update name
		service.updateTaskName(goodID, goodName2);
		//verify update
		task = service.getTask(goodID);
		assertTrue(task.getTaskName().equals(goodName2));
		assertFalse(task.getTaskName().equals(goodName));
	}
	
	@Test
	//Test for updating Task Description
	void testUpdateTaskDesc() {
		service.addTask(goodID, goodName, goodDesc);
		//update description
		service.updateTaskDesc(goodID, goodDesc2);
		//verify update
		task = service.getTask(goodID);
		assertTrue(task.getTaskDesc().equals(goodDesc2));
		assertFalse(task.getTaskDesc().equals(goodDesc));
	}
	
	@Test
	//Test for Task Removal
	void testTaskRemoval() {
		service.addTask(goodID, goodName, goodDesc);
		service.addTask(goodID2, goodName2, goodDesc2);
		service.removeTask(goodID);
		//verify second task remains
		int index = service.findTask(goodID2);
		assertTrue(index >= 0);
		//verify first task removed
		index = service.findTask(goodID);
		assertTrue(index == -1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task = service.getTask(goodID);
		});
	}
	
	@Test
	//Test for removing Task using ID that does not exist
	void testInvalidIDTaskRemoval() {
		service.addTask(goodID, goodName, goodDesc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.removeTask(goodID2);
		});
	}
	
	@Test
	//Test for creating a Task
	void testTaskCreation() {
		service.addTask(goodID, goodName, goodDesc);
		task = service.getTask(goodID);
		assertTrue(task.getTaskID().equals(goodID));
		assertTrue(task.getTaskName().equals(goodName));
		assertTrue(task.getTaskDesc().equals(goodDesc));
	}
	
	@Test
	//Test for creating multiple Tasks
	void testMultipleTaskCreation() {
		service.addTask(goodID, goodName, goodDesc);
		service.addTask(goodID2, goodName2, goodDesc2);
		service.addTask(goodID3, goodName3, goodDesc3);
		//verify first Task
		task = service.getTask(goodID);
		assertTrue(task.getTaskName().equals(goodName));
		assertTrue(task.getTaskDesc().equals(goodDesc));
		//verify second Task
		task = service.getTask(goodID2);
		assertTrue(task.getTaskName().equals(goodName2));
		assertTrue(task.getTaskDesc().equals(goodDesc2));
		//verify third task
		task = service.getTask(goodID3);
		assertTrue(task.getTaskName().equals(goodName3));
		assertTrue(task.getTaskDesc().equals(goodDesc3));
	}

}
