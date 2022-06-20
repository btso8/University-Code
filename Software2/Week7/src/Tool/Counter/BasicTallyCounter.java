package University-Code.Software2.Week7.src.Tool.Counter;

public class BasicTallyCounter implements ITallyCounter{

	int counter;
	int digits;

	public BasicTallyCounter() {
		counter = 0;
		digits = 3;
	}

	public BasicTallyCounter(int digits) throws Exception {
		if (digits < 3) {
			throw new Exception("The number of digits must be at least 3!");
		}
		counter = 0;
		this.digits = digits;
	}

	private int computeMaxValue() {
		return (int) Math.pow(10, digits) - 1;
	}

	@Override
	public int increment() throws InvalidOperationException {
		int old = counter;
		if (counter >= computeMaxValue()) {
			throw new InvalidOperationException(InvalidOperationException.INCREMENT_OPERATION);
		} else {
			counter++;
		}
		return old;
	}

	@Override
	public int reset() {
		int old = counter;
		counter = 0;
		return old;

	}

	@Override
	public int read() {
		return counter;

	}

	public String toString() {
		String template = "%0";
		template += digits + "d";
		return String.format(template, counter);
	}

}
