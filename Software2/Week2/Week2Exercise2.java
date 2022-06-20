package University-Code.Software2.Week2;
import java.util.Scanner;

public class Week2Exercise2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = keyboard.nextInt();
        System.out.print("Enter your heart rate: ");
        int rate = keyboard.nextInt();

        double maxHeartRate = 208 - 0.7 * age;
        if (rate >= 0.9 * maxHeartRate) {
            System.out.println(" Interval training");
        } else if (rate >= 0.7 * maxHeartRate && rate < 0.9 * maxHeartRate) {
            System.out.println(" Threshold training");
        } else if (rate >= 0.5 * maxHeartRate && rate < 0.7 * maxHeartRate) {
            System.out.println(" Aerobic training");
        } else {
            System.out.println(" Couch potatog");
        }

        keyboard.close();
    }
}
