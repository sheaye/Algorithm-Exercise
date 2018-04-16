package leetcode.dynamic;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return 1 since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */
public class Exercise19 {

    public static void main(String[] args) {
        Exercise19 exe = new Exercise19();
        System.out.println(exe.minCut("ab"));
    }

    /**
     * 解题思路：动态规划问题。
     * dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。
     * 分几种情况：
     * 1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，
     * dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
     * 2.对于任意大于1的i，如果s.substring(j,i+1)(j<=i,即遍历i之前的每个子串)是回文时，
     * dp[i] = min(dp[i], dp[j-1]+1);
     * 3.如果s.substring(j,i+1)(j<=i)不是回文时，dp[i] = min(dp[i],dp[j-1]+i+1-j);
     */
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
            if (dp[i] == 0) {
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if ( isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + i + 1 - j);
                }
            }
        }
        return dp[dp.length - 1];
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    /*public int minCut(String s) {
        return minCut1(s, 0, s.length() - 1);
    }

    public int minCut1(String s, int start, int end) {
        if (start > end) {
            return 0;
        }
        for (int i = end; i > start; i--) {
            if (isPalindrome(s, start, i)) {
                return minCut1(s, i + 1, end) + 1;
            }
        }
        return -1;
    }

    public int minCut2(String s, int curMin, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                int cur = 1 + minCut2(s, Integer.MAX_VALUE, i + 1, end);
                if (curMin > cur) {
                    curMin = cur;
                }
            }
        }
        return curMin - 1;
    }*/

}
