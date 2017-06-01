package asgn2GUIs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy� class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature � as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 500;
	
	//Panel
	private JPanel pnlDisplay;
	private JPanel pnlBtn;
	
	//Buttons
	private JButton btnLoad;
	private JButton btnUnload;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnDaily;
	
	//TextFields Customers
	private JTextField textCustomerName;
	private JTextField textCustomerMobile;
	private JTextField textCustomerType;
	private JTextField textCustomerX;
	private JTextField textCustomerY;
	private JTextField textCustomerDistance;
	
	//TextFields Pizza
	private JTextField textPizzaType;
	private JTextField textPizzaQty;
	private JTextField textPizzaPrice;
	private JTextField textPizzaCost;
	private JTextField textPizzaProfit;
	
	//Daily Totals
	private JTextField textDailyPizzaQty;
	private JTextField textDailyPizzaPrice;
	private JTextField textDailyPizzaCost;
	private JTextField textDailyPizzaProfit;
	private JTextField textDailyDistance;
	
	String fileName = "";
	int index = 0;
	int fileIndexSize = 0;

	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		
	}

	private void createGUI() {
		setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
	    
	    pnlDisplay = createPanel(Color.WHITE);
	    pnlBtn = createPanel(Color.LIGHT_GRAY);

	    btnLoad = createButton("Load");
	    btnUnload = createButton("Unload");
	    btnBack = createButton("Back");
	    btnNext = createButton("Next");
	    btnDaily = createButton("Daily");
	      
	    //Customer
	    textCustomerName = createTextField();
		textCustomerMobile = createTextField();
		textCustomerType = createTextField();
		textCustomerX = createTextField();
		textCustomerY = createTextField();
		textCustomerDistance = createTextField();
		
		//Pizza
		textPizzaType = createTextField();
		textPizzaQty = createTextField();
		textPizzaPrice = createTextField();
		textPizzaCost = createTextField();
		textPizzaProfit = createTextField();
		
		//Daily Totals
		textDailyPizzaQty = createTextField();
		textDailyPizzaPrice = createTextField();
		textDailyPizzaCost = createTextField();
		textDailyPizzaProfit = createTextField();
		textDailyDistance = createTextField();
		
		

		GridLayout Layout = new GridLayout(0,2);
		pnlDisplay.setLayout(Layout);
		pnlDisplay.add(new JLabel("Customers "));
		pnlDisplay.add(new JLabel(""));
		pnlDisplay.add(new JLabel("Customer: "));
		pnlDisplay.add(textCustomerName);
		pnlDisplay.add(new JLabel("Customer Mobile: "));
		pnlDisplay.add(textCustomerMobile);
		pnlDisplay.add(new JLabel("Customer Type: "));
		pnlDisplay.add(textCustomerType);
		pnlDisplay.add(new JLabel("Customer X: "));
		pnlDisplay.add(textCustomerX);
		pnlDisplay.add(new JLabel("Customer Y: "));
		pnlDisplay.add(textCustomerY);
		pnlDisplay.add(new JLabel("Customer Distance: "));
		pnlDisplay.add(textCustomerDistance);
		
		pnlDisplay.add(new JLabel("Pizza's "));
		pnlDisplay.add(new JLabel(""));
		pnlDisplay.add(new JLabel("Pizza Type: "));
		pnlDisplay.add(textPizzaType);
		pnlDisplay.add(new JLabel("Pizza Qty: "));
		pnlDisplay.add(textPizzaQty);
		pnlDisplay.add(new JLabel("Pizza Price: "));
		pnlDisplay.add(textPizzaPrice);
		pnlDisplay.add(new JLabel("Pizza Cost: "));
		pnlDisplay.add(textPizzaCost);
		pnlDisplay.add(new JLabel("Pizza Profit: "));
		pnlDisplay.add(textPizzaProfit);
		
		pnlDisplay.add(new JLabel("Daily Totals "));
		pnlDisplay.add(new JLabel(""));
		pnlDisplay.add(new JLabel("Daily Pizza Qty: "));
		pnlDisplay.add(textDailyPizzaQty);
		pnlDisplay.add(new JLabel("Daily Pizza Price: "));
		pnlDisplay.add(textDailyPizzaPrice);
		pnlDisplay.add(new JLabel("Daily Pizza Cost: "));
		pnlDisplay.add(textDailyPizzaCost);
		pnlDisplay.add(new JLabel("Daily Pizza Profit: "));
		pnlDisplay.add(textDailyPizzaProfit);
		pnlDisplay.add(new JLabel("Daily Customer Distance: "));
		pnlDisplay.add(textDailyDistance);
		
		
		layoutButtonPanel(); 
		
		this.getContentPane().add(pnlDisplay,BorderLayout.CENTER);
	    this.getContentPane().add(pnlBtn,BorderLayout.SOUTH);
	    
	    repaint(); 
	    this.setVisible(true);
	}
	
	@Override
	public void run() {
		createGUI();
	}

	private JPanel createPanel(Color c) {
		JPanel jp = new JPanel();
		jp.setBackground(c);
		return jp;
	}
	
	private JButton createButton(String name) {
		JButton jb = new JButton(name); 
		jb.addActionListener(this);
		return jb; 
	}
	
	private JTextField createTextField() {
		JTextField jtf = new JTextField("",30);
		jtf.addActionListener(this);
		return jtf;
	}
	
	private void layoutButtonPanel() {
		GridBagLayout layout = new GridBagLayout();
	    pnlBtn.setLayout(layout);
	    
	    //add components to grid
	    GridBagConstraints constraints = new GridBagConstraints(); 
	    
	    //Defaults
	    constraints.fill = GridBagConstraints.NONE;
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 100;
	    constraints.weighty = 100;

	    //Add Buttons to GUI
	    addToPanel(pnlBtn, btnLoad,constraints,0,0,2,1); 
	    addToPanel(pnlBtn, btnUnload,constraints,9,2,2,1); 
	    addToPanel(pnlBtn, btnBack,constraints,0,2,2,1); 
	    addToPanel(pnlBtn, btnNext,constraints,3,2,2,1);
	    addToPanel(pnlBtn, btnDaily,constraints,6,2,2,1);
	    
	    //Button Gray Out
	    btnUnload.setEnabled(false);
	    btnBack.setEnabled(false); 
	    btnNext.setEnabled(false); 
	    btnDaily.setEnabled(false); 
	    
	    
	    
	}
	
	private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints, int x, int y, int w, int h) {  
		      constraints.gridx = x;
		      constraints.gridy = y;
		      constraints.gridwidth = w;
		      constraints.gridheight = h;
		      jp.add(c, constraints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Get event source 
		Object src=e.getSource(); 
	      
		//Consider the alternatives - not all active at once. 
		if (src== btnLoad) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("./logs"));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = fileChooser.getSelectedFile();
			    fileName = selectedFile.toString();
			    updateText(index);
			    
			    //Button Gray Out
			    btnUnload.setEnabled(true);
			    btnNext.setEnabled(true); 
			    btnDaily.setEnabled(true);
			    btnLoad.setEnabled(false);
			    
			}  
		}
		if (src==btnUnload) {
			index = 0;
			fileName = "";
			textPizzaType.setText("");
			textPizzaQty.setText("");
			textPizzaPrice.setText("");
			textPizzaCost.setText("");
			textPizzaProfit.setText("");
			textCustomerName.setText("");
			textCustomerMobile.setText("");
			textCustomerType.setText("");
			textCustomerX.setText("");
			textCustomerY.setText("");
			textCustomerDistance.setText("");
			textDailyPizzaQty.setText("");
			textDailyPizzaPrice.setText("");
			textDailyPizzaCost.setText("");
			textDailyPizzaProfit.setText("");
			textDailyDistance.setText("");
			
		    btnUnload.setEnabled(false);
		    btnBack.setEnabled(false); 
		    btnNext.setEnabled(false); 
		    btnDaily.setEnabled(false); 
		    btnLoad.setEnabled(true);
		}
		if (src==btnNext) {
			btnBack.setEnabled(true);
			index++;
			if (index == fileIndexSize-1){
				btnNext.setEnabled(false);
			}
			System.out.println("index: " + index + "\n fileIndexSize: " + fileIndexSize);
			updateText(index);
		}
		if (src==btnBack) {
			btnNext.setEnabled(true);
			index--;
			if(index == 0){
				btnBack.setEnabled(false);
			}
			updateText(index);
		}
		if (src==btnDaily) {
			ArrayList<Pizza> pizza = null;
			ArrayList<Customer> Customer = null;
			try {
				pizza = LogHandler.populatePizzaDataset(fileName);
				Customer = LogHandler.populateCustomerDataset(fileName);
				
				double PizzaQty = 0;
				double PizzaPrice = 0;
				double PizzaCost = 0;
				double PizzaProfit = 0;
				double Distance = 0;
				
				for (int i = 0; i < pizza.size(); i++) {
					PizzaQty += pizza.get(i).getQuantity();
					PizzaPrice += pizza.get(i).getOrderPrice();
					PizzaCost += pizza.get(i).getOrderCost();
					PizzaProfit += pizza.get(i).getOrderProfit();
					Distance += Customer.get(i).getDeliveryDistance();
				}
				
				textDailyPizzaQty.setText(String.valueOf(PizzaQty));
				textDailyPizzaPrice.setText(String.valueOf(PizzaPrice));
				textDailyPizzaCost.setText(String.valueOf(PizzaCost));
				textDailyPizzaProfit.setText(String.valueOf(PizzaProfit));
				textDailyDistance.setText(String.valueOf(Distance));
				
			} catch (PizzaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LogHandlerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CustomerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void updateText(int index){
		try {
			ArrayList<Pizza> pizza = null;
			pizza = LogHandler.populatePizzaDataset(fileName);
			fileIndexSize = pizza.size();
			System.out.println("Uindex: " + index + "\n UfileIndexSize: " + fileIndexSize);
			textPizzaType.setText(pizza.get(index).getPizzaType());
			textPizzaQty.setText(String.valueOf(pizza.get(index).getQuantity()));
			textPizzaPrice.setText(String.valueOf(pizza.get(index).getOrderPrice()));
			textPizzaCost.setText(String.valueOf(pizza.get(index).getOrderCost()));
			textPizzaProfit.setText(String.valueOf(pizza.get(index).getOrderProfit()));
			
			ArrayList<Customer> Customer = null;
			Customer = LogHandler.populateCustomerDataset(fileName);
			fileIndexSize = Customer.size();
			textCustomerName.setText(Customer.get(index).getName());
			textCustomerMobile.setText(Customer.get(index).getMobileNumber());
			textCustomerType.setText(Customer.get(index).getCustomerType());
			textCustomerX.setText(String.valueOf(Customer.get(index).getLocationX()));
			textCustomerY.setText(String.valueOf(Customer.get(index).getLocationY()));
			textCustomerDistance.setText(String.valueOf(Customer.get(index).getDeliveryDistance()));
			
		} catch (PizzaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LogHandlerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CustomerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		    JFrame.setDefaultLookAndFeelDecorated(true);
	        SwingUtilities.invokeLater(new PizzaGUI("BorderLayout"));
	}
	

}
