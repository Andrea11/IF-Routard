/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.model;

import java.util.List;
import javax.persistence.Entity;

/**
 * @author AAccardo CCanete
 */

@Entity
public class Sejour extends Voyage {
    
    /*
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int idSejour;
    
     @Version
     private int version;
     */

    private String residence;

    /**
     * Empty constructor, <strong>only used for persistence</strong>
     */
    protected Sejour() {
        super();
    }

    /**
     * Complete constructor
     *
     * @param code Le code du pays (unique)
     * @param nom Le nom du voyage
     * @param dureeJour La durée du voyage en nombre de jours
     * @param description La description du voyage
     * @param residence La description de la résidence du séjour
     * @param gamme
     * @param pays Le pays sur lequel porte le voyage
     */
    public Sejour(String code, String nom, int dureeJour, String description,
            String residence, String gamme, List<Depart> departs, List<Pays> pays) {
        super(code, description, dureeJour, nom, gamme, departs, pays);
        this.residence = residence;
    }

	// Getters and setters:
    /**
     * @return the residence
     */
    public String getResidence() {
        return residence;
    }

    /**
     * @param residence the residence to set
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }
}
