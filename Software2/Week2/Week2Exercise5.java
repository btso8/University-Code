package University-Code.Software2.Week2;
import java.util.Scanner;

public class Week2Exercise5 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = keyboard.nextLine();
        String output = "";
        boolean newWord = true;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) != ' '){
                if (newWord){
                    output += sentence.toUpperCase().charAt(i);
                } else {
                    output += Character.toLowerCase(sentence.charAt(i));
                }
                newWord = false;
            } else {
                newWord = true;
            }
        }
        System.out.println(output);
        keyboard.close();
    }
}
