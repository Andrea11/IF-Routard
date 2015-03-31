package ifroutard.util;

import ifroutard.dao.*;
import ifroutard.dao.jpa.*;
import ifroutard.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ifroutard.service.Creer;

/**
 * La classe LectureDonneesCsv permet (comme son nom l'indique) la lecture de données CSV
 * dans des fichiers. Elle doit être complétée et personnalisée pour interagir avec VOTRE couche
 * service pour la création effective des entités. Elle comprend initialement la lecture d'un fichier
 * Clients et d'un fichier Pays. Une méthode {@link main()} permet de tester cette classe avant de
 * l'intégrer dans le reste de votre code.
 *
 * @author Équipe DASI - 2013/2014
 */

public class LectureDonneesUtil {

	/**
	 * Dans les donnees des conseillers en CSV, les champs 7 à 16 sont des pays
	 */
	public final int PAYS_DEBUT = 7;
	public final int PAYS_FIN = 16;//inclus

	/**
	 * Cette méthode main() lit tous les fichiers en entier.
	 *
	 * @param args non utilisé ici
	 */
	public static void main (String... args) {
		String cheminBase = "./data/IFRoutard-";
		String fichierClients = cheminBase + "Clients.csv";
		String fichierPays = cheminBase + "Pays.csv";
		String fichierConseiller = cheminBase + "Conseillers.csv";
		String fichierDeparts = cheminBase + "Departs.csv";
		String fichierCircuits = cheminBase + "Voyages-Circuits.csv";
		String fichierSejours = cheminBase + "Voyages-Sejours.csv";

		try {
			// ---- Pays
			LectureDonneesUtil lectureDonneesCsv_Pays =
					new LectureDonneesUtil(fichierPays);
                        
			// Lire tous les champs du fichier
			System.out.println("---- Ajout des PAYS");
			lectureDonneesCsv_Pays.lirePays(-1);
                        
			lectureDonneesCsv_Pays.fermer();


			// ---- Circuits
			LectureDonneesUtil lectureDonneesCsv_Circuit =
					new LectureDonneesUtil(fichierCircuits);
                        
			// Lire tous les champs du fichier
			System.out.println("---- Ajout des CIRCUITS");
			lectureDonneesCsv_Circuit.lireCircuits(-1);
                        
			lectureDonneesCsv_Circuit.fermer();


			// ---- Sejour
			LectureDonneesUtil lectureDonneesCsv_Sejour =
					new LectureDonneesUtil(fichierSejours);
                        
			// Lire tous les champs du fichier
			System.out.println("---- Ajout des SEJOURS");
			lectureDonneesCsv_Sejour.lireSejours(-1);
                        
			lectureDonneesCsv_Sejour.fermer();


			// ---- Conseillers
			LectureDonneesUtil lectureDonneesCsv_Conseiller =
					new LectureDonneesUtil(fichierConseiller);
                        
			// Lire tous les champs du fichier
			System.out.println("---- Ajout des CONSEILLERS");
			lectureDonneesCsv_Conseiller.lireConseillers(-1);
                        
			lectureDonneesCsv_Conseiller.fermer();


			// ---- Departs
			LectureDonneesUtil lectureDonneesCsv_Depart =
					new LectureDonneesUtil(fichierDeparts);
                        // Lire tous les champs du fichier
			System.out.println("---- Ajout des DEPARTS");
			lectureDonneesCsv_Depart.lireDeparts(-1);
                        
			lectureDonneesCsv_Depart.fermer();
                        
                        
                        // ---- Clients
			LectureDonneesUtil lectureDonneesCsv_Clients =
					new LectureDonneesUtil(fichierClients);
                        
			// Lire tous les champs du fichier
			System.out.println("---- Ajout des CLIENTS");
			lectureDonneesCsv_Clients.lireClients(-1);
                        
			lectureDonneesCsv_Clients.fermer();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			JpaUtil.cancelTransiction();
		}

	}

	/**
	 * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Client pour chaque ligne.
	 *
	 * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
	 * @throws IOException
	 */
	public void lireClients (int limite) throws IOException {
		String[] nextLine;

		// En-tete du fichier CSV
		nextLine = this.lecteurFichier.readNext();
		afficherEnTeteCsv(nextLine);
                Client c;
		
		// Lecture des lignes
		while ((nextLine = this.lecteurFichier.readNext()) != null) {
                        
			new Creer().creerClient(nextLine);

			// Limite (ou -1 si pas de limite)
			if (!(limite < 0) && (--limite < 1)) {
				break;
			}
		}
	}

	/**
	 * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
	 *
	 * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
	 * @throws IOException
	 */
	public void lireConseillers (int limite) throws IOException {
		String[] nextLine;

		// En-tete du fichier CSV
		nextLine = this.lecteurFichier.readNext();
		afficherEnTeteCsv(nextLine);

		// Lecture des lignes
		while ((nextLine = this.lecteurFichier.readNext()) != null) {
			new Creer().creerConseiller(nextLine);

			// Limite (ou -1 si pas de limite)
			if (!(limite < 0) && (--limite < 1)) {
				break;
			}
		}
	}

