package exam;

import java.util.Scanner;

//魔法币
public class MagicCoin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            try {
                System.out.println(getSteps(Integer.valueOf(next)));
            }catch (Exception e){

            }
        }
    }

    public static String getSteps(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "2";
        }
        if (n % 2 == 0) {
            return getSteps(n / 2 - 1) + "2";
        } else {
            return getSteps((n - 1) / 2) + "1";
        }
    }


}
