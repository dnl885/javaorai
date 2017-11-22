package x20171115_ZH;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
    @author Dani
 */
public class KonyaDanielZH {

    public static void main(String[] args) throws FileNotFoundException {

        String[] valaszok = new String[14];
        String[] versenyzoValasz = new String[14];
        ArrayList<String> versenyzok = new ArrayList<>();
        ArrayList<String> versenyzoValaszok = new ArrayList<>();
        ArrayList<Integer> versenyzoPontok = new ArrayList<>();
        String versenyzoAzonosito = "";
        String kerdes = "";
        String versenyzoEgyValasz = "";
        int kerdesSorszam = 0;
        int helyesValaszDb = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner ssc = new Scanner(System.in);

        //1. feladat: Az adatok beolvasása
        File theFile = new File("valaszok.txt");

        Scanner fsc = new Scanner(theFile);

        valaszok = fsc.nextLine().split("");

        System.out.println("1. feladat: Az adatok beolvasása");

        while (fsc.hasNextLine()) {
            String sor = fsc.nextLine();
            versenyzok.add(sor.split(" ")[0]);
            versenyzoValaszok.add(sor.split(" ")[1]);
        }

        //
        
        //2. feladat: Versenyzők száma
        int versenyzoDb = versenyzok.size();

        System.out.println("2. feladat: A vetélkedőn " + versenyzoDb + " versenyző indult.");

        //
        
        // 3.feladat: Adott azonosítójú versenyző válaszai
        System.out.println("3. A versenyző azonosítója = ");

        versenyzoAzonosito = ssc.nextLine();
        int versenyzoIndex = 0;

        for (int i = 0; i < versenyzok.size(); i++) {
            if (versenyzok.get(i).equals(versenyzoAzonosito)) {
                versenyzoIndex = i;
            }
        }

        System.out.println(versenyzoValaszok.get(versenyzoIndex));
        //

        //4. feladat: Adott azonosítójú versenyző helyes válaszai
        versenyzoValasz = versenyzoValaszok.get(versenyzoIndex).split("");

        System.out.println("4.feladat:");

        for (String valasz : valaszok) {
            System.out.print(valasz);
        }
        System.out.println("");

        for (int i = 0; i < versenyzoValasz.length; i++) {

            if (versenyzoValasz[i].equals(valaszok[i])) {
                System.out.print("+");
            } else {
                System.out.print(" ");
            }
        }
        //
        
        
        //5 feladat: Adott kérdésre helyes válasz adók számának meghatározása, és százalékos kiíratása
        System.out.println("");
        
        System.out.println("5.feladat: A feladat sorszáma = ");
        
        kerdesSorszam = ssc.nextInt();
        
        kerdes = valaszok[kerdesSorszam-1];
        
        for(int i = 0;i<versenyzoValaszok.size();i++){
            versenyzoEgyValasz = versenyzoValaszok.get(i).substring(kerdesSorszam-1,kerdesSorszam);
            
            if(versenyzoEgyValasz.equals(kerdes)){
                helyesValaszDb++;
            }
        }
        
        double helyesValaszSzazalek = ((double) helyesValaszDb/versenyzoDb)*100;
        
        System.out.println("A feladatra "+helyesValaszDb+" fő, a versenyzők "+df.format(helyesValaszSzazalek)+"%-a adott helyes választ.");
        //
        
        //6.feladat
        int osszpont = 0;
        int j = 0;
        System.out.println("6. feladat: Versenyzők pontszámának meghatározása");
        
        for(int i = 0;i<versenyzoDb;i++){
            if(versenyzoValaszok.get(i).substring(j,j+1).equals(valaszok[i])){
                System.out.println("Jó");
            }
            j++;
        }
        
        
        fsc.close();
        ssc.close();
    }
}
