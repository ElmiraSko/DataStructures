import java.io.PrintWriter;
import java.util.Scanner;

public class Z13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        byte countCow = 0;
        byte countBull = 0;
        String[] arrStr = new String[2];

        short number;
        for (int i = 0; i < 2; i++) {
            do {
                number = in.nextShort();
            } while (number < 1000 || number > 10000);
            arrStr[i] = String.valueOf(number);
        }

        for (byte i = 0; i < arrStr[0].length(); i++) {
            for (byte j = 0; j < arrStr[1].length(); j++){
                if ((arrStr[0].charAt(i) == arrStr[1].charAt(j)) && i == j){
                    countBull++;
                }else if (arrStr[0].charAt(i) == arrStr[1].charAt(j) && i!=j){
                    countCow++;
                }
            }
        }
        out.print(countBull + " " + countCow);
        out.flush();
    }
}