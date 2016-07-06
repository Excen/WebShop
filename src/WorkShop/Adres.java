/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkShop;

/**
 *
 * @author Excen
 */
public class Adres {
    
    public Adres(String straatNaam, String postCode, String toevoeging, int huisNummer, String woonPlaats){
        this.straatNaam = straatNaam;
        this.postCode = postCode;
        this.toevoeging = toevoeging;
        this.huisNummer = huisNummer;
        this.woonPlaats = woonPlaats;
    }
    
    private String straatNaam;
    private String postCode;
    private String toevoeging;
    private int huisNummer;
    private String woonPlaats;

    /**
     * @return the straatNaam
     */
    public String getStraatNaam() {
        return straatNaam;
    }

    /**
     * @param straatNaam the straatNaam to set
     */
    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    /**
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the toevoeging
     */
    public String getToevoeging() {
        return toevoeging;
    }

    /**
     * @param toevoeging the toevoeging to set
     */
    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    /**
     * @return the huisNummer
     */
    public int getHuisNummer() {
        return huisNummer;
    }

    /**
     * @param huisNummer the huisNummer to set
     */
    public void setHuisNummer(int huisNummer) {
        this.huisNummer = huisNummer;
    }

    /**
     * @return the woonPlaats
     */
    public String getWoonPlaats() {
        return woonPlaats;
    }

    /**
     * @param woonPlaats the woonPlaats to set
     */
    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }
}
