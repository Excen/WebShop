/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Factory;



import DAOs.Impl.KlantDAOImpl;
import DAOs.Interface.KlantDAOInterface;

/**
 *
 * @author Wendy
 */
public class KlantDAOFactory {
    public static KlantDAOInterface createKlantDAO(){
        return new KlantDAOImpl();
                
    }
}
