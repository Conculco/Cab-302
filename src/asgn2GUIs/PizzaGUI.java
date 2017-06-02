package asgn2GUIs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JPanel;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
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
	private static final long serialVersionUID = 1L;
	//Window Width/Height
	private static final int WIDTH = 400;
	private static final int HEIGHT = 500;
	
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
	PizzaRestaurant p = new PizzaRestaurant();
	int fileIndexSize = p.getNumCustomerOrders();
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		this.setTitle(title);
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
	private void clearPanel()
	{
		index = 0;
		fileIndexSize = 0;
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
			try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("./logs"));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				fileName = selectedFile.toString();
				if(p.processLog(fileName))
				{
					updateText(index);
			    //Button Gray Out
			    btnUnload.setEnabled(true);
			    btnNext.setEnabled(true); 
			    btnDaily.setEnabled(true);
			    btnLoad.setEnabled(false);
				} else {
					p.resetDetails();
					JOptionPane.showMessageDialog(pnlDisplay, "Log File is invalid");
				}
			}
			} catch (CustomerException e1) {
				JOptionPane.showMessageDialog(pnlDisplay, e1.getMessage() + " : Please check log file for errors");
				p.resetDetails();
				e1.printStackTrace();
			} catch (PizzaException e1) {
				JOptionPane.showMessageDialog(pnlDisplay, e1.getMessage() + " : Please check log file for errors");
				p.resetDetails();
				e1.printStackTrace();
			} catch (LogHandlerException e1) {
				JOptionPane.showMessageDialog(pnlDisplay, e1.getMessage() + " : Please check log file for errors");
				p.resetDetails();
				e1.printStackTrace();
			}
		}  

		if (src==btnUnload) {
			p.resetDetails();
			clearPanel();
		    btnUnload.setEnabled(false);
		    btnBack.setEnabled(false); 
		    btnNext.setEnabled(false); 
		    btnDaily.setEnabled(false); 
		    btnLoad.setEnabled(true);
		}
		if (src==btnNext) {
			btnBack.setEnabled(true);
			index++;
			if (index == p.getNumCustomerOrders() - 1){
				btnNext.setEnabled(false);
			}
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
			btnDaily.setEnabled(false);
			try {
				double PizzaQty = 0;
				double PizzaPrice = 0;
				double PizzaCost = 0;
				double PizzaProfit = 0;
				double Distance = 0;
				
				for (int i = 0; i < p.getNumCustomerOrders(); i++) {
					PizzaQty += p.getPizzaByIndex(i).getQuantity();
					PizzaPrice += p.getPizzaByIndex(i).getOrderPrice();
					PizzaCost += p.getPizzaByIndex(i).getOrderCost();
					PizzaProfit = p.getTotalProfit();
					Distance = p.getTotalDeliveryDistance();
				}
				textDailyPizzaQty.setText(String.valueOf(PizzaQty));
				textDailyPizzaPrice.setText(String.valueOf(PizzaPrice));
				textDailyPizzaCost.setText(String.valueOf(PizzaCost));
				textDailyPizzaProfit.setText(String.valueOf(PizzaProfit));
				textDailyDistance.setText(String.valueOf(Distance));
				
			} catch (PizzaException e1) {
				JOptionPane.showMessageDialog(pnlDisplay, e1.getMessage() + " : Please check log file for errors");
			}
		}
	}

	public void updateText(int index){
		try {
			//System.out.println("Uindex: " + index + "\n UfileIndexSize: " + fileIndexSize);
			textPizzaType.setText(p.getPizzaByIndex(index).getPizzaType());
			textPizzaQty.setText(String.valueOf(p.getPizzaByIndex(index).getQuantity()));
			textPizzaQty.setText(String.valueOf(p.getPizzaByIndex(index).getQuantity()));
			textPizzaPrice.setText(String.valueOf(p.getPizzaByIndex(index).getOrderPrice()));
			textPizzaCost.setText(String.valueOf(p.getPizzaByIndex(index).getOrderCost()));
			textPizzaProfit.setText(String.valueOf(p.getPizzaByIndex(index).getOrderProfit()));
			textCustomerName.setText(p.getCustomerByIndex(index).getName());
			textCustomerMobile.setText(p.getCustomerByIndex(index).getMobileNumber());
			textCustomerType.setText(p.getCustomerByIndex(index).getCustomerType());
			textCustomerX.setText(String.valueOf(p.getCustomerByIndex(index).getLocationX()));
			textCustomerY.setText(String.valueOf(p.getCustomerByIndex(index).getLocationY()));
			textCustomerDistance.setText(String.valueOf(p.getCustomerByIndex(index).getDeliveryDistance()));
			
		} catch (PizzaException e1) {
			JOptionPane.showMessageDialog(pnlDisplay, e1.getMessage() + " : Please check log file for errors");
			e1.printStackTrace();
		} catch (CustomerException e1) {
			JOptionPane.showMessageDialog(pnlDisplay, e1.getMessage() + " : Please check log file for errors");
			e1.printStackTrace();
		}
	}
}
