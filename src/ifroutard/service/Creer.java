/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.service;

import ifroutard.dao.ClientDao;
import ifroutard.dao.ConseillerDao;
import ifroutard.dao.DepartDao;
import ifroutard.dao.DevisDao;
import ifroutard.dao.PaysDao;
import ifroutard.dao.VoyageDao;
import ifroutard.model.Client;
import ifroutard.model.Conseiller;
import ifroutard.model.Depart;
import ifroutard.model.Devis;
import ifroutard.model.Pays;
import ifroutard.model.Voyage;
import ifroutard.util.jpaUtil;

/**
 *
 * @author ccanete
 */
public class Creer {

    /**
     * Service qui enregistre un client
     *
     * @param client Client à sauvegarder
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean creerClient(Client client) {

        if (!ClientDao.findByUser(client.getUsername()).isEmpty()) {
            return false;
        } else if (!ClientDao.findByEmail(client.getEmail()).isEmpty()) {
            return false;
        } else {
            ClientDao.persiste(client);
            return true;
        }
    }

    /**
     * Service qui met à jour un client
     *
     * @param client_new client mis à jour
     * @param client_old client à mettre à jour
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean updateClient(Client client_new, Client client_old) {
        if (client_new.getUsername() != client_old.getUsername()) {
            if (!ClientDao.findByUser(client_new.getUsername()).isEmpty()) {
                return false;
            }
        }
        if (client_new.getEmail() != client_old.getEmail()) {
            if (!ClientDao.findByEmail(client_new.getEmail()).isEmpty()) {
                return false;
            }
        }
        jpaUtil.startTransiction();
        client_old.update(client_new);
        ClientDao.update(client_old);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Service qui supprime un client
     *
     * @param client Client à supprimer
     * @return vrai si la suppression s'est passée correctement, faux sinon
     */
    public static boolean deleteClient(Client client) {
        if (!ClientDao.findByUser(client.getUsername()).isEmpty()) {
            ClientDao.delete(client);
        }
        return true;
    }

    /**
     * Service qui enregistre un conseiller
     *
     * @param conseiller Conseiller à sauvegarder
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean creerConseiller(Conseiller conseiller) {

        if (!ConseillerDao.findByUser(conseiller.getUsername()).isEmpty()) {
            return false;
        } else if (!ConseillerDao.findByEmail(conseiller.getEmail()).isEmpty()) {
            return false;
        } else {
            ConseillerDao.persiste(conseiller);
            return true;
        }
    }

    /**
     * Service qui met à jour un conseiller
     *
     * @param conseiller_new conseiller mis à jour
     * @param conseiller_old conseiller à mettre à jour
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean updateConseiller(Conseiller conseiller_new, Conseiller conseiller_old) {
        if (conseiller_new.getUsername() != conseiller_old.getUsername()) {
            if (!ConseillerDao.findByUser(conseiller_new.getUsername()).isEmpty()) {
                return false;
            }
        }
        if (conseiller_new.getEmail() != conseiller_old.getEmail()) {
            if (!ConseillerDao.findByEmail(conseiller_new.getEmail()).isEmpty()) {
                return false;
            }
        }
        jpaUtil.startTransiction();
        conseiller_old.update(conseiller_new);
        ConseillerDao.update(conseiller_old);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Service qui supprime un conseiller
     *
     * @param conseiller Conseiller à supprimer
     * @return vrai si la suppression s'est passée correctement, faux sinon
     */
    public static boolean deleteConseiller(Conseiller conseiller) {
        if (!ConseillerDao.findByUser(conseiller.getUsername()).isEmpty()) {
            ConseillerDao.delete(conseiller);
        }
        return true;
    }

    /**
     * Service qui enregistre un depart
     *
     * @param depart Depart à sauvegarder
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean creerDepart(Depart depart) {

        if (!DepartDao.findByCodeDep(depart.getCodeDepart()).isEmpty()) {
            return false;
        } else {
            DepartDao.persiste(depart);
            return true;
        }
    }

    /**
     * Service qui met à jour un depart
     *
     * @param depart_new depart mis à jour
     * @param depart_old depart à mettre à jour
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean updateDepart(Depart depart_new, Depart depart_old) {
        if (!depart_new.getCodeDepart().equals(depart_old.getCodeDepart())) {
            if (!DepartDao.findByCodeDep(depart_new.getCodeDepart()).isEmpty()) {
                return false;
            }
        }
        jpaUtil.startTransiction();
        depart_old.update(depart_new);
        DepartDao.update(depart_old);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Service qui supprime un depart
     *
     * @param depart Depart à supprimer
     * @return vrai si la suppression s'est passée correctement, faux sinon
     */
    public static boolean deleteDepart(Depart depart) {
        if (!DepartDao.findByCodeDep(depart.getCodeDepart()).isEmpty()) {
            DepartDao.delete(depart);
        }
        return true;
    }