	/**
	 * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
	 *
	 * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
	 * @throws IOException
	 */
	public void lirePays (int limite) throws IOException {
		String[] nextLine;

		// En-tete du fichier CSV
		nextLine = this.lecteurFichier.readNext();
		afficherEnTeteCsv(nextLine);

		
		// Lecture des lignes
		while ((nextLine = this.lecteurFichier.readNext()) != null) {
			new Creer().creerPays(nextLine);

			// Limite (ou -1 si pas de limite)
			if (!(limite < 0) && (--limite < 1)) {
				break;
			}
		}
	}

	/**
	 * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
	 *
	 * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
	 * @throws IOException
	 */
	public void lireDeparts (int limite) throws IOException {
		String[] nextLine;

		// En-tete du fichier CSV
		nextLine = this.lecteurFichier.readNext();
		afficherEnTeteCsv(nextLine);

		
		// Lecture des lignes
		while ((nextLine = this.lecteurFichier.readNext()) != null) {
			new Creer().creerDepart(nextLine);

			// Limite (ou -1 si pas de limite)
			if (!(limite < 0) && (--limite < 1)) {
				break;
			}
		}
	}

	/**
	 * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
	 *
	 * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
	 * @throws IOException
	 */
	public void lireCircuits (int limite) throws IOException {
		String[] nextLine;

		// En-tete du fichier CSV
		nextLine = this.lecteurFichier.readNext();
		afficherEnTeteCsv(nextLine);

		
		// Lecture des lignes
		while ((nextLine = this.lecteurFichier.readNext()) != null) {
			new Creer().creerCircuit(nextLine);

			// Limite (ou -1 si pas de limite)
			if (!(limite < 0) && (--limite < 1)) {
				break;
			}
		}
	}

	/**
	 * Lit le fichier CSV, affiche son en-tête, puis appelle la création de Pays pour chaque ligne.
	 *
	 * @param limite Nombre maximum de lignes à lire ou -1 pour ne pas limiter
	 * @throws IOException
	 */
	public void lireSejours (int limite) throws IOException {
		String[] nextLine;

		// En-tete du fichier CSV
		nextLine = this.lecteurFichier.readNext();
		afficherEnTeteCsv(nextLine);
                
		// Lecture des lignes
		while ((nextLine = this.lecteurFichier.readNext()) != null) {
			new Creer().creerSejour(nextLine);

			// Limite (ou -1 si pas de limite)
			if (!(limite < 0) && (--limite < 1)) {
				break;
			}
		}
	}

	// Méthodes de base

	/**
	 * Format de date pour la lecture des dates dans les fichiers CSV fournis.
	 */
	protected static final DateFormat CSV_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Format de date pour l'affichage à l'écran.
	 */
	protected static final DateFormat USER_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Le lecteur de fichier CSV.
	 * Il doit être initialisé avant l'appel aux méthodes de la classe.
	 */
	protected CSVReader lecteurFichier;

	/**
	 * Unique constructeur de la classe. Le fichier CSV donné en paramètre doit
	 * avoir le point-virgule ';' comme séparateur et être encodé en UTF-8. Le fichier est
	 * immédiatement ouvert (en lecture) par ce constructeur.
	 *
	 * @param cheminVersFichier Chemin vers le fichier CSV.
	 * @throws FileNotFoundException Si le chemin vers le fichier n'est pas valide ou le fichier non-lisible.
	 */
	public LectureDonneesUtil (String cheminVersFichier) throws FileNotFoundException, UnsupportedEncodingException {
		this.lecteurFichier = new CSVReader(new InputStreamReader(new FileInputStream(cheminVersFichier), "UTF-8"), ';');
	}

	/**
	 * Ferme le fichier CSV. Les autres méthodes ne doivent plus être appelées après cela.
	 *
	 * @throws IOException
	 */
	public void fermer () throws IOException {
		this.lecteurFichier.close();
	}

	/**
	 * Méthode statique pour lire une date à partir d'une chaîne de caractère.
	 * Adapté au format de date des fichiers CSV fournis, par exemple: 2014-02-01.
	 *
	 * @param date Chaîne de caractère représentant la date.
	 * @return La date interpétée ou la date actuelle en cas mauvais format en entrée.
	 */
	public static Date parseDate (String date) {
		try {
			return CSV_DATE_FORMAT.parse(date);
		} catch (ParseException ex) {
			return new Date();
		}
	}

	/**
	 * Méthode statique pour formater une date pour l'affichage.
	 * Par exemple: 01/02/2014.
	 *
	 * @param date Date à formater.
	 * @return Chaîne de caractère représentant la date.
	 */
	protected static String formatDate (Date date) {
		return USER_DATE_FORMAT.format(date);
	}

	/**
	 * Méthode statique pour afficher l'en-tête d'un fichier CSV lu par le lecteur.
	 * L'affichage se fait sur la "sortie d'erreur" (en rouge dans la console sous Netbeans).
	 * Le nom des colonnes est précédé de leur index dans le tableau (commençant à 0).
	 *
	 * @param colonnes le tableau des noms de colonnes.
	 */
	protected static void afficherEnTeteCsv (String[] colonnes) {

		for (int i = 0; i < colonnes.length; i++) {
			if (i > 0) {
				System.err.print("; ");
			}
			System.err.print("#" + Integer.toString(i) + " => " + colonnes[i]);
		}
		System.err.println();
	}
}
