package Application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import Application.Administratif.Mandat;
import Application.Administratif.PromesseVente;
import Application.Administratif.RendezVous;
import Application.Biens.Appartement;
import Application.Biens.Bien;
import Application.Biens.Maison;
import Application.Biens.Publicite;
import Application.Biens.Terrain;
import Application.Clients.Entreprise;
import Application.Clients.Notaire;
import Application.Clients.Personne;
import Application.Clients.Voeux;

public class Agence implements Serializable {

	private static final long serialVersionUID = 7504739039056182744L;

	private ArrayList<Bien> biens;
	private ArrayList<Personne> personnes;
	private ArrayList<Publicite> publicites;
	private ArrayList<RendezVous> rendezVous;
	private ArrayList<Mandat> mandats;
	private ArrayList<PromesseVente> promesses;

	public Agence() {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Agence.dat"))) {
			Agence prevAgence = (Agence) is.readObject();
			this.biens = prevAgence.biens;
			this.personnes = prevAgence.personnes;
			this.publicites = prevAgence.publicites;
			this.rendezVous = prevAgence.rendezVous;
			this.mandats = prevAgence.mandats;
			this.promesses = prevAgence.promesses;
		} catch (IOException | ClassNotFoundException e) {
			this.biens = new ArrayList<>();
			this.personnes = new ArrayList<>();
			this.publicites = new ArrayList<>();
			this.rendezVous = new ArrayList<>();
			this.mandats = new ArrayList<>();
			this.promesses = new ArrayList<>();
		}
	}

	/**
	 * MÉTHODES UTILES À TIMMO
	 */

	/**
	 * Saisir une chaîne de caractère avec un contrôle.
	 * 
	 * @return String saisi
	 */
	public String saisirString() {
		String var = "";
		while (var.equals("")) {
			try {
				var = Clavier.in.nextLine();
			} catch (Exception e) {
				System.out.print("Veuillez saisir une chaîne de caractères : ");
				Clavier.in.next();
			}
		}
		return var;
	}

	/**
	 * Saisir un entier avec un contrôle.
	 * 
	 * @return Integer saisi
	 */
	public int saisirInt() {
		Optional<Integer> var = null;
		while (var == null) {
			try {
				var = Optional.of(Clavier.in.nextInt());
			} catch (Exception e) {
				System.out.print("Veuillez saisir un entier : ");
				Clavier.in.next();
			}
		}
		return var.get();
	}

	/**
	 * Saisir une date avec un contrôle.
	 * 
	 * @return Date saisie
	 */
	public Date saisirDate() {
		System.out.print("(au format JJ-MM-YYYY) : ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		Boolean saisiOK;
		do {
			try {
				date = formatter.parse(saisirString());
				saisiOK = true;
			} catch (ParseException e) {
				System.out.print("Veuillez recommencer saisie au format JJ-MM-YYYY : ");
				saisiOK = false;
			}
		} while (!saisiOK);
		return date;
	}

	/**
	 * Affiche la liste des clients contenus dans l'Agence
	 * 
	 * @return Code d'erreur
	 */
	protected int afficherListeClients() {
		if (this.personnes.size() == 0) {
			System.out.println("Il n'y a pas de client");
			return 1;
		}
		System.out.println("\n========= Sélection de clients =========\n");
		int indice = 0;
		for (Personne p : this.personnes) {
			System.out.printf("%d : %s\n", indice++, p.getNom());
		}
		return 0;
	}

	/**
	 * Affiche la liste des biens contenus dans l'Agence
	 * 
	 * @return Code d'erreur
	 */
	protected int afficherListeBiens() {
		if (this.biens.size() == 0) {
			System.out.println("Il n'y a pas de biens");
			return 1;
		}
		System.out.println("\n========= Sélection de biens =========\n");
		int indice = 0;
		for (Bien b : this.biens) {
			System.out.printf("%d : %s\n", indice++, b.getNumero());
		}
		return 0;
	}

	/**
	 * Saisir les champs permettant de créer un Mandat
	 * 
	 * @return Mandat saisi
	 */
	protected Mandat creerMandat() {

		System.out.print("Entrez la date de disponibilité : ");
		Date dateDispo = saisirDate();

		System.out.print("Entrez la date de vente : ");
		Date dateVente = saisirDate();

		System.out.print("Entrez la duree : ");
		int duree = saisirInt();

		System.out.print("Entrez le prix : ");
		int prix = saisirInt();

		Mandat m = new Mandat(dateDispo, dateVente, duree, prix);
		this.mandats.add(m);
		return m;
	}

	/**
	 * FONCTIONNALITES DE TIMMO
	 */

	/**
	 * @code Controlleur => 1
	 * 
	 * Saisir les champs permettant de créer une personne qui peut être un 
	 * physique ou morale. 
	 * 
	 * @return Personne saisie
	 */
	protected Personne creerFicheClient() {
		System.out.println("\n========= Création fiche du client =========\n");

		System.out.println("Tapez 0 pour une Personne physique");
		System.out.println("Tapez 1 pour une Personne morale");
		int typePersonne = saisirInt();

		System.out.print("Entrez le nom du client : ");
		String nom = saisirString();

		System.out.print("Entrez l'adresse du client : ");
		String adresse = saisirString();

		System.out.print("Entrez l'adresse mail du client : ");
		String mail = saisirString();

		System.out.print("Entrez le numéro de téléphone du client : ");
		String telephone = saisirString();
		Personne p;
		if (typePersonne == 1) {
			System.out.print("Entrez la forme juridique de l'entreprise : ");
			String formeJuridique = saisirString();
			System.out.print("Entrez le numéro SIREN de l'entreprise : ");
			String numeroSIREN = saisirString();
			p = new Entreprise(adresse, mail, nom, telephone, formeJuridique, numeroSIREN);
		} else {
			p = new Personne(adresse, mail, nom, telephone);
		}

		this.personnes.add(p);
		return p;
	}

	/**
	 * @code Controlleur => 2 
	 * 
	 * Affiche et renvoie la Personne sélectionnée. 
	 * 
	 * @return Personne sélectionnée
	 */
	protected Personne afficherFicheClient() {
		if (afficherListeClients() == 1)
			return null;
		System.out.println("Saisissez le numéro du client : ");
		Personne p = this.personnes.get(saisirInt());
		System.out.println(p);
		return p;
	}

	/**
	 * @code Controlleur => 3 
	 * 
	 * Retire de l'Agence la Personne sélectionnée.
	 */
	protected void supprimerFicheClient() {
		if (afficherListeClients() == 1)
			return;
		int id = saisirInt();
		System.out.println("Suppression de " + this.personnes.get(id).getNom());
		personnes.remove(id);
	}

	/**
	 * @code Controlleur => 4 et Controlleur => 9 => 1
	 * 
	 * Saisir les champs permettant de créer un bien pouvant être un appartement, une maison ou un terrain.
	 */
	protected void creerFicheBien() {
		System.out.println("\n========= Création fiche du bien =========\n");

		String message = "\n-> Sélection type de bien <-\n";
		message += "0 : Appartement\n";
		message += "1 : Maison\n";
		message += "2 : Terrain\n\n";
		System.out.print(message + "Saisi : ");
		int choix = saisirInt();

		System.out.print("Entrez l'adresse du bien : ");
		String adresse = saisirString();

		System.out.print("Entrez le numero du bien : ");
		int numero = saisirInt();

		System.out.print("Entrez l'orientation du bien : ");
		String orientation = saisirString();

		System.out.print("Entrez le propriétaire du bien : ");
		Personne vendeur = afficherFicheClient();
		if (vendeur == null)
			vendeur = creerFicheClient();

		Mandat mandat = creerMandat();

		switch (choix) {
		case 0:
			System.out.print("Entrez les charges du bien : ");
			int charge = saisirInt();
			System.out.print("Entrez l'étage : ");
			int etage = saisirInt();
			System.out.print("Entrez le nombre de pièces : ");
			int nbPieces = saisirInt();
			Appartement a = new Appartement(adresse, numero, orientation, vendeur, mandat, charge, etage, nbPieces);
			this.biens.add(a);
			break;

		case 1:
			System.out.print("Entrez le type de chauffage : ");
			String chauffage = saisirString();
			System.out.print("Entrez le nombre d'étage : ");
			int nbEtage = saisirInt();
			System.out.print("Entrez le nombre de pièces : ");
			int nbPiece = saisirInt();
			System.out.print("Entrez la surface habitable : ");
			int surfaceHabitable = saisirInt();
			Maison m = new Maison(adresse, numero, orientation, vendeur, mandat, chauffage, nbEtage, nbPiece,
					surfaceHabitable);
			this.biens.add(m);
			break;

		case 2:
			System.out.print("Entrez la longueur de la façade : ");
			int longueurFacade = saisirInt();
			System.out.print("Entrez la surface au sol : ");
			int surfaceSol = saisirInt();
			Terrain t = new Terrain(adresse, numero, orientation, vendeur, mandat, longueurFacade, surfaceSol);
			this.biens.add(t);
			break;
		}

	}

	/**
	 * @code Controlleur => 5
	 * 
	 * Affiche et retourne le bien sélectionné.
	 * 
	 * @return Bien sélectionné
	 */
	protected Bien afficherFicheBien() {
		if (afficherListeBiens() == 1)
			return null;
		Bien b = this.biens.get(saisirInt());
		System.out.println(b);
		return b;
	}

	/**
	 * @code Controlleur => 6
	 * 
	 */
	protected void supprimerFicheBien() {
		if (afficherListeBiens() == 1)
			return;
		int id = saisirInt();
		this.mandats.remove(this.biens.get(id).getMandat());
		System.out.println("Suppression de " + this.biens.get(id).getNumero());
		biens.remove(id);
	}

	/**
	 * @code Controlleur => 7
	 * 
	 */
	protected void fairePublicite() {
		System.out.println("\n========= Création d'une Publicité =========\n");
		if (afficherListeBiens() == 1)
			return;
		System.out.println("\nSélectionnez un biens (\"-1\" pour valider) :");
		int saisi = 0;
		ArrayList<Bien> biensSelected = new ArrayList<>();
		while ((saisi = saisirInt()) != -1) {
			saisi = saisirInt();
			biensSelected.add(this.biens.get(saisi));
			System.out.println("\nBien ajouté !");
		}
		System.out.print("\nSaisissez une description :");
		String desc = saisirString();

		this.publicites.add(new Publicite(desc, biensSelected));
	}

	/**
	 * @code Controlleur => 8
	 * 
	 */
	protected void afficherPublicites() {
		if (this.biens.size() == 0) {
			System.out.println("Il n'y a pas de publicités");
		}
		System.out.println("\n========= Liste des publicités =========\n");
		int indice = 0;
		for (Publicite p : this.publicites) {
			System.out.printf("%d : %s\n", indice++, p);
		}
	}

	/**
	 * @code Controlleur => 9
	 * 
	 */
	protected void prendreRDV() {
		System.out.println("\n========= Sélection du type de Rendez-vous =========\n");
		System.out.println("1 - Rendez-vous avec un vendeur");
		System.out.println("2 - Rendez-vous avec un acheteur");
		System.out.println("3 - Rendez-vous pour une signature");
		System.out.println("Autre pour quitter");
		switch (saisirInt()) {
		case 1:
			creerFicheBien();
			break;
		case 2:
			creerVoeux();
			break;
		case 3:
			creerPromesseVente();
			break;
		default:
			System.out.println("Retour vers menu");
			return;
		}
	}

	/**
	 * @code Controlleur => 9 => 2
	 * 
	 */
	protected void creerVoeux() {
		System.out.println("\n========= Création d'un voeux acheteur =========\n");
		Personne acheteur = afficherFicheClient();

		System.out.println("Saisissez localisation : ");
		String localisation = saisirString();
		System.out.print("Saisissez nombre de pièces : ");
		int nbPieces = saisirInt();
		System.out.print("Saisissez prix : ");
		int prix = saisirInt();
		System.out.print("Saisissez surface : ");
		int surface = saisirInt();
		System.out.println("\n-> Sélectionnez type de bien <-\n");
		System.out.println("1 - Appartement");
		System.out.println("2 - Maison");
		System.out.println("3 - Terrain");
		System.out.print("Choisissez : ");
		String type = "";
		switch (saisirInt()) {
		case 1:
			type = "Appartement";
			break;
		case 2:
			type = "Maison";
			break;
		case 3:
			type = "Terrain";
			break;
		default:
			return;
		}
		System.out.printf("\nCréation du voeux pour %s \n", acheteur.getNom());
		acheteur.setVoeux(new Voeux(localisation, nbPieces, prix, surface, type));
	}

	/**
	 * @code Controlleur => 9 => 3
	 * 
	 */
	protected void creerPromesseVente() {
		System.out.println("\n========= Création d'une promesse de vente =========\n");

		System.out.println("-> Sélectionnez un bien : <-");
		Bien bien = afficherFicheBien();
		System.out.println("Création d'une fiche client de type notaire : ");
		Notaire notaire = (Notaire) creerFicheClient();
		System.out.println("Saisissez date : ");
		Date dateVente = saisirDate();

		System.out.printf("\nCréation d'une promesse de vente pour le bien %s \n", bien.getNumero());
		if (bien.getAcheteur() == null) {
			System.out.println("-> Sélectionnez l'acheteur intéressé par le bien : <-");
			Personne acheteur = afficherFicheClient();
			bien.setAcheteur(acheteur);
		}
		this.promesses.add(new PromesseVente(bien, notaire, dateVente));
	}

	/**
	 * @code Controlleur => 10
	 * 
	 */
	protected void editerStats() {
		System.out.println("TODO");
	}

	/**
	 * Lance une action sélectionnée à partir d'une saisi
	 * 
	 * @param saisi
	 */
	public void controleur(String saisi) {
		switch (saisi) {
		case "1":
			creerFicheClient();
			break;
		case "2":
			afficherFicheClient();
			break;
		case "3":
			supprimerFicheClient();
			break;
		case "4":
			creerFicheBien();
			break;
		case "5":
			afficherFicheBien();
			break;
		case "6":
			supprimerFicheBien();
			break;
		case "7":
			fairePublicite();
			break;
		case "8":
			afficherPublicites();
			break;
		case "9":
			prendreRDV();
			break;
		case "10":
			editerStats();
			break;
		case "q":
			close();
			break;
		}
		pause();
	}

	/**
	 * Affiche le menu avec toutes les actions disponibles
	 */
	@Override
	public String toString() {
		String menu = "";
		menu += "========= Menu Timmo =========\n";

		menu += "\n-> Section Client <-\n";
		menu += "1 : Créer fiche client\n";
		menu += "2 : Afficher fiche client\n";
		menu += "3 : Supprimer fiche client\n";

		menu += "\n-> Section Bien <-\n";
		menu += "4 : Créer fiche bien\n";
		menu += "5 : Afficher fiche bien\n";
		menu += "6 : Supprimer fiche bien\n";
		menu += "7 : Faire publicité pour biens\n";
		menu += "8 : Afficher publicité\n";

		menu += "\n-> Section Administration <-\n";
		menu += "9 : Prendre rendez-vous\n";

		menu += "\n-> Autres <-\n";
		menu += "10 : Editer Statistiques\n";

		menu += "\nq : Quitter\n";

		menu += "\nSélectionnez une action : ";
		return menu;
	}

	/**
	 * Met en pause et nettoie la console après la fin d'une action
	 */
	protected void pause() {
		System.out.println("Saisir pour passer > ");
		Clavier.in.next();
		clearScreen();
	}

	protected void clearScreen() {
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
	}

	/**
	 * Lancement du programme Timmo
	 */
	public void run() {

		String saisi = "";
		while (true) {
			System.out.print(this);
			saisi = Clavier.in.next();
			this.controleur(saisi);
		}

	}

	/**
	 * Fermeture du programme Timmo
	 */
	public void close() {
		System.out.println("Fermeture de Timmmo");

		// Sérialisation
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Agence.dat"))) {
			os.writeObject(this);
		} catch (IOException e) {
			System.err.println("Erreur pendant la sérialisation : " + e);
			System.exit(1);
		}
		Clavier.in.close();
	}
}
