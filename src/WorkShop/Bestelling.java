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
    private int artikel_id1;
    private String artikel_naam1;
    private int artikel_aantal1;
    private float artikel_prijs1;

    
    public Bestelling(){};

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
     * @return the artikel_id1
     */
    public int getArtikel_id1() {
        return artikel_id1;
    }

    /**
     * @param artikel_id1 the artikel_id1 to set
     */
    public void setArtikel_id1(int artikel_id1) {
        this.artikel_id1 = artikel_id1;
    }

    /**
     * @return the artikel_naam1
     */
    public String getArtikel_naam1() {
        return artikel_naam1;
    }

    /**
     * @param artikel_naam1 the artikel_naam1 to set
     */
    public void setArtikel_naam1(String artikel_naam1) {
        this.artikel_naam1 = artikel_naam1;
    }

    /**
     * @return the artikel_aantal1
     */
    public int getArtikel_aantal1() {
        return artikel_aantal1;
    }

    /**
     * @param artikel_aantal1 the artikel_aantal1 to set
     */
    public void setArtikel_aantal1(int artikel_aantal1) {
        this.artikel_aantal1 = artikel_aantal1;
    }

    /**
     * @return the artikel_prijs1
     */
    public float getArtikel_prijs1() {
        return artikel_prijs1;
    }

    /**
     * @param artikel_prijs1 the artikel_prijs1 to set
     */
    public void setArtikel_prijs1(float artikel_prijs1) {
        this.artikel_prijs1 = artikel_prijs1;
    }
    
    
    
}
    
    

