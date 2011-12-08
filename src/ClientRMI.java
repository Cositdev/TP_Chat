import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ClientRMI {
	
	private static String utilisateur;
	
	public static void main(String args[]) {
		Date da = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		System.out.println(formatter.format(da));
		
		try {
			System.out.println("Bonjour, quel est votre nom ?");
			BufferedReader inNom=null;
			inNom = new BufferedReader(new InputStreamReader(System.in));
			utilisateur=inNom.readLine().trim();
			System.out.println("Bonjour "+ utilisateur);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Vous pouvez commencer à papoter ");
	
		while (true) {
		
			try {
				Message mess= new Message(utilisateur);
				
				// Récupération d'un stub sur l'objet serveur.
				Information obj = (Information) Naming.lookup("//Sitcocolita-HP:70/mon_serveur");
				mess.EnvoyerMessage(obj);
				
				// Appel d'une méthode sur l'objet distant.
			} catch (Exception e) {
				System.out.println("Echec de l'envoi du message");
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
