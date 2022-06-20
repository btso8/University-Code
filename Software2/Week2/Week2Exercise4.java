package University-Code.Software2.Week2;
import java.util.Scanner;

public class Week2Exercise4 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = keyboard.nextLine();
        String output = "";
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) != ' '){
                output += sentence.charAt(i);
            }
        }
        System.out.println(output);
        keyboard.close();
    }
}
