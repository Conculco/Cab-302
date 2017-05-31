package asgn2Tests;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	@Test	
	public void ReadLogFile0() throws PizzaException, IOException, LogHandlerException{
		ArrayList<Pizza> pizza;
		pizza = LogHandler.populatePizzaDataset("./logs/20170101.txt");
		System.out.println(pizza);
		assertEquals(2, pizza.get(0).getQuantity());
		assertEquals("Vegetarian", pizza.get(0).getPizzaType());
	}
	@Test	
	public void ReadLogFile1() throws PizzaException, IOException, LogHandlerException{
		ArrayList<Pizza> pizza;
		pizza = LogHandler.populatePizzaDataset("./logs/20170101.txt");
		System.out.println(pizza);
		assertEquals(1, pizza.get(1).getQuantity());
		assertEquals("Meat Lovers", pizza.get(1).getPizzaType());
	}
	@Test	
	public void ReadLogFile2() throws PizzaException, IOException, LogHandlerException{
		ArrayList<Pizza> pizza;
		pizza = LogHandler.populatePizzaDataset("./logs/20170101.txt");
		System.out.println(pizza);
		assertEquals(3, pizza.get(2).getQuantity());
		assertEquals("Margherita", pizza.get(2).getPizzaType());
	}
}
