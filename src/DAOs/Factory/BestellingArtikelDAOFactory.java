/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Factory;

import DAOs.Impl.BestellingArtikelDAOImpl;
import DAOs.Interface.BestellingArtikelDAOInterface;

/**
 *
 * @author Excen
 */
public class BestellingArtikelDAOFactory {
    public static BestellingArtikelDAOInterface createDAO(){
        return (new BestellingArtikelDAOImpl());
    }
}


