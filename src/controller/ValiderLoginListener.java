package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domaine.Personne;
import persistance.PersonneMapper;
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
		if ( saisieID.getText().equals("")){
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "Veuillez entrer un ID", "Message d'erreur",  JOptionPane.ERROR_MESSAGE);


		}else{

			try {
				
				int id = Integer.parseInt(saisieID.getText());
				//Ici a la place on utilisera le mapper 
				p = PersonneMapper.getInstance().findById(id);

				/*p = new Personne(1, "Pat", "Tom", "A chier");
				p.setPere(new Personne(2, "Bibi", "Jean", "Nul"));
				List<Personne> l = new ArrayList<Personne>();
				p.addFils(new Personne(3, "test", "paul", "Très bien"));
				p.addFils(new Personne(4, "second", "pierre", "Très nul"));*/


				try {
					
					InterfacePersonne ip = null;
					try {
						ip = new InterfacePersonne(p);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					j.removeAll();
					j.add(ip);
					j.updateUI();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					JOptionPane jop3 = new JOptionPane();
					jop3.showMessageDialog(null, "Aucune personne avec cet ID", "Message d'erreur",  JOptionPane.ERROR_MESSAGE);

				}
			} catch (NumberFormatException e ){
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, "Veuillez entrer un ID correct !", "Message d'erreur",  JOptionPane.ERROR_MESSAGE);

			}
		}

	}

}
