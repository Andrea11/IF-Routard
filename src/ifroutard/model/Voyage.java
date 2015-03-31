/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author aaccardo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VOYAGE")
public abstract class Voyage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private int version;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    private Integer duree; //en jour

    private String nom;

    private String gamme;

    @ManyToMany
    private List<Pays> pays;

    @ManyToMany
    private List<Depart> departs;

    public Voyage() {
        this.departs = new ArrayList<>(); // Empty

    }

    public Voyage(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.description = "";
        this.departs = new ArrayList<>(); // Empty
        this.pays = new ArrayList<>(); // Empty

    }

    public Voyage(String code, Integer duree, String nom) {
        this.code = code;
        this.duree = duree;
        this.nom = nom;
        this.description = "";
        this.departs = new ArrayList<>(); // Empty
        this.pays = new ArrayList<>(); // Empty

    }

    public Voyage(String code, String description, Integer duree, String nom, String gamme) {
        this.code = code;
        this.description = description;
        this.duree = duree;
        this.nom = nom;
        this.gamme = gamme;
        this.departs = new ArrayList<>(); // Empty
        this.pays = new ArrayList<>(); // Empty

    }

    public int getVersion() {
        return version;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuree() {
        return duree;
    }

    public String getNom() {
        return nom;
    }

    public String getGamme() {
        return gamme;
    }

    public List<Pays> getPays() {
        return pays;
    }

    public List<Depart> getDeparts() {
        return departs;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGamme(String gamme) {
        this.gamme = gamme;
    }

    public void setDeparts(List<Depart> departs) {
        this.departs = departs;
    }

    /**
     * @param depart the depart to add
     */
    public void ajoutDepart(Depart depart) {
        this.departs.add(depart);
    }

    /**
     * @param pays the pays to add
     */
    public void ajoutPays(Pays pays) {
        this.pays.add(pays);
    }

}
