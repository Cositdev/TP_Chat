import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class TestRMIServer extends UnicastRemoteObject implements Information {
	
	private Historique historique;
	private ArrayList<String> userLog = new ArrayList<String>();

	// Implémentation du constructeur
	public TestRMIServer(String msg) throws java.rmi.RemoteException {
		super();
		historique= new Historique();
		System.out.println(msg);
	}
	
	
	// Implémentation de la méthode distante
	public String passerMessage(String Auteur,String message) throws java.rmi.RemoteException {
		Message mess = new Message(Auteur,message);
		historique.add(mess);
		return historique.Raconter();
	}
	public String lireTout(){
		return historique.Raconter();
	}
	
	public void addUser(String username) {
		System.out.println("hello "+username);

		userLog.add(username);
	}
	
	public String userList() {
		String retour = "";
		for (String user: userLog) {
			retour += user+"\n";
		}
		return retour;
	}
	
	public static void main(String args[]) {
		int port; String URL;
		System.out.println("Lancement du serveur !");
		
		try { // transformation d ’une chaîne de caractères en entier
			//Integer I = new Integer(args[0]);
			//port = I.intValue();
			port=70;
		} catch (Exception ex) {
			System.out.println(" Please enter: Server <port>"); return;
		}
		
		try {
			// Création du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);
			// Création d ’une instance de l’objet serveur
			Information obj = new TestRMIServer("Bienvenue sur le serveur !");
			// Calcul de l’URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+
			port+"/mon_serveur";
			Naming.rebind(URL, obj);
			System.out.println("Serveur lancé");
			System.out.println("URL : " + URL);
		} catch (Exception exc) { 
			exc.printStackTrace();
		}
	}
}