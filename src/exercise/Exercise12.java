package exercise;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Exercise12 {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(3 >> 2));

        System.out.println(Power(2, 3));
    }

    public static double Power(double base, int exponent) {
        if (exponent < 0) {
            return 1 / Power(base, -exponent);
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == 2) {
            return base * base;
        }
        return Power(Power(base, exponent >> 1), 2) * Power(base, exponent & 1);

    }

}
