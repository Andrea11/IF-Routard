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

/**
 *
 * @author aaccardo
 */

/* contrat
 *
 *   {"M.", "BORROTI MATIAS DANTAS", "Raphaël", "1976-07-10", "70 rue des Coquelicots, Villeneuve-d'Ascq", "0328178508", "rborrotimatiasdantas4171@free.fr"}
 */
@Entity
@Table(name = "CLIENTS") //, uniqueConstraints = @UniqueConstraint(columnNames = {"email", }))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    private String civilite;
    
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String adressePostale;

    private String telephone;

    @Column(nullable = false, unique = true)
    private String eMail;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public Client() {
    }

    public Client(String nom, String prenom, String eMail, String username, String password) {
        this.civilite = null;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = null;
        this.adressePostale = null;
        this.telephone = null;        
        this.eMail = eMail;
        this.username = username;
        this.password = password;
    }

    
    
    public Client(String civilite, String nom, String prenom, String dateNaissance, String adressePostale, String telephone, String eMail, String username, String password) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = DateUtil.toDate(dateNaissance);
        this.adressePostale = adressePostale;
        this.telephone = telephone;
        this.eMail = eMail;
        this.username = username;
        this.password = password;
    }

    public void update(Client c) {
        this.civilite = c.civilite;
        this.nom = c.nom;
        this.prenom = c.prenom;
        this.dateNaissance = c.dateNaissance;
        this.adressePostale = c.adressePostale;
        this.telephone = c.telephone;
        this.eMail = c.eMail;
        this.username = c.username;
        this.password = c.password;
    }
    
    public String getCivilite() {
        return civilite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public String getTelephone() {
        return telephone;
    }

    public String geteMail() {
        return eMail;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + DateUtil.Display(dateNaissance) + ", adressePostale=" + adressePostale + ", telephone=" + telephone + ", eMail=" + eMail + ", username=" + username + ", password=" + password + '}';
    }

    
    
    

}
