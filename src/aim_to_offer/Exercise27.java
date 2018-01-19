package aim_to_offer;


import java.util.*;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Exercise27 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> list = solution.Permutation("edcba");
        System.out.println(list);
    }

    public static class Solution {

        public ArrayList<String> Permutation(String str) {

            ArrayList<String> list = new ArrayList<>();
            if (str == null || str.length() < 1) {
                return list;
            }

            Stack<List<Character>> stack = new Stack<>();
            List<Character> item = new ArrayList<>();
            item.add(str.charAt(0));
            stack.push(item);

            Stack<List<Character>> temp = null;
            for (int i = 1; i < str.length(); i++) {
                temp = new Stack<>();
                while (!stack.empty()) {
                    List<Character> pop = stack.pop();
                    for (int j = 0; j < pop.size() + 1; j++) {
                        item = new ArrayList<>(pop);
                        item.add(j, str.charAt(i));
                        temp.push(item);
                    }
                }
                stack = temp;
            }

            TreeSet<String> set = new TreeSet<>();
            while (!stack.empty()) {
                List<Character> itemList = stack.pop();
                StringBuilder builder = new StringBuilder();
                for (Character ch : itemList) {
                    builder.append(ch);
                }
                set.add(builder.toString());
            }

            list.addAll(set);
            return list;
        }
    }
}
