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
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	
	//Panel
	private JPanel pnlDisplay;
	private JPanel pnlBtn;
	
	//Buttons
	private JButton btnLoad;
	private JButton btnUnload;
	private JButton btnFind;
	private JButton btnSwitch;
	
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
	    btnFind = createButton("Find");
	    btnSwitch = createButton("Switch");
	    //Place Buttons ON GUI 
	    
	    
	    textCustomerName = createTextField();
		textCustomerMobile = createTextField();
		textCustomerType = createTextField();
		textCustomerX = createTextField();
		textCustomerY = createTextField();
		textCustomerDistance = createTextField();
		
		textPizzaType = createTextField();
		textPizzaQty = createTextField();
		textPizzaPrice = createTextField();
		textPizzaCost = createTextField();
		textPizzaProfit = createTextField();
		

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
	    addToPanel(pnlBtn, btnUnload,constraints,3,0,2,1); 
	    addToPanel(pnlBtn, btnFind,constraints,0,2,2,1); 
	    addToPanel(pnlBtn, btnSwitch,constraints,3,2,2,1); 	
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
			    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			    
				FileInputStream fstream;
				try {
					fstream = new FileInputStream(selectedFile.getAbsolutePath());
						try{
							BufferedReader s = new BufferedReader(new InputStreamReader(fstream));
							String strLine;
							while ((strLine = s.readLine()) != null)   {
								System.out.println (strLine);
								//areDisplay.append(strLine);
								//areDisplay.append("\n");
							}
						}
						catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			}  
		}
		if (src==btnUnload) {
			textCustomerName.setText("");
		}
		if (src==btnSwitch) {
			JOptionPane.showMessageDialog(this,"A Warning Message","Wiring Class: Warning",JOptionPane.WARNING_MESSAGE);
		}
		if (src==btnFind) {
			JOptionPane.showMessageDialog(this,"An Error Message","Wiring Class: Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		    JFrame.setDefaultLookAndFeelDecorated(true);
	        SwingUtilities.invokeLater(new PizzaGUI("BorderLayout"));
	}
	

}
