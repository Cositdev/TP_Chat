import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FenetreConnexion extends JFrame {

	private JPanel contentPane;
	private JPanel container  =new JPanel();
	private JTextField identif;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnexion frame = new FenetreConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreConnexion() {
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		this.setTitle("Bienvenue");
		this.setSize(280, 180);
		//Message de bienvenue :
		
		JLabel Titre = new JLabel("Bienvenue dans le TP_Chat");
		JPanel TitrePanel = new JPanel();
		TitrePanel.setBackground(Color.yellow);
		TitrePanel.setLayout(new FlowLayout());
		TitrePanel.setPreferredSize(new Dimension(160, 30));
		TitrePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		TitrePanel.add(Titre);
		JPanel haut = new JPanel();
		haut.add(TitrePanel);
		
		JLabel message = new JLabel("Veuillez vous connecter");
		JPanel connexionPanel = new JPanel();
		connexionPanel.setLayout(new GridLayout(3,1));
		connexionPanel.add(message);
		identif = new JTextField();
		connexionPanel.add(identif);
		JButton ok = new JButton("Connexion");
		ok.addActionListener(new CLicOk());
		connexionPanel.add(ok);

		container.setLayout(new BorderLayout());
		container.add(haut,BorderLayout.NORTH);
		container.add(connexionPanel,BorderLayout.CENTER);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(container);
		
		

	}
	class CLicOk implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		setVisible(false);
    		ThreadClient th = new ThreadClient(identif.getText());
    		th.start();
    	}
    }
}
