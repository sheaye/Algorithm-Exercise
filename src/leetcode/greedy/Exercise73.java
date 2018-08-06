package leetcode.greedy;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S ="ADOBECODEBANC"
 * T ="ABC"
 * Minimum window is"BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string"".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Exercise73 {


    public static void main(String[] args) {
        Exercise73 exe = new Exercise73();
        System.out.println(exe.minWindow("ADOBECODEBANC","BANC"));
    }

    public String minWindow(String S, String T) {

        // init map, 记录T中每个元素出现的次数
        int[] map = new int[128];
        for (int i = 0; i < T.length(); i++) {
            map[T.charAt(i)]++;
        }
        // begin指向窗口首位的指针
        int begin = 0;
        // end指向窗口尾部的指针
        int end = 0;
        // d记录窗口长度
        int d = Integer.MAX_VALUE;
        // count记录T中没被窗口包含的字符个数
        int count = T.length();
        // head记录最小窗口的首字符位置
        int head = 0;
        while (end < S.length()) {
            if (map[S.charAt(end++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - begin < d) {
                    d = end - (head = begin);
                }
                if (map[S.charAt(begin++)]++ == 0){
                    count++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : S.substring(head, head + d);
    }

}
