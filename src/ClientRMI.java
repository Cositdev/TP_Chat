import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;


public class ClientRMI {

	/**
	 * @param args
	 */
	public static void main(String[] arg) {
		// TODO Auto-generated method stub
		//Dialogue client serveur
		
		
		String urlService = arg[0];
		BufferedReader in = null;
		String msg = null;
		String reponse = null;
		Information serveur = null;
		
		try{
			//ouvertrure du flux clavier
			in = new BufferedReader(new InputStreamReader(System.in));
			//localisation du service
			serveur = (Information) Naming.lookup(urlService);
			//boucle de lecture des mesages à envoyer ay serveur d'echo
			System.out.print("Message : ");
			msg = in.readLine().toLowerCase().trim();
			while(!msg.equals("fin")){
				//envoie du message au serveur et reception de la réponse
				reponse= serveur.echo(msg);
				//suivi
				System.out.println("Réponse serveur : "+reponse);
				//msg suivant
				System.out.print("Message : ");
				msg = in.readLine().toLowerCase().trim();
			} // fin du while
			//c'est fini
			System.exit(0);
			//gestion des erreurs
			
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur : "+e);
			System.exit(2);
		}//try
	}//main

}//classe
