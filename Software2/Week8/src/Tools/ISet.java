package University-Code.Software2.Week8.src.Tools;

public interface ISet<E> {
    boolean add(E element);
    void clear();
    boolean contains(E element);
    boolean isEmpty();
    boolean remove(E element);
    int size();
}
