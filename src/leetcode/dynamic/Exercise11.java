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
        String str = "catsanddog";
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(exe.wordBreak(str, set).toString());
    }

    private ArrayList<String> mList;
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        mList = new ArrayList<>();
        for (String d : dict) {
            if (s.startsWith(d)) {
                Deque<String> temp = new LinkedList<>();
                temp.addFirst(d);
                wordBreak(s.substring(d.length()), dict, temp);
            }
        }
        return mList;
    }

    private void wordBreak(String source, Set<String> dict, Deque<String> temp) {
        if (source == null || source.length() < 1) {
            StringBuilder builder = new StringBuilder();
            while (!temp.isEmpty()){
                builder.append(temp.removeFirst()).append(" ");
            }
            builder.deleteCharAt(builder.length() - 1);
            mList.add(builder.toString());
            return;
        }
        for (String dic : dict) {
            if (source.startsWith(dic)) {
                temp.addLast(dic);
                wordBreak(source.substring(dic.length()), dict, temp);
                temp.pollLast();
            }
        }
    }


}
