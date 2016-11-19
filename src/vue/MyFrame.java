package vue;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame(String name, Dimension d) {
		super(name);
		this.setPreferredSize(d);
		Login l = new Login(this);
		
		
		this.setContentPane(l);
		this.setVisible(true);
		this.setSize(d);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
}
