package University-Code.Software2.Week7.src.Tool.Counter;

public interface ITallyCounter {

	public int increment() throws InvalidOperationException;

    public int reset();

	public int read();

}
