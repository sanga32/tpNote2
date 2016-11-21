package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import persistance.UnitOfWork;

/**
 * Listener du bouton qui permet de valider les informations et qui déclenche la mise à jour de la base de données
 * @author Kevin
 *
 */

public class EnregListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UnitOfWork.getInstance().commit();
		JOptionPane.showMessageDialog(null, "Modifications enregistrées", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

}
