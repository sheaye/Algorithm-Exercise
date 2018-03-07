package aim_to_offer;

import java.util.LinkedList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Exercise54 {

    public static void main(String[] args) {
        Exercise54 exe = new Exercise54();
        String str = "google";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            exe.Insert(chars[i]);
        }
        System.out.println(exe.FirstAppearingOnce());
    }

    private LinkedList<Character> mList = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert2(char ch) {
        if (!mList.remove(((Character) ch))) {
            mList.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce2() {
        Character ch = mList.peek();
        return ch != null ? ch : '#';
    }


    private int index = 1;
    private int[] charArr;

    public Exercise54() {
        charArr = new int[256];
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charArr[ch] < 0) {
            return;
        }
        if (charArr[ch] > 0) {
            charArr[ch] = -1;
        } else {
            charArr[ch] = index++;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int ch = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i];
            if (index > 0 && index < min) {
                min = index;
                ch = i;
            }
        }
        return ch != -1 ? (char) ch : '#';
    }


}
