package x20171018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
    @author Dani
*/
public class SzoVisszafele {
    public static void main(String[] args) {
        try{
            File theFile = new File("vissza.txt");
            Scanner sc = new Scanner(theFile,"utf-8");
            String sor = "";
            StringBuilder sb;
            
            while(sc.hasNextLine()){
                sor = sc.nextLine();
                System.out.println("Előrefelé: "+sor);
                sb = new StringBuilder(sor);
                System.out.println("Hátrafelé: "+sb.reverse());
            }   
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
