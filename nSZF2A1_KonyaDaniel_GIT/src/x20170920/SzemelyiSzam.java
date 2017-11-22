package x20170920;

import java.util.Random;

/*
    @author Dani
 */
public class SzemelyiSzam {

    private Random r = new Random();
    private int szulEv, szulHonap, szulNap, szulSor;

    private String generalNem() {

        String nem = Integer.toString(r.nextInt(8 - 1) + 1);

        return nem;
    }

    private String generalSzulEv() {
        szulEv = r.nextInt(99);
        String stringSzulEv = "";

        if (szulEv <= 9) {
            stringSzulEv = String.format("%02d", szulEv);
        } else {
            stringSzulEv = Integer.toString(szulEv);
        }

        return stringSzulEv;
    }

    private String generalHonap() {
        szulHonap = r.nextInt(12 - 1) + 1;
        String stringSzulHonap = "";

        if (szulHonap < 10) {
            stringSzulHonap = String.format("%02d", szulHonap);
        } else {
            stringSzulHonap = Integer.toString(szulHonap);
        }

        return stringSzulHonap;
    }

    private String generalNap() {
        szulNap = r.nextInt(27 - 1) + 1;
        String stringSzulNap = "";

        if (szulNap < 10) {
            stringSzulNap = String.format("%02d", szulNap);
        } else {
            stringSzulNap = Integer.toString(szulNap);
        }

        return stringSzulNap;
    }

    private String generalSzuletesiSor() {
        szulSor = r.nextInt(999);
        String stringSzulSor = "";

        if (szulSor < 100) {
            stringSzulSor = String.format("%03d", szulSor);
        } else {
            stringSzulSor = Integer.toString(szulSor);
        }

        return stringSzulSor;
    }

    private String generalEllenorzoSzam(String stringNem, String stringSzulEv, String stringSzulHonap, String stringSzulNap, String stringSzulSor) {
        int ellenorzoSzam;
        String szemSzam = stringNem + stringSzulEv + stringSzulHonap + stringSzulNap + stringSzulSor;

        if (Integer.parseInt(stringSzulEv) < 97) {
                ellenorzoSzam = RegiAlgoritmus(szemSzam);
        } else {
                ellenorzoSzam = UjAlgoritmus(szemSzam);

        }
        return Integer.toString(ellenorzoSzam);
    }

    private int RegiAlgoritmus(String szemSzam) {
        int ellenorzoSzam = 0;

        for (int i = 0; szemSzam.length() > i; i++) {
            int k = Integer.parseInt(szemSzam.substring(i, i + 1));

            ellenorzoSzam += k * (i + 1);
        }

        ellenorzoSzam %= 11;

        return ellenorzoSzam;
    }

    private int UjAlgoritmus(String szemSzam) {
        int ellenorzoSzam = 0;
        int j = 0;

        for (int i = szemSzam.length(); i > 0; i--) {

            int k = Integer.parseInt(szemSzam.substring(j, j + 1));

            ellenorzoSzam += k * i;

            j++;
        }
        ellenorzoSzam %= 11;

        return ellenorzoSzam;
    }
    
    private boolean isHibas(String szemszam){
        return szemszam.length()>11;
    }

    private String buildSzemSzam() {

        String stringNem = generalNem();
        String stringSzulEv = generalSzulEv();
        String stringSzulHonap = generalHonap();
        String stringSzulNap = generalNap();
        String stringSzulSor = generalSzuletesiSor();
        String stringEllenorzoSzam = generalEllenorzoSzam(stringNem, stringSzulEv, stringSzulHonap, stringSzulNap, stringSzulSor);

        String teljesSzemSzam = stringNem + stringSzulEv + stringSzulHonap + stringSzulNap + stringSzulSor + stringEllenorzoSzam;

        return teljesSzemSzam;
    }
    
    public String generalSzemSzam(){
        String sz = buildSzemSzam();
        
        while(isHibas(sz)){
            sz = buildSzemSzam();
        }
        return sz;
    }
    
    
    
}
