/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.service;

import ifroutard.dao.CircuitDao;
import ifroutard.dao.ClientDao;
import ifroutard.dao.ConseillerDao;
import ifroutard.dao.DepartDao;
import ifroutard.dao.DevisDao;
import ifroutard.dao.PaysDao;
import ifroutard.dao.SejourDao;
import ifroutard.dao.VoyageDao;
import ifroutard.model.Circuit;
import ifroutard.model.Client;
import ifroutard.model.Conseiller;
import ifroutard.model.Depart;
import ifroutard.model.Devis;
import static ifroutard.model.Devis_.dateDepart;
import ifroutard.model.Pays;
import ifroutard.model.Sejour;
import ifroutard.model.Voyage;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aaccardo
 */
public class Recherche {

    /**
     * Retourne tous les clients
     *
     * @return Une liste avec tous les clients
     */
    public static List<Client> getAllClient() {
        return ClientDao.all();
    }

    /**
     * Retourne les clients par leur nom et leur prénom
     *
     * @param nomComplet Tableau contenant le nom et le prenom
     * @return Une liste avec tous les clients selectionés par nom et prenom
     */
    public static List<Client> getClient(String[] nomComplet) {
        String nom, prenom;
        if (nomComplet[0] == null) {
            nom = "";
        } else {
            nom = nomComplet[0];
        }
        if (nomComplet[1] == null) {
            prenom = "";
        } else {
            prenom = nomComplet[1];
        }

        return ClientDao.findByFullName(nom, prenom);
    }

    /**
     * Retourne les clients par leur numéro de téléphone
     *
     * @param telephone
     * @return Une liste avec tous les clients selectionés par telephone
     */
    public static List<Client> getClientTel(String telephone) {
        return ClientDao.findByTel(telephone);
    }

    /**
     * Retorune les clients par leur émail
     *
     * @param email
     * @return Une liste avec tous les clients selectionés par email
     */
    public static List<Client> getClientEmail(String email) {
        return ClientDao.findByEmail(email);
    }

    /**
     * Retourne tous les conseillers
     *
     * @return Une liste avec tous les conseillers
     */
    public static List<Conseiller> getAllConseiller() {
        return ConseillerDao.all();
    }

    /**
     * Retourne les conseiller par leur nom et leur prénom
     *
     * @param nomComplet Tableau contenant le nom et le prenom
     * @return Une liste avec tous les conseiller selectionés par nom et prenom
     */
    public static List<Conseiller> getConseiller(String[] nomComplet) {
        String nom, prenom;
        if (nomComplet[0] == null) {
            nom = "";
        } else {
            nom = nomComplet[0];
        }
        if (nomComplet[1] == null) {
            prenom = "";
        } else {
            prenom = nomComplet[1];
        }

        return ConseillerDao.findByFullName(nom, prenom);
    }

    /**
     * Retourne tous les départs
     *
     * @return Une liste avec tous les départs
     */
    public static List<Depart> getAllDepart() {
        return DepartDao.all();
    }

    /**
     * Retourne les départs selectionés par code de Départ
     *
     * @param codeDepart Code univoque pour un départ
     * @return Une liste avec les départs correspondants
     */
    public static List<Depart> getDepart(String codeDepart) {
        return DepartDao.findByCodeDep(codeDepart);
    }

    /**
     * Retourne les départs selectionés par prix
     *
     * @param prixMax Prix maximale du départ
     * @param prixMin Prix minimale du départ
     * @return Une liste avec les départs correspondants
     */
    public static List<Depart> getDepartParPrix(int prixMax, int prixMin) {
        return DepartDao.findByPrice(prixMin, prixMax);
    }

    /**
     * Retourne les départs selectionés par date
     *
     * @param dateDepart La date de départ
     * @return Une liste avec les départs correspondants
     */
    public static List<Depart> getDepartParDate(Date dateDepart) {
        return DepartDao.findByDate(dateDepart);
    }

    /**
     * Retourne les départs selectionés par lieu de départ et d'arrivée
     *
     * @param lieuDepart Le lieu de départ
     * @param lieuArrivee Le lieu d'arrivée
     * @return Une liste avec les départs correspondants
     */
    public static List<Depart> getDepartParLieu(String lieuDepart, String lieuArrivee) {
        if (lieuDepart == null) {
            return DepartDao.findByArrivee(lieuArrivee);
        } else if (lieuArrivee == null) {
            return DepartDao.findByDepart(lieuDepart);
        }
        return DepartDao.findByDA(lieuDepart, lieuArrivee);
    }

