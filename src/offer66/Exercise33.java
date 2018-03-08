package offer66;

import java.util.ArrayList;
import java.util.List;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Exercise33 {

    public static void main(String[] args) {
        Exercise33 exe = new Exercise33();
        System.out.println(exe.GetUglyNumber_Solution(1500));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //  ×2，×3，×5的三个基数的索引
        int index2 = 0, index3 = 0, index5 = 0;
        //  ×2，×3，×5的所得值
        int num2 = 2, num3 = 3, num5 = 5;
        for (int i = 1; i < index; i++) {
            int min = Math.min(num2, Math.min(num3, num5));
            list.add(min);
            if (min == num2) {
                num2 = list.get(++index2) * 2;
            }
            if (min == num3) {
                num3 = list.get(++index3) * 3;
            }
            if (min == num5) {
                num5 = list.get(++index5) * 5;
            }
        }
        return list.get(index-1);
    }

}
