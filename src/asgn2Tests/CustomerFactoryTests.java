package asgn2Tests;

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
	public void customerFactoryTest() 
	{
		try {
			test = CustomerFactory.getCustomer(code, name, mobileNumber, positionX, positionY);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
