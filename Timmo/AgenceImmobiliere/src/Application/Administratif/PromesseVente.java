package Application.Administratif;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import Application.Biens.Bien;
import Application.Clients.Notaire;

enum Etat {
	EST_EN_COURS, EST_ANNULE, EST_VALIDE
}

public class PromesseVente implements Serializable {

	private static final long serialVersionUID = -8014795763184539189L;
	
	private Bien bien;
	private Notaire notaire;
	private Date dateVente;
	private Etat etat;
	private HashMap<String, Boolean> signatures;

	public PromesseVente(Bien bien, Notaire notaire, Date dateVente) {
		this.bien = bien;
		this.notaire = notaire;
		this.dateVente = dateVente;
		this.etat = Etat.EST_EN_COURS;
		this.signatures = new HashMap<>();
		this.signatures.put("Acheteur", false);
		this.signatures.put("Vendeur", false);
		this.signatures.put("Notaire", false);
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Notaire getNotaire() {
		return notaire;
	}

	public void setNotaire(Notaire notaire) {
		this.notaire = notaire;
	}

	public Etat getEtat() {
		return this.etat;
	}

	public void annuler() {
		this.etat = Etat.EST_ANNULE;
	}

	public void valider() {
		if (!signatures.containsValue(false)) {
			this.etat = Etat.EST_VALIDE;
		}
	}

	public void acheteurASigne() {
		if (this.bien.getAcheteur() != null)
			this.signatures.put("Acheteur", true);
		else
			System.out.println("Il n'y a pas d'acheteur");
	}

	public void vendeurASigne() {
		this.signatures.put("Vendeur", true);
	}

	public void notaireASigne() {
		this.signatures.put("Notaire", true);
	}

	public float getCommissionAgence() throws Exception {
		if (this.etat == Etat.EST_VALIDE)
			return (float) (this.bien.getMandat().getPrix() * 0.07);
		else
			throw new Exception("Promesse de vente n'a pas été validé");
	}
}