    /**
     * Retourne les devis selectionés par client, ou conseiller ou (voyage,
     * conseiller, client, date de départ)
     *
     * @param voyage Le voyage de référence du devis
     * @param conseiller Le conseiller chargé du devis
     * @param client Le client intéressé par le devis
     * @param dateDepart La date prévue de départ
     * @return Une liste avec les devis correspondants
     */
    public static List<Devis> getDevis(Voyage voyage, Conseiller conseiller, Client client, Date dateDepart) {
        if (voyage == null || dateDepart == null) {
            if (client != null) {
                return DevisDao.findByClient(client);
            } else if (conseiller != null) {
                return DevisDao.findByConseiller(conseiller);
            }
        }
        if (conseiller != null && client != null) {
            return DevisDao.find(voyage, conseiller, client, dateDepart);
        } else {
            return null;
        }
    }

    /**
     * Retourne les pays selectionés par le code du pays
     *
     * @param codePays Le code du pays
     * @return Une liste avec les pays correspondants
     */
    public static List<Pays> getPaysParCodePays(String codePays) {
        return PaysDao.findByCodePays(codePays);
    }

    /**
     * Retourne les pays selectionés par le nom
     *
     * @param nomPays Le nom du pays
     * @return Une liste avec les pays correspondants
     */
    public static List<Pays> getPaysParNomPays(String nomPays) {
        return PaysDao.findByNamePays(nomPays);
    }

    /**
     * Retourne les pays selectionés par la langue
     *
     * @param language Le language le plus parlé dans le pays
     * @return Une liste avec les pays correspondants
     */
    public static List<Pays> getPaysParLangue(String language) {
        return PaysDao.findByLanguage(language);
    }

    /**
     * Retourne tous les pays
     *
     * @return Une liste avec tous les pays
     */
    public static List<Pays> getAllPays() {
        return PaysDao.all();
    }

    /**
     * Retourne tous les voyages
     *
     * @return Une liste avec tous les voyages
     */
    public static List<Voyage> getAllVoyage() {
        return VoyageDao.all();
    }

    /**
     * Retourne les voyages selectionés par leur code
     *
     * @param nom Le nom du voyage
     * @return Une liste avec les voyages correspondants
     */
    public static List<Voyage> getVoyageParNom(String nom) {
        return VoyageDao.findByNameVoyage(nom);
    }

    /**
     * Retourne les voyages selectionés par leur durée
     *
     * @param duree La durée du voyage en jours
     * @return Une liste avec les voyages correspondants
     */
    public static List<Voyage> getVoyageParDuree(int duree) {
        return VoyageDao.findByDuree(duree);
    }

    /**
     * Retourne les voyages selectionés par les pays qu'on visite pendant ce
     * voyage
     *
     * @param pays La liste des pays qu'on souhaite visiter
     * @return Une liste avec les voyages correspondants
     */
    public static List<Voyage> getVoyageParPays(List<Pays> pays) {
        return VoyageDao.findByPays(pays);
    }

    /**
     * Retourne les voyages selectionés par leur code
     *
     * @param code Le code identificatif du voyage
     * @return Une liste avec les voyages correspondants
     */
    public static List<Voyage> getVoyageParCode(String code) {
        return VoyageDao.findByCodeVoyage(code);
    }

    /**
     * Retourne tous les circuits
     *
     * @return Une liste avec tous les circuits
     */
    public static List<Circuit> getAllCircuit() {
        return CircuitDao.allCircuits();
    }

    /**
     * Retourne tous les séjours
     *
     * @return Une liste avec tous les séjours
     */
    public static List<Sejour> getAllSejours() {
        return SejourDao.allSejours();
    }

    /**
     * Retourne les circuits selectionés par la distance du parcours
     *
     * @param distanceKm Distance en KM minimale du circuit
     * @return Une liste avec les circuits correspondants
     */
    public static List<Circuit> getCircuitParKm(int distanceKm) {
        return CircuitDao.findByKm(distanceKm);
    }

}
