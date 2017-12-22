package Application.Biens;
import java.util.ArrayList;

public class Publicite {
	
	private String description;
	private ArrayList<Bien> biens;

	public Publicite(String description) {
		this.description = description;
	}
	
	public Publicite(String description, ArrayList<Bien> alBiens) {
		this(description);
		this.biens = alBiens;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Bien> getBien() {
		return biens;
	}

	public void addBiens(Bien bien) {
		this.biens.add(bien);
	}

	public void removeBiens(Bien bien) {
		if(biens.contains(bien))
			this.biens.remove(bien);
	}
	
	@Override
	public String toString() {
		String str = "Publicité concernant : ";
		for(Bien b : biens)
			str += "   " + b.getAdresse() + ", ";
		str.substring(0,str.length()-2);
		str += "\nDescription : " + this.description;
		return str;
	}
}
