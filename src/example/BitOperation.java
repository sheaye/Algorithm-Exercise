package example;

/**
 * Created by yexinyan on 2017/11/16.
 */
public class BitOperation {

    public static void main(String[] args) {
        testAdd(123);
        testAdd(124);
        System.out.println();

        testOr(123);
        testOr(124);
        System.out.println();

        testXOr1();
        System.out.println();

        testXor2();
        System.out.println();

    }

    /*
     * 按位与 a&b
     * 通常用于取位操作
     * 0&0=0; 1&0=0; 1&1=1
     *
     *      00101
     *      11100  &
     *      ---------
     *      00100
     *
     */

    /**
     * 按位与应用一：可以用来判断奇偶
     * 任意偶数与1执行按位与操作，结果为1；任意奇数与1执行按位与结果为0；
     */
    public static void testAdd(int target) {
        System.out.println(target + "是一个" + ((target & 1) == 1 ? "奇数" : "偶数"));
    }

    /*
     * 按位或操作 a|b
     * 0|1=1; 1|1=1; 0|0=0
     *
     *      00101
     *      11100  |
     *      ---------
     *      11101
     *
     * 通常用于二进制的无条件赋值
     */

    /**
     * 按位或应用一
     * 任意整数与1执行按位或最后一个二进制位都得1，即是奇数
     */
    public static void testOr(int target) {
        System.out.println("123的最近偶数是" + ((target | 1) - 1));
    }

    /*
     * 按位异或 a^b
     * 相同位数字不同得1，数字相同得0
     * a^b^b = a
     * a^b^a = b
     * 1^1=0; 0^0=0; 1^0=1
     *
     *      00101
     *      11100  ^
     *      ---------
     *      11001
     */

    /**
     * 异或应用一：
     * 可以对信息进行简单加密
     */
    public static void testXOr1() {
        int data = 1314520;
        int secret = 1990093;
        System.out.println("甲使用密钥对信息: " + data + " 加密后交给乙");
        int encryptedData = data ^ secret;
        System.out.println("乙使用密钥对信息: " + encryptedData + " 解密");
        int decodedData = encryptedData ^ secret;
        System.out.println("乙读出实际信息：" + decodedData);
    }

    /**
     * 异或应用二：
     * 不使用第三个变量达到交换两个变量值的目的
     */
    public static void testXor2() {
        int a = 123, b = 321;
        System.out.println("a = " + a + ", b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ", b = " + b);
    }

    /*
     * 取反 ~a
     * ~1=0；~0=1
     *
     *
     */

    /*
     * 左移 a<<b = a * 2^b
     *
     *
     */

    /*
     * 带符号右移 a>>b = a / 2^b
     *
     *
     */

    /*
     * 无符号右移 a>>>b
     *
     *
     */

}
