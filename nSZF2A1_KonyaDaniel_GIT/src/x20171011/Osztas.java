package x20171011;

import java.util.Scanner;

/*
    @author Dani
 */
public class Osztas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int osztando, oszto;
        boolean sikeres = false;
        
        System.out.println("Kérem az osztandót!");

        osztando = sc.nextInt();

        System.out.println("Kérem az osztót!");
        oszto = sc.nextInt();
        
        try {
            double hanyados = (double) (osztando / oszto);

            System.out.println(osztando + "/" + oszto + " = " + hanyados);
        } catch (ArithmeticException e) {
            System.out.println("");
        }finally{
            if(sikeres){
                System.out.println("Az osztás sikeresen lezajlott!");
            }else{
                System.out.println("Az osztás sikertelen!");
            }
        }

    }
}
