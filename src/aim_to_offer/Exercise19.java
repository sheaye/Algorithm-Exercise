package aim_to_offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Exercise19 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list.toString());
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int y = matrix.length;
        if (y < 1) {
            return null;
        }
        int x = matrix[0].length;
        if (x < 1) {
            return null;
        }
        int count = x * y;
        int i = 0, j = 0;
        int direct = 0;
        int left = 0, right = x - 1, top = 0, bottom = y - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (count > 0) {
            if (direct == 0) {// 向右遍历
                int value = matrix[i][j++];
                list.add(value);
                if (j > right) {
                    j--;
                    i++;
                    top++;
                    direct = 1;
                }
            } else if (direct == 1) {// 向下遍历
                int value = matrix[i++][j];
                System.out.print(value + ", ");
                list.add(value);
                if (i > bottom) {
                    i--;
                    j--;
                    right--;
                    direct = 2;
                }
            } else if (direct == 2) {// 向左遍历
                int value = matrix[i][j--];
                list.add(value);
                if (j < left) {
                    j++;
                    i--;
                    bottom--;
                    direct = 3;
                }
            } else {// 向上遍历
                int value = matrix[i--][j];
                list.add(value);
                if (i < top) {
                    i++;
                    j++;
                    left++;
                    direct = 0;
                }
            }
            count--;
        }
        return list;
    }

    public static ArrayList<Integer> printMatrix2(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int y = matrix.length;
        if (y < 1) {
            return null;
        }
        int x = matrix[0].length;
        if (x < 1) {
            return null;
        }
        for (int i = 0, j = 0;;) {

        }

    }


}
