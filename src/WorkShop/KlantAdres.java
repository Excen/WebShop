

package WorkShop;

/**
 *
 * @author Wendy
 */
public class KlantAdres {
     
    private int klantId;
    private int adresId;
    
    public KlantAdres(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public KlantAdres(int klantId, int adresId) {
        this.klantId = klantId;
        this.adresId = adresId;        
        }

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }
    
    
}
