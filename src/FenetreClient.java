import java.awt.BorderLayout;
import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
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
			
				areaChat.setText(obj.lireTout(utilisateur));
				areaGens.setText(obj.userList());
				
				// Appel d'une méthode sur l'objet distant.
			} catch (Exception e) {
				System.out.println("Echec de la lecture des messages");
				e.printStackTrace();
				System.exit(0);
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
		JOptionPane jop = new JOptionPane();

		try {
			int port = 70;
			//String URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/mon_serveur";
			String URL = "//Sitcocolita-HP:80/mon_serveur";
			obj = (Information) Naming.lookup(URL);
			
			
		} catch (MalformedURLException e) {
			jop.showMessageDialog(null, "Erreur de connexion au serveur : MalFormedURLDialog \n"+e.getMessage(),"Raté !", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		} catch (RemoteException e) {
			jop.showMessageDialog(null, "Erreur de connexion au serveur : RemoteException\n"+e.getMessage(),"Raté !", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
	
			System.exit(0);
		} catch (NotBoundException e) {
			jop.showMessageDialog(null, "Erreur de connexion au serveur : NotBoundException\n"+e.getMessage(),"Raté !", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
		catch (Exception e) {
			jop.showMessageDialog(null, "Erreur de connexion au serveur : Exeption\n"+e.getMessage(),"Raté !", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
		
		
		addWindowListener(new quitter());
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		

		
		areaChat = new JTextArea ();
		areaChat.setLineWrap(true); 
		areaChat.setColumns(10);
		scrollArea = new JScrollPane(areaChat);
		scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollArea, BorderLayout.CENTER);

		areaGens = new JTextArea ();
		areaGens.setLineWrap(true); 
		areaChat.setEditable(false);
		areaGens.setColumns(10);
		areaGens.setEditable(false);

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
        	   String mess= textField.getText();
        	   if(mess.equals("/who")){
        		   try {
					obj.who(utilisateur);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	   }else{
		        	try {
						Message m = new Message(utilisateur, mess);
						areaChat.setText(m.EnvoyerMessage(obj));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	   }
        	   textField.setText("");

             }
           }
         }
	class quitter extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			try {
				obj.deconnexion(utilisateur);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}
	 
}

