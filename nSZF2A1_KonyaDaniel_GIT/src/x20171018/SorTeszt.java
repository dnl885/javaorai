package x20171018;

/*
    @author Dani
*/
public class SorTeszt {
    public static void main(String[] args) {
        try {
            Sor sor = new Sor();
            
            sor.hozzaAd(1);
            sor.hozzaAd(2);
            sor.hozzaAd(3);
            
            sor.kiVesz();
            sor.kiVesz();
            sor.kiVesz();
        } catch (SorException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
    }
}
