package Application.Clients;

import java.io.Serializable;

public class Personne implements Serializable{
	
	private static final long serialVersionUID = -792317305443434076L;
	
	private String adresse;
	private String email;
	private String nom;
	private String telephone;
	private Voeux voeux;
	
	public Personne(String adresse, String email, String nom, String telephone) {
		this.adresse = adresse;
		this.email = email;
		this.nom = nom;
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Voeux getVoeux() {
		return voeux;
	}

	public void setVoeux(Voeux voeux) {
		this.voeux = voeux;
	}

	@Override
	public String toString() {
		String fiche = "\n";
		fiche += "Nom : " + this.getNom() + "\n";
		fiche += "Adresse : " + this.getAdresse() + "\n";
		fiche += "Email : " + this.getEmail() + "\n";
		fiche += "Tel : " + this.getTelephone() + "\n";
		return fiche;
	}
	
}
