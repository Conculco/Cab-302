package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a drone. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Euclidean 
 * Distance between the customer and the restaurant.  A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author PersonB
 *
 */
public class DroneDeliveryCustomer extends Customer {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String mobileNumber;
	@SuppressWarnings("unused")
	private int locationX;
	@SuppressWarnings("unused")
	private int locationY;
	@SuppressWarnings("unused")
	private String type;

	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a drone.  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment
	 *  Specification are violated. 
     *
     * <P> PRE: TRUE
     * <P> POST: All field values are set
     *
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public DroneDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		super(name, mobileNumber, locationX, locationY, "Drone Delivery");
		this.name = name;
		if (name.length() <= 0) {
			throw new CustomerException("Name entered is invalid");
		}
		this.mobileNumber = mobileNumber;
		if (mobileNumber.startsWith("0") && mobileNumber.length() == 10){
			this.mobileNumber = mobileNumber;
		} else {
			throw new CustomerException("The phone number entered is invalid");
		}
		if(locationX > 10 || locationX < - 10 || locationY > 10 || locationY < - 10 || getDeliveryDistance() == 0) {
			throw new CustomerException("Delivery Distance is too much");
		} else {
			this.locationX = locationX;
			this.locationY = locationY;
		}
	}

	/**
	 * Returns the Euclidean Distance between the instance of DroneDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
     * @return The distance between the restaurant and the customer in Euclidean distance.
	 */
	@Override
	public double getDeliveryDistance() {
		double x1 = getLocationX();
		double y1 = getLocationY();
		return Math.abs(Math.sqrt((x1*x1) + (y1*y1)));
	}
}
