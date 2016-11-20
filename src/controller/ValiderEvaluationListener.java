package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import domaine.Personne;

public class ValiderEvaluationListener implements ActionListener {

	private JTextField eval;
	
	public ValiderEvaluationListener(Personne filsAModifier, JTextField nouvelleEval) {
		// TODO Auto-generated constructor stub
		eval = nouvelleEval;
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if ( eval.getText().equals("")){
			JOptionPane jop2 = new JOptionPane();
			jop2.showMessageDialog(null,"L'évaluation ne contient rien", "Message préventif",  JOptionPane.WARNING_MESSAGE);

		}
		
		if ( JListListener.tmp == null ){
			JOptionPane jop3 = new JOptionPane();
			jop3.showMessageDialog(null, "Veuillez sélectionner un fils", "Message d'erreur",  JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println("----------Attention----------"+ JListListener.tmp.getEvaluation());
			JListListener.tmp.setEvaluation(eval.getText());
			eval.setText("");
			System.out.println("----------Attention----------"+ JListListener.tmp.getEvaluation());
		}
		
	}

}
