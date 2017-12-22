package Application.Biens;

import java.io.Serializable;

import Application.Administratif.Mandat;
import Application.Clients.Personne;

public abstract class Bien implements Serializable {

	private static final long serialVersionUID = -7466702085038199065L;
	
	private String adresse;
	private int numero;
	private String orientation;
	private Personne vendeur;
	private Personne acheteur;
	private Mandat mandat;

	public Bien(String adresse, int numero, String orientation, Personne vendeur, Mandat mandat) {
		this.adresse = adresse;
		this.numero = numero;
		this.orientation = orientation;
		this.vendeur = vendeur;
		this.mandat = mandat;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Personne getVendeur() {
		return vendeur;
	}

	public void setVendeur(Personne vendeur) {
		this.vendeur = vendeur;
	}

	public Personne getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Personne acheteur) {
		this.acheteur = acheteur;
	}

	public Mandat getMandat() {
		return mandat;
	}

	@Override
	public String toString() {
		String message = "";
		message += "Le bien " + this.numero + " appartient à " + this.vendeur.getNom();
		message += "\nAdresse : " + this.adresse;
		message += "\nOrientation :" + this.orientation;
		return message;
	}

}
