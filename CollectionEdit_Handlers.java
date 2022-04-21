package project_main;

/*
 *Author: Devin Schmidt 
 * 
 *Developed for: CS-499
 * 
 * Description: Class that handles updating, adding and deleting records in the database
 * 
 * 				To use this class create a CollectionEdit_Handlers object "handlers"
 * 
 * 				To edit values in records call handlers.editRecordValues(MongoClient, String, CodecRegistry, String) and pass a 
 * 					MongoClient object that contains the connection to use, a String of the data collection to use, a CodecRegistry 
 * 					object that contains the codec to use to convert the data, and a String with the id of the record use.
 * 
 * 				To add a record to the data set call handlers.addRentalFile(MongoClient, String, CodecRegistry) and pass a MongoClient
 * 					object that contains the connection to use, a String of the data collection to use, a CodecRegistry object that 
 * 					contains the codec to decode the record values.
 * 
 * 				To remove a record from the collection call handlers.removeRecord(MongoClient, String, CodecRegistry, String) and pass
 * 					a MongoClient object that contains the connection to use, a String with the data collection to use, a CodecRegistry
 * 					object that contains the codec to use to decode the record values.
 * 				
 */

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

public class CollectionEdit_Handlers {
	
	static String id = "";//variable to hold the record id
	static String name = "";//variable to hold the record name
	static String summary = "";//variable to hold the record summary
	static String minimum_nights = "";//variable to hold the minimum_nights value
	static String maximum_nights = "";//variable to hold the maximum_nights value
	static int accommodates = -1;//variable to hold the accommodates value
	static int bedrooms = -1;//variable to hold the bedrooms value
	static int beds = -1;//variable to hold the beds value
	static String user_field_input = "";//variable to hold the user input
	
	//Method to edit a record in the collection
	public static void editRecordValues(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry, 
			String id) {
		
		try {
			//Load the database and collection
			MongoDatabase database = mongoClient.getDatabase(dataBase);
			MongoCollection<Document> collection = database.getCollection("listingsAndReviews");
			//document to use in the query
			Document query = new Document().append("_id", id);
			//Rental object to hold copy of record to be edited
			Rental rental = new Rental();
			//get the record as a Rental object
			rental = Search_Handler.returnIdEquals(mongoClient, dataBase, pojoCodecRegistry, id);
			
			//Output current values of the record
			System.out.println("Current Values:");
			System.out.println(rental);
			
			//Prompt user for changes to name, enter blank line to keep existing. 
			System.out.println("Enter new name (blank to keep):");
			name = IO_System.getFieldInput();
			//Check if current value is to be kept
			if(name.equals("")) {
				name = rental.getName();
			}
			
			//Prompt user for changes to summary, enter blank line to keep existing.
			System.out.println("Enter new summary (blank to keep):");
			//Check if current value is to be kept
			summary = IO_System.getFieldInput();
			if(summary.equals("")) {
				summary = rental.getSummary();
			}
			
			//Prompt user for changes to minimum_nights, enter blank line to keep existing.
			System.out.println("Enter new minimum night to stay (blank to keep):");
			minimum_nights = IO_System.getFieldInput();
			//Check if current value is to be kept
			if(minimum_nights.equals("")) {
				minimum_nights = rental.getMinimum_nights();
			}
			
			//Prompt user for changes to maximum_nights, enter blank line to keep existing.
			System.out.println("Enter new maximum nights to stay (blank to keep):");
			maximum_nights = IO_System.getFieldInput();
			//Check if current value is to be kept
			if(maximum_nights.equals("")) {
				maximum_nights = rental.getMaximum_nights();
			}
			
			//Prompt user for changes to accommodates, enter blank line to keep existing.
			System.out.println("Enter new number of people to accomodate (blank to keep):");
			accommodates = IO_System.getNumberInput();
			//Check if current value is to be kept
			if(accommodates < 0) {
				accommodates = rental.getAccommodates();
			}
			
			//Prompt user for changes to bedrooms, enter blank line to keep existing.
			System.out.println("Enter new amount of bedrooms (blank to keep):");
			bedrooms = IO_System.getNumberInput();
			//Check if current value is to be kept
			if(bedrooms < 0) {
				bedrooms = rental.getBedrooms();
			}
			
			//Prompt user for changes to beds, enter blank line to keep existing.
			System.out.println("Enter new number of beds (blank to keep):");
			beds = IO_System.getNumberInput();
			//Check if current value is to be kept
			if(beds < 0) {
				beds = rental.getBeds();
			}
			
			//Create a Bson object to update collection
			Bson updates = Updates.combine(
					Updates.set("name", name),
					Updates.set("summary", summary),
					Updates.set("minimum_nights", minimum_nights),
					Updates.set("maximum_nights", maximum_nights),
					Updates.set("accommodates", accommodates),
					Updates.set("bedrooms", bedrooms),
					Updates.set("beds", beds));
			
			//Update the collection and collect the results
			UpdateResult results = collection.updateOne(query, updates);
			
			if(results.getModifiedCount() > 0) {
				System.out.println("Number of Files updated = " + results.getModifiedCount());
			} else {
				System.out.println("Failed to update database");
			}
		} catch(Exception e) {
			System.out.println("Unable to update collection. Exception: " + e);
		}
	}
	
