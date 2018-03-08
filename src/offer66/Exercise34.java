package offer66;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Exercise34 {

    public static void main(String[] args) {
        Exercise34 exe = new Exercise34();
        System.out.println(exe.FirstNotRepeatingChar("google"));
    }

    private class ValueBean {
        private int mFirstIndex;
        private int mTimes;

        ValueBean(int mFirstIndex) {
            this.mFirstIndex = mFirstIndex;
            mTimes = 1;
        }

        void addTimes() {
            mTimes++;
        }
    }

    public int FirstNotRepeatingChar2(String str) {
        Map<Character, ValueBean> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.get(ch).addTimes();
            } else {
                map.put(ch, new ValueBean(i));
            }
        }
        for (Map.Entry<Character, ValueBean> entry : map.entrySet()) {
            if (entry.getValue().mTimes == 1) {
                return entry.getValue().mFirstIndex;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
