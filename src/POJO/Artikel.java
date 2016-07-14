package POJO;


public class Artikel {
    private int artikelID;
    private String artikelNaam;
    private double artikelPrijs;
    
    public Artikel(){
    }
    
    public Artikel(int artikelID, String artikelNaam, double artikelPrijs) {
        this.artikelID = artikelID;
        this.artikelNaam = artikelNaam;
        this.artikelPrijs = artikelPrijs;
        }

    public int getArtikelID() {
        return artikelID;
    }

    public String getArtikelNaam() {
        return artikelNaam;
    }

    public double getArtikelPrijs() {
        return artikelPrijs;
    }

    public void setArtikelID(int artikelID) {
        this.artikelID = artikelID;
    }

    public void setArtikelNaam(String artikelNaam) {
        this.artikelNaam = artikelNaam;
    }

    public void setArtikelPrijs(double artikelPrijs) {
        this.artikelPrijs = artikelPrijs;
    }
    
}
