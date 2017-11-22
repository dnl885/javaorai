package x20171004;

import java.io.File;
import java.util.Scanner;

/*
    @author Dani
*/
public class fileRead {
    public static void main(String[] args) throws Exception {
        
        File theFile = new File("input.txt");
        
        try{
            Scanner sc = new Scanner(theFile);
            
            while(sc.hasNextLine()){
                String sor = sc.nextLine();
                System.out.println(sor);
            }
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
    }
}
