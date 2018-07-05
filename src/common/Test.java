package common;

public class Test {

    public static void main(String[] args) {

        int[] numbers = {4, 7, 2, 5, 3};
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.println("                num  = " + num);
            System.out.println("               flag  = " + IntegerUtil.toBinary(flag, 8));
            System.out.println("         flag >> num = " + IntegerUtil.toBinary(flag >> num, 8));
            System.out.println("   (flag >> num) & 1 = " + IntegerUtil.toBinary((flag >> num) & 1, 8));
            System.out.println("            1 << num = " + IntegerUtil.toBinary(1 << num, 8));
            flag |= (1 << num);
            System.out.println("     flag|(1 << num) = " + IntegerUtil.toBinary(flag, 8));
            System.out.println();

        }

    }
}
