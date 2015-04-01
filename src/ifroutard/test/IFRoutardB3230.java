/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.test;

import ifroutard.model.Circuit;
import ifroutard.model.Client;
import ifroutard.model.Conseiller;
import ifroutard.model.Depart;
import ifroutard.model.Devis;
import ifroutard.model.Pays;
import ifroutard.model.Sejour;
import java.util.Iterator;
import java.util.List;
import ifroutard.service.Creer;
import ifroutard.service.Recherche;
import ifroutard.util.DateUtil;
import java.util.ArrayList;

/**
 *
 * @author aaccardo
 */
public class IFRoutardB3230 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Initialisation
        String[] test = {"A", null};
        List result;
        Iterator itr;
        List<Pays> pays = new ArrayList<>();
        List<Depart> departs = new ArrayList<>();
        Client testClient1 = new Client("M.", "BORROTI MATIAS DANTAS", "Andrea <3", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "andrea@free.fr", "pass");
        Client testClient2 = new Client("M.", "ACCARDO", "s", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "rborrotimatiasdantas4171@free.fr", "pass");
        Conseiller testConseiller1 = new Conseiller("Accardo", "Andrea", "test1@gmail.com", "Andri", "pass");
        Conseiller testConseiller2 = new Conseiller("Accardo", "Marco", "test2@gmail.com", "Mark", "pass");
        Depart testDepart1 = new Depart("69123", "11/07 12:30", "11/07 15:45", "Lyon", "Palerme", 150, "Vol low-cost", "avion");
        Depart testDepart2 = new Depart("69143", "11/07 10:30", "11/07 16:45", "Rome", "Palerme", 100, "Vol low-cost", "avion");
        departs.add(testDepart1);
        departs.add(testDepart2);
        Pays testPays1 = new Pays("62314", "Italie", "Rome", "Italien", 60000000, 250000);
        Pays testPays2 = new Pays("64514", "France", "Paris", "Français", 72000000, 300000);
        pays.add(testPays1);
        Circuit testCircuit1 = new Circuit("3525", "Safari", 12, "Découverte de l'Afrique", 3500, "Jeep", "moyenne", departs, pays);
        Circuit testCircuit2 = new Circuit("3535", "Randonnée", 8, "Les Alpes", 252, "Pie", "low-budget", departs, pays);
        pays.add(testPays2);
        Sejour testSejour1 = new Sejour("1423", "Paix", 7, "", "chambre double", "haute", departs, pays);
        Sejour testSejour2 = new Sejour("1523", "Calme", 4, "", "chambre single", "haute", departs, pays);
        Devis testDevis1 = new Devis(testSejour2, testConseiller1, testClient2, DateUtil.toTime("15/07 18:34"), 1600);
        Devis testDevis2 = new Devis(testCircuit1, testConseiller2, testClient1, DateUtil.toTime("21/07 08:34"), 1200);

        // Création
        Creer.creerClient(testClient1);
        Creer.creerConseiller(testConseiller1);
        Creer.creerDepart(testDepart1);
        Creer.creerPays(testPays1);
        Creer.creerVoyage(testCircuit1);
        Creer.creerVoyage(testSejour1);
        Creer.creerDevis(testDevis2);

/*
        // Recherche 1
        
         result = Recherche.getClient(test);

         // Affichage 1
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 2
         result = Recherche.getClientEmail("andrea@");

         // Affichage 2
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 3
         result = Recherche.getClientTel("0328");

         // Affichage 3
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 4
         result = Recherche.getAllClient();

         // Affichage 4
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();
         // Recherche 5
         result = Recherche.getDepart("691");

         // Affichage 5
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 6
         result = Recherche.getDepartParDate(DateUtil.toTime("11-07 12:30"));

         // Affichage 6
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 7
         result = Recherche.getDepartParLieu("Lyon", "PaL");

         // Affichage 7
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 8
         result = Recherche.getDepartParPrix(300, 100);

         // Affichage 8
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();
         // Recherche 9
         result = Recherche.getPaysParCodePays("62314");

         // Affichage 9
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 10
         result = Recherche.getPaysParNomPays("Italie");

         // Affichage 10
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         // Recherche 11
         result = Recherche.getPaysParLangue("Italien");

         // Affichage 11
         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();*/
        // Recherche 12
        result = Recherche.getCircuitParKm(3000);

        // Affichage 12
        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        // Recherche 13
        result = Recherche.getVoyageParCode("1");

        // Affichage 13
        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        // Recherche 14
        result = Recherche.getVoyageParDuree(4);

        // Affichage 14
        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        // Recherche 15
        result = Recherche.getVoyageParNom("Calme");

        // Affichage 15
        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        // Recherche 16
        result = Recherche.getVoyageParPays(pays);

        // Affichage 16
        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        // Recherche 17
        result = Recherche.getDevis(testSejour2, testConseiller1, testClient2, DateUtil.toTime("15/07 18:34"));

        // Affichage 17
        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();


        // Mis à jour
        /*System.out.println("MIS A JOUR");
        Creer.updateClient(testClient2, testClient1);
        Creer.updateConseiller(testConseiller2, testConseiller1);
        Creer.updateDepart(testDepart2, testDepart1);
        Creer.updatePays(testPays2, testPays1);/*
         result = Recherche.getAllConseiller();

         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         result = Recherche.getAllClient();

         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         result = Recherche.getAllDepart();

         itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();*/

        result = Recherche.getAllPays();

        itr = result.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();
        //Creer.clean();
    }

}
