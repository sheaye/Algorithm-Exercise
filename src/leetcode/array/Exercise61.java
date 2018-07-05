package leetcode.array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class Exercise61 {

    public static void main(String[] args) {
        Exercise61 exe = new Exercise61();
//        int[] A = {1, 4, 7, 10, 13, 16, 19, 0, 0, 0, 0, 0, 0, 0};
//        int[] B = {2, 5, 8, 11, 14, 17, 20};
        int[] A = {1};
        int[] B = {};
        exe.merge(A, 7, B, 7);
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
