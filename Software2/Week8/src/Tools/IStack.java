package University-Code.Software2.Week8.src.Tools;

public interface IStack<T> {

    boolean isEmpty();

    boolean push(T value);

    T peek();

    T pop();
}
