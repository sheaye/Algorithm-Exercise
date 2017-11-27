package exercise;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Exercise11 {

    public static void main(String[] args) {
        System.out.println(NumberOf1_2(1234));
//        System.out.println(NumberOf1_2(-1234));
    }

    public static int NumberOf1(int n) {
        boolean positive = n >= 0;
        int countOf0 = 0, countOf1 = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                countOf0++;
            } else {
                countOf1++;
            }
            n = n >>> 1;
        }
        return positive ? countOf1 : (32 - countOf0);
    }

    public static int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            System.out.println("n             = " + Integer.toBinaryString(n));
            System.out.println("n-1           = " + Integer.toBinaryString(n - 1));
            n = (n - 1) & n;
            System.out.println("(n - 1) & n   = " + Integer.toBinaryString(n));
            System.out.println();
        }
        return count;
    }
}
