package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JPanel;

import persistance.UnitOfWork;
import vue.Login;

public class AnnulerListener implements ActionListener {

	JPanel j;
	
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
