package codinguniwork.software2.week2;
import java.util.Scanner;

public class Week2Exercise6 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter first int: ");
        int number = keyboard.nextInt();
        String first = Integer.toString(number);
        System.out.print("Enter second int: ");
        number = keyboard.nextInt();
        String second = Integer.toString(number);
        String output = "";

        for( int i = 0; i < Math.min(first.length(), second.length()); i++){
            if (first.charAt(i) == second.charAt(i)){
                output += '1';
            } else {
                output += '0';
            }
        }
        for( int i = 0; i < Math.abs(first.length() - second.length()); i++){
            output += '0';
        }

        System.out.println(output);
        keyboard.close();
    }
}