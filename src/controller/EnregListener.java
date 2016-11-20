package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import persistance.UnitOfWork;

public class EnregListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UnitOfWork.getInstance().commit();
		JOptionPane.showMessageDialog(null, "Modifications enregistrées", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

}
