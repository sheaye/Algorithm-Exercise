package exam;

import java.util.Scanner;

/**
 * 相反数
 */
public class Opposite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int value = scanner.nextInt();
            System.out.println(opposite(value));
        }
    }

    public static int opposite(int n) {
        int op = 0;
        int temp = n;
        while (temp != 0) {
            op = op * 10 + temp % 10;
            temp /= 10;
        }
        return n + op;
    }

}
