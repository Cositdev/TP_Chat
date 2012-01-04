import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class TestRMIServer extends UnicastRemoteObject implements Information {
	//private Historique historique;
	private ListeClients clients =new ListeClients();

	// Implémentation du constructeur
	public TestRMIServer(String msg) throws java.rmi.RemoteException {
		super();
		System.out.println(msg);
	}
	
	
	// Implémentation de la méthode distante
	public String passerMessage(String Auteur,String message) throws java.rmi.RemoteException {
		Message mess = new Message(Auteur,message);
		clients.envoyerPartout(mess);
		return clients.get(Auteur).getHistorique().Raconter();
	}
	public String lireTout(String Nom){
		String retour = "";
		try{
		retour = clients.get(Nom).getHistorique().Raconter();
		}catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println("Echec de la lecture (Utilisateur supprimé ?)");
		}
		return retour;
	}
	
	public void addUser(String username) throws RemoteException {
		System.out.println("hello "+username);
		//Message mess = new Message(serverName,username +" vient de se connecter");
		//historique.add(mess);
		//userLog.add(username);
		clients.ajouterClient(username);
	}
	
	public String userList() {
		return clients.listerClients();
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
		if(System.getSecurityManager() == null)
            System.setSecurityManager(new RMISecurityManager());
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
		FenetreServeur j = new FenetreServeur();
		j.setVisible(true);

	}

	@Override
	public void who(String nom) throws RemoteException {
		String liste = "Liste des Utilisateurs connectés :\n"+clients.listerClients();
		clients.get(nom).ajouterMessage(new Message("Serveur",liste));
	}
	
	@Override
	public void deconnexion(String username) throws RemoteException {
		clients.deconnecterClient(username);
	}

}