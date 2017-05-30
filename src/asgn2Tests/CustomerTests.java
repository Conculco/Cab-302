package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
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
	
	@Test	
	public void customerPickUpDeliveryDistance() throws CustomerException {
		PickUpCustomer aCustomer = new PickUpCustomer("Customer Name", "0403123123", 0, 0);
		assertEquals(Double.doubleToLongBits(0), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerPickUpDeliveryDistance2() throws CustomerException {
		PickUpCustomer aCustomer = new PickUpCustomer("Customer Name", "0403123123", 0, 2);
		assertEquals(Double.doubleToLongBits(0), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDriverDeliveryDistance() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 0, 0);
		assertEquals(Double.doubleToLongBits(0), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDriverDeliveryDistance2() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 0, 1);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDroneDeliveryDistance() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", 0, 0);
		assertEquals(Double.doubleToLongBits(0), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDroneDeliveryDistance2() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", 0, 1);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDroneDeliveryDistance3() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", 1, 1);
		double i = Math.sqrt((1*1) + (1*1));
		assertEquals(Double.doubleToLongBits(i), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDroneDeliveryDistance4() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", 1, 2);
		double i = Math.sqrt((1*1) + (2*2));
		assertEquals(Double.doubleToLongBits(i), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	
	
}
