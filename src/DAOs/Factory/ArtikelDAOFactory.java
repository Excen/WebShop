/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Factory;

import DAOs.Impl.ArtikelDAOImpl;
import DAOs.Interface.ArtikelDAOInterface;

/**
 *
 * @author Anne
 */
public class ArtikelDAOFactory {
    public static ArtikelDAOInterface createDAO() {
        
        String change = "yeah het werkt!";
        return (new ArtikelDAOImpl());
    }
}
