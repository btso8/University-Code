package University-Code.Software2.Week2;
import java.util.Scanner;

public class Week2Exercise1 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the amout of banana to purchase: ");
        double weight = keyboard.nextDouble();
        double cost = weight * 3.0;
        
        if (cost >= 50) {
            System.out.println(" The cost is £" + (cost + 1.5));
        } else {
            System.out.println(" The cost is £" + (cost + 4.99));
        }
        
        keyboard.close();
    }
}
