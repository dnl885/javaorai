package x20171018;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
    @author Dani
 */
public class IOToken {

    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Kérek több egész számot vesszővel elválasztva!");
        String sor = sc.nextLine();
        String hibasAdatok = "";
        
        StringTokenizer st = new StringTokenizer(sor, " ");
        int db = 0;
        while (st.hasMoreTokens()) {
            try {
                sum+= Integer.parseInt(st.nextToken());
                db++;
            } catch (NumberFormatException e) {
                hibasAdatok += (e.getMessage().split(":")[1].replace("\"","").trim()+";");
            }     
        }
        
        System.out.println("\nA beolvasott számok (" + db + " db) összege: " + sum+"\n");
        System.out.println("Hibás adat(ok): "+hibasAdatok);
    }
}
