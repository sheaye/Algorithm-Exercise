package offer66;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Exercise53 {

    public static void main(String[] args) {
        Exercise53 exe = new Exercise53();
//        String[] nums = {"+100", "5e2", "-123", "3.1416", "-1E-16"};
        String[] nums = {"12e","1a3.14","1.2.3","+-5","12e+4.3"};
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
            char[] chars = num.toCharArray();
            System.out.println(num + ": " + exe.isNumeric(chars));
        }
    }

    public boolean isNumeric2(char[] str) {
        String string = String.valueOf(str);
//      [\+-]?匹配“+”或“-”0次或1次
//      [0-9]*匹配0到9的数字零到多个
//      (\.[0-9]*)?匹配小数部分
//      [eE]匹配e或E
        return string.matches("[\\+-]?[0-9]+(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }
        int i = 0;
        char firstChar = str[0];
        if (firstChar == '+' || firstChar == '-') {
            if (str.length == 1) {
                return false;
            }
            i = 1;
        }
        boolean eFlag = false;
        boolean dotFlag = false;
        for (; i < str.length; i++) {
            char c = str[i];
            if (c >= '0' && c <= '9') {

            } else if (c == 'e' || c == 'E') {
                if (eFlag) {
                    return false;
                } else if (++i == str.length) {
                    return false;
                } else {
                    eFlag = true;
                    dotFlag = true;
                    if (str[i] != '-' && str[i] != '+' && (str[i] < '0' || str[0] > '9')) {
                        return false;
                    }
                }
            } else if (c == '.') {
                if(dotFlag){
                    return false;
                }else {
                    dotFlag = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
