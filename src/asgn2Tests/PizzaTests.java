package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MeatLoversPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	
	@Test	
	public void pizzaPizzaType() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertEquals("Meat Lovers", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaQuantity() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertEquals(1, aPizza.getQuantity());
	}
	@Test	
	public void pizzaCostPerPizza() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getCostPerPizza();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaOrderCost() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderCost();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaOrderPrice() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderPrice();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaOrderProfit() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderProfit();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaPricePerPizza() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getPricePerPizza();
		assertEquals(12, i);
	}
	
	
}
