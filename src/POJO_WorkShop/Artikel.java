package POJO_WorkShop;


public class Artikel {
    private int artikelId;
    private String artikelNaam;
    private double prijs;
    
    public Artikel(int artikelId, String artikelNaam, double prijs) {
        this.artikelId = artikelId;
        this.artikelNaam = artikelNaam;
        this.prijs = prijs;
        }

    public int getKlantId() {
        return artikelId;
    }

    public String getArtikelNaam() {
        return artikelNaam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setKlantId(int klantId) {
        this.artikelId = klantId;
    }

    public void setArtikelNaam(String artikelNaam) {
        this.artikelNaam = artikelNaam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
    
}
