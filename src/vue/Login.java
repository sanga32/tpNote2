package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ValiderLoginListener;

public class Login extends JPanel{

	public Login(JFrame f){

		super();
		this.setPreferredSize(f.getSize());
		this.setLayout(new GridLayout(8,8));
		JLabel jl = new JLabel("Votre id: ");
		JTextField id = new JTextField();
		JButton valider = new JButton("OK");
		
		jl.setPreferredSize(new Dimension(50, 80));
		id.setPreferredSize(new Dimension(120, 80));
		valider.setPreferredSize(new Dimension(50, 50));
		valider.addActionListener(new ValiderLoginListener(id, this));
		this.add(jl, BorderLayout.CENTER);
		this.add(id, BorderLayout.EAST);
		this.add(valider, BorderLayout.SOUTH);
		

	}
}
