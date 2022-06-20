package codinguniwork.software2.week7.src.tool.counter;

public interface ITallyCounter {

	public int increment() throws InvalidOperationException;

    public int reset();

	public int read();

}