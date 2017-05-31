package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.VegetarianPizza;

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
	public void pizzaPizzaType_MeatLovers() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertEquals("Meat Lovers", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaPizzaType_Vegetarian() throws PizzaException{
		VegetarianPizza aPizza = new VegetarianPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertEquals("Vegetarian", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaPizzaType_Margerita() throws PizzaException{
		MargheritaPizza aPizza = new MargheritaPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertEquals("Margherita", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaPizzaType_MeatLovers_WrongType() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertNotEquals("Vegetarian", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaPizzaType_Vegetarian_WrongType() throws PizzaException{
		VegetarianPizza aPizza = new VegetarianPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertNotEquals("Margherita", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaPizzaType_Margerita_WrongType() throws PizzaException{
		MargheritaPizza aPizza = new MargheritaPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertNotEquals("Meat Lovers", aPizza.getPizzaType());
	}
	@Test	
	public void pizzaQuantity() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		assertEquals(1, aPizza.getQuantity());
	}
	@Test(expected=PizzaException.class)	
	public void pizzaQuantity_Negative() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(-1, LocalTime.of(19, 00), LocalTime.of(19, 00));
	}
	@Test(expected=PizzaException.class)	
	public void pizzaQuantity_OverOrder() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(11, LocalTime.of(19, 00), LocalTime.of(19, 00));
	}
	@Test	
	public void pizzaCostPerPizza() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		double i = aPizza.getCostPerPizza();
		assertEquals(Double.doubleToLongBits(5.0), Double.doubleToLongBits(i));
	}
	@Test	
	public void pizzaOrderCost() throws PizzaException{
		VegetarianPizza aPizza = new VegetarianPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderCost();
		assertEquals(5, i);
	}
	@Test	
	public void pizzaOrderCost_Multiple() throws PizzaException{
		MargheritaPizza aPizza = new MargheritaPizza(3, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderCost();
		assertEquals(4, i);
	}
	@Test	
	public void pizzaOrderPrice() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderPrice();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaOrderPrice_2() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderPrice();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaOrderProfit() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getOrderProfit();
		assertEquals(7, i);
	}
	@Test	
	public void pizzaPricePerPizza_MeatLovers() throws PizzaException{
		MeatLoversPizza aPizza = new MeatLoversPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getPricePerPizza();
		assertEquals(12, i);
	}
	@Test	
	public void pizzaPricePerPizza_Vegetarian() throws PizzaException{
		VegetarianPizza aPizza = new VegetarianPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getPricePerPizza();
		assertEquals(10, i);
	}
	@Test	
	public void pizzaPricePerPizza_Margherita() throws PizzaException{
		MargheritaPizza aPizza = new MargheritaPizza(1, LocalTime.of(19, 00), LocalTime.of(19, 00));
		int i = (int) aPizza.getPricePerPizza();
		assertEquals(8, i);
	}
	
	
	
	
}
