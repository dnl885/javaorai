package x20171011;

/*
    @author Dani
 */
public class VeremKivetel {

    public static class VeremException extends Exception {

        public VeremException(String message) {
            super(message);
        }
    }

    public static class Verem {

        private final static int MERET = 3;
        private int[] verem = new int[MERET];
        private int mutato = 0;

        public void betesz(int i) throws VeremException {
            if (mutato < MERET) {
                verem[mutato] = i;
                mutato++;
            } else {
                throw new VeremException("Verem megtelt!");
            }
        }

        public int kivesz() throws VeremException {
            if (mutato == 0) {
                throw new VeremException("A verem üres!");
            } else {
                mutato--;
                int i = verem[mutato];
                System.out.println("A szám (" + i + ") a veremből kivéve!");
                return i;
            }
        }
    }

    public static void main(String[] args) {

        Verem v = new Verem();

        try {
            v.betesz(21);
            v.betesz(52);
            v.betesz(77);
            v.betesz(99);
        } catch (VeremException ve) {
            System.out.println(ve.getMessage());
        }

        try {
            v.kivesz();
            v.kivesz();
            v.kivesz();
            v.kivesz();
        } catch (VeremException ve) {
            System.out.println(ve.getMessage());
        }
    }
}
