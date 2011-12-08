
/**
 * @author Bertrand
 * Classe permetant l'affichage de la fenètre de statistiques
 */
public class ThreadPerso extends Thread{
	private String nom;
	public ThreadPerso (String nom){
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
