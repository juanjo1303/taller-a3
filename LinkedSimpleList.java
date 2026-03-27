import java.util.Iterator;

public class LinkedSimpleList<T> implements Iterable<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;
    public LinkedSimpleList() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addByIndex(T data, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { addFirst(data); return; }
        if (index == size) { addLast(data); return; }

        Node<T> newNode = new Node<>(data);
        Node<T> prev = first;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (first == null) return null;
        T data = first.data;
        first = first.next;
        if (first == null) last = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (last == null) return null;
        T data = last.data;
        if (first == last) {
            first = last = null;
        } else {
            Node<T> current = first;
            while (current.next != last) {
                current = current.next;
            }
            current.next = null;
            last = current;
        }
        size--;
        return data;
    }

    public T removeByIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<T> prev = first;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        T data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return data;
    }

    public T search(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Buscar por valor (devuelve el índice o -1)
    public int buscar(T data) {
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void invertir() {
        if (first == null || first.next == null) return;

        Node<T> prev = null;
        Node<T> current = first;
        Node<T> next = null;

        // El que era el primero será el último
        last = first;

        while (current != null) {
            next = current.next; // Guardar el resto de la lista
            current.next = prev; // Invertir el puntero
            prev = current;      // Avanzar prev
            current = next;      // Avanzar current
        }
        first = prev; // El último procesado es el nuevo primero
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedSimpleListIterator();
    }


    public void removeIndex(int index) {
        if (index == 0) {
            first = first.getNext();
        }
        int i = 0;
        Node<T> x = first;
        while(i<index){
            i++;
            x.getNext();
            if(i==index-1){
                x.setNext(x.getNext().getNext());
                x.getNext().setNext(null);
            }
        }
    }
}
