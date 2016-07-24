/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs.Impl;

import DAOs.Interface.KlantDAOInterface;
import POJO.Klant;
import POJO.Klant.KlantBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
//import java.util.Set;
//import java.util.HashSet;
//import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Wendy
 */
public class KlantDAOImpl implements KlantDAOInterface {

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
    
    KlantBuilder klantBuilder = new KlantBuilder();
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
public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      // Get an EmailValidator
            EmailValidator validator = EmailValidator.getInstance();
            
            // Validate an email address
            boolean isAddressValid = validator.isValid(email);

            // Validate a variable containing an email address
                 
    } catch (Exception ex) {
        System.out.println(email + " is not a valid E-mail address. Probeer opnieuw. ");   
        result = false;
    }
        return result;
}
       
    @Override  // werkt - niet met foreach loop
    public ArrayList<Klant> findAllKlanten() throws SQLException, ClassNotFoundException {
       
        ArrayList<Klant> klantenLijst = new ArrayList<>();
        
        try{
            //load driver
            Class.forName(driver);
            System.out.println("Driver loaded");
            //establish a connection
            con = DriverManager.getConnection(url,
                user, pw);
            System.out.println("Database Connected");
        } 
        catch(ClassNotFoundException ex){
            Logger.getLogger(KlantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
    @Override  // werkt
    public Klant findByKlantId(int klantId) throws SQLException, ClassNotFoundException {
       
       Klant klant = new Klant(klantBuilder);
       
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
    
    @Override    // werkt
    public Klant findByVoorNaam(String voorNaam) throws SQLException, ClassNotFoundException {
        
        Klant klant = new Klant(klantBuilder);
       
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

    @Override // werkt
    public Klant findByAchterNaam(String achterNaam) throws SQLException, ClassNotFoundException {
        
        Klant klant = new Klant(klantBuilder);
       
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

    @Override // werkt
    public Klant findByEmail(String email) throws SQLException, ClassNotFoundException {
        
        Klant klant = new Klant(klantBuilder);
       
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

    @Override // werkt
    public Klant findByVoorNaamAchterNaam(String voorNaam, String achterNaam) 
            throws SQLException, ClassNotFoundException {
       
        Klant klant = new Klant(klantBuilder);
       
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
    
   @Override // werkt
    public Klant insertKlant(Klant klant) throws SQLException, ClassNotFoundException {
        
        int klantId = 0;        
        
        String voornaam = klant.getVoorNaam();
        String achternaam = klant.getAchterNaam();        
        String tussenvoegsel = klant.getTussenVoegsel();
        String email = klant.getEmail();
        
        // the mysql insert statement
        String sqlQuery = "insert into Klant (voornaam, achternaam, tussenvoegsel, email)"
                         + " values (?, ?, ?, ?)";
    
        // create a mysql database connection      
        Class.forName(driver);
        // create a sql date object so we can use it in our INSERT statement
        try (Connection conn = DriverManager.getConnection(url, user, pw);
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt  = conn.prepareStatement(sqlQuery,
                Statement.RETURN_GENERATED_KEYS) ) {
                 
                preparedStmt.setString (1, voornaam);
                preparedStmt.setString (2, achternaam);
                preparedStmt.setString (3, tussenvoegsel);
                preparedStmt.setString (4, email);
                 // execute the preparedstatement
                 
                 int affectedRows = preparedStmt.executeUpdate();
                 if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                 } 
                 
                 rs = preparedStmt.getGeneratedKeys();
                 if (rs.isBeforeFirst()){
                    if (rs.next()) 
                        klantId = rs.getInt(1);                         
                 } 
                 
                klantBuilder.klantId(klantId);
                klantBuilder.voorNaam(voornaam);
                klantBuilder.achterNaam(achternaam);
                klantBuilder.tussenVoegsel(tussenvoegsel);
                klantBuilder.email(email);
                 
                klant = klantBuilder.build();
                 
        }
        catch (SQLException e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    return klant;
  }  
    
    public Klant updateGegevens(Klant klant){
    
    int klantId = klant.getKlantId();
    String voornaam = klant.getVoorNaam();
    String achternaam = klant.getAchterNaam();        
    String tussenvoegsel = klant.getTussenVoegsel();
    String email = klant.getEmail();            
        
    try {
    // create a mysql database connection
      
    Class.forName(driver);
    // create a sql date object so we can use it in our INSERT statement
        try (Connection conn = DriverManager.getConnection(url, user, pw)) {

                String sqlQuery = "Update Klant set voornaam = ? , achternaam = ?, tussenvoegsel = ?, email = ? where klant_id = ?"; 

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                preparedStmt.setString (1, voornaam);
                preparedStmt.setString (2, achternaam);
                preparedStmt.setString (3, tussenvoegsel);
                preparedStmt.setString (4, email);
                preparedStmt.setInt(5, klantId);

                // execute the preparedstatement
                preparedStmt.executeUpdate();

               // Now you can extract all the records
               // to see the updated records
               sqlQuery = "SELECT klant_id, voornaam, tussenvoegsel, achternaam, email FROM klant where klant_id = ? ";

               preparedStmt = conn.prepareStatement(sqlQuery);
               preparedStmt.setInt(1, klantId);
               rs = preparedStmt.executeQuery();   

               while(rs.next()){
               klantBuilder.klantId(rs.getInt("klant_id"));
               klantBuilder.voorNaam(rs.getString("voornaam"));
               klantBuilder.achterNaam(rs.getString("achternaam"));
               klantBuilder.tussenVoegsel(rs.getString("tussenvoegsel"));
               klantBuilder.email(rs.getString("email"));

               // build Klant
               klant = klantBuilder.build();  
               }
        }
    }
    catch (ClassNotFoundException | SQLException e) {
		System.err.println("Got an exception!");
		System.err.println(e.getMessage());
    }
        
  return klant; 
}
    
    
    @Override // werkt
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
                 String sqlQuery = "Update Klant set voornaam = ? where klant_id = ? "; 
                        
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, voornaam);
                 preparedStmt.setInt(2, klantId);
                                
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

    @Override //werkt
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
                 String sqlQuery = "Update Klant set achternaam = ? where klant_id = ?" ;
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, achternaam);
                 preparedStmt.setInt(2, klantId);
                                
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
    
    @Override// werkt
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
                
                 String sqlQuery = "Update Klant set tussenvoegsel = ? where klant_id = ?"; 
    
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, tussenvoegsel);
                 preparedStmt.setInt(2, klantId);
                 
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
    
    @Override // werkt
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
                 
                 String sqlQuery = "Update Klant set email = ? where klant_id = ?"; 

                  // create the mysql update preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
                 preparedStmt.setString (1, email);
                 preparedStmt.setInt(2, klantId);
                                
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
    
    @Override  //werkt
    public boolean deleteByKlantId(int klantId) throws SQLException {
            
        boolean deleted = false; 
        
        try{  
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
             try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement.first parent, than child
                 String sqlQuery = "delete from klant where klant_id =  ? " ;                 
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);                
                   preparedStmt.setInt(1, klantId);
                 // execute the preparedstatement
                 int rowsAffected = preparedStmt.executeUpdate(); 
                 if (rowsAffected != 0)
                     deleted = true;
             }
        }    
        catch (ClassNotFoundException | SQLException e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    return deleted;
}   
        
    @Override // werkt
    public boolean deleteByKlantNaam(String achternaam, String tussenvoegsel, String voornaam) throws SQLException {
             
        boolean deleted = false;  
      
        try{
        Class.forName(driver);
             // create a sql date object so we can use it in our INSERT statement
            try (Connection conn = DriverManager.getConnection(url, user, pw)) {
                 // create a sql date object so we can use it in our INSERT statement
                 
                 // the mysql insert statement.first parent, than child
                 String sqlQuery = "delete from klant where (voornaam, achternaam, " 
                         + "tussenvoegsel) = (?,?,? )";                 
                 
                 // create the mysql insert preparedstatement
                 PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);                
                 preparedStmt.setString(1,voornaam);
                 preparedStmt.setString(2,achternaam);
                 preparedStmt.setString(3,tussenvoegsel);
                 
                 // execute the preparedstatement
                 int rowsAffected = preparedStmt.executeUpdate();   
                 System.out.println("Aantal klanten verwijderd: " + rowsAffected);
                 if (rowsAffected >= 1)
                     deleted = true; 
                 
            }
        }   
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
      return deleted; 
    } 
    
    @Override
    public int deleteAll() throws SQLException {
        
        int rowsAffected = 0; 
        
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
                 rowsAffected = preparedStmt.executeUpdate();   
                 
        }
        }
    
            catch (ClassNotFoundException | SQLException e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }    
        return rowsAffected; 
    }  // delete klnat_id ook uit koppelklantadres tabel

    /*
     @Override // gebruik methode insert van hier boven. 
    gebruik maken van gevulde lijsten werkt nog niet. methode an sich wel.
    
    public int[] addBatchKlanten() throws Exception {    
	KlantDAOImpl klantDAO = new KlantDAOImpl();
        //load driver
        Class.forName(driver);
        System.out.println("Driver loaded");
        //establish a connection
        con = DriverManager.getConnection(url,
                user, pw);
        System.out.println("Database Connected"); 
	// Create statement object 
	
        String sqlQuery = "insert into Klant (voornaam, achternaam, tussenvoegsel)"
                         + " values (?, ?, ?)";  
						 
	stmt = con.prepareStatement(sqlQuery);
	
        con.setAutoCommit(false);					 
	
        klantDAO.vulVoornaamLijst();
        klantDAO.vulAchternaamLijst();
        klantDAO.vulTussenvoegselLijst();
        
        
	int x = (int)(Math.random()* voornaamLijst.size());
        System.out.println(voornaamLijst.size());
	
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

    @Override //werkt
    public void vulVoornaamLijst (){
	Scanner input = new Scanner(System.in);
        
        for (int i = 0; i< 20; i++){
        
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
    }
	
    @Override // werkt
    public void vulAchternaamLijst (){		
		
	Scanner input = new Scanner(System.in);
        for (int i = 0; i< 20; i++){
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
    }
	
    @Override // werkt
    public void vulTussenvoegselLijst (){		
	Scanner input = new Scanner(System.in);
        
        for (int i = 0; i< 10; i++){
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
    }

    /*
    @Override
    public void updateAdresKlant(int adresId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Klant> findByAdresId(int adresId) throws Exception {
    
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
*/

		
} 


