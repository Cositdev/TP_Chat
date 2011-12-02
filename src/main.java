import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;


public class main {

	public static void main(String[] args) {
		try {
			
			//c�t� serveur
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			
			System.out.println("Mise en place du Security Manager ...");
			//System.setSecurityManager(new java.rmi.RMISecurityManager());
			TestRMIServer testRMIServer = new TestRMIServer();
			System.out.println("Enregistrement du serveur");
			Naming.rebind("rmi://"+java.net.InetAddress.getLocalHost()+"/TestRMI",testRMIServer);
			 
			//Naming.rebind("rmi://localhost/TestRMI", testRMIServer);
			
			System.out.println("Serveur lanc�");
			
			//c�t� client
			System.setSecurityManager(new RMISecurityManager());
			
		   
		}
		catch (Exception e) {
			System.out.println("Exception captur�e!: " + e.getMessage());
		}
	}

}
