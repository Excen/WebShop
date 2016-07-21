/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Factory;

import DAOs.Impl.KlantAdresDAOImpl;
import DAOs.Interface.KlantAdresDAOInterface;

/**
 *
 * @author Wendy
 */
public class KlantAdresDAOFactory {
    public static KlantAdresDAOInterface createKlantAdresDAO(){
        return new KlantAdresDAOImpl();
}
}