	//Method to add a record to the collection
	public static void addRentalFile(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry) {
		//Variable to check for duplicate id's
		boolean duplicateId = true;
		
		//Prompt user for name and collect input
		System.out.println("Enter name:");
		name = IO_System.getFieldInput();
		
		//Prompt user for summary and collect input
		System.out.println("Enter summary:");
		summary = IO_System.getFieldInput();
		
		//Prompt user for minimum_nights and collect input
		System.out.println("Enter minimum nights:");
		minimum_nights = IO_System.getFieldInput();
		
		//Prompt user for maximum_nights and collect input
		System.out.println("Enter maximum nights:");
		maximum_nights = IO_System.getFieldInput();
		
		//Prompt user for accommodates and collect input
		System.out.println("Enter number of people accommodated:");
		accommodates = IO_System.getMenuInput();
		
		//Prompt user for number of bedrooms and collect input
		System.out.println("Enter number of bedrooms:");
		bedrooms = IO_System.getMenuInput();
		
		//Prompt user for number of beds and collect input
		System.out.println("Enter number of beds:");
		beds = IO_System.getMenuInput();
		
		//Prompt user for id and collect input
		System.out.println("Enter id:");
		id = IO_System.getFieldInput();
		
		//check for duplicate id's in database, assume user entered a duplicate
		while(duplicateId == true) {
			//Use Rental object to search database by calling method
			Rental rental = Search_Handler.returnIdEquals(mongoClient, dataBase, pojoCodecRegistry, id);
			//Check if Rental object is null, if it is duplicate does not exist set duplicateId to false
			if(rental == null) {
				duplicateId = false;
			} else {
				//duplicate found, prompt for new id value
				System.out.println("Id already exists, please re-enter Id:");
				id = IO_System.getFieldInput();
			}
		}
		
		try {
			//Load database and collection as documents
			MongoDatabase database = mongoClient.getDatabase(dataBase);
			MongoCollection<Document> collection = database.getCollection("listingsAndReviews");
			
			try {
				//insert record into collection as document
				InsertOneResult result = collection.insertOne(new Document()
						.append("_id", id)
						.append("name", name)
						.append("summary", summary)
						.append("minimum_nights", minimum_nights)
						.append("maximum_nights", maximum_nights)
						.append("accommodates", accommodates)
						.append("bedrooms", bedrooms)
						.append("beds", beds));
				
				//output success message
				System.out.println("Insert success. Document Id is: " + result.getInsertedId());
			} catch(MongoException e) {
				//Output failure message
				System.out.println("Insert failed. MongoException: " + e);
			}
		} catch(Exception e) {
			//Output failure message
			System.out.println("Insert failed. Exception: " + e);
		}
		
		
	}
	
	//method to remove a record from the database
	public static void removeRecord(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry, 
			String id) {
		
		try {
			//Load database and collection as documents
			MongoDatabase database = mongoClient.getDatabase(dataBase);
			MongoCollection<Document> collection = database.getCollection("listingsAndReviews");
			
			//Filter to use to find document to delete
			Bson filter = Filters.eq("_id", id);
			
			//Delete document and capture result
			DeleteResult result = collection.deleteOne(filter);
			//Output success message
			System.out.println("Number of deleted documents = " + result.getDeletedCount());
		} catch(MongoException e) {
			//Output failure message
			System.out.println("Unable to delete document. Exception: " + e);
		}
	}
}
