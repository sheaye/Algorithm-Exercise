package note.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 4, 8, 3, 9, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid + 1, right, temp);
        mergeArray(array, left, mid, right, temp);
    }

    private static void mergeArray(int[] array, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int lEnd = mid + 1;
        int rEnd = right + 1;
        int k = 0;
        while (l < lEnd && r < rEnd) {
            if (array[l] < array[r]) {
                temp[k++] = array[l++];
            } else {
                temp[k++] = array[r++];
            }
        }
        while (l < lEnd) {
            temp[k++] = array[l++];
        }
        while (r < rEnd) {
            temp[k++] = array[r++];
        }
        for (int i = 0; i < k; i++) {
            array[left + i] = temp[i];
        }
    }


}
