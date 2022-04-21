package project_main;

/*
 *Author: Devin Schmidt 
 * 
 *Developed for: CS-499
 * 
 * Description: Class for the object to hold record data from the database
 * 
 * 				To use this class create a Rental object "rental". Rental objects can be created with all default values or by specifying
 * 					a value for each variable.
 * 
 * 				To set the name variable on a Rental object call rental.setName(String) passing a String value for the name.
 * 
 * 				To get the name value of a Rental object call rental.getName(). This returns a String with the value of name variable.
 * 
 * 				To set the summary variable on a Rental object call rental.setSummary(String) and pass a String with the value for
 * 					the summary.
 * 
 * 				To get the summary value of a Rental object call rental.getSummary(). This returns a String with the value of the 
 * 					summary variable.
 * 
 * 				To set the minimum_nights variable of a Rental object call rental.setMinimum_nights(String) and pass a String with
 * 					the value for minimum_nights.
 * 
 * 				To get the minimum_nights value of a Rental object call rental.getMinimum_nights(). This returns a String with the 
 * 					value of the minimum_nights variable.
 * 
 * 				To set the maximum_nights variable of a Rental object call rental.setMaximum_nights(String) and pass a String with 
 * 					the value for the maximum_nights.
 * 
 * 				To get the maximum_nights value of a Rental object call rental.getMaximum_nights(). This returns a String with the 
 * 					value of the maximum_nights variable.
 * 
 * 				To set the accommodates variable of a Rental object call rental.setAccommodates(int) and pass an int with the value
 * 					for the accommodates variable.
 * 
 * 				To get the accommodates value of a Rental object call rental.getAccommodates(). This returns an int with the value
 * 					of the accommodates variable.
 * 
 * 				To set the bedrooms variable of a Rental object call rental.setBedrooms(int) and pass an int with the value for the 
 * 					bedrooms variable.
 * 
 * 				To get the bedrooms value of a Rental object call rental.getBedrooms(). This returns an int with the value of the 
 * 					bedrooms variable.
 * 
 * 				To set the beds variable of a Rental object call rental.setBeds(int) and pass an int with the value for the beds
 * 					variable.
 * 
 * 				To get the beds value of a Rental object call rental.getBeds(). This will return an int with the value of the beds
 * 					variable.
 * 
 * 				To output the values of the rental to console call System.out.println(rental). This invokes the toString() method of
 * 					this class and displays the rental values.
 * 
 */

public class Rental {
	
	//Class variables to hold fields from records
	String name = "";//variable to hold the value in the name field of record
	String summary = "";//variable to hold the value in the summary field of record
	String minimum_nights = "";//variable to hold the value in the minimum_nights field of the record
	String maximum_nights = "";//variable to hold the value in the maximum_nights field of the record
	
	int accommodates = -1;//variable to hold the value in the accommodates field of the record
	int bedrooms = -1;//variable to hold the value in the bedrooms field of the record
	int beds = -1;//variable to hold the value in the beds field of the record
	//The unique identifier for this database is held as a string
	String id;//variable to hold the value in the _id field of the record
	
	//Empty constructor
	public Rental() {}
	
	//Constructor with values pased
	public Rental(String name, String summary, String minimum_nights, String maximum_nights, int accomodates, int bedrooms,
			int beds) {
		this.name = name;
		this.summary = summary;
		this.minimum_nights = minimum_nights;
		this.maximum_nights = maximum_nights;
		this.accommodates = accomodates;
		this.bedrooms = bedrooms;
		this.beds = beds;
		
	}
	
	//Method to set name
	public void setName(String name) {
		this.name = name;
	}
	
	//Method to get name
	public String getName() {
		return this.name;
	}
	
	//Method to set summary
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	//Method to get summary
	public String getSummary() {
		return this.summary;
	}
	
	//Method to set minimum_nights
	public void setMinimum_nights(String min_nights) {
		this.minimum_nights = min_nights;
	}
	
	//Method to get minimum_nights
	public String getMinimum_nights() {
		return this.minimum_nights;
	}
	
	//Method to set maximum_nights
	public void setMaximum_nights(String max_nights) {
		this.maximum_nights = max_nights;
	}
	
	//Method to get maximum_nights
	public String getMaximum_nights() {
		return this.maximum_nights;
	}
	
	//Method to set accommodates
	public void setAccommodates(int accomodates) {
		this.accommodates = accomodates;
	}
	
	//Method to get accommodates
	public int getAccommodates() {
		return this.accommodates;
	}
	
	//method to set bedrooms
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	
	//Method to get bedrooms
	public int getBedrooms() {
		return this.bedrooms;
	}
	
	//Method to set beds
	public void setBeds(int beds) {
		this.beds = beds;
	}
	
	//Method to get beds
	public int getBeds() {
		return this.beds;
	}
	
	//Method to set _id
	public void setId(String id) {
		this.id = id;
	}
	
	//Method to get _id
	public String getId() {
		return this.id;
	}
	
	//Display Rental values as a string
	@Override
    public String toString() {
        return "Air bnb Rental [\n  Name = " + name + ",\n  Summary = " + summary + ",\n  Minimum stay(nights) = " + minimum_nights
        		+ "\n  Maximum stay(nights) = " + maximum_nights + "\n  Accomodates = " + accommodates + "\n  Number of bedrooms = "
        		+ bedrooms + "\n  Number of beds = " + beds + "\n  Record Id = " + id + "\n]";
    }

}
