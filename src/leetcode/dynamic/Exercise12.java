package leetcode.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class Exercise12 {

    public static void main(String[] args) {
        Exercise12 exe = new Exercise12();
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("codee");
        System.out.println(exe.wordBreak("leetcode", dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null) {
            return false;
        }
        if (s.length() < 1) {
            return true;
        }
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            String sub = s.substring(i, len);
            if (dict.contains(sub) && wordBreak(s.substring(0, i), dict)) {
                return true;
            }
        }
        return false;

    }

}
