package WorkShop;

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
    
    // Constructor
    public Bestelling(int bestelling_id, int klant_id){
        this.bestelling_id = bestelling_id;
        this.klant_id = klant_id;
        datum = new java.util.Date();
    }
    
    public Bestelling(){
        
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
