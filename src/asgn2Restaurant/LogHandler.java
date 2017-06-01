package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	private final static String COMMA = ",";
	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * @throws IOException 
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		ArrayList<Customer> cust = new ArrayList<Customer>();
		String thisLine = null;
		try {
			@SuppressWarnings("resource")
			//Read file and split into array split by commas
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((thisLine = br.readLine()) != null) {
				String[] arrayUnsorted = thisLine.split(COMMA);

				//Sorting the elements of the 'arrayUnsorted' into useful variables
				String custType = arrayUnsorted[4];
				String custNum = arrayUnsorted[3];
				String custName = arrayUnsorted[2];
				int custLocx = Integer.parseInt(arrayUnsorted[5]);
				int custLocy = Integer.parseInt(arrayUnsorted[6]);
				cust.add(CustomerFactory.getCustomer(custType, custName, custNum, custLocx, custLocy));
			}
		} catch (IOException e) {
					e.printStackTrace();
		}
		return cust;		
}

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		ArrayList<Pizza> pizza = new ArrayList<Pizza>();
		String thisLine = null;
		try {
			@SuppressWarnings("resource")
			//Read File and Split into array split by commas
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((thisLine = br.readLine()) != null) {
				String[] arrayUnsorted = thisLine.split(COMMA);
				
				//Sorting the elements of the 'arrayUnsorted' into useful variables
				String pizzaCode = arrayUnsorted[7];
				int QTY = Integer.parseInt(arrayUnsorted[8]);
				LocalTime orderTime = LocalTime.parse(arrayUnsorted[0]);
				LocalTime deliveryTime = LocalTime.parse(arrayUnsorted[1]);
				pizza.add(PizzaFactory.getPizza(pizzaCode, QTY, orderTime, deliveryTime));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
   	    return pizza;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		Customer cust = null;
		String thisLine = line;
		String[] compArr = thisLine.split(COMMA);
			
		//Load Elements of array into correct format for getPizza()
		String custType = compArr[4];
		String custNum = compArr[3];
		String custName = compArr[2];
		int custLocx = Integer.parseInt(compArr[5]);
		int custLocy = Integer.parseInt(compArr[6]);
		cust = CustomerFactory.getCustomer(custType, custName, custNum, custLocx, custLocy);
   	    return cust;
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		Pizza pizza = null;
		String thisLine = line;
		String[] compArr = thisLine.split(COMMA);
			
		//Load Elements of array into correct format for getPizza()
		String pizzaCode = compArr[7];
		int QTY = Integer.parseInt(compArr[8]);
		LocalTime orderTime = LocalTime.parse(compArr[0]);
		LocalTime deliveryTime = LocalTime.parse(compArr[1]);
		pizza = PizzaFactory.getPizza(pizzaCode, QTY, orderTime, deliveryTime);
   	    return pizza;	
	}

}
