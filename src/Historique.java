import java.util.ArrayList;


public class Historique extends ArrayList<Message> {
	public String Raconter(){
		String retour = "";
		for(Message m : this){
			retour = retour + m.LireMessage()+"\n";
		}
		return retour;
	}
}
