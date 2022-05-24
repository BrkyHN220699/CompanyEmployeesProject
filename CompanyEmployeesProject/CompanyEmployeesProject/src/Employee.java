
/**
 *
 * @author berkayhan
 */
public class Employee {
    
    private int Id;
    private String Ad;
    private String Soyad;
    private String Departman;
    private String Maas; 

    public Employee(int Id, String Ad, String Soyad, String Departman, String Maas) {
        this.Id = Id;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Departman = Departman;
        this.Maas = Maas;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Ad
     */
    public String getAd() {
        return Ad;
    }

    /**
     * @param Ad the Ad to set
     */
    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    /**
     * @return the Soyad
     */
    public String getSoyad() {
        return Soyad;
    }

    /**
     * @param Soyad the Soyad to set
     */
    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    /**
     * @return the Departman
     */
    public String getDepartman() {
        return Departman;
    }

    /**
     * @param Departman the Departman to set
     */
    public void setDepartman(String Departman) {
        this.Departman = Departman;
    }

    /**
     * @return the Maas
     */
    public String getMaas() {
        return Maas;
    }

    /**
     * @param Maas the Maas to set
     */
    public void setMaas(String Maas) {
        this.Maas = Maas;
    }
    
    
    
    
}
