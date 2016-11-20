package vue;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
	public MyFrame(String name, Dimension d) throws SQLException {
		super(name);
		Login l = new Login();
		
		/*Personne p = new Personne(1, "Pat", "Tom", "A chier");
		List<Personne> li = new ArrayList<Personne>();
		p.addFils(new Personne(3, "test", "paul", "Très bien"));
		p.addFils(new Personne(4, "second", "pierre", "Très nul"));
		
		InterfacePersonne l = new InterfacePersonne(p);*/
		this.setContentPane(l);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(d);
		this.setLocationRelativeTo(null);

	}
	
}
