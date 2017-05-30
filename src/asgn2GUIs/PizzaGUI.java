package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
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
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	

	private JPanel pnlDisplay;
	private JPanel pnlTwo;
	private JPanel pnlBtn;
	private JPanel pnlFour;
	private JPanel pnlFive;
	
	private JButton btnLoad;
	private JButton btnUnload;
	private JButton btnFind;
	private JButton btnSwitch;
	
	private JTextArea areDisplay; 
	
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
	    pnlTwo = createPanel(Color.LIGHT_GRAY);
	    pnlBtn = createPanel(Color.LIGHT_GRAY);
	    pnlFour = createPanel(Color.LIGHT_GRAY);
	    pnlFive = createPanel(Color.LIGHT_GRAY);
	    
	    btnLoad = createButton("Load");
	    btnUnload = createButton("Unload");
	    btnFind = createButton("Find");
	    btnSwitch = createButton("Switch");
	    
	    areDisplay = createTextArea();
	    
	    pnlDisplay.setLayout(new BorderLayout());
	    pnlDisplay.add(areDisplay, BorderLayout.CENTER);
	 
	    layoutButtonPanel(); 
	    
	    this.getContentPane().add(pnlDisplay,BorderLayout.CENTER);
	    this.getContentPane().add(pnlTwo,BorderLayout.NORTH);
	    this.getContentPane().add(pnlBtn,BorderLayout.SOUTH);
	    this.getContentPane().add(pnlFour,BorderLayout.EAST);
	    this.getContentPane().add(pnlFive,BorderLayout.WEST);
	    repaint(); 
	    this.setVisible(true);
	}
	
	@Override
	public void run() {
		// TO DO
		createGUI();
	}

	private JPanel createPanel(Color c) {
		JPanel jp = new JPanel();
		jp.setBackground(c);
		return jp;
	}
	
	private JButton createButton(String str) {
		JButton jb = new JButton(str); 
		jb.addActionListener(this);
		return jb; 
	}
	
	private JTextArea createTextArea() {
		JTextArea jta = new JTextArea(); 
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setFont(new Font("Arial",Font.BOLD,24));
		jta.setBorder(BorderFactory.createEtchedBorder());
		return jta;
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
	   
		/**
		 * @param args
		 */
		public static void main(String[] args) {
		    JFrame.setDefaultLookAndFeelDecorated(true);
	        SwingUtilities.invokeLater(new PizzaGUI("BorderLayout"));
		}
	

}
