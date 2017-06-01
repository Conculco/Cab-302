package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

import java.util.regex.*;

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
		FileInputStream fstream;
		ArrayList<Customer> cust = new ArrayList<Customer>();
		String name = "";
		String num = "";
		String slocx = "";
		int locx = 0;
		String slocy = "";
		int locy = 0;
		String type = "";
		try {
			fstream = new FileInputStream(filename);
				try{
					BufferedReader s = new BufferedReader(new InputStreamReader(fstream));
					String strLine;
					while ((strLine = s.readLine()) != null)   {
						//System.out.println(strLine);
						Pattern findName = Pattern.compile("([A-Z])\\w+ ([A-Z])*'?\\w+");
						Matcher matchName = findName.matcher(strLine);
						while(matchName.find())
						{
							name = matchName.group();
							//System.out.println(matchName.group());
						}
						Pattern findNum = Pattern.compile("([0-9]){10}");
						Matcher matchNum = findNum.matcher(strLine);
						while(matchNum.find())
						{
							//System.out.println(matchNum.group());
							num = matchNum.group();
						}
						Pattern findLocX = Pattern.compile(",-*[0-9],");
						Matcher matchLocX = findLocX.matcher(strLine);
						while(matchLocX.find())
						{
							//System.out.println(matchLocX.group());
							slocx = matchLocX.group().replace(",", "");
							locx = Integer.parseInt(slocx);
						}
						Pattern findLocY = Pattern.compile(",[0-9],P");
						Matcher matchLocY = findLocY.matcher(strLine);
						while(matchLocY.find())
						{
							//System.out.println(matchLocY.group());
							slocy = matchLocY.group().replace(",", "").replace("P", "");
							locy = Integer.parseInt(slocy);
						}
						Pattern findType = Pattern.compile("PUC|DNC|DVC");
						Matcher matchType = findType.matcher(strLine);
						while(matchType.find())
						{
							//System.out.println(matchType.group());
							type = matchType.group();
						}
						cust.add(CustomerFactory.getCustomer(type, name, num, locx, locy));
					}
					
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cust.iterator().toString());
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
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((thisLine = br.readLine()) != null) {
				String[] compArr = thisLine.split(COMMA);
				
				//Load Elements of array into correct format for getPizza()
				String pizzaCode = compArr[7];
				int QTY = Integer.parseInt(compArr[8]);
				LocalTime orderTime = LocalTime.parse(compArr[0]);
				LocalTime deliveryTime = LocalTime.parse(compArr[1]);
				
				//System.out.println(pizzaCode);
				//System.out.println(QTY);
				//System.out.println(orderTime);
				
				//String pizzaCode, int quantity, LocalTime orderTime, LocalTime deliveryTime
				pizza.add(PizzaFactory.getPizza(pizzaCode, QTY, orderTime, deliveryTime));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		
		System.out.println(pizzaCode);
		System.out.println(QTY);
		System.out.println(orderTime);
		System.out.println(deliveryTime);
			
			//String pizzaCode, int quantity, LocalTime orderTime, LocalTime deliveryTime
		pizza = PizzaFactory.getPizza(pizzaCode, QTY, orderTime, deliveryTime);
   	    return pizza;	
	}

}
