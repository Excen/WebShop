/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Factory;

import DAOs.Impl.BestellingDAOImpl;
import DAOs.Interface.BestellingDAOInterface;

/**
 *
 * @author Excen
 */
public class BestellingDAOFactory {
    public static BestellingDAOInterface createDAO(){
        return (new BestellingDAOImpl());
    }
}


