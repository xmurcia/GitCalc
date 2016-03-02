package calc;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

public class Other_Methods extends Create_GUI {

	public Other_Methods() throws HeadlessException {
		super();
	}

	public Other_Methods(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public Other_Methods(String arg0) throws HeadlessException {
		super(arg0);
	}

	public Other_Methods(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

	protected void setDisplayString(String s) {
		data.jlbOutput.setText(s);
	}

	protected String getDisplayString() {
		return data.jlbOutput.getText();
	}

	protected void addDigitToDisplay(int digit) {
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

	protected void addDecimalPoint() {
		data.displayMode = Global.INPUT_MODE;
	
		if (data.clearOnNextDigit)
			setDisplayString("");
	
		String inputString = getDisplayString();
	
		// If the input string already contains a decimal point, don't
		//  do anything to it.
		if (inputString.indexOf(".") < 0)
			setDisplayString(new String(inputString + "."));
	}

	protected void processSignChange() {
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

	protected void clearAll() {
		setDisplayString("0");
		data.lastOperator = "0";
		data.lastNumber = 0;
		data.displayMode = Global.INPUT_MODE;
		data.clearOnNextDigit = true;
	}

	protected void clearExisting() {
		setDisplayString("0");
		data.clearOnNextDigit = true;
		data.displayMode = Global.INPUT_MODE;
	}

	protected double getNumberInDisplay() {
		String input = data.jlbOutput.getText();
		return Double.parseDouble(input);
	}

	protected void processOperator(String op) {
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

	protected void processEquals() {
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

	protected void displayResult(double result) {
		setDisplayString(Double.toString(result));
		data.lastNumber = result;
		data.displayMode = Global.RESULT_MODE;
		data.clearOnNextDigit = true;
	}

	protected void displayError(String errorMessage) {
		setDisplayString(errorMessage);
		data.lastNumber = 0;
		data.displayMode = Global.ERROR_MODE;
		data.clearOnNextDigit = true;
	}

}