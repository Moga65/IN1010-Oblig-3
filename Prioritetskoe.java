public class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E> {
    public void leggTil(E x) {
        Node ny_node = new Node(x);
        if (antall == 0) {
            start = ny_node;
            slutt = ny_node;
        } else if (ny_node.data.compareTo(start.data) < 0) {
            ny_node.neste = start;
            start = ny_node;
        } else {
            Node hjelpe_peker = start;
            while (hjelpe_peker.neste != null && ny_node.data.compareTo(hjelpe_peker.neste.data) > 0) {
                hjelpe_peker = hjelpe_peker.neste;
            }
            ny_node.neste = hjelpe_peker.neste;
            hjelpe_peker.neste = ny_node;
            if (ny_node.neste == null) {
                slutt = ny_node;
            }
        }
        antall++;
    }
}