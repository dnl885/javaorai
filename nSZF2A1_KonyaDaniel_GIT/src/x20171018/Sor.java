package x20171018;

/*
    @author Dani
 */
public class Sor {

    private final int MERET = 3;
    private int[] sor = new int[MERET];
    private int E;
    private int U;
    private int mutato = 0;
    private int aktMeret = 0;

    Sor() {
        E = 0;
        U = -1;
    }

    public void hozzaAd(int elem) throws SorException {
        if (isFull()) {
            throw new SorException("A sor tele van!");
        } else {
            U++;
            if (U == MERET - 1) {
                E = 0;
            }

            sor[U] = elem;
            aktMeret++;
            System.out.println(elem + " hozzáadva a sorhoz!");
        }
    }

    public void kiVesz() throws SorException {
        if (isEmpty()) {
            throw new SorException("A sor üres!");
        } else {
            E++;
            if (E == MERET - 1) {
                System.out.println(sor[E - 1] + " eltávolítva a sorból!");
                E = 0;
            } else {
                System.out.println(sor[E - 1] + " eltávolítva a sorból!");
            }
        }
        aktMeret--;
    }

    private boolean isFull() {
        return aktMeret == MERET;
    }

    private boolean isEmpty() {
        return aktMeret == 0;
    }

}
