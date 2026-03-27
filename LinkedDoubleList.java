public class LinkedDoubleList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode; // Conexión hacia atrás
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (last == null) {
            first = last = newNode;
        } else {
            newNode.prev = last; // Conexión hacia atrás
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
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Insertamos antes de 'current'
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public T removeFirst() {
        if (first == null) return null;
        T data = first.data;
        first = first.next;
        if (first != null) first.prev = null;
        else last = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (last == null) return null;
        T data = last.data;
        last = last.prev; // ¡Súper rápido en lista doble!
        if (last != null) last.next = null;
        else first = null;
        size--;
        return data;
    }

    public T removeByIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.data;
    }

    public T search(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> current;
        // Optimización: si el índice está después de la mitad, empezamos por el final
        if (index < size / 2) {
            current = first;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = last;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current.data;
    }

    public void invertir() {
        if (first == null || first.next == null) return;

        Node<T> current = first;
        Node<T> temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = first;
        first = last;
        last = temp;
    }

    public void forward() {
        if (first != null) {
            Node<T> current = first;
        }
        assert first != null;
        Node<T> current = first.next;
    }

    public void backward() {
        if (first == null || first.prev == null) {
            Node<T> current = first;
        }
        Node<T> current = first.prev;
    }
}
