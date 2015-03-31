/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aaccardo
 */

public class Conseiller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    private String nom;

    private String prenom;

    @Column(unique=true)
    private String eMail;

    public Conseiller(String nom, String prenom, String eMail) {
        this.nom = nom;
        this.prenom = prenom;
        this.eMail = eMail;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String geteMail() {
        return eMail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Conseiller{" + "nom=" + nom + ", prenom=" + prenom + ", eMail=" + eMail + '}';
    }
    
    
}
