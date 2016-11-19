package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import domaine.Personne;
import vue.InterfacePersonne;

public class ValiderLoginListener implements ActionListener{

	private JTextField saisieID;
	private JPanel j, t;

	public ValiderLoginListener(JTextField id, JPanel f) {
		// TODO Auto-generated constructor stub
		saisieID = id;
		j = f;
		t = new JPanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Personne p;
		//PersonneMapper pm = new PersonneMapper();
		//p = pm.findById(saisieID.getText());
		
		p = new Personne(1, "Pat", "Tom", "A chier");
		InterfacePersonne ip = new InterfacePersonne(p);
		j.removeAll();
		j.updateUI();
	}

}
