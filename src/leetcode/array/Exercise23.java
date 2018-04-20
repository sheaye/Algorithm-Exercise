package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 */
public class Exercise23 {

    public static void main(String[] args) {
        Exercise23 exe = new Exercise23();
        int[] arr = {100, 4, 200, 5, 1, 3, 2};
        System.out.println(exe.longestConsecutive(arr));
    }

    public int longestConsecutive(int[] num) {
        if (num == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        int length = 0;
        int temp = 0;
        for (int n : num) {
            if (set.remove(n)) {
                temp++;
                int inc = n + 1, dec = n - 1;
                while (set.remove(inc++)) {
                    temp++;
                }
                while (set.remove(dec--)) {
                    temp++;
                }
                if (length < temp) {
                    length = temp;
                }
                temp = 0;
            }
        }
        return length;
    }

    public int longestConsecutive1(int[] num) {
        if (num == null) {
            return 0;
        }
        int flag = 0;
        for (int i = 0; i < num.length; i++) {
            flag |= 1 << num[i];
        }
        int length = 0;
        int temp = 0;
        while (flag != 0) {
            if ((flag & 1) == 1) {
                temp++;
            } else {
                if (length < temp) {
                    length = temp;
                }
                temp = 0;
            }
            flag >>= 1;
        }
        return length;
    }

}
