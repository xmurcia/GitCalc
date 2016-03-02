package calc;

/**

@author Xavi Murcia Daniel Perez
**/

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Buttons extends JFrame {

	protected JButton jbnButtons[];
	protected JPanel jplMaster;
	protected JPanel jplBackSpace;
	protected JPanel jplControl;

	public Buttons() throws HeadlessException {
		super();
	}

	public Buttons(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public Buttons(String arg0) throws HeadlessException {
		super(arg0);
	}

	public Buttons(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

}