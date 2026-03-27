import java.util.Iterator;

public class LinkedSimpleListIterator<T> implements Iterator<T> {
    private Node<T> aux;
    @Override
    public boolean hasNext() {
        return aux != null;
    }

    @Override
    public T next() {
        return aux.getNext().getData();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
