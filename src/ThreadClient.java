
/**
 * @author Bertrand
 * Classe permetant l'affichage de la fenètre de statistiques
 */
public class ThreadClient extends Thread{
	private String nom;
	public ThreadClient (String nom){
		super();
		this.nom=nom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		FenetreClient fen = new FenetreClient(nom);
		fen.run();
	}

}
