import java.rmi.*;
public class ClientRMI {
public static void main(String args[]) {
	try {
	// R�cup�ration d'un stub sur l'objet serveur.
	Information obj = (Information) Naming.lookup("//Sitcocolita-HP:70/mon_serveur");
	// Appel d'une m�thode sur l'objet distant.
	System.out.println(obj.sayHello("Coucou !"));
	} catch (Exception exc) {
		}
	}
}