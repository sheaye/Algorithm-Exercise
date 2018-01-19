package aim_to_offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Exercise13 {

    public void reOrderArray(int[] array) {
        int len = array.length;
        int oddLength = 0;
        int evenLength = 0;
        int[] oddArray = new int[len];
        int[] evenArray = new int[len];
        for (int i = 0; i < len; i++) {
            int item = array[i];
            if (item % 2 != 0) {
                oddArray[oddLength] = item;
                oddLength++;
            } else {
                evenArray[evenLength] = item;
                evenLength++;
            }
        }
        for (int i = 0; i < oddLength; i++) {
            array[i] = oddArray[i];
        }
        for (int i = 0; i < evenLength; i++) {
            array[oddLength + i] = evenArray[i];
        }
        System.out.println("reOrderArray:" + Arrays.toString(array));
    }

    public void reOrderArray2(int[] array){
        int len = array.length;
    }

    public void reOrderArray3(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 == 0) {// 顺序遍历找到后文中第一个偶数的位置
                System.out.print("j = " + j+", ");
                for (int k = j + 1; k < array.length; k++) {
                    if (array[k] % 2 != 0) {// 在第一个偶数之后顺序遍历找到第一个奇数的位置
                        System.out.print("k = " + k);
                        int temp = array[k];
                        System.out.print("， temp = " + temp);
                        for (int m = k; m > j; m--) {//将奇数之前的偶数部分后移一位
                            array[m] = array[m - 1];
                        }
                        array[j] = temp;// 将奇数插入到偶数之前
                        System.out.println(", array = " + Arrays.toString(array));
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Exercise13 exercise = new Exercise13();
        int[] array = {2, 1, 3, 4, 5, 6, 8, 7, 9};
        exercise.reOrderArray3(array);
    }
}
