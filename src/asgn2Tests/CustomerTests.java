package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;


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
	
	@Test(expected=CustomerException.class)
	public void customerName_Nothing() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("", "0403123123", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test
	public void customerName_Hyphenated() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("john-john john", "0403123123", 4, 5);
		assertEquals("john-john john", aCustomer.getName());
	}
	
	@Test
	public void customerName_SomethingSpecialThrownIn() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("john-john j'ohn", "0403123123", 4, 5);
		assertEquals("john-john j'ohn", aCustomer.getName());
	}
	
	@Test	
	public void customerMobile() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 4, 5);
		assertEquals("0403123123", aCustomer.getMobileNumber());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_Nothing() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_LargerThan_Alot() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0425151023216120234131155210215441", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_LargerThan_One() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "04031231232", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_LessThan_One() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "040312312", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_LettersAtStart_Length10() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "s04031d312", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_LettersInMiddle_Length10() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "04031dd312", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_Invalid_NoZeroStart() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "2403123121", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
	}
	
	@Test(expected=CustomerException.class)
	public void customerMobile_Invalid_SymbolStart() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "-403123121", 4, 5);
		assertEquals("Customer Name", aCustomer.getName());
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
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 1, 0);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test	
	public void customerDriverDeliveryDistance2() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 0, 1);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test(expected=CustomerException.class)	
	public void customerDriverDeliveryDistance3() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 11, 1);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test
	public void customerDriverDeliveryDistance4() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 5, 6);
		assertEquals(Double.doubleToLongBits(11), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test(expected=CustomerException.class)	
	public void customerDriverDeliveryDistance5() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", -5, -11);
		assertEquals(Double.doubleToLongBits(11), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test(expected=CustomerException.class)	
	public void customerDriverDeliveryDistance6() throws CustomerException {
		DriverDeliveryCustomer aCustomer = new DriverDeliveryCustomer("Customer Name", "0403123123", 0, 0);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test
	public void customerDroneDeliveryDistance() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", 1, 0);
		assertEquals(Double.doubleToLongBits(1), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
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
	@Test(expected=CustomerException.class)	
	public void customerDroneDeliveryDistance5() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", 0, 0);
		double i = Math.sqrt((1*1) + (2*2));
		assertEquals(Double.doubleToLongBits(i), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	@Test(expected=CustomerException.class)	
	public void customerDroneDeliveryDistance6() throws CustomerException {
		DroneDeliveryCustomer aCustomer = new DroneDeliveryCustomer("Customer Name", "0403123123", -11, 0);
		double i = Math.sqrt((1*1) + (2*2));
		assertEquals(Double.doubleToLongBits(i), Double.doubleToLongBits(aCustomer.getDeliveryDistance()));
	}
	
	
	
}
