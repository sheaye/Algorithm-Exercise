package offer66;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述：对应每个测试案例，输出两个数，小的先输出。
 */
public class Exercise42 {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        Exercise42 exe = new Exercise42();
        System.out.println(exe.FindNumbersWithSum(array,50));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0, j = array.length - 1; i < j; ) {
            int s = array[i] + array[j];
            if (s > sum) {
                j--;
            } else if (s < sum) {
                i++;
            } else {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
        }
        return list;

    }
}
