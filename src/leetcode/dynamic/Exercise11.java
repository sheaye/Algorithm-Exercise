package leetcode.dynamic;


import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
public class Exercise11 {

    public static void main(String[] args) {
        Exercise11 exe = new Exercise11();
//        String str = "catsanddog";
//        String str = "a";
        String str = "ab";
        Set<String> set = new HashSet<>();
//        set.add("cat");
//        set.add("cats");
//        set.add("and");
//        set.add("sand");
//        set.add("dog");
        set.add("a");
        set.add("b");
        /*ProgramTimer.timing("workBreak", 5000000, new ProgramTimer.Runner() {
            @Override
            public void run() {
                exe.wordBreak1(str, set);
            }
        });
        ProgramTimer.timing("workBreak2", 5000000, new ProgramTimer.Runner() {
            @Override
            public void run() {
                exe.wordBreak(str, set);
            }
        });*/
        System.out.println(exe.wordBreak1(str, set).toString());
    }

    private ArrayList<String> mResult;
    private ArrayList<String> mTemp;

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        mResult = new ArrayList<>();
        mTemp = new ArrayList<>();
        doBreak(s, dict);
        return mResult;
    }

    private void doBreak(String s, Set<String> dict) {
        int len = s.length();
        if (len < 1) {
            StringBuilder builder = new StringBuilder();
            for (int i = mTemp.size() - 1; i >= 0; i--) {
                builder.append(mTemp.get(i)).append(" ");
            }
            builder.deleteCharAt(builder.length() - 1);
            mResult.add(builder.toString());
        }

        for (int i = len - 1; i >= 0; i--) {
            String sub = s.substring(i, len);
            if (dict.contains(sub)) {
                mTemp.add(sub);
                doBreak(s.substring(0, i), dict);
                mTemp.remove(mTemp.size() - 1);
            }
        }
    }

    public ArrayList<String> wordBreak1(String s, Set<String> dict) {
        mResult = new ArrayList<>();
        mTemp = new ArrayList<>();
        doBreak1(s, dict);
        return mResult;
    }

    private void doBreak1(String s, Set<String> dict) {
        if (s.length() < 1) {
            StringBuilder builder = new StringBuilder();
            for (String str : mTemp) {
                builder.append(str).append(" ");
            }
            builder.deleteCharAt(builder.length() - 1);
            mResult.add(builder.toString());
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String sub = s.substring(0, i + 1);
            if (dict.contains(sub)) {
                mTemp.add(sub);
                doBreak1(s.substring(i + 1, len), dict);
                mTemp.remove(mTemp.size() - 1);
            }
        }
    }


}
