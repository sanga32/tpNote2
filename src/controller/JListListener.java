package controller;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domaine.Personne;

public class JListListener implements ListSelectionListener {

	JList<Personne> l;
	JLabel j;
	JPanel jp;
	protected static Personne tmp;

	public JListListener(JList<Personne> l, JLabel evalFils, JPanel jp, Personne filsAModifier) {
		super();
		this.l = l;
		j = evalFils;
		this.jp = jp;
		tmp = filsAModifier;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		int i = l.getSelectedIndex();
		System.out.println("Element numero= " + i + " selectionné.");
		System.out.println("Valeur de l'element: " + l.getModel().getElementAt(i).toString());
		System.out.println("ID de l'element: " + l.getModel().getElementAt(i).getId());
		j.setText("Evaluation de " + l.getModel().getElementAt(i));
		tmp = l.getModel().getElementAt(i);
		System.out.println("---"+tmp+"---");
		jp.updateUI();

	}

}
