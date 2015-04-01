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
public class Circuit extends Voyage {

    /*
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int idCircuit;
    
     @Version
     private int version;
     */
    private int distanceKm;

    private String transport;

    /**
     * Empty constructor, <strong>only used for persistence</strong>
     */
    protected Circuit() {
        super();
    }

    /**
     * Complete constructor
     *
     * @param code Le code du pays (unique)
     * @param nom Le nom du voyage
     * @param dureeJour La durée du voyage en nombre de jours
     * @param description La description du voyage
     * @param distanceKm
     * @param transport
     * @param gamme
     * @param pays Le pays sur lequel porte le voyage
     */
    public Circuit(String code, String nom, int dureeJour, String description,
            int distanceKm, String transport, String gamme, List<Depart> departs, List<Pays> pays) {
        super(code, description, dureeJour, nom, gamme, departs, pays);
        this.distanceKm = distanceKm;
        this.transport = transport;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public String getTransport() {
        return transport;
    }

    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return (Voyage.class).toString() + "Circuit{" + "distanceKm=" + distanceKm + ", transport=" + transport + '}';
    }
    
    
}
