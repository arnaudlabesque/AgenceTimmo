package Application.Clients;

public class Entreprise extends Personne {

	private static final long serialVersionUID = 3527130265911264129L;
	
	private String formeJuridique;
	private String numeroSIREN;
	
	public Entreprise(String adresse, String email, String nom, String telephone,String formeJuridique, String numeroSIREN) {
		super(adresse,email,nom,telephone);
		this.setFormeJuridique(formeJuridique);
		this.setNumeroSIREN(numeroSIREN);
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getNumeroSIREN() {
		return numeroSIREN;
	}

	public void setNumeroSIREN(String numeroSIREN) {
		this.numeroSIREN = numeroSIREN;
	}
	
}
