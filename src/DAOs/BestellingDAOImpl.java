/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import WorkShop.Bestelling;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Excen
 */
public class BestellingDAOImpl implements BestellingDAO {
    
    String url = "URL";
    String user = "User";
    String pw = "PassWord";
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;


    public ArrayList<Bestelling> findAll() throws SQLException {
        
        ArrayList<Bestelling>bestellinglijst = new ArrayList<>();
        
        String sqlQuery = "select * from Bestelling";
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            
        while (rs.next()) {
            
            Bestelling bestelling = new Bestelling();
            bestelling.setBestelling_id(rs.getInt("bestelling_id"));

            // add bestelling in de list
            bestellinglijst.add(bestelling);
            }
          
          return bestellinglijst;  
          }
    

    @Override
    public Bestelling FindById(int bestelling_id) throws SQLException {
        
        String sqlQuery = "select " + bestelling_id + " from bestelling";
        Bestelling bestelling = null;
        
        con = DriverManager.getConnection(url, user, pw);
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            
        while (rs.next()) {
            
            bestelling = new Bestelling();
            bestelling.setBestelling_id(rs.getInt("bestelling_id"));

            
            }    
            return bestelling;
        }
        
    }

    @Override
    public boolean instert(Bestelling bestelling) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Bestelling bestelling) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Bestelling bestelling) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
