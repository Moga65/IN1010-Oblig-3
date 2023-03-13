class IndeksertListe <E> extends Lenkeliste<E> {
    public void leggTil (int pos, E x) {
        Node nynode = new Node(x);
        if (antall == 0) {
            start = nynode;
            slutt = nynode;
        } else if (pos == 0) {
            nynode.neste = start;
            start = nynode;
        } else if (pos == stoerrelse()) {
            slutt.neste = nynode;
            slutt = nynode;
        } else {
            Node peker = start;
            for (int i = 0; i < pos - 1; i++) {
                peker = peker.neste;
            }
            nynode.neste = peker.neste;
            peker.neste = nynode;
        }
        antall++;
    }

    public void sett (int pos, E x) {
        if (pos < 0 || pos >= antall) {
            throw new UgyldigListeindeks(pos);
        }
        Node node = start;
        for (int i = 0; i < pos; i++) {
            node = node.neste;
        }
        node.data = x;
    }
    public E hent (int pos) {
        if (pos < 0 || pos >= antall) {
            throw new UgyldigListeindeks(pos);
        }
        if (start == null) {
            return null;
        }
        Node nynode = start;
        for(int i = 0; i < pos; i++) {
            nynode = nynode.neste;
        }
        return nynode.data;
    }
    
    public E fjern(int pos) {
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }
        if (start == null) {
            return null;
        }
        Node nynode = start;
        if (pos == 0) {
            start = start.neste;
            antall--;
            return nynode.data;
        }
        Node forrige_node = null;
        for (int i = 0; i < pos; i++) {
            forrige_node = nynode;
            nynode = nynode.neste;
        }
        if (nynode == slutt){
            slutt = forrige_node;
        }
        forrige_node.neste = nynode.neste;
        antall--;
        return nynode.data;
    }
    }
