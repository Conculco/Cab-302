package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	private String pizzaCode = "PZM";
	private int quantity = 5;
	private LocalTime orderTime = LocalTime.of(19, 00);
	private LocalTime deliveryTime = LocalTime.of(19, 20);
	private Pizza test;

	@Test
	public void pizzaFactoryCostPerPizza() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(Double.doubleToLongBits(5.0), Double.doubleToLongBits(test.getCostPerPizza()));
	}
	@Test
	public void pizzaFactoryGetOrderCost() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(Double.doubleToLongBits(25.0), Double.doubleToLongBits(test.getOrderCost()));
	}
	@Test
	public void pizzaFactoryGetOrderPrice() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(Double.doubleToLongBits(60.0), Double.doubleToLongBits(test.getOrderPrice()));
	}
	@Test
	public void pizzaFactoryGetOrderProfit() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(Double.doubleToLongBits(35.0), Double.doubleToLongBits(test.getOrderProfit()));
	}
	@Test
	public void pizzaFactoryGetPizzaType() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals("Meat Lovers", test.getPizzaType());
	}
	@Test
	public void pizzaFactoryGetPricePerPizza() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(Double.doubleToLongBits(12.0), Double.doubleToLongBits(test.getPricePerPizza()));
	}
	@Test
	public void pizzaFactoryGetQuantity() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(5, test.getQuantity());
	}
	@Test(expected=PizzaException.class)
	public void pizzaException() throws PizzaException {
		test = PizzaFactory.getPizza("PZE", quantity, orderTime, deliveryTime);
		assertEquals("Meat Lovers", test.getPizzaType());
	}
	@Test(expected=PizzaException.class)
	public void pizzaExceptionToManyPizza() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, 11, orderTime, deliveryTime);
	}
	@Test(expected=PizzaException.class)
	public void pizzaExceptionToLittlePizza() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, 0, orderTime, deliveryTime);
	}
	@Test(expected=PizzaException.class)
	public void pizzaExceptionToEarly() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, LocalTime.of(18, 00), deliveryTime);
	}
	@Test(expected=PizzaException.class)
	public void pizzaExceptionToLate() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, LocalTime.of(23, 00), LocalTime.of(23, 20));
	}
	@Test(expected=PizzaException.class)
	public void pizzaExceptionToLong() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, LocalTime.of(19, 00), LocalTime.of(20, 30));
	}
	@Test(expected=PizzaException.class)
	public void pizzaExceptionToLong() throws PizzaException {
		test = PizzaFactory.getPizza(pizzaCode, quantity, LocalTime.of(19, 00), LocalTime.of(20, 30));
	}
}
