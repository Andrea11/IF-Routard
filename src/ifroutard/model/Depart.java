/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.model;

import ifroutard.util.DateUtil;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Version;

/**
 *
 * @author aaccardo
 */
@Entity
@Table(name = "DEPARTS")
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDepart;

    @Version
    private int version;

    @Column(nullable = false, unique = true)
    private String codeDepart;

    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @Temporal(TemporalType.DATE)
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
     * Small constructor
     *
     * @param codeDepart
     * @param dateDepart
     * @param dateArrivee
     * @param lieuDepart
     * @param lieuArrivee
     */
    public Depart(String codeDepart, String dateDepart, String dateArrivee, String lieuDepart, String lieuArrivee) {
        this.codeDepart = codeDepart;
        this.dateDepart = DateUtil.toTime(dateDepart);
        this.dateArrivee = DateUtil.toTime(dateArrivee);
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
    }

    /**
     * Complete constructor
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
    public Depart(String codeDepart, String dateDepart, String dateArrivee, String lieuDepart, String lieuArrivee, int prix, String description, String moyenTransport) {
        this.codeDepart = codeDepart;
        this.dateDepart = DateUtil.toTime(dateDepart);
        this.dateArrivee = DateUtil.toTime(dateArrivee);
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
        this.prix = prix;
        this.description = description;
        this.moyenTransport = moyenTransport;
    }

    public void update(Depart d) {
        this.codeDepart = d.codeDepart;
        this.dateDepart = d.dateDepart;
        this.dateArrivee = d.dateArrivee;
        this.lieuDepart = d.lieuDepart;
        this.lieuArrivee = d.lieuArrivee;
        this.prix = d.prix;
        this.description = d.description;
        this.moyenTransport = d.moyenTransport;
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

    @Override
    public String toString() {
        return "Depart{" + "codeDepart=" + codeDepart + ", dateDepart=" + DateUtil.displayTime(dateDepart) + ", dateArrivee=" + DateUtil.displayTime(dateArrivee) + ", lieuDepart=" + lieuDepart + ", lieuArrivee=" + lieuArrivee + ", prix=" + prix + ", description=" + description + ", moyenTransport=" + moyenTransport + '}';
    }

}
