package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a driver. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Manhattan  
 * Distance between the customer and the restaurant. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author Person B
 *
 */
public class DriverDeliveryCustomer extends Customer {
	private String name;
	private String mobileNumber;
	private int locationX;
	private int locationY;
	private String type;
	
	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a driver.  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment
	 *  Specification are violated. 
     *
     *  <P>PRE: TRUE
 	 *  <P>POST: All field values are set
	 *  
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY -  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public DriverDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		super(name, mobileNumber, locationX, locationY, "Driver Delivery");
		this.name = name;
		if (name.length() <= 0)
		{
			throw new CustomerException("Name entered is invalid");
		}
		this.mobileNumber = mobileNumber;
		if (mobileNumber.startsWith("0") && mobileNumber.length() == 9)
		{
			this.mobileNumber = mobileNumber;
		}
		else
		{
			throw new CustomerException("The phone number entered is invalid");
		}
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	/**
	 * Returns the Manhattan Distance between the instance of DriverDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
	 * @return The distance between the restaurant and the customer in Manhattan distance.
	 */
	@Override
	public double getDeliveryDistance() {	
		return getLocationX() + getLocationY();
	}
}