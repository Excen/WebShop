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
//import java.util.Set;
//import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Wendy
 */
class KlantDAOImpl implements KlantDAO {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    //String url = "jdbc:mysql://localhost3306/winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    
    ArrayList <String> voornaamLijst = new ArrayList<>();
    ArrayList <String> achternaamLijst = new ArrayList<>();
    ArrayList <String> tussenvoegselLijst = new ArrayList<>();
    /*
    private void connectToDB () {
    
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, uer, pw);
            System.out.print("You are connected to " + url);
        }
        catch(java.lang.Exception ex){
            ex.printStackTrace();
        }
*/

       
    @Override
    public ArrayList<Klant> findAllKlanten() throws SQLException, ClassNotFoundException {
       
        KlantBuilder klantBuilder = new KlantBuilder();     
        ArrayList<Klant> klantenLijst = new ArrayList<>();
        
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
        String sqlQuery = "select * from Klant";
        
        try{
        stmt = con.prepareStatement(sqlQuery);
        rs = stmt.executeQuery();
            
            while (rs.next()) {
            
                klantBuilder.klantId(rs.getInt("klant_id"));
                klantBuilder.voorNaam(rs.getString("voornaam"));
                klantBuilder.achterNaam(rs.getString("achternaam"));
                klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                klantBuilder.email(rs.getString("email"));
            
                // build Klant
                Klant klant = klantBuilder.build();    
                //voeg klant toe aan lijst
                klantenLijst.add(klant);             
            }
            con.close();
        }
        catch( SQLException ex){
            System.out.println(ex.getMessage());
        }                               
        return klantenLijst; 
    }
    
