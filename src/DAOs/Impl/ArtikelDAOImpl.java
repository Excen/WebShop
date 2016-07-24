package DAOs.Impl;

import DAOs.Interface.ArtikelDAOInterface;
import POJO.Artikel;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtikelDAOImpl implements ArtikelDAOInterface {

    Connection con;
    ResultSet rs;
    PreparedStatement pstmt;
    Statement st;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    String gebruikersNaam = "Anjewe";
    String wachtwoord = "Koetjes";

    @Override
    public ArrayList<Artikel> findAll() {
        ArrayList<Artikel> artikelList = new ArrayList<>();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlQuery = "select * from artikel";
            pstmt = con.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // get the fields from one artikel and store it in an Artikel object
                Artikel artikel = new Artikel();
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));

                // add the artikel in the list
                artikelList.add(artikel);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
        }

        return artikelList;
    }

    @Override
    public Artikel findByArtikelID(int artikelID) {
        Artikel artikel = new Artikel();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlQuery = "select * from artikel where artikel_id = ? ";
            pstmt = con.prepareStatement(sqlQuery);
            pstmt.setInt(1, artikelID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            }
            else {
                throw new NullPointerException(); // is nog nodig, of kan gewoon printstatement in else?
            }
        } 
        catch (NullPointerException ex) {
            System.out.println("Dit artikel naam bestaat niet, probeer opnieuw. ");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
        }
        return artikel;
    }

    @Override
    public Artikel findByArtikelNaam(String artikelNaam) {
        Artikel artikel = new Artikel();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String SQLZoeken = "select * from artikel where artikel_naam = '" + artikelNaam + "'";
            pstmt = con.prepareStatement(SQLZoeken);
            rs = pstmt.executeQuery(SQLZoeken);
            if (rs.next()) {
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            } 
            else {
                throw new NullPointerException(); // is nog nodig, of kan gewoon printstatement in else?
            }
        } 
        catch (NullPointerException ex) {
            System.out.println("Dit artikel naam bestaat niet, probeer opnieuw. ");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
        }
        return artikel;
    }

   
    @Override
    public Artikel findByArtikelPrijs(double artikelPrijs) {
        Artikel artikel = new Artikel();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlQuery = "select * from artikel where artikel_prijs = " + artikelPrijs;
            pstmt = con.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                artikel.setArtikelID(rs.getInt("artikel_id"));
                artikel.setArtikelNaam(rs.getString("artikel_naam"));
                artikel.setArtikelPrijs(rs.getDouble("artikel_prijs"));
            }
            else {
                throw new NullPointerException(); // is nog nodig, of kan gewoon printstatement in else?
            }
        } 
        catch (NullPointerException ex) {
            System.out.println("Dit artikel naam bestaat niet, probeer opnieuw.");    
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data search failed");
            ex.printStackTrace();
        }
        return artikel;

    }

    @Override
    public Artikel insertArtikel(String artikelNaam, double artikelPrijs) {
        //boolean return als gelukt is? 
        Artikel artikel = new Artikel();
        int artikelId = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlUpdate = "insert into artikel (artikel_naam, artikel_prijs)"
                    + "values (?, ?)";
            pstmt = con.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);

           
            pstmt.setString(1, artikelNaam);
            pstmt.setDouble(2, artikelPrijs);

            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
            if (rs.isBeforeFirst()) {
                if (rs.next()) {
                    artikelId = rs.getInt(1);
                }
            }
            artikel.setArtikelID(artikelId);
            artikel.setArtikelNaam(artikelNaam);
            artikel.setArtikelPrijs(artikelPrijs);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Data entry failed.");
            ex.printStackTrace();
            
        }
                
        return artikel;
    }
    
    
    

    // delete methode
    @Override
    public boolean deleteArtikel(int artikelId) {
        boolean isDeleted = false;
        try {
           Class.forName(driver);
           con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
           String artikelZoeken = "select * from artikel where artikel_id = " + artikelId;
           pstmt = con.prepareStatement(artikelZoeken);
           rs = pstmt.executeQuery(artikelZoeken);
           boolean artikelFound = rs.next();
           
           if (artikelFound) {
            String sqlUpdate = "delete from artikel where artikel_id = ?";
            pstmt = con.prepareStatement(sqlUpdate);
            pstmt.setInt(1, artikelId);
            pstmt.executeUpdate(); 
            isDeleted = true;
            }
             
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Deleting failed.");
            ex.printStackTrace();
        }
        return isDeleted;
    }
    
    
    // update method
    @Override
    public boolean update(Artikel artikel) {
        boolean gelukt = false;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, gebruikersNaam, wachtwoord);
            String sqlUpdate = "update artikel set artikel_id = ?, artikel_naam = ?, artikel_prijs = ?";
            pstmt = con.prepareStatement(sqlUpdate);

            pstmt.setInt(1, artikel.getArtikelID());
            pstmt.setString(2, artikel.getArtikelNaam());
            pstmt.setDouble(3, artikel.getArtikelPrijs());

            pstmt.executeUpdate();
            gelukt = true;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Update failed.");
            ex.printStackTrace();
        }
        
        return gelukt;
    }

}
