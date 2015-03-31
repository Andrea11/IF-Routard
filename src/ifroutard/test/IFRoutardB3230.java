/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.test;

import ifroutard.model.Client;
import java.util.Iterator;
import java.util.List;
import ifroutard.service.Creer;
import ifroutard.service.Recherche;

/**
 *
 * @author aaccardo
 */
public class IFRoutardB3230 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Recherche r = new Recherche();
        //new Creation().creerClient("M.", "BORROTI MATIAS DANTAS", "Andrea <3", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "andrea@free.fr");
        Client newClient = new Client("M.", "ACCARDO", "s", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "rborrotimatiasdantas4171@free.fr", "andrea", "pass");
        Creer serviceClient = new Creer();
        //String [] newClient = {"M.", "ACCARDO", "Andrea", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "rborrotimatiasdantas4171@free.fr"};
        //serviceClient.creerClient(newClient);
        String[] nom = {"ACCARDO", "s"};
        List result1 = r.getClient(nom);
        List result2 = r.getClientEmail("rborrotimatiasdantas4171");
        List result3 = r.getClientTel("0328");
        System.out.println("Original contents of all: ");
        Iterator itr = result1.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

       /* itr = result2.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        itr = result3.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\r\n");
        }
        System.out.println();

        /*
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("IF-Routard-B3230PU");
         EntityManager em = emf.createEntityManager();

         em.getTransaction().begin();
         Client newClient = new Client("M.", "BORROTI MATIAS DANTAS", "Raphaël", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "rborrotimatiasdantas4171@free.fr");
         em.persist(newClient);

         em.getTransaction().commit();

         em.close();
        
        
        

         /*
         EntityManagerFactory emf;
         emf = Persistence.createEntityManagerFactory("IF-Routard-B3230PU");
         EntityManager em = emf.createEntityManager();

         em.getTransaction().begin();

         Query q = em.createQuery("SELECT e FROM Client e");
         //q.setParameter("name", "Michael");
         List<Client> result = q.getResultList();

         // Use iterator to display contents of al
         System.out.println("Original contents of al: ");
         Iterator itr = result.iterator();
         while (itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + "\r\n");
         }
         System.out.println();

         em.close();
         */
    }

}
