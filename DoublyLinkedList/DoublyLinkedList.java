package DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public DoublyLinkedList() {
        first = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(isEmpty()) {
            first = newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        }
        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            first = newNode;
        } else {
            Node<T> aux = first;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(newNode);
            newNode.setPrev(aux);
        }
        size ++;
    }

    public void addIndex (T data, int index){
        if(!isValidIndex(index)){
            throw new RuntimeException("Index out of range");
        }
        Node<T> newNode = new Node<>(data);
        if(index == 0){
            addFirst(data);
            return;
        }
        Node<T> actual = first;
        for (int i = 0; i < index -1; i++){
        actual = actual.getNext();
        }
        Node<T> next = actual.getNext();

        newNode.setNext(next);
        newNode.setPrev(actual);

        actual.setNext(newNode);

        if(next != null){
            next.setPrev(newNode);
        }
        size ++;
    }

    public T getData (int index){
        if(!isValidIndex(index)){
            throw new RuntimeException("Index out of range.");
        }
        Node<T> actual = first;
        int actualIndex = 0;
        while(actual != null){
            if(actualIndex == index){
                T data = actual.getData();
                return data;
            }
            actual = actual.getNext();
            actualIndex++;
        }
        return null;
    }

    public void setData (int index, T data){
        if(!isValidIndex(index)){
            throw new RuntimeException("Index out of range.");
        }
        Node<T> actual = first;
        int actualIndex = 0;
        while(actual != null){
            if(actualIndex == index){
                actual.setData(data);
                return;
            }
            actual = actual.getNext();
            actualIndex++;
        }
    }

   public int getIndex(T data){
        Node<T> actual = first;
        int searchIndex = 0;
        while (actual != null){
            if(actual.getData().equals(data)){
                return searchIndex;
            }
            searchIndex++;
            actual = actual.getNext();
        }
        return -1;
   }

   public boolean isValidIndex(int index){
    return index >= 0 && index < size;
   }

   public boolean isEmpty() {
        return first == null;
    }

    public void removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("List is empty.");
        } 
        if(first.getNext() == null){
            first = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty()){
            throw new RuntimeException("List is empty");
        }
        if (first.getNext() == null){
            first = null;
        } else {
            Node<T>  aux = first;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.getPrev().setNext(null);
        }
        size--;
    }

    public void removeData(T data){
        if(isEmpty()){
            throw new RuntimeException("List is empty.");
        }
        if(first.getData().equals(data)){
            removeFirst();
            return;
        }
        Node<T> aux = first;
        while(aux != null){
            if(aux.getData().equals(data)){
                Node<T> prev = aux.getPrev();
                Node<T> next = aux.getNext();

                if(next != null){
                    next.setPrev(prev);
                }
                if(prev != null){
                    prev.setNext(next);
                }
                size--;
                return;
            }
            aux = aux.getNext();
        }
    }

    public void removeAt(int index){
        if(!isValidIndex(index)){
            throw new RuntimeException("Index out of range.");
        } else {
            if(index == 0){
                removeFirst();
                return;
            }

            Node<T> actual = first;
            for(int i = 0; i < index; i++){
                actual = actual.getNext();
            }

            Node<T> prev = actual.getPrev();
            Node<T> next = actual.getNext();

            if(next != null){
                next.setPrev(prev);
            }
            prev.setNext(next);
            size--;

        }

    }

    public void sortList(){
        if(first == null || first.getNext() == null) return;
        boolean swapped;
        do{
            swapped = false;
            Node<T> actual = first;
            while(actual.getNext() != null){
                if(actual.getData().compareTo(actual.getNext().getData()) > 0){
                    T temp = actual.getData();
                    actual.setData(actual.getNext().getData());
                    actual.getNext().setData(temp);
                    swapped = true;
                }
                actual = actual.getNext();
            }
        } while(swapped);
    }

    public void reverseList(){
        if(first == null || first.getNext() == null){
            return;
        }
        first = reverseList(first);
    }

    private Node<T> reverseList(Node<T> actual){
        if(actual.getNext() == null){
            actual.setPrev(null);
            return actual;
        }
        Node<T> newHead = reverseList(actual.getNext());
        Node<T> next = actual.getNext();

        next.setNext(actual);
        actual.setPrev(next);

        actual.setNext(null);
        return newHead;
    }


    public void printList(){
        Node<T> aux = first;
        if (aux == null){
            System.out.println("List is empty.");
        } else {
            while(aux != null){
                System.out.println(aux.toString());
                aux = aux.getNext();
            }
        }
    }

    public void removeList(){
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getFirst(){
        return first;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<>(this);
    }

}
