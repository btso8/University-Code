package codinguniwork.software2.week8.src.tools;

public interface ISet<E> {
    boolean add(E element);
    void clear();
    boolean contains(E element);
    boolean isEmpty();
    boolean remove(E element);
    int size();
}
