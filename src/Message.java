import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Time;


public class Message extends UnicastRemoteObject  {
	private String message;
	private String Auteur;
	private Time Heure;
	
	public Message(String Auteur, String message)throws java.rmi.RemoteException{
		this.message = message;
		this.Auteur= Auteur;
		
	}
	public Message(String Auteur)throws java.rmi.RemoteException{

		try {
			BufferedReader in=null;
			in = new BufferedReader(new InputStreamReader(System.in));
			String msg=in.readLine().trim();
			this.message=msg;
			this.Auteur=Auteur;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur dans la creation d'un message a partir du flux rentrant");
			System.exit(0);
		}
	}
	
	public void EnvoyerMessage(Information obj){
		try {
			System.out.println(obj.passerMessage(this.Auteur,this.message));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String LireMessage(){
		return Auteur+"> "+ message;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	
	
	
}
