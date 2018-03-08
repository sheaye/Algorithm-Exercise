package offer66;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by yexinyan on 2017/11/15.
 */
public class Exercise8 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(JumpFloor(i));
        }
    }

    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int f1 = 1, f2 = 2, f = 0;
        for (int i = 3; i <= target; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
