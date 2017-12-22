package Application.Biens;

import Application.Administratif.Mandat;
import Application.Clients.Personne;

public class Maison extends Bien{
	
	private static final long serialVersionUID = 4562265457601270882L;
	
	private String chauffage;
	private int nbEtage;
	private int nbPieces;
	private int surfaceHabitable;
	
	public Maison(String adresse, int numero, String orientation, Personne vendeur, Mandat mandat, String chauffage, int nbEtage, int nbPieces, int surfaceHabitable) {
		super(adresse, numero, orientation, vendeur, mandat);
		this.chauffage = chauffage;
		this.nbEtage = nbEtage;
		this.nbPieces = nbPieces;
		this.surfaceHabitable = surfaceHabitable;
	}

	public String getChauffage() {
		return chauffage;
	}

	public void setChauffage(String chauffage) {
		this.chauffage = chauffage;
	}

	public int getNbEtage() {
		return nbEtage;
	}

	public void setNbEtage(int nbEtage) {
		this.nbEtage = nbEtage;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	public int getSurfaceHabitable() {
		return surfaceHabitable;
	}

	public void setSurfaceHabitable(int surfaceHabitable) {
		this.surfaceHabitable = surfaceHabitable;
	}

}
