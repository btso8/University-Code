package University-Code.Software2.Week7.src.Tool.Counter;

import java.util.ArrayList;
import java.util.List;

public class BetterTallyCounter extends BasicTallyCounter 
    implements IAdvancedCounter {

    @Override
    public int decrement() throws InvalidOperationException {
        if(counter == 0){
            throw new InvalidOperationException(InvalidOperationException.DECREMENT_OPERATION);
        }

		int old = counter;
		counter --;
		return old;

    }
    
    public static void main(String[] args) {
        List<ITallyCounter> allCounters = new ArrayList<>();
        allCounters.add(new BasicTallyCounter());
        allCounters.add(new BetterTallyCounter());
        try{
        allCounters.get(0).increment();
        allCounters.get(0).increment();
        allCounters.get(1).increment();
        } catch(InvalidOperationException ex){
        }
        int sum = 0;
        for(ITallyCounter counter: allCounters){
            System.out.println(counter.read());
            sum += counter.read();
        } 
        System.out.println("Total sum of counters is: " + sum);
    }
}
