
class Lenkeliste <E> implements Liste<E> {

    Node start = null;
    Node slutt = null;
    int antall = 0;

    public class Node {
        E data;
        Node neste = null;
        Node forrige = null;

        public Node(E data) {
            this.data = data;
            this.neste = null;
            this.forrige = null;
        }
    }

    public int stoerrelse() {
        return antall;
    }
    
    public void leggTil(E x) {
        Node nyNode = new Node(x);
        if (antall ==  0) {
            start = nyNode;
            slutt = nyNode;
        } else {
            slutt.neste = nyNode;
            nyNode.forrige = slutt;
            slutt = nyNode;
        }
        antall++;
    }

    public E hent() throws UgyldigListeindeks {
        if(start == null){
            throw new UgyldigListeindeks(0);
        }
        return start.data; 
    }

   /* public E fjern() throws UgyldigListeindeks {
        if(antall == 0) {
            throw new UgyldigListeindeks(0);
        }
        Node returner = start; 
        start = start.neste;
        start.forrige = null; 
        antall--;
        return returner.data; 
    } */

    public E fjern() throws UgyldigListeindeks {
        if (antall == 0) {
            throw new UgyldigListeindeks(0);
        }
        E data = start.data;
        if (antall == 1) {
            start = null;
            slutt = null;
        } else {
            Node node = start;
            start = node.neste;
        }
        antall--;
        return data;
    }

    public String toString() {
        String ut = "";
        Node denne = start;
        while (denne != null) {
            ut += denne.data + " ";
            denne = denne.neste;
        }
        return ut;
    }
       
    /* public static void main(String[] args) {
        Lenkeliste<Integer> enliste = new Lenkeliste<>();
        for (int i = 0; i < 10; i++) { 
            enliste.leggTil(i);
        }
        enliste.fjern();
        System.out.println(enliste.toString());
    } */
} 