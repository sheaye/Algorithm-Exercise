package leetcode.array;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * click to show follow up.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class Exercise74 {

    public static void main(String[] args) {
        Exercise74 exe = new Exercise74();
        int[] arr = {0, 1, 1, 2, 0, 1, 2, 2, 1, 1, 1, 1};
        exe.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors2(int[] A) {
        int index0 = 0;
        int index2 = A.length - 1;
        int i = 0;
        while (i < index2 + 1) {
            if (A[i] == 0) {
                swap(A, i++, index0++);
            } else if (A[i] == 2) {
                swap(A, i, index2--);
            } else {
                i++;
            }
        }
    }

    public void sortColors(int[] A) {
        int index0 = 0;
        int index2 = A.length - 1;
        for (int i = 0; i < index2 + 1; ) {
            if (A[i] == 0) {
                swap(A, i++, index0++);
            } else if (A[i] == 2) {
                swap(A, i, index2--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
