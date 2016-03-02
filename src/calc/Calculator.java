package calc;
/*
Name: Hemanth. B
Website: http://www.java-swing-tutorial.com

Topic: A basic Java Swing Calculator

Conventions Used in Source code
---------------------------------
	1. All JLabel components start with jlb*
	2. All JPanel components start with jpl*
	3. All JMenu components start with jmenu*
	4. All JMenuItem components start with jmenuItem*
	5. All JDialog components start with jdlg*
	6. All JButton components start with jbn*
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Calculator extends Buttons implements ActionListener{
	/*
	 * Variables in class "Global"
	 */
	
	CalculatorData data = new CalculatorData(new Font("DejaVu Sans", 0, 20), new Font("DejaVu Sans",  1, 20));


	// Constructor 
	public Calculator() 
	{
		/* 
		 * Load all GUI features
		 */ 
		loadGUI();
		

		data.jmenuitemAbout = new JMenuItem("About Calculator");
		data.jmenuitemAbout.setFont(data.f12);
		data.jmenuHelp.add(data.jmenuitemAbout);
		
		JMenuBar mb = new JMenuBar();
		mb.add(data.jmenuFile);
		mb.add(data.jmenuHelp);
		setJMenuBar(mb);
		
		//Set  frame layout manager.

		this.setBackground(Color.gray);

		jplMaster = new JPanel();
		
		
		
		data.jlbOutput = new JLabel("0");
		data.jlbOutput.setHorizontalTextPosition(JLabel.RIGHT);
		data.jlbOutput.setBackground(Color.red);
		data.jlbOutput.setOpaque(true);
		
		// Add components to frame
		getContentPane().add(data.jlbOutput, BorderLayout.NORTH);
		
		//Function to create all calculator buttons
		jbnButtons = creaBotons();
		data.jplButtons = creaJPLButtons();	
		
		
		jplBackSpace = new JPanel();
		jplBackSpace.setLayout(new GridLayout(1, 1, 2, 2));
		jplBackSpace.add(jbnButtons[20]);
		jplControl = new JPanel();
		jplControl.setLayout(new GridLayout(1, 2, 2 ,2));
		jplControl.add(jbnButtons[21]);
		jplControl.add(jbnButtons[22]);

//		Setting all Numbered JButton's to Blue. The rest to Red
		for (int i=0; i<jbnButtons.length; i++)	{
			jbnButtons[i].setFont(data.f12);

			if (i<10)
				jbnButtons[i].setForeground(Color.orange);
				
			else
				jbnButtons[i].setForeground(Color.GREEN);
		}
	
		// Set panel layout manager for a 4 by 5 grid
		
		
		jplMaster.setLayout(new BorderLayout());
		jplMaster.add(jplBackSpace, BorderLayout.WEST);
		jplMaster.add(jplControl, BorderLayout.EAST);
		jplMaster.add(data.jplButtons, BorderLayout.SOUTH);

		// Add components to frame
		getContentPane().add(jplMaster, BorderLayout.SOUTH);
		requestFocus();
		
		//activate ActionListener
		for (int i=0; i<jbnButtons.length; i++){
			jbnButtons[i].addActionListener(this);
		}
		
		data.jmenuitemAbout.addActionListener(this);
		data.jmenuitemExit.addActionListener(this);

		clearAll();

		//add WindowListener for closing frame and ending program
		addWindowListener(new WindowAdapter() {

				public void windowClosed(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	//End of Contructor Calculator

	// Perform action
	public void actionPerformed(ActionEvent e){
		double result = 0;
	   
		if(e.getSource() == data.jmenuitemAbout){
			JDialog dlgAbout = new CustomABOUTDialog(this, "About Java Swing Calculator", true);
			dlgAbout.setVisible(true);
		}else if(e.getSource() == data.jmenuitemExit){
			System.exit(0);
		}	

		// Search for the button pressed until end of array or key found
		for (int i=0; i<jbnButtons.length; i++)
		{
			if(e.getSource() == jbnButtons[i])
			{
				switch(i)
				{
					case 0:
						addDigitToDisplay(i);
						break;

					case 1:
						addDigitToDisplay(i);
						break;

					case 2:
						addDigitToDisplay(i);
						break;

					case 3:
						addDigitToDisplay(i);
						break;

					case 4:
						addDigitToDisplay(i);
						break;

					case 5:
						addDigitToDisplay(i);
							break;

					case 6:
						addDigitToDisplay(i);
						break;

					case 7:
						addDigitToDisplay(i);
						break;

					case 8:
						addDigitToDisplay(i);
						break;

					case 9:
						addDigitToDisplay(i);
						break;

					case 10:	// +/-
						processSignChange();
						break;

					case 11:	// decimal point
						addDecimalPoint();
						break;

					case 12:	// =
						processEquals();
						break;

					case 13:	// divide
						processOperator("/");
						break;

					case 14:	// *
						processOperator("*");
						break;

					case 15:	// -
						processOperator("-");
						break;

					case 16:	// +
						processOperator("+");
						break;

					case 17:	// sqrt
						if (data.displayMode != Global.ERROR_MODE)
						{
							try
							{
								if (getDisplayString().indexOf("-") == 0)
									displayError("Invalid input for function!");

								result = Math.sqrt(getNumberInDisplay());
								displayResult(result);
							}

							catch(Exception ex)
							{
								displayError("Invalid input for function!");
								data.displayMode = Global.ERROR_MODE;
							}
						}
						break;

					case 18:	// 1/x
						if (data.displayMode != Global.ERROR_MODE){
							try
							{
								if (getNumberInDisplay() == 0)
									displayError("Cannot divide by zero!");
	
								result = 1 / getNumberInDisplay();
								displayResult(result);
							}
							
							catch(Exception ex)	{
								displayError("Cannot divide by zero!");
								data.displayMode = Global.ERROR_MODE;
							}
						}
						break;

					case 19:	// %
						if (data.displayMode != Global.ERROR_MODE){
							try	{
								result = getNumberInDisplay() / 100;
								displayResult(result);
							}
	
							catch(Exception ex)	{
								displayError("Invalid input for function!");
								data.displayMode = Global.ERROR_MODE;
							}
						}
						break;

					case 20:	// backspace
						if (data.displayMode != Global.ERROR_MODE){
							setDisplayString(getDisplayString().substring(0,
										getDisplayString().length() - 1));
							
							if (getDisplayString().length() < 1)
								setDisplayString("0");
						}
						break;

					case 21:	// CE
						clearExisting();
						break;

					case 22:	// C
						clearAll();
						break;
				}
			}
		}
	}

	
	
	void setDisplayString(String s){
		data.jlbOutput.setText(s);
	}

	String getDisplayString (){
		return data.jlbOutput.getText();
	}

	void addDigitToDisplay(int digit){
		if (data.clearOnNextDigit)
			setDisplayString("");

		String inputString = getDisplayString();
		
		if (inputString.indexOf("0") == 0){
			inputString = inputString.substring(1);
		}

		if ((!inputString.equals("0") || digit > 0)  && inputString.length() < Global.MAX_INPUT_LENGTH){
			setDisplayString(inputString + digit);
		}
		

		data.displayMode = Global.INPUT_MODE;
		data.clearOnNextDigit = false;
	}

	void addDecimalPoint(){
		data.displayMode = Global.INPUT_MODE;

		if (data.clearOnNextDigit)
			setDisplayString("");

		String inputString = getDisplayString();
	
		// If the input string already contains a decimal point, don't
		//  do anything to it.
		if (inputString.indexOf(".") < 0)
			setDisplayString(new String(inputString + "."));
	}

	void processSignChange(){
		if (data.displayMode == Global.INPUT_MODE)
		{
			String input = getDisplayString();

			if (input.length() > 0 && !input.equals("0"))
			{
				if (input.indexOf("-") == 0)
					setDisplayString(input.substring(1));

				else
					setDisplayString("-" + input);
			}
			
		}

		else if (data.displayMode == Global.RESULT_MODE)
		{
			double numberInDisplay = getNumberInDisplay();
		
			if (numberInDisplay != 0)
				displayResult(-numberInDisplay);
		}
	}

	void clearAll()	{
		setDisplayString("0");
		data.lastOperator = "0";
		data.lastNumber = 0;
		data.displayMode = Global.INPUT_MODE;
		data.clearOnNextDigit = true;
	}

	void clearExisting(){
		setDisplayString("0");
		data.clearOnNextDigit = true;
		data.displayMode = Global.INPUT_MODE;
	}

	double getNumberInDisplay()	{
		String input = data.jlbOutput.getText();
		return Double.parseDouble(input);
	}

	void processOperator(String op) {
		if (data.displayMode != Global.ERROR_MODE)
		{
			double numberInDisplay = getNumberInDisplay();

			if (!data.lastOperator.equals("0"))	
			{
				try
				{
					double result = processLastOperator();
					displayResult(result);
					data.lastNumber = result;
				}

				catch (DivideByZeroException e)
				{
				}
			}
		
			else
			{
				data.lastNumber = numberInDisplay;
			}
			
			data.clearOnNextDigit = true;
			data.lastOperator = op;
		}
	}

	void processEquals(){
		double result = 0;

		if (data.displayMode != Global.ERROR_MODE){
			try			
			{
				result = processLastOperator();
				displayResult(result);
			}
			
			catch (DivideByZeroException e)	{
				displayError("Cannot divide by zero!");
			}

			data.lastOperator = "0";
		}
	}

	double processLastOperator() throws DivideByZeroException {
		double result = 0;
		double numberInDisplay = getNumberInDisplay();

		if (data.lastOperator.equals("/"))
		{
			if (numberInDisplay == 0)
				throw (new DivideByZeroException());

			result = data.lastNumber / numberInDisplay;
		}
			
		if (data.lastOperator.equals("*"))
			result = data.lastNumber * numberInDisplay;

		if (data.lastOperator.equals("-"))
			result = data.lastNumber - numberInDisplay;

		if (data.lastOperator.equals("+"))
			result = data.lastNumber + numberInDisplay;

		return result;
	}

	void displayResult(double result){
		setDisplayString(Double.toString(result));
		data.lastNumber = result;
		data.displayMode = Global.RESULT_MODE;
		data.clearOnNextDigit = true;
	}

	void displayError(String errorMessage){
		setDisplayString(errorMessage);
		data.lastNumber = 0;
		data.displayMode = Global.ERROR_MODE;
		data.clearOnNextDigit = true;
	}
	
	public JButton[] creaBotons(){
		
		jbnButtons = new JButton[23];
		// Create numeric Jbuttons
				for (int i=0; i<=9; i++)
				{
					// set each Jbutton label to the value of index
					jbnButtons[i] = new JButton(String.valueOf(i));
				}
				jbnButtons[10] = new JButton("+/-");
				jbnButtons[11] = new JButton(".");
				jbnButtons[12] = new JButton("=");
				jbnButtons[13] = new JButton("/");
				jbnButtons[14] = new JButton("*");
				jbnButtons[15] = new JButton("-");
				jbnButtons[16] = new JButton("+");
				jbnButtons[17] = new JButton("sqrt");
				jbnButtons[18] = new JButton("1/x");
				jbnButtons[19] = new JButton("%");
				jbnButtons[20] = new JButton("Backspace");
				jbnButtons[21] = new JButton(" CE ");
				jbnButtons[22] = new JButton("C");
				
		
		return jbnButtons ;
		
	}
	
	public JPanel creaJPLButtons(){
		
		data.jplButtons = new JPanel();
		
		data.jplButtons.setLayout(new GridLayout(4, 5, 2, 2));
		
		//Add buttons to keypad panel starting at top left
		// First row
		for(int i=7; i<=9; i++)		{
			data.jplButtons.add(jbnButtons[i]);
		}
		
		// add button / and sqrt
		data.jplButtons.add(jbnButtons[13]);
		data.jplButtons.add(jbnButtons[17]);
		
		// Second row
		for(int i=4; i<=6; i++)
		{
			data.jplButtons.add(jbnButtons[i]);
		}
		
		// add button * and x^2
		data.jplButtons.add(jbnButtons[14]);
		data.jplButtons.add(jbnButtons[18]);

		// Third row
		for( int i=1; i<=3; i++)
		{
			data.jplButtons.add(jbnButtons[i]);
		}
		
		//adds button - and %
		data.jplButtons.add(jbnButtons[15]);
		data.jplButtons.add(jbnButtons[19]);
		
		//Fourth Row
		// add 0, +/-, ., +, and =
		data.jplButtons.add(jbnButtons[0]);
		data.jplButtons.add(jbnButtons[10]);
		data.jplButtons.add(jbnButtons[11]);
		data.jplButtons.add(jbnButtons[16]);
		data.jplButtons.add(jbnButtons[12]);
		
		return data.jplButtons;
		
		
	}
	
	public JMenu creaMenuFile(){
		
		data.jmenuFile = new JMenu();
		data.jmenuFile.setFont(data.f121);
		data.jmenuFile.setMnemonic(KeyEvent.VK_F);
		
		return data.jmenuFile;
		
	}
	
	public JMenuItem creaMenuItem(){
		data.jmenuitemExit = new JMenuItem("Exit");
		data.jmenuitemExit.setFont(data.f12);
		data.jmenuitemExit.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X, 
													ActionEvent.CTRL_MASK));
		return data.jmenuitemExit;
		
	}
	
	public JMenu creaMenuAjuda(){
		data.jmenuHelp = new JMenu("Help");
		data.jmenuHelp.setFont(data.f121);
		data.jmenuHelp.setMnemonic(KeyEvent.VK_H);	
		return data.jmenuHelp;
		
	}
	
	public void loadGUI(){
				//CREA EL MENU
				data.jmenuFile = creaMenuFile();	
				//CREA ITEM DEL MENU
				data.jmenuitemExit = creaMenuItem();
				//AFEGEIX ITEMS AL MENU
				data.jmenuFile.add(data.jmenuitemExit);
				//AFEGEIX MENU DE AJUDA
				data.jmenuHelp = creaMenuAjuda();
	}
}		//End of Swing Calculator Class.



