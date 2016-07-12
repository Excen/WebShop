/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

/**
 *
 * @author Excen
 */
public class BestellingArtikelDAOFactory {
    public static BestellingArtikelDAO createDAO(){
        return (new BestellingArtikelDAOImpl());
    }
}


