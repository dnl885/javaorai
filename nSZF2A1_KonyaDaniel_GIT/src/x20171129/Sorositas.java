package x20171129;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

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
        makeJSON();

    }

    private static void makeJSON() throws IOException {

        Diak d = new Diak();

        d.nev = "Nagy Sándor";
        d.kor = 32;

        Diak d1 = new Diak();

        d1.nev = "Kiss József";
        d1.kor = 42;

        FileWriter fw = new FileWriter("diak.json");

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("D:\\staff.json")) {

            gson.toJson(d, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