    @Override
    public Klant findByKlantId(int klantId) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant();
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected");
        
          
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where klant_id = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setInt(1, klantId);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {  
            
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
                        
        }  
        con.close();      
        }
        catch(SQLException ex){}
                
        return klant; 
    }
    
    @Override    
    public Klant findByVoorNaam(String voorNaam) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant();
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where voornaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, voorNaam);      
            rs = stmt.executeQuery();          
            
            while (rs.next()) {
            
                klantBuilder.klantId(rs.getInt("klant_id"));
                klantBuilder.voorNaam(rs.getString("voornaam"));
                klantBuilder.achterNaam(rs.getString("achternaam"));
                klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                klantBuilder.email(rs.getString("email"));
            
                // build Klant
                klant = klantBuilder.build();
                        
            }   
            con.close();     
        } 
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override
    public Klant findByAchterNaam(String achterNaam) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant();
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where achternaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, achterNaam);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {               
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
                       
        }  
        con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override
    public Klant findByEmail(String email) throws SQLException, ClassNotFoundException {
        
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant();
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where email = ? ";
        stmt = con.prepareStatement(sqlQuery);
        
        try{
            stmt.setString(1, email);      
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
                        
        } 
        con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override
    public Klant findByVoorNaamAchterNaam(String voorNaam, String achterNaam) 
            throws SQLException, ClassNotFoundException {
       
        KlantBuilder klantBuilder = new KlantBuilder();
        Klant klant = new Klant();
       
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
        
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from Klant where voorNaam = ? and achterNaam = ? ";
        stmt = con.prepareStatement(sqlQuery);
        try{
            stmt.setString(1, voorNaam);
            stmt.setString(2, achterNaam);
            rs = stmt.executeQuery();          
            
        while (rs.next()) {       
            
            klantBuilder.klantId(rs.getInt("klant_id"));
            klantBuilder.voorNaam(rs.getString("voornaam"));
            klantBuilder.achterNaam(rs.getString("achternaam"));
            klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
            klantBuilder.email(rs.getString("email"));
            
            // build Klant
            klant = klantBuilder.build();
                        
        } 
        con.close();       
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
                
        return klant;
    }

    @Override
    public Klant insertKlant() throws SQLException {
        
        Klant klant = new Klant();
        
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
                stmt = conn.prepareStatement(sqlQuery,
                         PreparedStatement.RETURN_GENERATED_KEYS);
                 stmt.setString (2, voornaam);
                 stmt.setString (3, achternaam);
                 stmt.setString (4, tussenvoegsel);
                 stmt.setString (5, email);
                 
                 rs = stmt.getGeneratedKeys();
                 if (rs.isBeforeFirst()){
                     KlantBuilder klantBuilder = new KlantBuilder();
                     rs.next(); 
                     klantBuilder.klantId(rs.getInt(1));
                     klantBuilder.voorNaam(rs.getString("voornaam"));
                     klantBuilder.achterNaam(rs.getString("achternaam"));
                     klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
                     klantBuilder.email(rs.getString("email"));
            
            // build Klant
                    klant = klantBuilder.build();
                 }
                 
                 
                 // execute the preparedstatement
                 stmt.execute();
             }
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
         return klant;
  }  /* insert klant_id ook in koppelklantadres tabel
    check: bestaat adres al? ja: 
    nee: 
    */
    
    
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
    public void deleteByKlantId() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Klant ID: ");
        int klantId = input.nextInt();
       
        
      try{  
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement.first parent, than child
                 String sqlQuery = "delete from bestelling, klant where  " 
                         + "klant.klant_id = bestelling.klant_id and klant.klant_id = " 
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
    }   // delete klnat_id ook uit koppelklantadres tabel 
        
    @Override
    public void deleteByKlantNaam() throws SQLException {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Voornaam: ");
        String voornaam = input.next().trim();
        System.out.print("Achternaam: ");
        String achternaam = input.next().trim();
        System.out.print("Tussenvoegsel: ");
        String tussenvoegsel = input.next().trim();
       
        
      try{  
      Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement.first parent, than child
                 String sqlQuery = "delete from bestelling, klant where  " 
                         + "klant.klant_id = bestelling.klant_id and klant.voornaam = " 
                         + voornaam  + ", klant.achternaam = " + achternaam + 
                         ", klant.tussenvoegsel = " + tussenvoegsel;                 
                 
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
    } // delete klnat_id ook uit koppelklantadres tabel
    
    
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
    }  // delete klnat_id ook uit koppelklantadres tabel

    @Override
    public ArrayList<Klant> FindByAdresId(int adresId) throws Exception {
    
        ArrayList<Klant> klantenByAdres = new ArrayList<>();
                
        String sqlQuery = "select klant_id, voornaam, achternaam, tussenvoegsel, "
                + "email from klant where koppelklantadres.adres_id = ? " +
                "and klant.klant_id = koppelklantadres.klant_id";
        
        stmt = con.prepareStatement(sqlQuery);
        try{
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(url, user, pw)) {
            stmt.setInt(1, adresId);      
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
                        
                }        
            }
        }
        catch(SQLException | ClassNotFoundException ex){}
                
        return klantenByAdres; 
        
        
    }

    
     @Override // gebruik methode insert van hier boven. 
    public int[] addBatchKlanten() throws Exception {    
	
	// Create statement object 
	
        String sqlQuery = "insert into Klant (voornaam, achternaam, tussenvoegsel)"
                         + " values (?, ?, ?)";  
						 
	stmt = con.prepareStatement(sqlQuery);
	
        con.setAutoCommit(false);					 
		
	int x = (int)(Math.random()* voornaamLijst.size());
	
	for (int i = 0; i < x; i++){
            String voornaam = 
               voornaamLijst.get((int)(Math.random())*(voornaamLijst.size() + 1));
            String achternaam = 
               achternaamLijst.get((int)(Math.random())*(achternaamLijst.size() + 1));
            String tussenvoegsel = 
               tussenvoegselLijst.get ((int)(Math.random())*(tussenvoegselLijst.size() + 1));
	
	// Add above SQL statement in the batch.	
	stmt.setString (1, voornaam);
        stmt.setString (2, achternaam);
        stmt.setString (3, tussenvoegsel);
        
        stmt.addBatch(sqlQuery);
	}               
    
    // Create an int[] to hold returned values
    int[] count = stmt.executeBatch();
    //Explicitly commit statements to apply changes
    con.commit();
        

    return count;  
    }  

    @Override
    public void vulVoornaamLijst (){
	Scanner input = new Scanner(System.in);
        boolean continueInput = true; 
        
       do{
        try{	
	System.out.print("Voeg nieuwe voornaam toe: ");
	String voornaamNieuw = input.nextLine(); 
        
            if(!voornaamLijst.contains(voornaamNieuw)){
                voornaamLijst.add(voornaamNieuw);  
                continueInput = false;
            }
            else {
                System.out.print("Naam bestaat al, probeer opnieuw");
                input.nextLine();            
            }  		       
        
        }
        catch (InputMismatchException ex){
            System.out.println("Probeer opnieuw: foutieve input");
           input.nextLine();
        }
       }while(continueInput);
    }
	
    @Override
    public void vulAchternaamLijst (){		
		
	Scanner input = new Scanner(System.in);
        boolean continueInput = true; 
        
       do{
        try{	
	System.out.print("Voeg nieuwe achternaam toe: ");
	String achternaamNieuw = input.nextLine(); 
        
            if(!achternaamLijst.contains(achternaamNieuw)){
                achternaamLijst.add(achternaamNieuw);  
                continueInput = false;
            }
            else {
                System.out.print("Naam bestaat al, probeer opnieuw");
                input.nextLine();            
            }  		       
        
        }
        catch (InputMismatchException ex){
            System.out.println("Probeer opnieuw: foutieve input");
           input.nextLine();
        }
       }while(continueInput);
    }
	
    @Override
    public void vulTussenvoegselLijst (){		
	Scanner input = new Scanner(System.in);
        boolean continueInput = true; 
        
       do{
        try{	
	System.out.print("Voeg nieuwe voornaam toe: ");
	String tussenvoegselNieuw = input.nextLine(); 
        
            if(!tussenvoegselLijst.contains(tussenvoegselNieuw)){
                tussenvoegselLijst.add(tussenvoegselNieuw);  
                continueInput = false;
            }
            else {
                System.out.print("Tussenvoegsel bestaat al in de lijst, probeer opnieuw");
                input.nextLine();            
            }  		       
        
        }
        catch (InputMismatchException ex){
            System.out.println("Probeer opnieuw: foutieve input");
           input.nextLine();
        }
       }while(continueInput);
    }

    
    @Override
    public void updateAdresKlant(int adresId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
		
} 


