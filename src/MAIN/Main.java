package MAIN;

import DAOs.Impl.AdresDAOImpl;
import POJO.Adres;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Excen
 */
public class Main {        
        /*
        
        Statement stat = connectie.prepareStatement(Select search from *);
        ResultSet result = stat.executeQuery();
        
    }
    // connection to Database
    private void connectToDB () {
    
        try{
            Class.forName(driver);
            Connection connectie = DriverManager.getConnection(Url, User, Pw);
            System.out.print("You are connected to " + Url);
        }
        catch(java.lang.Exception ex){
            ex.printStackTrace();
        }
        
    //  execute SQL commands
        private void executeSQL(){
        if (connection == null){
            System.out.print ("Please first connect to a database")
            return; 
        }
        else {       
        
        }
        
        }        
        */
        
    public static void main (String [] args) throws SQLException, ClassNotFoundException{
   
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/winkel?autoReconnect=true&useSSL=false";
    //String url = "jdbc:mysql://localhost3306/winkel";
    String user = "Anjewe"; 
    String pw = "Koetjes"; 
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
        
        try {
        
        Class.forName(driver);
        con = DriverManager.getConnection(url,user,pw);

        System.out.println("connected with "+ con.toString());

        AdresDAOImpl adresDAO = new AdresDAOImpl();
        //adresDAO.insertAdres();
       
        
        Adres adres = adresDAO.findByAdresID(15);
        System.out.println(adres);
        
        boolean updateGelukt = adresDAO.updatePostCode();
        //System.out.println(adres.getAdresId() + " " + adres.getWoonPlaats() );
        System.out.println("adres updaten is gelukt: " + updateGelukt);
        
        
        
        ArrayList<Adres> adressen = adresDAO.findAllAdresses();
        for (int i = 0; i< adressen.size(); i++){
            System.out.println ((adressen.get(i)).getAdresId() + "  " +
                    (adressen.get(i)).getStraatNaam() + "  " +(adressen.get(i)).getHuisNummer() +
                    "  " + (adressen.get(i)).getToevoeging() +
                    "  " + (adressen.get(i)).getPostCode() +
                    "  " + (adressen.get(i)).getWoonPlaats());
        } 
        }    
        catch(SQLException | HeadlessException e) {
        System.out.print("not connect to server and message is: " + e.getMessage());
        }
                   
    }
}
        
    
    


