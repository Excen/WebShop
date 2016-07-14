/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Factory;


import DAOs.Impl.AdresDAOImpl;

import DAOs.Interface.AdresDAOInterface;

/**
 *
 * @author Wendy
 */
public class AdresDAOFactory {
    public static AdresDAOInterface createAdresDAO(){
        return new AdresDAOImpl();
    }
}
