package codeProf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class ExempleUI {

    // Couche SERVICE

    public static class UseCase1Service {
        private String param;
        public UseCase1Service(String param) {
            // Faire l'action correspondante au C.U (en utilisant les couches domaine/persistance/etc..)
            this.param = param;
        }
        public String resultat() {
            //Recuperer resultat du C.U.
            try {
                return param.toString();
            } catch (Exception e) {
                return ("???");
            }
        }
    }


    // Donnee "factice" avec ID
    public static class MaDonnee {
        int id;
        static int current_id = 1000;
        String value;
        public MaDonnee(String value) {
            this.id = current_id;
            current_id++;
            this.value = value;
        }
        public String toString() {
            return value;
        }
        public int getId() {
            return id;
        }
    }

    // Ceci appartient a la couche INTERFACE (à faire normalement dans un fichier séparé! La tout est mis ensemble pour garder l'exemple simple.)
    public static class UseCase1UI extends JPanel implements ActionListener, ListSelectionListener{

        JButton add= new JButton("Ajouter");
        JButton cancel= new JButton("Annuler");
        JLabel resultat = new JLabel("Champ: ");
        
        Document modeleTextField = new PlainDocument(); // Modele du JTextField
        JTextField textfield = new JTextField(modeleTextField, "", 8); //Creer un JTextField avec le modele
        
        JList<MaDonnee> l = new JList<MaDonnee>();
        DefaultListModel<MaDonnee> lmodel = new DefaultListModel<MaDonnee>();
        
        public UseCase1UI() {

            //ajouter elements
            add(new JLabel("Hello world"));
            add(add);
            add(cancel);
            add(resultat);
            add(textfield);
            l.setModel(lmodel);
            l.getSelectionModel().addListSelectionListener(this);
            add(l);

            //definir le listener
            add.addActionListener(this);
            cancel.addActionListener(this);
        }
        
        // listener pour la JList
        public void valueChanged(ListSelectionEvent e) {
            int debutIndex = l.getSelectionModel().getMinSelectionIndex();
            int finIndex = l.getSelectionModel().getMaxSelectionIndex();
            
            System.out.println("\nChangement de la selection de liste! ");
            if (l.getSelectionModel().isSelectionEmpty()) {
                System.out.println("Rien n'est selectionne.");
            } else {
                for (int i = debutIndex; i <= finIndex; i++) {
                    System.out.println("Element numero= " + i + " selectionné.");
                    System.out.println("Valeur de l'element: " + l.getModel().getElementAt(i).toString());
                    System.out.println("ID de l'element: " + l.getModel().getElementAt(i).getId());
                }
            }
        }

        // listener pour les boutons
        public void actionPerformed(ActionEvent e) {
            System.out.println("Un event s'est produit!");
            if (e.getSource() == add) {
                System.out.println("Vous avez clique: OK");
                try {
                
                  // Lecture des infos du JTExtField via le modele, et appel de la classe correspondante au C.U.
                  UseCase1Service m = new UseCase1Service(modeleTextField.getText(0, modeleTextField.getLength()));
                  String res = m.resultat();
                  resultat.setText("Resultat: " + res);
                  lmodel.addElement(new MaDonnee(res));
                } catch (BadLocationException ex) {
                    // gestion erreur ici ...
                }
            } else {
                System.out.println("Vous avez clique: Annuler");
                try {
                  // Effacement du JTextField via le modele
                  modeleTextField.remove(0, modeleTextField.getLength());
                } catch (BadLocationException ex) {
                  // gestion erreur ici ... 
                }
            }
        }
    }
    public static class MyFrame extends JFrame {

        public MyFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            setSize(640,400);

            //ajout d'un panel dans la frame
            getContentPane().add(new UseCase1UI());
            setLocationRelativeTo(null);
        }
    }

    public static void main(String [] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }
}
