package aim_to_offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Exercise29 {

    public static void main(String[] args) {
        Exercise29 exe = new Exercise29();
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = exe.GetLeastNumbers_Solution(array, 4);
        System.out.println(list.toString());
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            int min = input[i];
            for (int j = i + 1; j < input.length; j++) {
                if (min > input[j]) {
                    min = input[j];
                    swap(input, i, j);
                }
            }
            list.add(input[i]);
        }
        return list;
    }

    /*public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    swap(array, i, j);
                }
            }
        }
    }*/

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

}
