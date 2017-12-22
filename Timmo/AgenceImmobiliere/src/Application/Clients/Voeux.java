package Application.Clients;

import java.io.Serializable;

public class Voeux implements Serializable {
	
	private static final long serialVersionUID = -8968805157018606880L;
	
	private String localisation;
	private int nbPieces;
	private int prix;
	private int surface;
	private String typeBien;
	
	public Voeux(String localisation, int nbPieces, int prix, int surface, String typeBien) {
		this.localisation = localisation;
		this.nbPieces = nbPieces;
		this.prix = prix;
		this.surface = surface;
		this.typeBien = typeBien;
	}

	public String getLocalisation() {
		return localisation;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public int getPrix() {
		return prix;
	}

	public int getSurface() {
		return surface;
	}

	public String getTypeBien() {
		return typeBien;
	}
	
}
