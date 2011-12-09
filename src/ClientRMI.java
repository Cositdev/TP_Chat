import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ClientRMI {
	
	private static String utilisateur;
	
	public static void main (String args[]) {
		Date da = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		System.out.println(formatter.format(da));
		System.out.println("Vous pouvez commencer à papoter ");

		FenetreConnexion fen = new FenetreConnexion();
		fen.setVisible(true);
		
	}
}
