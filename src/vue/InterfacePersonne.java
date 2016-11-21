package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.AnnulerListener;
import controller.EnregListener;
import controller.JListListener;
import controller.ValiderEvaluationListener;
import domaine.Personne;

/**
 * Classe InterfacePersonne qui affiche les informations d'une personne 
 * @author Kevin Delporte, Alexandre Godon, Teddy Lequette
 *
 */

@SuppressWarnings("serial")
public class InterfacePersonne extends JPanel {

	public InterfacePersonne(Personne p) throws SQLException {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0; // la grille commence en (0, 0)
		gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.
		gbc.gridwidth = 3; // valeur par défaut - peut s'étendre sur une seule ligne.
		gbc.anchor = GridBagConstraints.FIRST_LINE_START; 
		gbc.insets = new Insets(10, 15, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;		
		JLabel vous = new JLabel("Vous: "+ p.getNom()+" "+p.getPrenom());
		JLabel pere;
		if ( p.getPere() == null ){
			pere = new JLabel("Votre père: aucun");

		} else {
			pere = new JLabel("Votre père: "+p.getPere());

		}
		JLabel eval = new JLabel("Votre évaluation: "+p.getEvaluation());
		
		this.add(vous, gbc);
		
		gbc.gridy = 1;
		this.add(pere, gbc);
		
		gbc.gridy = 2;
		this.add(eval, gbc);

		JButton jb = new JButton("Annuler");
		
	    gbc.gridwidth =2;
		gbc.gridheight = 3;
		gbc.gridx = 3;
		gbc.gridy = 0;
		
		jb.addActionListener(new AnnulerListener(this));
		
		this.add(jb, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridheight = 1;
	    gbc.gridwidth =2;
	    
	    JLabel jl2 = new JLabel("Vos Fils");
	    this.add(jl2, gbc);
	    
	    JList<Personne> jl = new JList<Personne>();
        DefaultListModel<Personne> lmodel = new DefaultListModel<Personne>();
      
        for ( Personne pers : p.getFils()){
        	lmodel.addElement(pers);
        }
        
        jl.setModel(lmodel);
        JLabel evalFils = new JLabel("Sélectionner un fils");
        Personne filsAModifier = null;
        jl.getSelectionModel().addListSelectionListener(new JListListener(jl, evalFils, this, filsAModifier));
        
        JScrollPane listScrollPane = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridheight = 3;
	    gbc.gridwidth =3;
	    
	    this.add(listScrollPane, gbc);
        
	    gbc.gridx = 3;
		gbc.gridheight = 1;
	    gbc.gridwidth =1;

	    this.add(evalFils, gbc);
	    
        gbc.gridy = 5;

	    JTextField nouvelleEval = new JTextField();
		gbc.fill = GridBagConstraints.NONE;		
		nouvelleEval.setPreferredSize(new Dimension(130, 35));
		nouvelleEval.addActionListener(new ValiderEvaluationListener(filsAModifier, nouvelleEval));
	    this.add(nouvelleEval, gbc);
	    
	    gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.PAGE_START; // ou BASELINE_LEADING mais pas WEST.

	    JButton validerEvaluation = new JButton("Valider");
	    validerEvaluation.addActionListener(new ValiderEvaluationListener(filsAModifier, nouvelleEval));
	    
	    this.add(validerEvaluation, gbc);
	    
	    gbc.gridy = 7;
	    gbc.gridwidth =4;
	    
	    JButton enreg = new JButton("Enregistrer les modifs");
	    enreg.addActionListener(new EnregListener());
	    
	    this.add(enreg, gbc);

	}

}
