package offer66;

import java.util.LinkedList;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class Exercise40 {

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        Exercise40 exe = new Exercise40();
        exe.FindNumsAppearOnce2(array, num1, num2);
        System.out.print(num1[0]);
        System.out.print(num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
                list.remove(Integer.valueOf(array[i]));
            } else {
                list.add(array[i]);
            }
        }
        num1[0] = list.pop();
        num2[0] = list.pop();
    }

    /**
     * 异或：如果a、b两个值不同，异或结果为1，如果两个值相同，异或结果为0
     * 异或法则：0^0=0,0^1=1,1^0=1,1^1=0,不带进位
     * a^b^a = b
     * 按位与规则：1&1=1,0&1=0,1&0=0,0&0=0,不带进位
     */
    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        if (array.length < 2) {
            return;
        }
        // 异或值
        int xor = 0;
        // 得到列表中所有值的异或值
        // 由于相同的两个数异或后所得为0，异或的最终结果为两个单独的数异或后所得值
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        int flag = 1;
        // 找到异或结果最低位为1的flag，这一位也是num1和num2的不同位
        while ((xor & flag) == 0) {
            flag <<= 1;
        }
        num1[0] = xor;
        num2[0] = xor;
        for (int i = 0; i < array.length; i++) {
        // 通过flag按位与将array里的数分为flag位为1和flag位为0两类
            if ((flag & array[i]) == 0) {
                // 根据a^b^a = b规则找到num2
                num2[0] ^= array[i];
            } else {
                // 根据a^b^a = b规则找到num1
                num1[0] ^= array[i];
            }
        }
    }

    private String toBinary(int i) {
        String s = Integer.toBinaryString(i);
        return s.length() < 8 ? "00000000".substring(s.length()) + s:s;
    }
}
