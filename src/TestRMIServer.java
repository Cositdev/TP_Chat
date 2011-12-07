import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class TestRMIServer extends UnicastRemoteObject implements Information {
String message;
// Implémentation du constructeur
	public TestRMIServer(String msg) throws java.rmi.RemoteException {
	super();
	System.out.println(msg);
	}
	
	
// Implémentation de la méthode distante
	public String sayHello(String mot) throws java.rmi.RemoteException {
		System.out.println(mot);
		String retour;
		if(mot.contains("Guillaume")){
			retour="C'est vrai";
		}else{
			retour="<"+mot+">";
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