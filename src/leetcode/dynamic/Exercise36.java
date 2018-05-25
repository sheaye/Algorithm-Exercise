package leetcode.dynamic;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string
 * which is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 * Return3.
 */
public class Exercise36 {

    public static void main(String[] args) {
        Exercise36 exe = new Exercise36();
        System.out.println(exe.numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String S, String T) {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        int sLen = S.length();
        int tLen = T.length();
        int[][] array = new int[sLen + 1][tLen + 1];
        // 初始化第一行，字符串S为""，除了子字符串为""的情况，结果全部为0
        for (int i = 1; i < tLen + 1; i++) {
            array[0][i] = 0;
        }
        // 初始化第一列，子字符串为"",结果全部为1
        for (int i = 0; i < sLen + 1; i++) {
            array[i][0] = 1;
        }
        for (int i = 1; i < sLen + 1; i++) {
            // j>i时子序列的长度大于源数列，结果为0，无需遍历
            // 或者for (int j = 1; j <= Math.min(i, tLen); j++)
            for (int j = Math.min(i, tLen); j > 0; j--) {
                // 如果当前位置的字母不同
                if (S.charAt(i - 1) != T.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j];
                } else {// 如果当前位置的字母相同
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }

        }
        return array[sLen][tLen];
    }

    // 因为当前结果只取决于上一行结果的当前位置和后面一位，因此可以降维
    public int numDistinct2(String S, String T) {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        int sLen = S.length();
        int tLen = T.length();
        int[] array = new int[tLen + 1];
        array[0] = 1;
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = Math.min(i, tLen); j > 0; j--) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    array[j] = array[j] + array[j - 1];
                }
            }
        }
        return array[tLen];
    }

    private int total = 0;

    public int numDistinct3(String S, String T) {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        numDistinct3(S, T, 0, 0);
        return total;
    }

    private void numDistinct3(String s, String t, int si, int ti) {
        if (s.length() - si < t.length() - ti) {
            return;
        }
        int sum = 0;
        boolean bool = ti == t.length() - 1;
        for (int i = si; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(ti)) {
                if (bool) {
                    sum++;
                } else {
                    numDistinct3(s, t, i + 1, ti + 1);
                }
            }
        }
        total += sum;
    }

}
