package vue;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import domaine.Personne;

public class MyFrame extends JFrame{
	
	public MyFrame(String name, Dimension d) throws SQLException {
		super(name);
		//Login l = new Login(this);

		Personne p = new Personne(1, "Pat", "Tom", "A chier");
		List<Personne> li = new ArrayList<Personne>();
		p.addFils(new Personne(3, "test", "paul", "Très bien"));
		p.addFils(new Personne(4, "second", "pierre", "Très nul"));
		
		InterfacePersonne l = new InterfacePersonne(p);
		this.setContentPane(l);
		this.setVisible(true);
		this.setSize(d);
		this.setLocationRelativeTo(null);
		this.setResizable(true);

	}
	
}
