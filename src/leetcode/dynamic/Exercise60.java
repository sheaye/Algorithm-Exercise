package leetcode.dynamic;

import common.IntegerUtil;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example,[0,2,3,1]is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class Exercise60 {

    public static void main(String[] args) {
        Exercise60 exe = new Exercise60();
        int n = 4;
        ArrayList<Integer> list = exe.grayCode(n);

    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int num = 1 << n;
        for (int i = 0; i < num; ++i) {
            System.out.println("i = " + i);
            System.out.println(IntegerUtil.toBinary(i, n) + " >> 1 ^ " + IntegerUtil.toBinary(i, n) + " = " + IntegerUtil.toBinary(i >> 1 ^ i, n));
            arr.add(i >> 1 ^ i);
            System.out.println();
        }
        return arr;
    }
}
