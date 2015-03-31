/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Version;

/**
 *
 * @author aaccardo
 */
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDepart;

    @Version
    private int version;

    @Column(nullable = false, unique = true)
    private String codeDepart;

    private Date dateDepart;

    private Date dateArrivee;

    private String lieuDepart;

    private String lieuArrivee;

    private int prix; //prix en euros

    private String description;
    
    private String moyenTransport;

    /**
     * Empty constructor, <strong>only used for persistence</strong>
     */
    public Depart() {
    }

    /**
     *  Small constructor
     * 
     * @param codeDepart
     * @param dateDepart
     * @param dateArrivee
     * @param lieuDepart
     * @param lieuArrivee
     */
    public Depart(String codeDepart, Date dateDepart, Date dateArrivee, String lieuDepart, String lieuArrivee) {
        this.codeDepart = codeDepart;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
    }
    /**
     *  Complete constructor
     * 
     * @param codeDepart
     * @param dateDepart
     * @param dateArrivee
     * @param lieuDepart
     * @param lieuArrivee
     * @param prix
     * @param description 
     * @param moyenTransport
     */
    public Depart(String codeDepart, Date dateDepart, Date dateArrivee, String lieuDepart, String lieuArrivee, int prix, String description, String moyenTransport) {
        this.codeDepart = codeDepart;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
        this.prix = prix;
        this.description = description;
        this.moyenTransport = moyenTransport;
    }

    public String getMoyenTransport() {
        return moyenTransport;
    }

    public int getIdDepart() {
        return idDepart;
    }

    public int getVersion() {
        return version;
    }

    public String getCodeDepart() {
        return codeDepart;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public String getLieuArrivee() {
        return lieuArrivee;
    }

    public int getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public void setCodeDepart(String codeDepart) {
        this.codeDepart = codeDepart;
        this.version++;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
        this.version++;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
        this.version++;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
        this.version++;
    }

    public void setLieuArrivee(String lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
        this.version++;
    }

    public void setPrix(int prix) {
        this.prix = prix;
        this.version++;
    }

    public void setDescription(String description) {
        this.description = description;
        this.version++;
    }

    public void setMoyenTransport(String moyenTransport) {
        this.moyenTransport = moyenTransport;
    }
    

}
