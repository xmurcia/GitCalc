package calc;

/**

@author Xavi Murcia Daniel Perez
**/
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import org.junit.Before;
import org.junit.Test;

public class Create_GUI extends Buttons {
	CalculatorData data = new CalculatorData(new Font("DejaVu Sans", 0, 20), new Font("DejaVu Sans",  1, 20));
	
	
	public Create_GUI() throws HeadlessException {
		super();
	}

	
	public Create_GUI(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public Create_GUI(String arg0) throws HeadlessException {
		super(arg0);
	}

	public Create_GUI(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

	/**
	 * Returns an array to Calculator class where buttons are loaded  
	 * @return      Array of created buttons
	 */
	public JButton[] creaBotons() {
		
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
	
	
	
	public JPanel creaJPLButtons() {
		
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

	public JMenu creaMenuFile() {
		
		data.jmenuFile = new JMenu();
		data.jmenuFile.setFont(data.f121);
		data.jmenuFile.setMnemonic(KeyEvent.VK_F);
		
		return data.jmenuFile;
		
	}

	public JMenuItem creaMenuItem() {
		data.jmenuitemExit = new JMenuItem("Exit");
		data.jmenuitemExit.setFont(data.f12);
		data.jmenuitemExit.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X, 
													ActionEvent.CTRL_MASK));
		return data.jmenuitemExit;
		
	}

	public JMenu creaMenuAjuda() {
		data.jmenuHelp = new JMenu("Help");
		data.jmenuHelp.setFont(data.f121);
		data.jmenuHelp.setMnemonic(KeyEvent.VK_H);	
		return data.jmenuHelp;
		
	}

}