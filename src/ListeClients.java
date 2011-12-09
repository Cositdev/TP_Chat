import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class ListeClients extends Hashtable<String, ClientConnecte> {
	private ArrayList<String> listeNoms = new ArrayList<String>();

	
	public void ajouterClient(String nom) throws RemoteException{
		this.put(nom, new ClientConnecte(nom));
		Message mess = new Message("Serveur",nom +" vient de se connecter");
		envoyerPartout(mess);
		listeNoms.add(nom);
	}
	public void deconnecterClient(String nom) throws RemoteException{
		Message mess = new Message("Serveur",nom +" vient de se déconnecter");
		envoyerPartout(mess);
		this.remove(nom);
		listeNoms.remove(nom);

	}
	
	public void envoyerPartout(Message mess){
		Set cles = this.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()){
		   String cle = (String) it.next();
		   ClientConnecte Client = this.get(cle); 
		   Client.ajouterMessage(mess);
		}
	}
	public void ajouterMessage(String user,String message){
		try {
			this.get(user).ajouterMessage(new Message(user,message));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String listerClients(){
		String retour = "";
		for (String user: listeNoms) {
			retour += user+"\n";
		}
		return retour;
	}
	
}
