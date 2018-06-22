package leetcode.dynamic;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 */
public class Exercise52 {

    public static void main(String[] args) {
        Exercise52 exe = new Exercise52();
        System.out.println(exe.isInterleave("a", "", "a"));
//        System.out.println(exe.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
//        System.out.println(exe.isInterleave("a", "b", "a"));
    }

    /*public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len1+len2 !=len3){
            return false;
        }

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();

        //dp[i][j]代表 chs1[0...i]  chs2[0...j]能否顺序匹配chs3[i+j]
        boolean[][] dp = new boolean[len1+1][len2+1];
        //初始化 s1中取0个字符 s2中取0个字符 匹配s3从0开始的0个字符 肯定匹配true
        dp[0][0] = true;

        //s1中取0个s2中取i个 去和s3中0+i 个匹配
        for(int i = 1 ; i < len2 + 1; i ++ ){
            dp[0][i] = dp[0][i-1] && chs2[i-1] == chs3[i-1];
        }
        //s2中取0个s1中取i个 去和s3中0+i 个匹配
        for(int i = 1 ; i < len1 + 1; i ++ ){
            dp[i][0] = dp[i-1][0] && chs1[i-1] == chs3[i-1];
        }

        for(int i = 1 ; i < len1+1 ; i ++ ){
            for(int j = 1 ; j < len2+1 ; j ++ ){
                dp[i][j] = dp[i-1][j] && (chs3[i+j-1] == chs1[i-1])
                        || dp[i][j-1] && (chs3[i+j-1] == chs2[j-1]);
            }
        }

        return dp[len1][len2];
    }*/

    /*public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s3 == null) {
            return false;
        }
        if (s1 == null) {
            return s3.equals(s2);
        }
        if (s2 == null) {
            return s3.equals(s1);
        }
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 + len2 != s3.length()) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();

        // dp[i][j]表示s1的前i个字符和s2的前j个字符能否匹配s3的前(i+j)个字符
        boolean[][] dp = new boolean[len2 + 1][len1 + 1];
        dp[0][0] = true;
        for (int i = 1; i < len2 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && (chs2[i - 1] == s3.charAt(i - 1));
        }
        for (int i = 1; i < len1 + 1; i++) {
            dp[0][i] = dp[0][i - 1] && (chs1[i - 1] == s3.charAt(i - 1));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (chs1[j - 1] == chs3[i + j - 1] && dp[i][j - 1]) || (chs2[i - 1] == chs3[i + j - 1] && dp[i - 1][j]);
            }
        }
        return dp[len2][len1];
    }*/

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s3 == null) {
            return false;
        }
        if (s1 == null) {
            return s3.equals(s2);
        }
        if (s2 == null) {
            return s3.equals(s1);
        }
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 + len2 != s3.length()) {
            return false;
        }
        // dp[i][j]表示s1的前i个字符和s2的前j个字符能否匹配s3的前(i+j)个字符
        boolean[][] dp = new boolean[len2 + 1][len1 + 1];
        dp[0][0] = true;
        for (int i = 1; i < len2 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i < len1 + 1; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (s1.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) || (s2.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]);
            }
        }
        return dp[len2][len1];
    }


    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s3 == null) {
            return false;
        }
        if (s1 == null || s1.length() < 1) {
            return s3.equals(s2);
        }
        if (s2 == null || s2.length() < 1) {
            return s3.equals(s1);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave2(s1, s1.length() - 1, s2, s2.length() - 1, s3, s3.length() - 1);

    }

    private boolean isInterleave2(String s1, int end1, String s2, int end2, String s3, int end3) {

        if (end3 < 0) {
            return true;
        }
        char cur = s3.charAt(end3);
        if (end1 >= 0) {
            if (s1.charAt(end1) == cur && isInterleave2(s1, end1 - 1, s2, end2, s3, end3 - 1)) {
                return true;
            }
        }
        if (end2 >= 0) {
            if (s2.charAt(end2) == cur && isInterleave2(s1, end1, s2, end2 - 1, s3, end3 - 1)) {
                return true;
            }
        }

        return false;
    }

}
