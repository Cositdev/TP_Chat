import java.rmi.*;

public interface Information extends java.rmi.Remote {
	public String sayHello(String message)
	throws java.rmi.RemoteException;
}