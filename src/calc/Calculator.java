package calc;
/**

@author Xavi Murcia Daniel Perez
**/

/*
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
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends Listener_Buttons implements ActionListener{
	/*
	 * Variables in class "Global"
	 */
	


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



