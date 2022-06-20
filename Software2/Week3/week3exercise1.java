package codinguniwork.software2.week3;
public class week3exercise1 {

    public static int toBase10(String binary) {
        int number = 0;
        for(int i = 0; i < binary.length(); i++){
            if (binary.charAt(binary.length() - 1 -i) == '1'){
                number += Math.pow(2, i);
            }
        }
        return number;
    }

    public static void main(String[] args) {
        String binary = "11111111";
        System.out.println(binary + " --> " + week3exercise1.toBase10(binary));
        binary = "00000000";
        System.out.println(binary + " --> " + week3exercise1.toBase10(binary));
        binary = "10001011";
        System.out.println(binary + " --> " + week3exercise1.toBase10(binary));
    }
}
