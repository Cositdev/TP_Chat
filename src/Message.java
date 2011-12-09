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
	
	public String EnvoyerMessage(Information obj){
		String retour = "";
		try {
			retour =obj.passerMessage(this.Auteur,this.message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
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
