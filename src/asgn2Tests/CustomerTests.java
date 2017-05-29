package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;


/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */

public class CustomerTests {
	
	@Test	
	public void customerName() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test	
	public void customerMobile() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 4, 5);
		assertEquals("0403123123", aCustomer.getMobileNumber());
	}
	
	@Test	
	public void customerLocationX() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 4, 5);
		assertEquals(4, aCustomer.getLocationX());
	}
	
	@Test	
	public void customerLocationY() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 4, 5);
		assertEquals(5, aCustomer.getLocationY());
	}
	
	@Test	
	public void customerCustomerType() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 4, 5);
		assertEquals("Driver Delivery", aCustomer.getCustomerType());
	}
	
}
