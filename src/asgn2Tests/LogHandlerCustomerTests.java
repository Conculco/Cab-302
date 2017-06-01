package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	@Test	
	public void ClassTest() throws IOException, LogHandlerException, CustomerException{
		ArrayList<Customer> Customer;
		Customer = LogHandler.populateCustomerDataset("./logs/20170101.txt");
		System.out.println(Customer);
		assertEquals("asgn2Customers.DriverDeliveryCustomer", Customer.get(0).getClass().getName());
	}
	
	@Test	
	public void ReadLogFile0() throws IOException, LogHandlerException, CustomerException{
		ArrayList<Customer> Customer;
		Customer = LogHandler.populateCustomerDataset("./logs/20170101.txt");
		System.out.println(Customer);
		assertEquals("Casey Jones", Customer.get(0).getName());
		assertEquals("0123456789", Customer.get(0).getMobileNumber());
		assertEquals("Driver Delivery", Customer.get(0).getCustomerType());
		assertEquals(5, Customer.get(0).getLocationX());
		assertEquals(5, Customer.get(0).getLocationY());
	}
	@Test	
	public void ReadLogFile1() throws IOException, LogHandlerException, CustomerException{
		ArrayList<Customer> Customer;
		Customer = LogHandler.populateCustomerDataset("./logs/20170101.txt");
		System.out.println(Customer);
		assertEquals("April O'Neal", Customer.get(1).getName());
		assertEquals("0987654321", Customer.get(1).getMobileNumber());
		assertEquals("Drone Delivery", Customer.get(1).getCustomerType());
		assertEquals(3, Customer.get(1).getLocationX());
		assertEquals(4, Customer.get(1).getLocationY());
	}
	@Test	
	public void ReadLogFile2() throws IOException, LogHandlerException, CustomerException{
		ArrayList<Customer> Customer;
		Customer = LogHandler.populateCustomerDataset("./logs/20170101.txt");
		System.out.println(Customer);
		assertEquals("Oroku Saki", Customer.get(2).getName());
		assertEquals("0111222333", Customer.get(2).getMobileNumber());
		assertEquals("Pick Up", Customer.get(2).getCustomerType());
		assertEquals(0, Customer.get(2).getLocationX());
		assertEquals(0, Customer.get(2).getLocationY());
	}
	@Test	
	public void ReadLine() throws PizzaException, IOException, LogHandlerException{
		Customer cust;
		try {
			cust = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
			System.out.println(cust);
			assertEquals("Driver Delivery", cust.getCustomerType());
			assertEquals("Casey Jones", cust.getName());
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		
	}
	
}
