
package DAOs;

import WorkShop.Artikel;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;



public class ArtikelDAOImpl implements ArtikelDAO {
    
    /** strusture:
    * driver;
    * connection;
    * ResultSet;
    * PreperaredStatement;
    * public Artikel[] // arraylist? findAll method() throws SQLException {
    *   Artikel[] artikel;
    *   String sqlQuery = "select * from Artikel";
    *   con = ResourceManager.getConnection();
    *   stmt = con.prepareStatement(sqlquery);
    *   rs = statement.executeQuery();
    *   while (rs.next) {
    *       // get columns and stor in array;
    *       }
    *   return artikel;
    *   }
    */
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
   
   
    @Override
    public ArrayList<Artikel> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Artikel> artikelList = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost3306/winkel", "annehoogerbrugge", "74ZkAgs190");
        String sqlQuery = "select * from Artikel";
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        while (rs.next()) {
            /** get the fields from one artikel
             * and store it in an Artikel object
             */
            Artikel artikel = new Artikel();
            artikel.setArtikelID(rs.getInt("artikel_id"));
            artikel.setArtikelNaam(rs.getString("atrikel_naam"));
            artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            // add the artikel in the list
            artikelList.add(artikel);
            }
          connection.close();
          return artikelList;  
       
       // ga morgen verder    
}
    
            
    /** @Override
    public Artikel findbyArtikelID (int artikelID) throws SQLException {
        // implementation code
        // String sqlQuery = "select * from Artikel where artikel_id = " + artikelID; of ?
        return Artikel;
        
        }
    public Artikel findbyArtikelNaam (String artikelNaam) throws SQLException {
        // implementation code
        // String sqlQuery = "select * from Artikel where artikel_Naam = " + artikelNaam;
        return Artikel;
        }
    public Artikel findbyArtikelPrijs (double artikelPrijs) throws SQLException {
        // implementation code
        // String sqlQuery = "select * from Artikel where artikel_prijs = " + artikelPrijs;
        return Artikel;
        }
    // insert methode
    // delete methode
    // update methode
    * /
}
