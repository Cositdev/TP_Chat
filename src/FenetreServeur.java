import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FenetreServeur extends JFrame {

	private JPanel contentPane;

	public FenetreServeur() {
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		this.setTitle("Serveur lancé");
		this.setSize(280, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblServeurEnCours = new JLabel("Serveur en cours");
		contentPane.add(lblServeurEnCours);
		
		JButton btnNewButton = new JButton("Arreter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.exit(0);
			}
		});
		contentPane.add(btnNewButton);
	}

}
