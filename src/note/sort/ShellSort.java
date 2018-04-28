package note.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 4, 8, 3, 9, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {

    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
