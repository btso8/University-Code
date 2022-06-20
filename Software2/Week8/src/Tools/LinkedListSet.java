package codinguniwork.software2.week8.src.tools;

public class LinkedListSet<E> implements ISet<E> {

    Node<E> elements;
    int size;

    public LinkedListSet(){
        size = 0;
        elements = null;
    }

    @Override
    public boolean add(E element) {
        if(contains(element)){
            return false;
        }
        elements = new Node<E>(element, elements);
        size += 1;
        return true;
    }

    @Override
    public void clear() {
        elements = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        Node<E> currentNode = elements;
        while(currentNode != null){
            if(element.equals(currentNode.getData())){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E element) {
        if(size == 0){
            return false;
        }   
        Node<E> currentNode = elements;
        if(currentNode.getData().equals(element)){
            elements = currentNode.next;
            size -= 1;
            return true;
        }

        while(currentNode.getNext() != null){
            if(element.equals(currentNode.next.getData())){
                currentNode.next = currentNode.next.next;
                size -= 1;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    
}


class Node<T> {
    T datum;
    Node<T> next;

    public Node(){
        datum = null;
        next = null;
    }

    public Node(T data){
        datum = data;
        next = null;
    }

    public Node(T data, Node<T> next){
        datum = data;
        this.next = next;
    }

    public T getData(){
        return datum;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public void setDatum(T data){
        datum = data;
    }
}
