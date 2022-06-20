package codinguniwork.software2.week2;
import java.util.Scanner;

public class Week2Exercise3 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a whole number [0 to exit]: ");
        int number = keyboard.nextInt();
        int sum = 0;
        while (number != 0) {
            sum += number;
            System.out.print("Enter a whole number [0 to exit]: ");
            number = keyboard.nextInt();
        }
        System.out.print("the total sum of numbers entered is " + sum);
        keyboard.close();
    }
}
