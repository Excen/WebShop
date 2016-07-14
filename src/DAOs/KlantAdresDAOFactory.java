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
public class KlantAdresDAOFactory {
    public static KlantAdresDAO createKlantAdresDao(){
        return new KlantAdresDAOImpl();
}
}
