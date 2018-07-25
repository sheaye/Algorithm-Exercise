package leetcode.array;

import java.util.Arrays;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A =[1,1,1,2,2,3],
 * Your function should return length =5, and A is now[1,1,2,2,3].
 */
public class Exercise69 {

    public static void main(String[] args) {
        Exercise69 exe = new Exercise69();
        int[] A = new int[]{1, 1, 1, 2};
        System.out.println(exe.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }

    /*public int removeDuplicates(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int[] dummy = new int[A.length];
        dummy[0] = A[0];


        int temp = A[0];
        int tempLen = 1;
        int totalLen = 1;
        for (int i = 1, j = 1; i < A.length; i++) {
            if (A[i] == temp) {
                dummy[j++] = temp;
                tempLen++;
                totalLen++;
                while (i < A.length && A[i] == temp && tempLen > 1) {
                    i++;
                }
                if (i < A.length) {
                    dummy[j++] = A[i];
                    totalLen++;
                    temp = A[i];
                    tempLen = 1;
                }
            } else {
                totalLen++;
                temp = A[i];
                dummy[j++] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = dummy[i];
        }
        return totalLen;
    }*/

    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length < 3) {
            return A.length;
        }
        int index = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[index - 2]) {
                A[index++] = A[i];
            }
        }
        return index;
    }


}
