/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import static ifroutard.dao.Template.all;
import ifroutard.model.Sejour;
import java.util.List;

/**
 *
 * @author Andri
 */
public class SejourDao extends VoyageDao {

    /**
     * Retrouve tous les séjours
     *
     * @return Toutes les entites de séjour
     */
    public static List<Sejour> allSejours() {
        return all("Sejour");
    }
}
