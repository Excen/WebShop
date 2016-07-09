/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

/**
 *
 * @author Wendy
 */
public class KlantDAOFactory {
    public static KlantDAO createKlantDao(){
        return new KlantDAOImpl();
                
    }
}
