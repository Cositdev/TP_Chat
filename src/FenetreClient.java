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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FenetreClient extends JFrame implements Runnable{
	private String utilisateur;
	private JTextArea  areaChat;
	private JTextArea  areaGens;
	private JLabel labelNom;
	private JTextField textField;
	private Information obj;
	private JScrollPane scrollArea;
	private JScrollPane scrollGens;

	/**
	 * Launch the application.
	 */
	
	@Override
	public void run() {
		this.setVisible(true);

		areaChat.setText("C'est parti");
		while (true) {
			
			try {
				
				// Récupération d'un stub sur l'objet serveur.
			
				areaChat.setText(obj.lireTout());
				
				// Appel d'une méthode sur l'objet distant.
			} catch (Exception e) {
				System.out.println("Echec de l'envoi du message");
				e.printStackTrace();
				// TODO: handle exception
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	public FenetreClient(String nom) {
		utilisateur = nom;
		try {
			obj = (Information) Naming.lookup("//Sitcocolita-HP:70/mon_serveur");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		

		
		areaChat = new JTextArea ();
		areaChat.setLineWrap(true); 
		areaChat.setColumns(10);
		scrollArea = new JScrollPane(areaChat);
		scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollArea, BorderLayout.CENTER);

		areaGens = new JTextArea ();
		areaGens.setLineWrap(true); 
		areaGens.setColumns(10);
		scrollGens = new JScrollPane(areaGens);
		scrollGens.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollGens, BorderLayout.EAST);
		
		
		labelNom = new JLabel(utilisateur);
		getContentPane().add(labelNom, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.addKeyListener(new majEnter() );
		getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
	}

	class majEnter extends KeyAdapter{
         public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_ENTER) {
	        	try {
					Message m = new Message(utilisateur, textField.getText());
					areaChat.setText(m.EnvoyerMessage(obj));
					textField.setText("");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
             }
           
           
           }
         }

	 
}

