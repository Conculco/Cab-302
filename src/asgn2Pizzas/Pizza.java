package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Person A
 *
 */
public abstract class Pizza  {
	
	private int quantity;
	private LocalTime orderTime;
	private LocalTime deliveryTime;
	private String type;
	private double cost;
	private double price;
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
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
		if(type.equals(new String("Margherita")) || type.equals(new String("Vegetarian")) || type.equals(new String("Meat Lovers")))
		{
			this.type = type;
		}
		else
		{
			throw new PizzaException("Pizza be whack yo, ain't got dis flava homie");
		}
		
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		double pizzaCost = 0;
		for (PizzaTopping p : PizzaTopping.values()){
			if(containsTopping(p.CHEESE)){
				pizzaCost += p.CHEESE.getCost();
			}
			if(containsTopping(p.TOMATO)){
				pizzaCost += p.TOMATO.getCost();
			}
			if(containsTopping(p.BACON)){
				pizzaCost += p.BACON.getCost();
			}
			if(containsTopping(p.SALAMI)){
				pizzaCost += p.SALAMI.getCost();
			}
			if(containsTopping(p.PEPPERONI)){
				pizzaCost += p.PEPPERONI.getCost();
			}
			if(containsTopping(p.CAPSICUM)){
				pizzaCost += p.CAPSICUM.getCost();
			}
			if(containsTopping(p.MUSHROOM)){
				pizzaCost += p.MUSHROOM.getCost();
			}
			if(containsTopping(p.EGGPLANT)){
				pizzaCost += p.EGGPLANT.getCost();
			}
		}
		this.cost = pizzaCost;
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		for (PizzaTopping p : PizzaTopping.values())
		{
			return p.getCost();
		}
		return this.price = 0.00;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		if(this.type.equals(new String("Margherita")))
		{
			return price = 8;
		}
		else if(type.equals(new String("Vegetarian")))
		{ 
			return price = 10;
		}
		else if(type.equals(new String("Meat Lovers")))
		{
			return price = 12;
		}
		else 
		{
			return price;
		}
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		return getPricePerPizza() * getQuantity();
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		return getPricePerPizza() * getQuantity();
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		return getOrderPrice() - getOrderCost();
	}
	
	
	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		if(this.type.equals(new String("Margherita")))
		{
			if(topping.name().equals("CHEESE") || topping.name().equals("TOMATO"))
			{
				return true;
			}
		}
		if(this.type.equals(new String("Vegetarian")))
		{
			if(topping.name().equals("CHEESE") || topping.name().equals("TOMATO") 
					|| topping.name().equals("EGGPLANT") || topping.name().equals("MUSHROOM") 
					|| topping.name().equals("CAPSICUM"))
			{
				return true;
			}
		}
		if(this.type.equals(new String("Meat Lovers")))
		{
			if(topping.name().equals("CHEESE") || topping.name().equals("TOMATO") 
					|| topping.name().equals("BACON") || topping.name().equals("PEPPARONI") 
					|| topping.name().equals("SALAMI"))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		return this.quantity; 
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		return this.type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
