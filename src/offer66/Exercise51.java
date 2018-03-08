package offer66;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Exercise51 {
    public static void main(String[] args) {
        Exercise51 exe = new Exercise51();
        System.out.println(Arrays.toString(exe.multiply(new int[]{3, 5, 7, 9, 11})));

    }

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length == 0) {
            return B;
        }
        B[0] = 1;
        for (int i = 0; i < A.length-1; i++) {
            B[i + 1] = B[i] * A[i];
        }
        int temp = 1;
        for (int i = B.length - 1; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
