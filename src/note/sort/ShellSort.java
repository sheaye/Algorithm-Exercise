package note.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void singleSort(int[] array, int start, int step) {
        for (int i = start + step; i < array.length; i += step) {
            for (int j = i; j > start; j -= step) {
                if (array[j] < array[j - step]) {
                    swap(array, j, j - step);
                } else {
                    break;
                }
            }
        }
    }

    private static void insertSort(int[] array, int step) {
        for (int i = 0; i < step; i++) {
            singleSort(array, i, step);
        }
    }

    public static void shellSort(int[] array) {
        int step = array.length;
        while (step > 1) {
            step >>= 1;
            insertSort(array,step);
        }
    }



    /*private static void insertSort(int[] array, int step) {
        System.out.println("step = "+step);
        for (int i = 0; i < step; i++) {
            System.out.println("    i = "+i);
            for (int j = i + step; j < array.length; j += step) {
                System.out.println("        j = "+j);
                if (array[j] < array[j - step]) {
                    swap(array, j, j - step);
                }
            }
        }
    }*/


}
