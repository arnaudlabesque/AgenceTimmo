package Application.Biens;

import Application.Administratif.Mandat;
import Application.Clients.Personne;

public class Terrain extends Bien {
	
	private static final long serialVersionUID = 5019327203176851737L;
	
	private int longueurFacade;
	private int surfaceSol;
	
	public Terrain(String adresse, int numero, String orientation, Personne vendeur, Mandat mandat, int longueurFacade, int surfaceSol) {
		super(adresse, numero, orientation, vendeur, mandat);
		this.longueurFacade = longueurFacade;
		this.surfaceSol = surfaceSol;
	}

	public int getLongueurFacade() {
		return longueurFacade;
	}

	public void setLongueurFacade(int longueurFacade) {
		this.longueurFacade = longueurFacade;
	}

	public int getSurfaceSol() {
		return surfaceSol;
	}

	public void setSurfaceSol(int surfaceSol) {
		this.surfaceSol = surfaceSol;
	}

}
