package leetcode.dynamic;

public class Exercise59 {

    public static void main(String[] args) {
        Exercise59 exe = new Exercise59();
        System.out.println(exe.numDecodings("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
    }

    /**
     * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * For example,
     * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
     * The number of ways decoding"12"is 2.
     *
     * @param s
     */
    public int numDecodings2(String s) {
        if (s == null || s.length() < 1 || s.charAt(0) == '0') {
            return 0;
        }
        int[] num = new int[s.length()];
        num[0] = 1;
        if (s.length() < 2) {
            return num[0];
        }
        if (s.charAt(1) == '0') {
            if (Integer.valueOf(s.substring(0, 2)) > 26) {
                return 0;
            } else {
                num[1] = num[0];
            }
        } else {
            if (Integer.valueOf(s.substring(0, 2)) > 26) {
                num[1] = 1;
            } else {
                num[1] = num[0] + 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (Integer.valueOf(s.substring(i - 1, i + 1)) > 26 || s.charAt(i - 1) == '0') {
                    return 0;
                }
                num[i] = num[i - 2];
                continue;
            }
            if (s.charAt(i - 1) == '0' || Integer.valueOf(s.substring(i - 1, i + 1)) > 26) {
                num[i] = num[i - 1];
                continue;
            }
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[s.length() - 1];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() < 1 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] num = new int[len + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == '0' && (s.charAt(i - 2) > '2' || s.charAt(i - 2) == '0')) {
                return 0;
            }
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                // 如果当前位非0,那么当前位可以单独解析为字母。
                // 当前位单独解析为字母的情况下解析的种类有num[i-1]种
                num[i] += num[i - 1];
            }
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                // 如果后两位为1~26,那还可以解析的种类为num[i-2]
                num[i] += num[i - 2];
            }
        }
        return num[len];

    }


}
