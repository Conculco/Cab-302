package asgn2Tests;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	@Test	
	public void ReadLogFile() throws PizzaException, IOException{
		ArrayList<Customer> i;
		try {
		i = LogHandler.populateCustomerDataset("C:/Users/Joshua/git/Cab-302/logs/20170102.txt");
			System.out.println(i);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
