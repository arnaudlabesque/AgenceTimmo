package Application.Administratif;
import java.io.Serializable;
import java.util.Date;

public class Mandat implements Serializable {

	private static final long serialVersionUID = 3175833556633077280L;
	
	private Date dateDispo;
	private Date dateVente;
	private int duree;
	private int prix;
	
	public Mandat(Date dateDispo, Date dateVente, int duree, int prix) {
		this.dateDispo = dateDispo;
		this.dateVente = dateVente;
		this.duree = duree;
		this.prix = prix;
	}

	public Date getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
}
