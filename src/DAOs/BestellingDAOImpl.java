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
    
    

    @Override
    public ArrayList<Bestelling>bestellinglijst findAll() throws SQLException {
        con = DriverManager.getConnection(url, user, pw);
        String sqlQuery = "select * from Bestelling";
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        while (rs.next()) {
            
            Bestelling bestelling = new Bestelling();
            bestelling.setBestelling_id(rs.getInt("bestelling_id"));
            bestelling.
            
            
            artikel.setArtikelID(rs.getInt("artikel_id"));
            artikel.setArtikelNaam(rs.getString("atrikel_naam"));
            artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            // add the artikel in the list
            artikelList.add(artikel);
            }
          connection.close();
          return artikelList;  
    }

    @Override
    public Bestelling FindById(int bestelling_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
