package aim_to_offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Exercise48 {

    public static void main(String[] args) {
        Exercise48 exe = new Exercise48();
        System.out.println(exe.Add(111, 899));
    }

    public int Add(int num1, int num2) {
        int n1 = (num1 & num2) << 1;
        int n2 = num1 ^ num2;
        if ((n1 & n2) != 0) {
            return Add(n1, n2);
        }
        return n1 | n2;
    }

}
