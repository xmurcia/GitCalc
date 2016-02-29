package calc;
import java.awt.Container;

public class Main {

	public static void main(String args[]) {
		Calculator calci = new Calculator();
		Container contentPane = calci.getContentPane();
//		contentPane.setLayout(new BorderLayout());
		calci.setTitle("Java Swing Calculator");
		calci.setSize(241, 217);
		calci.pack();
		calci.setLocation(400, 250);
		calci.setVisible(true);
		calci.setResizable(false);
	}

}
