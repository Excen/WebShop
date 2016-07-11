/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

/**
 *
 * @author Anne
 */
public class ArtikelDAOFactory {
    public static ArtikelDAO createDAO() {
        
        String change = "yeah het werkt!";
        return (new ArtikelDAOImpl());
    }
}
