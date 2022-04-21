package project_main;

/*
 *Author: Devin Schmidt 
 * 
 *Developed for: CS-499
 * 
 * Description: Class that handles searching the database for records that match criteria
 * 
 * 				To use this class create a Search_Handler object "search"
 * 
 * 				To find the first record in a collection call search.findFirstRecord(MongoClient, String, CodecRegistry) and pass
 * 					a MongoClient object with the connection to use, a String with the collection to access, a CodecRegistry object
 * 					with a Codec to use to decode the record values.
 * 
 * 				To find a record searching a single field for a value that equals call search.singleQueryEquals(MongoClient, String, CodecRegistry,
 *					String, int) and pass a MongoClient object with the connection to use, a String with the collection to access, 
 *					a CodecRegistry object with a codec to use to decode the record values, a String with the field to search (must
 *					contain an integer value), and an int to compare the record field to.
 *
 *				To find a record searching a single field for a value that is in a range call search.singleQueryRange(MongoClient, String, 
 *					CodecRegistry, String, int, int) and pass a MongoClient with the connection to use, a String with the collection to access,
 *					a CodecRegistry object that contains the codec to decode the record values with, a String with the field to search,
 *					an int for the upper end of the ranged to consider, and an int for the lower limit of the range to consider.
 *
 *				To find a record by the ID call search.(MongoClient, String, CodecRegistry, String) and pass a MongoClient object that
 *					has the connection to use, a String with the collection to access, a CodecRegistry that contains the codec to 
 *					decode the record values, and a String with the ID to match.
 *
 *				To return a Rental object that matches an id call search.returnIdEquals(MongoClient, String, CodecRegistry, String)
 *					and pass a MongoClient object that contains the connection to use, a String with the collection to access, a
 *					CodecRegistry object with the codec to decode the record values, and a String with the ID to match. This returns
 *					a Rental object.
 *
 */

import java.util.ArrayList;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Search_Handler {
	
	//Method to return the first record found in database
	public static void findFirstRecord(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry) {
		//Rental object to hold record
		Rental rental = new Rental();
		
		try {
			//Load the database and collection
			MongoDatabase database = mongoClient.getDatabase(dataBase).withCodecRegistry(pojoCodecRegistry);
			MongoCollection<Rental> collection = database.getCollection("listingsAndReviews", Rental.class);
			
			//find the rental in the collection and output values
			rental = collection.find().first();
	        System.out.println(rental);
	        
		} catch(Exception e) {
			System.out.println("Unable to load database. Exception: " + e);
		}
		
	}
	
	//Method to search database with a single field equal to the users value
	public static void singleQueryEquals(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry,
			String field, int value) {
		
		try {
			//Load database and collection
			MongoDatabase database = mongoClient.getDatabase(dataBase).withCodecRegistry(pojoCodecRegistry);
			MongoCollection<Rental> collection = database.getCollection("listingsAndReviews", Rental.class);
			
			//ArrayList to hold results of search
			ArrayList<Rental> rentals = new ArrayList<Rental>();
	        //filter to use in the search
	        Bson filter = Filters.eq(field, value);
	        //search collection and fill arraylist with results
	        collection.find(filter).into(rentals);
	        //check there are records in the arraylist before accessing
	        if(rentals.size() < 1) {
	        	//display no results if list is empty
	        	System.out.println("No Results");
	        } else {
	        	//output each records values from the list one at a time
	        	for(int i = 0; i < rentals.size(); ++i) {
	            	System.out.println(rentals.get(i));
	            }
	        }
		} catch(Exception e) {
			System.out.println("Unable to load database. Exception: " + e);
		}
	}
	
	//method to search one field for a value in a range
	public static void singleQueryRange(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry,
			String field, int upper_limit, int lower_limit) {
		
		try {
			//load database and collection
			MongoDatabase database = mongoClient.getDatabase(dataBase).withCodecRegistry(pojoCodecRegistry);
			MongoCollection<Rental> collection = database.getCollection("listingsAndReviews", Rental.class);
			//ArrayList to hold results
			ArrayList<Rental> rentals = new ArrayList<Rental>();
	        //filter to use in search
	        Bson filter = Filters.and(Filters.gte(field, lower_limit), Filters.lte(field, upper_limit));
	        //search the collection
	        collection.find(filter).into(rentals);
	        //check if any records are in list before accessing
	        if(rentals.size() < 1) {
	        	//if no records present output no results
	        	System.out.println("No results");
	        } else {
	        	//Output results one record at a time
	        	for(int i = 0; i < rentals.size(); ++i) {
	            	System.out.println(rentals.get(i));
	            }
	        }
			
		} catch(Exception e) {
			System.out.println("Unable to load database. Exception: " + e);
		}
  
	}
	
	//Method for finding a record by id value
	public static void queryIdEquals(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry,
			String value) {
		
		try {
			//Load the database and collection
			MongoDatabase database = mongoClient.getDatabase(dataBase).withCodecRegistry(pojoCodecRegistry);
			MongoCollection<Rental> collection = database.getCollection("listingsAndReviews", Rental.class);
			//filter to use in the search
			Bson filter = Filters.eq("_id", value);
			//rental object to hold results of search
			Rental rental = collection.find(filter).first();
			//output values of record
	        System.out.println(rental);
			
		} catch(Exception e) {
			System.out.println("Unable to load database. Exception: " + e);
		}

	}
	
	//method to return a Rental object that equals the id input, used for edits, adding and deletions
	public static Rental returnIdEquals(MongoClient mongoClient, String dataBase, CodecRegistry pojoCodecRegistry,
			String value) {
		//Rental object to use
		Rental rental = new Rental();
		
		try {
			//Load database and collection
			MongoDatabase database = mongoClient.getDatabase(dataBase).withCodecRegistry(pojoCodecRegistry);
			MongoCollection<Rental> collection = database.getCollection("listingsAndReviews", Rental.class);
			//filter to use in the search
			Bson filter = Filters.eq("_id", value);
			//find the record
			rental = collection.find(filter).first();
			
		} catch(Exception e) {
			System.out.println("Unable to load database. Exception: " + e);
		}
		//return record found or empty object
		return rental;
	}
}
