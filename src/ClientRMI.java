import java.rmi.*;
public class ClientRMI {
public static void main(String args[]) {
	try {
	// Récupération d'un stub sur l'objet serveur.
	Information obj = (Information) Naming.lookup("//Sitcocolita-HP:70/mon_serveur");
	// Appel d'une méthode sur l'objet distant.
	System.out.println(obj.sayHello("Coucou !"));
	} catch (Exception exc) {
		}
	}
}