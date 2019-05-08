import java.util.Vector;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private static Vector<Lloguer> lloguers;
	
	public Client(String nif, String nom, String telefon) {
		super();
		this.nif = nif;
		this.nom = nom;
		this.telefon = telefon;
		this.lloguers = new Vector<Lloguer>();
	}
	
	public String getNif(){ 
		return nif;
	}
    public String getNom(){
    	return nom;
    }
    public String getTelefon(){
    	return telefon; 
    }
	
    public void setNif(String nif){ 
    	this.nif = nif;
    }
    public void setNom(String nom){
    	this.nom = nom;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public static void afegeix(Lloguer lloguer) {
    	if (!lloguers.contains(lloguer)) {
    		lloguers.add(lloguer);
    	}
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        // XXX: de moment buit
        return null;
    }

	@Override
	public String toString() {
		return "Client [nif=" + nif + ", nom=" + nom + ", telefon=" + telefon + ", lloguers=" + lloguers + "]";
	}
    
    
    
}
