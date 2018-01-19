package aim_to_offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Exercise10 {

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }

    public static int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int r1 = 1, r2 = 2, r3 = 0;
        for (int i = 3; i <= target; i++) {
            r3 = r1 + r2;
            r1 = r2;
            r2 = r3;
        }
        return r3;
    }
}
