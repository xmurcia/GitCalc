package calc;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class Listener_Buttons extends Other_Methods {

	public Listener_Buttons() throws HeadlessException {
		super();
	}

	public Listener_Buttons(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public Listener_Buttons(String arg0) throws HeadlessException {
		super(arg0);
	}

	public Listener_Buttons(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

	public void actionPerformed(ActionEvent e) {
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

}