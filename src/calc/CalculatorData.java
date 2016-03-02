package calc;


/**

@author Xavi Murcia Daniel Perez
**/
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalculatorData {
	public int displayMode;
	public boolean clearOnNextDigit;
	public boolean percent;
	public double lastNumber;
	public String lastOperator;
	public JMenu jmenuFile;
	public JMenu jmenuHelp;
	public JMenuItem jmenuitemExit;
	public JMenuItem jmenuitemAbout;
	public JLabel jlbOutput;
	public JPanel jplButtons;
	public Font f12;
	public Font f121;

	public CalculatorData(Font f12, Font f121) {
		this.f12 = f12;
		this.f121 = f121;
	}
}