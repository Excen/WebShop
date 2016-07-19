package POJO;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Excen
 */
public class Bestelling {
    private int bestelling_id;
    private int klant_id;
    private java.util.Date datum;
    
    /*
    java.sql.Date d= new java.sql.Date(format.parse(source).getTime());
    
    String source="2008/4/5";              
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");                       
        java.sql.Date d=(Date) format.parse(source);
        
        ---
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

            pstmt.setTimestamp(1, date);
    
        ---    
    
        proc_stmt.setTimestamp(1, new java.sql.Timestamp(fromDate.getTime());
        
    */
    
    // Constructor
    public Bestelling(int bestelling_id, int klant_id){
        this.bestelling_id = bestelling_id;
        this.klant_id = klant_id;
        datum = new java.util.Date();
        java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
    }
    
    public Bestelling(){
        datum = new java.util.Date();
        java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
    }
    
    
    /**
     * @return the bestelling_id
     */
    public int getBestelling_id() {
        return bestelling_id;
    }

    /**
     * @param bestelling_id the bestelling_id to set
     */
    public void setBestelling_id(int bestelling_id) {
        this.bestelling_id = bestelling_id;
    }

    /**
     * @return the klant_id
     */
    public int getKlant_id() {
        return klant_id;
    }

    /**
     * @param klant_id the klant_id to set
     */
    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    /**
     * @return the datum
     */
    public java.util.Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(java.util.Date datum) {
        this.datum = datum;
    }
    
    
    
    
   




}
