package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import domaine.Personne;
import vue.InterfacePersonne;

public class ValiderLoginListener implements ActionListener{

	private JTextField saisieID;
	private JPanel j;

	public ValiderLoginListener(JTextField id, JPanel f) {
		// TODO Auto-generated constructor stub
		saisieID = id;
		j = f;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Personne p;
		//PersonneMapper pm = new PersonneMapper();
		//p = pm.findById(saisieID.getText());
		
		p = new Personne(1, "Pat", "Tom", "A chier");
		p.setPere(new Personne(2, "Bibi", "Jean", "Nul"));
		List<Personne> l = new ArrayList<Personne>();
		l.add(new Personne(3, "test", "paul", "Très bien"));
		l.add(new Personne(4, "second", "pierre", "Très nul"));

		
		try {
			InterfacePersonne ip = new InterfacePersonne(p);
			j.removeAll();
			j.add(ip);
			j.updateUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
