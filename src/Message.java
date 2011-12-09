import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Time;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Message extends UnicastRemoteObject  {
	private String message;
	private String Auteur;
	private Calendar Heure;
	
	public Message(String Auteur, String message) throws java.rmi.RemoteException {
		this.message = message;
		this.Auteur= Auteur;
		this.Heure = Calendar.getInstance();
	}
	
	public String EnvoyerMessage(Information obj){
		String retour = "";
		try {
			retour =obj.passerMessage(this.Auteur,this.message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return retour;
	}
	
	public String LireMessage(){
		SimpleDateFormat sdfHeure = new SimpleDateFormat("HH:mm:ss");
		String heure = sdfHeure.format(this.Heure.getTime());
		
		return "[" + heure + "] " + this.Auteur + " > " + this.message;
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
