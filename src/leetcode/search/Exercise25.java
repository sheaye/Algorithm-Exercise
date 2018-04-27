package leetcode.search;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Exercise25 {


    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
            }
        };
        Exercise25 exe = new Exercise25();
        System.out.println(exe.ladderLength("hit", "cog", dict));
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int len = 1;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            while (curLevelSize-- > 0) {
                String curStr = queue.poll();
                if (isTransformEnable(curStr, end)) {
                    return len + 1;
                }
                Iterator<String> iterator = dict.iterator();
                while (iterator.hasNext()) {
                    String str = iterator.next();
                    if (isTransformEnable(curStr, str)) {
                        queue.add(str);
                        iterator.remove();
                    }
                }
            }
            len++;
        }
        return 0;
    }

    private boolean isTransformEnable(String start, String end) {
        if (start.equals(end)) {
            return false;
        }
        for (int i = 0; i < end.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                while (++i < end.length()) {
                    if (start.charAt(i) != end.charAt(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
