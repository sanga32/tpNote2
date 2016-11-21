package vue;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
	public MyFrame(String name, Dimension d) throws SQLException {
		super(name);
		Login l = new Login();
		this.setContentPane(l);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(d);
		this.setLocationRelativeTo(null);

	}
	
}
