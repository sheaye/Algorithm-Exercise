package offer66;

import java.util.HashSet;
import java.util.Set;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Exercise66 {

    public static void main(String[] args) {
        Exercise66 exe = new Exercise66();
        exe.movingCount(5, 10, 10);
        System.out.println(exe.set.size());
    }

    private Set<Integer> set = new HashSet<>();

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0) {
            return 0;
        }
        moving(threshold, rows, cols, 0, 0);
        return set.size();
    }

    private void moving(int threshold, int rows, int cols, int x, int y) {
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
            return;
        }
        int index = y * cols + x;
        if (set.contains(index)) {
            return;
        }
        int sum = 0;
        int tempX = x, tempY = y;
        while (tempX != 0) {
            sum += tempX % 10;
            if (sum > threshold) {
                return;
            }
            tempX /= 10;
        }
        while (tempY != 0) {
            sum += tempY % 10;
            if (sum > threshold) {
                return;
            }
            tempY /= 10;
        }
        set.add(index);
        moving(threshold, rows, cols, x + 1, y);
        moving(threshold, rows, cols, x, y + 1);
        moving(threshold, rows, cols, x - 1, y);
        moving(threshold, rows, cols, x, y - 1);
    }

}
