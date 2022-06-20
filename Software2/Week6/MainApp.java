package University-Code.Software2.Week6;
public class MainApp {

	public static void main(String[] args) {
		TallyCounter tallyCounter;

		//Test for problem 1 /////////////////////////////////////////////////

		// tallyCounter = new TallyCounter();
		// System.out.println(tallyCounter);

		// // Test increment and read
		// for(int i = 0; i < 1002; i++) {
		// 	tallyCounter.increment();
		// 	System.out.println(tallyCounter);			
		// }

		// // Test reset
		// tallyCounter.reset();
		// System.out.println(tallyCounter.read());

		// Test for Problem 2 ////////////////////////////////////////////////

		int digits = 2;
		try {
			tallyCounter = new TallyCounter(digits);
		} catch(Exception e) {
			System.err.println(e);
		}

		digits = 3;
		try{
			tallyCounter = new TallyCounter(digits);
			System.out.println(tallyCounter);

			for(int i = 0; i< Math.pow(10, digits) + 2; i++) {
				tallyCounter.increment();
				System.out.println(tallyCounter);			
			}

			tallyCounter.reset();
			System.out.println(tallyCounter.read());

			for(int i = 0; i < 4; i++) {
				tallyCounter.increment();
				System.out.println(tallyCounter);			
			}
			for(int i = 0; i < 6; i++) {
				tallyCounter.decrement();
				System.out.println(tallyCounter);
			}
		} catch(Exception e) {
			System.err.println(e);
		}
	}

}
