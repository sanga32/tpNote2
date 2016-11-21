package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vue.Login;

/**
 * Classe listener du bouton annuler qui permet un retour à la page de login
 * @author Kevin Delporte, Alexandre Godon, Teddy Lequette 
 *
 */

public class AnnulerListener implements ActionListener {

	private JPanel j;
	
	public AnnulerListener(JPanel j) {
		// TODO Auto-generated constructor stub
		this.j = j;
	}

		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Login log = new Login();
		j.removeAll();
		j.add(log);
		j.updateUI();
	}

}