    /**
     * Service qui enregistre un devis
     *
     * @param devis Devis à sauvegarder
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean creerDevis(Devis devis) {
        if (devis.getVoyage() == null || devis.getConseiller() == null || devis.getClient() == null || devis.getDateDepart() == null)
        {
            return false;
        }
        if (!DevisDao.find(devis.getVoyage(), devis.getConseiller(), devis.getClient(), devis.getDateDepart()).isEmpty()) {
            return false;
        } else {
            DevisDao.persiste(devis);
            return true;
        }
    }

    /**
     * Service qui met à jour un devis
     *
     * @param devis_new devis mis à jour
     * @param devis_old devis à mettre à jour
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean updateDevis(Devis devis_new, Devis devis_old) {
        if (!(devis_new.getVoyage().equals(devis_old.getVoyage()))
         && !(devis_new.getConseiller().equals(devis_old.getConseiller()))
         && !(devis_new.getClient().equals(devis_old.getClient()))
         && !(devis_new.getDateDepart().equals(devis_old.getDateDepart()))){
            
        }
        jpaUtil.startTransiction();
        devis_old.update(devis_new);
        DevisDao.update(devis_old);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Service qui supprime un devis
     *
     * @param devis Devis à supprimer
     * @return vrai si la suppression s'est passée correctement, faux sinon
     */
    public static boolean deleteDevis(Devis devis) {
        if (!DevisDao.find(devis.getVoyage(), devis.getConseiller(), devis.getClient(), devis.getDateDepart()).isEmpty()) {
            DevisDao.delete(devis);
        }
        return true;
    }
    
    /**
     * Service qui enregistre un pays
     *
     * @param pays Pays à sauvegarder
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean creerPays(Pays pays) {

        if (!PaysDao.findByCodePays(pays.getCodePays()).isEmpty()) {
            return false;
        } else {
            PaysDao.persiste(pays);
            return true;
        }
    }

    /**
     * Service qui met à jour un pays
     *
     * @param pays_new pays mis à jour
     * @param pays_old pays à mettre à jour
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean updatePays(Pays pays_new, Pays pays_old) {
        if (pays_new.getCodePays() != pays_old.getCodePays()){
            if (!PaysDao.findByCodePays(pays_new.getCodePays()).isEmpty())
            {
                return false;
            }
        }
        jpaUtil.startTransiction();
        pays_old.update(pays_new);
        PaysDao.update(pays_old);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Service qui supprime un pays
     *
     * @param pays Pays à supprimer
     * @return vrai si la suppression s'est passée correctement, faux sinon
     */
    public static boolean deletePays(Pays pays) {
        if (!PaysDao.findByCodePays(pays.getCodePays()).isEmpty()) {
            PaysDao.delete(pays);
        }
        return true;
    }
    
    /**
     * Service qui enregistre un voyage
     *
     * @param voyage Voyage à sauvegarder
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean creerVoyage(Voyage voyage) {

        if (!VoyageDao.findByCodeVoyage(voyage.getCode()).isEmpty()) {
            return false;
        } else {
            VoyageDao.persiste(voyage);
            return true;
        }
    }

    /**
     * Service qui met à jour un voyage
     *
     * @param voyage_new voyage mis à jour
     * @param voyage_old voyage à mettre à jour
     * @return vrai si la création s'est passée correctement, faux sinon
     */
    public static boolean updateVoyage(Voyage voyage_new, Voyage voyage_old) {
        if (voyage_new.getCode()!= voyage_old.getCode()){
            if (!VoyageDao.findByCodeVoyage(voyage_new.getCode()).isEmpty())
            {
                return false;
            }
        }
        jpaUtil.startTransiction();
        voyage_old.update(voyage_new);
        VoyageDao.update(voyage_old);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Service qui supprime un voyage
     *
     * @param voyage Voyage à supprimer
     * @return vrai si la suppression s'est passée correctement, faux sinon
     */
    public static boolean deleteVoyage(Voyage voyage) {
        if (!VoyageDao.findByCodeVoyage(voyage.getCode()).isEmpty()) {
            VoyageDao.delete(voyage);
        }
        return true;
    }
    
    

    /**
     * <strong>Only used for TESTS</strong>
     */
    public static void clean() {
        jpaUtil.startTransiction();
        ClientDao.removeAll();
        ConseillerDao.removeAll();
        DepartDao.removeAll();
        DevisDao.removeAll();
        PaysDao.removeAll();
        VoyageDao.removeAll();
        jpaUtil.commitTransiction();
    }
}
