package leetcode.bitoperation;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Exercise15 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 6};
        Exercise15 exe = new Exercise15();
        System.out.println(exe.singleNumber(a));
    }

    public int singleNumber(int[] A) {
        int flag = 0;
        for (int i = 0; i < A.length; i++) {
            flag ^= A[i];
        }
        return flag;
    }

}
