package taskService;

/*
 * Name: Devin Schmidt
 * 
 * Class: CS-320-T3228
 * 
 * Date: 02/14/2021
 * 
 * Description: Class to create and manage Task object
 */

public class Task {
	//Fields for Task object
	String taskID;
	String taskName;
	String taskDesc;
	
	//default constructor
	public Task() {
		taskID = null;
		taskName = null;
		taskDesc = null;
	}
	
	//method for creating Task object
	public Task createTask(String ID, String name, String desc) {
		//Task object to create and return
		Task task = new Task();
		
		//verify ID meets requirements
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		} else {
			//create Task
			this.taskID = ID;
			setTaskName(name);
			setTaskDesc(desc);
		}
		
		return task;
	}
	
	//method for setting/updating taskName
	public void setTaskName(String name) {
		//verify name meets requirements
		if (name == null || name.length() > 20) {
			//fault if requirments are not met
			throw new IllegalArgumentException("Invalid Name");
		} else {
			//set taskName
			this.taskName = name;
		}
	}
	
	//method for setting/updating taskDesc
	public void setTaskDesc(String desc) {
		//verify desc meets requirements
		if (desc == null || desc.length() > 50) {
			//fault if desc doesn't meet requirements
			throw new IllegalArgumentException("Invalid Description");
		} else {
			//set taskDesc
			this.taskDesc = desc;
		}
	}
	
	//method for returning taskID
	public String getTaskID() {
		return this.taskID;
	}
	
	//method for returning taskName
	public String getTaskName() {
		return this.taskName;
	}
	
	//method for returning taskDesc
	public String getTaskDesc() {
		return this.taskDesc;
	}

}