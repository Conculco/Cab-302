package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;



/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Person A
 *
 */
public class MargheritaPizza extends Pizza {

	private int quantity;
	private LocalTime orderTime;
	private LocalTime deliveryTime;
	
	/**
	 * 
	 *  This class represents a margherita pizza made at the  Pizza Palace restaurant.   The margherita pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
	 * <P>PRE: TRUE
	 * <P>POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MargheritaPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		super(quantity, orderTime, deliveryTime, "Margherita", 8.00);
		
		if(quantity < 1)
		{
			throw new PizzaException("Order contains less than one pizza");
		}
		else if(quantity > 10)
		{
			throw new PizzaException("Order contains more than 10 pizzas bruh, chill fam");
		}
		else
		{
			this.quantity = quantity;
		}
		if(orderTime.isBefore(LocalTime.of(19, 00)) || orderTime.isAfter(LocalTime.of(23, 00)))
		{
			throw new PizzaException("Kitchen is closed, new orders cannot be taken");
		}
		else
		{
			this.orderTime = orderTime;
		}
	}

}
