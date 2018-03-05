package aim_to_offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Exercise52 {


    public static void main(String[] args) {
        Exercise52 exe = new Exercise52();
        String str = "a";
        String pattern = ".*";
        char[] sArray = str.toCharArray();
        char[] pArray = pattern.toCharArray();
        System.out.println(exe.match(sArray, pArray));
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int si, char[] pattern, int pi) {
        if (si == str.length && pi == pattern.length) {
            return true;
        }
        if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
            if (si < str.length && (pattern[pi] == str[si] || pattern[pi] == '.')) {
                return match(str, si, pattern, pi + 2) || match(str, si + 1, pattern, pi);
            } else {
                return match(str, si, pattern, pi + 2);
            }
        }
        if (si < str.length && pi < pattern.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
            return match(str, si + 1, pattern, pi + 1);
        }
        return false;
    }

    /*public boolean match(char[] str, char[] pattern) {
        char last = 0;
        int pi = 0, si = 0;
        while (pi < pattern.length && si < str.length) {
            char cur = pattern[pi];
            if (cur == '*') {
                pi++;
            } else if (cur == '.') {
                si++;
                if (si == str.length) {
                    return false;
                }
                pi++;
            } else {
                if (last == '*') {
                    while (si < str.length && str[si] != cur) {
                        si++;
                    }
                    if (si == str.length) {
                        return false;
                    }
                    si++;
                    pi++;
                } else {
                    if (si >= str.length || str[si] != cur) {
                        return false;
                    }
                    si++;
                    pi++;
                }

            }
            last = cur;
        }
        if (si < str.length && pattern[pattern.length - 1] == '*') {
            return true;
        }
        if (pi < pattern.length) {
            for (int i = pi; i < pattern.length; i++) {
                if (pattern[i] != '*') {
                    return false;
                }
            }
        }
        return true;
    }*/


}
