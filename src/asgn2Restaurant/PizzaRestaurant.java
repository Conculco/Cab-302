package asgn2Restaurant;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;

/**
 * This class acts as a �model� of a pizza restaurant. It contains an ArrayList of Pizza objects and an ArrayList of  Customer objects.
 *  It contains a method that can populate the ArrayLists,  several methods to retrieve information about the ArrayLists and 
 *  a method to reset the array list. Information about the x and y location of the restaurant and the time that first and last 
 *  orders are accepted are listed in Section 5 of the Assignment Specification. 
 *  
 *  Any exceptions raised by one of the methods called by this class should be passed to asgn2GUIs.PizzaGUI so that it can be shown to
 *  the user.
 * 
 * @author Person A and Person B
 *
 */
public class PizzaRestaurant {

	private ArrayList<Customer> customersArray;
	private Customer customer;
	private ArrayList<Pizza> pizzasArray;
	private Pizza pizza;
	private final static String COMMA = ",";
	
	/**
	 * Creates an instance of the PizzaRestaurant and sets the customers and pizzas fields to
	 * an appropriate initial empty state. 
	 * 
	 * <P> PRE: TRUE
	 * <P> POST: The customers and pizzas fields are initialized to an empty state
	 * 
	 */
	public PizzaRestaurant() {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		ArrayList<Pizza> pizza = new ArrayList<Pizza>();
	}

	/**
	 * This method processes the information contained in the log file and populates the customers and pizzas fields.  
	 * The other classes that the method interacts with are listed in Section 11 of the specification document. 
     *
     * <P> PRE: TRUE
     * <P>POST: If no exception is thrown then the customers and pizzas fields are populated with the details in the log file ordered as they appear in the log file.
     * <P>      If an exception is thrown then the customers and pizzas fields should be empty.
     * 
	 * @param filename The log's filename
	 * @return true if the file was processed correctly 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above (passed by another class).
     *
	 */
	public boolean processLog(String filename) throws CustomerException, PizzaException, LogHandlerException{
		customersArray = LogHandler.populateCustomerDataset(filename);
		pizzasArray = LogHandler.populatePizzaDataset(filename);
		FileInputStream fstreamCust = null;
		FileInputStream fstreamPizza = null;
		@SuppressWarnings("resource")
		
		BufferedReader brCust = new BufferedReader(new InputStreamReader(fstreamCust));
		BufferedReader brPizza = new BufferedReader(new InputStreamReader(fstreamPizza));
		String strCustLine;
		String strPizzaLine;
		try {
			strCustLine = brCust.readLine();
			strPizzaLine = brPizza.readLine();
			String thisCustLine = strCustLine;
			String thisPizzaLine = strPizzaLine;
			String[] compArr = thisCustLine.split(COMMA);
			String[] compArrPizza = thisPizzaLine.split(COMMA);
			String lineCompare = customersArray.get(0).getName();
			String lineCompare2 = compArr[2];
			String lineCompare3 = pizzasArray.get(0).getPizzaType();
			String lineCompare4 = compArrPizza[8];
			if(lineCompare.equals(lineCompare2) && lineCompare3.equals(lineCompare4)) {
				return true;
			} 
			else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Returns the Customer object contained at the specified index of the customers field. The index should be the same as the index in the log file.
	 * @param index - The index within the customers field to retrieve.
	 * @return The Customer object located at the specified index.
	 * @throws CustomerException if index is invalid.
	 */
	public Customer getCustomerByIndex(int index) throws CustomerException{
		return customersArray.get(index);
	}
	
	/**
	 * Returns the Pizza object contained at the specified index of the pizzas field. The index should be the same as the index in the log file.
	 * @param index - The index within the pizzas field to retrieve.
	 * @return The Pizza object located at the specified index.
	 * @throws PizzaException if index is invalid.
	 */	
	public Pizza getPizzaByIndex(int index) throws PizzaException{
		return pizzasArray.get(index);
	}
	
	/**
	 * Returns the number of objects contained in the pizzas field. This value SHOULD be the same as 
	 * the value returned by getNumCustomerOrders.
	 * 
	 * @return the number of objects contained in the pizzas field.
	 */
	public int getNumPizzaOrders(){
		return customersArray.size();
	}

	/**
	 * Returns the number of objects contained in the customers field. This value SHOULD be the same as 
	 * the value returned by getNumPizzaOrders.
	 * 
	 * @return the number of objects contained in the customers field.
	 */
	public int getNumCustomerOrders(){
		return pizzasArray.size();
	}

			
	
	/**
	 * Returns the total delivery distance for all of the customers.
	 * 
	 * @return the total delivery distance for all Customers objects in the customers field.
	 */
	public double getTotalDeliveryDistance(){
		int deliveryDistanceTotal = 0;
		while (customersArray.iterator().hasNext()) {
			deliveryDistanceTotal += customersArray.iterator().next().getDeliveryDistance();
		}
		System.out.println(deliveryDistanceTotal);
		return deliveryDistanceTotal;
	}

	/**
	 * Returns the total profit for all of the pizza orders.
	 * 
	 * @return the total profit for all of the Pizza objects in the pizzas field.
	 */	
	public double getTotalProfit(){
		int totalProfit = 0;
		while (pizzasArray.iterator().hasNext()) {
			totalProfit += pizzasArray.iterator().next().getOrderProfit();
		}
		return totalProfit;
	}
	
	/**
	 * Resets the pizzas and customers fields to their initial empty states.
	 * 
	 * <P> PRE: True
	 * <P> POST:  The pizzas and customers fields are set to their initial empty states
	 */
	public void resetDetails(){
		// TO DO
	}

}
