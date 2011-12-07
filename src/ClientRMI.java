import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.*;
public class ClientRMI {
public static void main(String args[]) {
	while (true){
		try {
			// Récupération d'un stub sur l'objet serveur.
			Information obj = (Information) Naming.lookup("//Sitcocolita-HP:70/mon_serveur");
			// Appel d'une méthode sur l'objet distant.
			BufferedReader in=null;
			in = new BufferedReader(new InputStreamReader(System.in));
			String msg=in.readLine().trim();
			System.out.println(obj.sayHello(msg));
			} catch (Exception exc) {
				}
			}
	}

}