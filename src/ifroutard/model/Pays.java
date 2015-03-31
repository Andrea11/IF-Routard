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
import javax.persistence.Version;

/**
 *
 * @author aaccardo
 */
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPays;

    @Version
    private int version;

    private String namePays;

    @Column(nullable = false, unique = true)
    private String codePays;

    private String capital;

    private String languages;

    private long nbInhabitants;

    private long surface;

    /**
     * Empty constructor, <strong>only used for persistence</strong>
     */
    protected Pays() {
    }

    /**
     * Small constructor
     *
     * @param codePays The country code
     * @param namePays The country name
     * @param capital The country capital
     */
    public Pays(String codePays, String namePays, String capital) {
        this.codePays = codePays;
        this.namePays = namePays;
        this.capital = capital;
        this.languages = null;
        this.nbInhabitants = 0;
        this.surface = 0;
    }

    /**
     * Complete constructor
     *
     * @param codePays The country code
     * @param namePays The country name
     * @param capital The country capital
     * @param languages The languages spoken as a String
     * @param nbInhabitants The country number of inhabitants
     * @param surface The surface in square km
     */
    public Pays(String codePays, String namePays, String capital, String languages,
            long nbInhabitants, long surface) {
        this.codePays = codePays;
        this.namePays = namePays;
        this.capital = capital;
        this.languages = languages;
        this.nbInhabitants = nbInhabitants;
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Pays{" + "namePays=" + namePays + ", codePays=" + codePays + ", capital=" + capital + ", languages=" + languages + ", nbInhabitants=" + nbInhabitants + ", surface=" + surface + '}';
    }
    
    

    public int getVersion() {
        return version;
    }

    public String getNamePays() {
        return namePays;
    }

    public String getCodePays() {
        return codePays;
    }

    public String getCapital() {
        return capital;
    }

    public String getLanguages() {
        return languages;
    }

    public long getNbInhabitants() {
        return nbInhabitants;
    }

    public long getSurface() {
        return surface;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
        this.version++;
    }

    public void setCapital(String capital) {
        this.capital = capital;
        this.version++;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
        this.version++;
    }

    public void setNbInhabitants(long nbInhabitants) {
        this.nbInhabitants = nbInhabitants;
        this.version++;
    }

    public void setSurface(long surface) {
        this.surface = surface;
        this.version++;
    }

}
