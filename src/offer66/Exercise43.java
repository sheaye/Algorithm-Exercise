package offer66;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Exercise43 {

    public static void main(String[] args) {
        Exercise43 exe = new Exercise43();
        System.out.println(exe.LeftRotateString2("abcXYZdef", 3));
    }

    public String LeftRotateString(String str, int n) {
        if (str == null || n > str.length()) {
            return "";
        }
        return str.substring(n) + str.substring(0, n);
    }

    public String LeftRotateString2(String str, int n) {
        if (str == null || n > str.length()) {
            return "";
        }
        char[] chars = str.toCharArray();
        char[] temp = new char[n];
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (i < n) {
                temp[i] = chars[i];
            }
            if (i < len - n) {
                chars[i] = chars[i + n];
            } else {
                chars[i] = temp[i - len + n];
            }
        }
        return String.valueOf(chars);
    }

}
