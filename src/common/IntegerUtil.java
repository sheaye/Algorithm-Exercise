package common;

public class IntegerUtil {

    public static void main(String[] args) {
        System.out.println(toBinary(10));
    }

    public static String toBinary(int num){
        String s = Integer.toBinaryString(num);
        return s.length() < 8 ? "00000000".substring(s.length()) + s:s;
    }
}
