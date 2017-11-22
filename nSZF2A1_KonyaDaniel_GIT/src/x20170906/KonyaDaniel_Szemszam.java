package x20170906;

import java.util.Scanner;

/*
    @author Dani
 */
public class KonyaDaniel_Szemszam {

    public static void main(String args[]) {

        String szemSzam = "";
        int szulEv;
        Scanner sc = new Scanner(System.in);

        /*
        Tesztelt valós személyi számok
        19803113955 - Férfi, érvényes (új algoritmus)
        19507296865 - Férfi, érvényes (régi algoritmus)
        19702091623 - Férfi, érvényes (új algoritmus)
        */
        
        /*
        Tesztelt generált személyi számok
        43409044347 - Nő, érvényes (régi algoritmus)
        68303067315 - Nő, érvényes (régi algoritmus)
        29802202877 - Nő, érvényes (új algoritmus)
        */
        
        do {
            System.out.println("Kérem, írjon be egy személyi számot!");

            szemSzam = sc.nextLine();

        } while (szemSzam.length() < 11 || szemSzam.length() > 11);
        
        try{
            szulEv = Integer.parseInt(szemSzam.substring(1, 3));

            if (szulEv < 97) {
                RegiAlgoritmus(szemSzam);
            } else {
                UjAlgoritmus(szemSzam);
            }
        }catch(NumberFormatException e){
            System.out.println("FORMAI HIBA!\nKérem, csak számokat írjon be!");
        }
    }

    static void RegiAlgoritmus(String szemSzam) {
        try{
        int ellenorzendoSzam = Integer.parseInt(szemSzam.substring(szemSzam.length() - 1));
        int ellenorzoSzam = 0;
        int nem = Integer.parseInt(szemSzam.substring(0, 1));
        int k;
        for (int i = 0; i < szemSzam.length(); i++) {

            k = Integer.parseInt(szemSzam.substring(i, i + 1));

            ellenorzoSzam += k * (i + 1);
        }

        if (ellenorzoSzam % 11 != ellenorzendoSzam) {
            System.out.println("A megadott személyi szám érvénytelen!");
        } else {
            System.out.println("A megadott személyi szám alapján a személy neme: " + (nem % 2 == 0 ? "Nő" : "Férfi"));
            System.out.println("Érvényes!");
        }
        }catch(NumberFormatException e){
            System.out.println("FORMAI HIBA!\nKérem, csak számokat írjon be!");
        }
    }

    static void UjAlgoritmus(String szemSzam) {
        try{
        int ellenorzendoSzam = Integer.parseInt(szemSzam.substring(szemSzam.length() - 1));
        int ellenorzoSzam = 0;
        int nem = Integer.parseInt(szemSzam.substring(0, 1));
        int k;
        int j = 0;

        for (int i = szemSzam.length() - 1; i >= 0; i--) {

            k = Integer.parseInt(szemSzam.substring(j, j + 1));

            ellenorzoSzam += k * i;

            j++;
        }

        if (ellenorzoSzam % 11 != ellenorzendoSzam) {
            System.out.println("A megadott személyi szám érvénytelen!");
        } else {
            System.out.println("A megadott személyi szám alapján a személy neme: " + (nem % 2 == 0 ? "Nő" : "Férfi"));
            System.out.println("Érvényes!");
        }
        }catch(NumberFormatException e){
            System.out.println("FORMAI HIBA!\nKérem, csak számokat írjon be!");
        }
    }
}
