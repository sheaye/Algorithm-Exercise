package leetcode.bitoperation;

import common.IntegerUtil;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Exercise14 {

    public static void main(String[] args) {
        Exercise14 exe = new Exercise14();
        int[] A = {1, 2, 1, 3, 2, 1, 2};
        System.out.println(exe.singleNumber(A));
    }

    /*public int singleNumber(int[] A) {
        int flag = 0;
        int sum = 0;
        int sub = 0;
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            if (((flag >> cur) & 1) == 0) {
                sub += cur;
                flag |= 1 << cur;
            }
            sum += cur;
        }
        return sub - (sum - sub) / 2;
    }*/


    public int singleNumber(int[] A) {
        int once = 0;
        int twice = 0;
        int thrice = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
//            System.out.println("num = " + IntegerUtil.toBinary(num) + ", once = " + IntegerUtil.toBinary(once) + ", twice = " + IntegerUtil.toBinary(twice) + ", thrice = " + IntegerUtil.toBinary(thrice));
            twice |= once & num;
            once ^= num;
            thrice = once & twice;
            once &= ~thrice;
            twice &= ~thrice;
        }
        return once;
    }

}
