package University-Code.Software2.Week6;
public class TallyCounter {

	private int counter;
	private int digits;

	public TallyCounter() {
		counter = 0;
		digits = 3;
	}

	public TallyCounter(int digits) throws Exception {
		if (digits < 3) {
			throw new Exception("The number of digits must be at least 3!");
		}
		counter = 0;
		this.digits = digits;
	}

	private int computeMaxValue() {
		return (int) Math.pow(10, digits) - 1;
	}

	public int decrement() {
		int old = counter;
		counter = counter > 0 ? counter - 1 : 0;
		return old;

	}

	public int increment() {
		int old = counter;
		if (counter >= computeMaxValue()) {
			counter = 0;
		} else {
			counter++;
		}
		return old;
	}

	public int reset() {
		int old = counter;
		counter = 0;
		return old;

	}

	public int read() {
		return counter;
	}

	public String toString() {
		String template = "%0";
		template += digits + "d";
		return String.format(template, counter);
	}

}
