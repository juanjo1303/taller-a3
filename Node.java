public class Node<T> {
    protected Node<T> next;
    protected Node<T> prev;
    protected T data;

    public Node(T data){
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setData(T data) {
        this.data = data;
    }
}
