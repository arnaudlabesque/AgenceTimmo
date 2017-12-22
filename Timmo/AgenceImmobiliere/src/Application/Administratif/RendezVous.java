package Application.Administratif;
import java.io.Serializable;
import java.util.Date;

import Application.Biens.Bien;
import Application.Clients.Personne;

public class RendezVous implements Serializable {
	
	private static final long serialVersionUID = 7356507523445672820L;
	
	private Personne personne;
	private Bien bien;
	private Date date;
	
	public RendezVous(Personne personne, Bien bien, Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}
	
}
