package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	
	private String name = "Test Unit";
	private String mobileNumber = "0425080171";
	private int positionX = 3;
	private int positionY = 2;
	private Customer test;
	private String code = "PUC";
	
	@Test
	public void customerFactoryTest_Pickup() throws CustomerException {
		test = CustomerFactory.getCustomer(code, name, mobileNumber, positionX, positionY);
		assertEquals("Pick Up", test.getCustomerType());
	}
	@Test
	public void customerFactoryTest_Driver() throws CustomerException {
		this.code = "DVC";
		test = CustomerFactory.getCustomer(code, name, mobileNumber, positionX, positionY);
		assertEquals("Driver Delivery", test.getCustomerType());
	}
	@Test
	public void customerFactoryTest_Drone() throws CustomerException {
		this.code = "DNC";
		test = CustomerFactory.getCustomer(code, name, mobileNumber, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_InvalidType() throws CustomerException {
		String newCode = "DNCD";
		test = CustomerFactory.getCustomer(newCode, name, mobileNumber, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyInvalidType() throws CustomerException {
		String newCode = "";
		test = CustomerFactory.getCustomer(newCode, name, mobileNumber, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyNameInvalidDriver() throws CustomerException {
		String newName = "";
		test = CustomerFactory.getCustomer(code, newName, mobileNumber, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyNameInvalidDrone() throws CustomerException {
		String newName = "";
		test = CustomerFactory.getCustomer(code, newName, mobileNumber, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyNameInvalidPickup() throws CustomerException {
		String newName = "";
		test = CustomerFactory.getCustomer(code, newName, mobileNumber, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyNumInvalidDriver() throws CustomerException {
		String newNum = "";
		test = CustomerFactory.getCustomer(code, name, newNum, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyNumInvalidDrone() throws CustomerException {
		String newNum = "";
		test = CustomerFactory.getCustomer(code, name, newNum, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	@Test(expected=CustomerException.class)	
	public void customerFactoryTest_EmptyNumInvalidPickup() throws CustomerException {
		String newNum = "";
		test = CustomerFactory.getCustomer(code, name, newNum, positionX, positionY);
		assertEquals("Drone Delivery", test.getCustomerType());
	}
	
	
}
