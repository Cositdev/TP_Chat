
/**
 * @author Bertrand
 * Classe permetant l'affichage de la fenètre de statistiques
 */
public class ThreadClient extends Thread{
	private String nom;
	private String Adresse;
	public ThreadClient (String nom,String adresse){
		super();
		this.nom=nom;
		this.Adresse=adresse;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		FenetreClient fen = new FenetreClient(nom,Adresse);
		fen.run();
	}

}
