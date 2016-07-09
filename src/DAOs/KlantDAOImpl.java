/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;


import WorkShop.Klant;
import WorkShop.Klant.KlantBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Wendy
 */
class KlantDAOImpl implements KlantDAO {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost3306/Winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;

    /* Class.forName(driver);
    con = DriverManager.getConnection(url,user,pw );
    */

    @Override
    public ArrayList<Klant> findAllKlanten() throws SQLException, ClassNotFoundException {
        ArrayList<Klant> klantenLijst = new ArrayList<>();
       
        String sqlQuery = "select * from Klant";
        
        try{
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
        while (rs.next()) {
            
            KlantBuilder klantBuilder = new KlantBuilder();
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            Klant klant = klantBuilder.build();    
            //voeg klant toe aan lijst
            klantenLijst.add(klant);
            con.close(); 
        }
        }
        catch(SQLException ex){}
                               
        return klantenLijst; 
    }
    
    @Override
    public Klant findByKlantId(int klantId) throws SQLException {
        Klant klant = Klant.getInstance();  
        String sqlQuery = "select voornaam, achternaam, tussenvoegsel, email " + 
                "from Klant where klant_id = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setInt(1, klantId);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            KlantBuilder klantBuilder = new KlantBuilder();
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
            con.close();            
        }        
        }
        catch(SQLException ex){}
                
        return klant;
    }    
    
        @Override
    public Klant findByVoorNaam(String voorNaam) throws SQLException {
        
        Klant klant = Klant.getInstance();  
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where voornaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setString(1, voorNaam);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            KlantBuilder klantBuilder = new KlantBuilder();
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
            con.close();            
        }        
        }
        catch(SQLException ex){}
                
        return klant;
    }

    @Override
    public Klant findByAchterNaam(String achterNaam) throws SQLException {
        Klant klant = Klant.getInstance();  
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where achternaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setString(1, achterNaam);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            KlantBuilder klantBuilder = new KlantBuilder();
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
            con.close();            
        }        
        }
        catch(SQLException ex){}
                
        return klant;
    }


    @Override
    public Klant findByEmail(String email) throws SQLException {
        Klant klant = Klant.getInstance();  
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where email = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setString(1, email);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            KlantBuilder klantBuilder = new KlantBuilder();
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
            con.close();            
        }        
        }
        catch(SQLException ex){}
                
        return klant;
    }

    @Override
    public Klant findByVoorNaamAchterNaam(String voorNaam, String achterNaam) throws SQLException {
        Klant klant = Klant.getInstance();  
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where voorNaam = ? and achterNaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setString(1, voorNaam);
            stmt.setString(2, achterNaam);
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            KlantBuilder klantBuilder = new KlantBuilder();
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
            con.close();            
        }        
        }
        catch(SQLException ex){}
                
        return klant;
    }

    @Override
    public void insert() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Voornaam: ");
        String voornaam = input.next().trim();
        
        System.out.print("Achternaam: ");
        String achternaam = input.next().trim();
        
        System.out.print("tussenvoegsel: ");
        String tussenvoegsel = input.next().trim();
        
        System.out.print("email: ");
        String email = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "insert into Klant (voornaam, achternaam, tussenvoegsel, email)"
                         + " values (?, ?, ?, ?)";
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, voornaam);
                 preparedStmt.setString (2, achternaam);
                 preparedStmt.setString (3, tussenvoegsel);
                 preparedStmt.setString (4, email);
                 
                 // execute the preparedstatement
                 preparedStmt.execute();
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }    
    @Override
    public void updateVoorNaam() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("Voornaam: ");
        String voornaam = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Klant set voornaam = ? where klant_id = " 
                         + klantId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, voornaam);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        
    }

    @Override
    public void updateAchterNaam() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("Achternaam: ");
        String achternaam = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Klant set achternaam = ? where klant_id = " 
                         + klantId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, achternaam);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        
    }
    
    @Override
    public void updateTussenVoegsel() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("TussenVoegsel: ");
        String tussenvoegsel = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Klant set tussenvoegsel = ? where klant_id = " 
                         + klantId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, tussenvoegsel);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        
    }
    
    @Override
    public void updateEmail() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
        System.out.print("Email: ");
        String email = input.next().trim();
        
         try {
      // create a mysql database connection
      
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "Update Klant set email = ? where klant_id = " 
                         + klantId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, email);
                                
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        
    }
    
    @Override
    public void delete() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
       
        
      try{  
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from klant where klant_id = " 
                         + klantId ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                                                 
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
      }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
    }    
        
    
    
    @Override
    public void deleteAll() throws SQLException {
        
        try{  
            
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement
                 String sqlQuery = "delete from klant";                         
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                                                 
                 // execute the preparedstatement
                 preparedStmt.executeUpdate();
                 
             }
      }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
        
    }

    
    
    
    
}
