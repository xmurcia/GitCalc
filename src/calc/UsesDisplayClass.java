package calc;
import javax.swing.JLabel;

public class UsesDisplayClass {
	static boolean clearOnNextDigit;
	static int displayMode;
	final static int INPUT_MODE = 0;
	final static int MAX_INPUT_LENGTH = 20;
	private static JLabel jlbOutput;
	
	static void addDigitToDisplay(int digit){
		if (clearOnNextDigit)
			setDisplayString("");

		String inputString = getDisplayString();
		
		if (inputString.indexOf("0") == 0){
			inputString = inputString.substring(1);
		}

		if ((!inputString.equals("0") || digit > 0)  && inputString.length() < MAX_INPUT_LENGTH){
			setDisplayString(inputString + digit);
		}
		

		displayMode = INPUT_MODE;
		clearOnNextDigit = false;
	}
	
	static String getDisplayString (){
		return jlbOutput.getText();
	}
	static void setDisplayString(String s){
		jlbOutput.setText(s);
	}
}
