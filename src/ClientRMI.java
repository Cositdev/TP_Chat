public class ClientRMI {
	private static String URL = "//169.254.201.116:80/mon_serveur";

	public static void main (String args[]) {
		FenetreConnexion fen = new FenetreConnexion(URL);
		fen.setVisible(true);
	}
}
