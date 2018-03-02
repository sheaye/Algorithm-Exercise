package aim_to_offer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class Exercise49 {

    public static void main(String[] args) {
        Exercise49 exe = new Exercise49();
        System.out.println(exe.StrToInt("-4809"));
    }

    public int StrToInt(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        char firstChar = str.charAt(0);
        if (firstChar == '-') {
            return 0 - strToInt(str, 1);
        }
        if (firstChar == '+') {
            return strToInt(str, 1);
        }
        return strToInt(str, 0);
    }

    private int strToInt(String str, int start) {
        int num = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return 0;
            }
            num = num * 10 + c - '0';
        }
        return num;
    }
}
