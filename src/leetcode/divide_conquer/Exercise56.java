package leetcode.divide_conquer;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given"25525511135",
 * return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * IP地址是一个32位的二进制数，通常被分割为4个“8位二进制数”（也就是4个字节）。
 * IP地址通常用“点分十进制”表示成（a.b.c.d）的形式，其中，a,b,c,d都是0~255之间的十进制整数。
 */
public class Exercise56 {

    public static void main(String[] args) {
        Exercise56 exe = new Exercise56();
        System.out.println(exe.restoreIpAddresses("010010").toString());//"0.10.0.10","0.100.1.0
    }


    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> restoreIpAddresses2(String s) {
        restoreIpAddresses(s, "", 0, 0);
        return result;
    }

    private void restoreIpAddresses(String source, String header, int start, int index) {
        // 剩下的数字的位数超限，pass
        if (source.length() - start > (4 - index) * 3) {
            return;
        }
        // 遍历当前位置及两位
        for (int i = start; i < Math.min(start + 3, source.length()); i++) {
            StringBuilder builder = new StringBuilder(header);
            String cur = source.substring(start, i + 1);
            // 如果组成的数字位数超过1而以0开头，pass;如果组成的数字超过255，pass
            if ((cur.length() > 1 && cur.startsWith("0")) || Integer.parseInt(cur) > 255) {
                return;
            }
            builder.append(cur);
            if (index < 3) {
                // 如果没有达到4组，继续解析剩下的数字
                builder.append(".");
                restoreIpAddresses(source, builder.toString(), i + 1, index + 1);
            } else if (i == source.length() - 1) {
                // 如果还剩余了数字，
                result.add(builder.toString());
            }
        }
    }

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) {
            return res;
        }
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        return true;
    }

}
