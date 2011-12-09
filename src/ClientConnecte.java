import java.util.ArrayList;


public class ClientConnecte {
	private String nom;
	private Historique historique;
	
	public ClientConnecte(String nom){
		historique=new Historique();
		this.nom=nom;
	}
	
	public String ajouterMessage(Message mess){
		historique.add(mess);
		return historique.Raconter();
	}
	
	public Historique getHistorique(){
		return this.historique;
	}
}
