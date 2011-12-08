import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.rmi.Naming;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FenetreClient extends JFrame implements Runnable{
	JTextArea  labelChat;
	JLabel labelNom;

	/**
	 * Launch the application.
	 */
	
	@Override
	public void run() {
		this.setVisible(true);

		labelChat.setText("C'est parti");
		while (true) {
			
			try {
				
				// Récupération d'un stub sur l'objet serveur.
				Information obj = (Information) Naming.lookup("//Sitcocolita-HP:70/mon_serveur");
				labelChat.setText(obj.lireTout());
				// Appel d'une méthode sur l'objet distant.
			} catch (Exception e) {
				System.out.println("Echec de l'envoi du message");
				e.printStackTrace();
				// TODO: handle exception
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	public FenetreClient(String nom) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		

		
		labelChat = new JTextArea ();
		getContentPane().add(labelChat, BorderLayout.CENTER);
		labelChat.setLineWrap(true); 
		labelChat.setColumns(10);

		
		labelNom = new JLabel(nom);
		getContentPane().add(labelNom, BorderLayout.NORTH);
		
	}

	

}
