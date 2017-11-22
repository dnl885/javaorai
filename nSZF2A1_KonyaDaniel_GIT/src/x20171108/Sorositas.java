package x20171108;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
    @author Kónya Dániel
 */
class Diak implements Serializable {

    String nev;
    Integer kor;

}

public class Sorositas {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        2 db metódus:
        make() - sorosít
        load() - betölt, DeSorosít
         */
        make();
        //load();
        load2();

    }

    private static void make() {

        Diak d = new Diak();

        d.nev = "Nagy Sándor";
        d.kor = 32;

        Diak d1 = new Diak();

        d1.nev = "Kiss József";
        d1.kor = 42;

        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(d);
            oos.writeObject(d1);

            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private static void load() {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Diak dsd = (Diak) ois.readObject();
            Diak dsd1 = (Diak) ois.readObject();

            System.out.println("Diák 1 név: " + dsd.nev);
            System.out.println("Diák 1 név: " + dsd.kor);

            System.out.println("Diák 2 név: " + dsd1.nev);
            System.out.println("Diák 2 név: " + dsd1.kor);

            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    private static void load2() throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("data.txt");
            ois = new ObjectInputStream(fis);

            while (ois.read() == -1) {
                Diak d = (Diak) ois.readObject();

                System.out.println("Név:" + d.nev + "\nKor:" + d.kor);
            }
            
            ois.close();
            
            }catch(IOException | ClassNotFoundException e){
                    
            }
        }
    }
