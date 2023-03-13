public class  Stabel<E> extends Lenkeliste<E> {
    @Override
    public void leggTil(E x) {
        Node nyNode = new Node(x);
        if(start == null){ 
            start = nyNode;
        }
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }
}
