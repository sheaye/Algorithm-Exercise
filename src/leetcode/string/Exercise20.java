package leetcode.string;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s ="aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Exercise20 {

    public static void main(String[] args) {
        Exercise20 exe = new Exercise20();
        System.out.println(exe.partition("fff"));
    }

    private ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> partition(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(s, 0, i)) {
                List<String> list = new LinkedList<>();
                list.add(s.substring(0, i + 1));
                partition(s, list, i + 1);
            }
        }
        return result;
    }

    private void partition(String s, List<String> list, int start) {
        if (start > s.length() - 1) {
            ArrayList<String> item = new ArrayList<>(list);
            result.add(item);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                partition(s, list, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /*public ArrayList<ArrayList<String>> partition(String s) {
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (isPalindrome(s, i, len - 1)) {
                List<String> list = new LinkedList<>();
                list.add(s.substring(i, s.length()));
                partition(s, list, i - 1);
            }
        }
        return result;
    }

    private void partition(String s, List<String> list, int end) {
        if (end < 0) {
            ArrayList<String> item = new ArrayList<>(list);
            result.add(item);
            return;
        }
        for (int i = end; i >= 0; i--) {
            if (isPalindrome(s, i, end)) {
//                list.add(0, s.substring(i, end + 1));
                list.add(s.substring(i, end + 1));
                partition(s, list, i - 1);
//                list.remove(0);
                list.remove(list.size() - 1);
            }
        }

    }*/


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/f983806a2ecb4106a17a365a642a9632
     * 来源：牛客网
     */
    public ArrayList<ArrayList<String>> partition2(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> nullAL = new ArrayList<>();
        result.add(nullAL);
        int strLength = s.length();
        // 遍历s中每个字符
        for (int i = 0; i < strLength; i++) {
            String palindrome = String.valueOf(s.charAt(i));
            ArrayList<ArrayList<String>> additionResult = new ArrayList<>();
            for (ArrayList<String> resultAL : result) {
                int resultALSize = resultAL.size();
                // 如果能和最后一个字符串相等，那么该字符串与最后一个字符串可以构成回文，新建一个list，存储这种情况。
                if (resultALSize > 0 && resultAL.get(resultALSize - 1).equals(palindrome)) {
                    ArrayList<String> additionAL = new ArrayList<>(resultAL);
                    additionAL.set(resultALSize - 1, additionAL.get(resultALSize - 1) + palindrome);
                    additionResult.add(additionAL);
                }
                // 如果能和倒数第二个字符串相等，那么倒数两个字符串与该字符可以构成回文，新建一个list，存储这种情况
                if (resultALSize > 1 && resultAL.get(resultALSize - 2).equals(palindrome)) {
                    ArrayList<String> additionAL = new ArrayList<>(resultAL.subList(0, resultALSize - 2));
                    additionAL.add(palindrome + resultAL.get(resultALSize - 1) + palindrome);
                    additionResult.add(additionAL);
                }
                // 这个字母一定为回文，记录这种情况
                resultAL.add(palindrome);
            }
            result.addAll(additionResult);
        }
        // 这题坑爹，最后的结果要按每个list中字符串的字典序排列，排列不对不给过
        Collections.sort(result, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                int o1Size = o1.size();
                int o2Size = o2.size();
                int count = o1Size < o2Size ? o1Size : o2Size;
                for (int i = 0; i < count; i++) {
                    if (o1.get(i).compareTo(o2.get(i)) != 0) {
                        return o1.get(i).compareTo(o2.get(i));
                    }
                }
                return Integer.compare(o1Size, o2Size);
            }
        });

        return result;
    }

}
