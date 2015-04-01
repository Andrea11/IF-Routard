/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author aaccardo
 */
@Entity
@Table(name = "DEVIS", uniqueConstraints
        = @UniqueConstraint(columnNames = {"VOYAGE", "CONSEILLER", "CLIENT", "DATEDEPART"}))
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "VOYAGE", nullable = false)
    private Voyage voyage;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "CONSEILLER", nullable = false)
    private Conseiller conseiller;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "CLIENT", nullable = false)
    private Client client;

    @Column(name = "DATEDEPART", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @Column(name = "PRIX", nullable = false)
    private int prix;

    public Devis(Voyage voyage, Conseiller conseiller, Client client, Date dateDepart, int prix) {
        this.voyage = voyage;
        this.conseiller = conseiller;
        this.client = client;
        this.dateDepart = dateDepart;
        this.prix = prix;
    }

    /**
     * Empty constructor, <strong>only used for persistence</strong>
     */
    public Devis() {
    }

    public void update(Devis d) {
        this.voyage = d.voyage;
        this.conseiller = d.conseiller;
        this.client = d.client;
        this.dateDepart = d.dateDepart;
        this.prix = d.prix;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public Integer getId() {
        return id;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public int getPrix() {
        return prix;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Devis{" + "voyage=" + voyage + ", conseiller=" + conseiller + ", client=" + client + ", dateDepart=" + dateDepart + ", prix=" + prix + '}';
    }

}
