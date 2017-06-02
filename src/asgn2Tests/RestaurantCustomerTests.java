package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	PizzaRestaurant p = new PizzaRestaurant();
	@Test
	public void RestaurantCustomer_processLogTest() throws CustomerException, PizzaException, LogHandlerException{
		Boolean cool = null; 
		if(p.processLog("./logs/20170101.txt") == true)
			{
				cool = true;
			}
		assertEquals(cool, true);
	}
	@Test
	public void RestaurantCustomer_processLogTest2() throws CustomerException, PizzaException, LogHandlerException{
		Boolean cool = null; 
		if(p.processLog("./logs/20170102.txt") == true)
			{
				cool = true;
			}
		assertEquals(cool, true);
	}
	@Test
	public void RestaurantCustomer_processLogTest3() throws CustomerException, PizzaException, LogHandlerException{
		Boolean cool = null; 
		if(p.processLog("./logs/20170103.txt") == true)
			{
				cool = true;
			}
		assertEquals(cool, true);
	}
	@Test(expected=CustomerException.class)	
	public void RestaurantCustomer_processLogTest4() throws CustomerException, PizzaException, LogHandlerException{
		Boolean cool = false; 
		if(p.processLog("./logs/20170101 Cust Exception.txt") == true)
			{
				cool = true;
			}
		assertEquals(cool, false);
	}
	@Test(expected=PizzaException.class)	
	public void RestaurantCustomer_processLogTest5() throws CustomerException, PizzaException, LogHandlerException{
		Boolean cool = false; 
		if(p.processLog("./logs/20170101 Pizza Exception.txt") == true)
			{
				cool = true;
			}
		assertEquals(cool, false);
	}
	@Test	
	public void RestaurantCustomer_getCustomerByIndex1() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		String acValue = p2.getCustomerByIndex(0).getName();
		String exValue = "Casey Jones";
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getCustomerByIndex2() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		String acValue = p2.getCustomerByIndex(1).getName();
		String exValue = "April O'Neal";
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getCustomerByIndex3() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		String acValue = p2.getCustomerByIndex(2).getName();
		String exValue = "Oroku Saki";
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getPizzaByIndex1() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		String acValue = p2.getPizzaByIndex(0).getPizzaType();
		String exValue = "Vegetarian";
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getPizzaByIndex2() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		String acValue = p2.getPizzaByIndex(1).getPizzaType();
		String exValue = "Meat Lovers";
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getPizzaByIndex3() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		String acValue = p2.getPizzaByIndex(2).getPizzaType();
		String exValue = "Margherita";
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getNumCustomerOrders1() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		int acValue = p2.getNumCustomerOrders();
		int exValue = 3;
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getNumCustomerOrders2() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170102.txt");
		int acValue = p2.getNumCustomerOrders();
		int exValue = 10;
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getNumCustomerOrders3() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170103.txt");
		int acValue = p2.getNumCustomerOrders();
		int exValue = 100;
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getNumPizzaOrders1() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170101.txt");
		int acValue = p2.getNumCustomerOrders();
		int exValue = 3;
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getNumPizzaOrders2() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170102.txt");
		int acValue = p2.getNumCustomerOrders();
		int exValue = 10;
		assertEquals(exValue, acValue);
	}
	@Test	
	public void RestaurantCustomer_getNumPizzaOrders3() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant p2 = new PizzaRestaurant();
		p2.processLog("./logs/20170103.txt");
		int acValue = p2.getNumPizzaOrders();
		int exValue = 100;
		assertEquals(exValue, acValue);
	}
	
	
}
