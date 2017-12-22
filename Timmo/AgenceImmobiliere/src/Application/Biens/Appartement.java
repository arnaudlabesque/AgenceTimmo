package Application.Biens;

import Application.Administratif.Mandat;
import Application.Clients.Personne;

public class Appartement extends Bien {

	private static final long serialVersionUID = 9006553945601067949L;
	
	private int charge;
	private int etage;
	private int nbPieces;
	
	public Appartement(String adresse, int numero, String orientation, Personne vendeur, Mandat mandat, int charge, int etage, int nbPieces) {
		super(adresse, numero, orientation, vendeur, mandat);
		this.charge = charge;
		this.etage = etage;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public int getetage() {
		return etage;
	}

	public void setetage(int etage) {
		this.etage = etage;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	
}
