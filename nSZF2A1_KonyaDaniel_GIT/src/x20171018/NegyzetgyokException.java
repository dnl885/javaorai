package x20171018;

import static java.lang.Double.isNaN;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
    @author Dani
 */
public class NegyzetgyokException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double szam;
        
        System.out.println("Adj meg egy számot és visszaadom annak négyzetgyökét!");
        try{
        szam = sc.nextDouble();
        
        
        gyokVonas(szam);
        } catch (InputMismatchException ime) {
            System.out.println("Csak számból lehet gyököt vonni!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private static void gyokVonas(double szam) throws Exception {
        double gyokEredmeny = Math.sqrt(szam);
        DecimalFormat df = new DecimalFormat("#.###");
        
        if (isNaN(gyokEredmeny)) {
            throw new Exception("Negatív számból nem lehet négyzegyököt vonni");
        }
        System.out.printf(szam+" négyzetgyöke: "+df.format(gyokEredmeny));
    }
}
