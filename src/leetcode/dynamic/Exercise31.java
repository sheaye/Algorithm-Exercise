package leetcode.dynamic;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Exercise31 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>() {
                    {
                        add(2);
                    }
                });
            }

            {
                add(new ArrayList<Integer>() {
                    {
                        add(3);
                        add(4);
                    }
                });
            }

            {
                add(new ArrayList<Integer>() {
                    {
                        add(6);
                        add(5);
                        add(7);
                    }
                });
            }

            {
                add(new ArrayList<Integer>() {
                    {
                        add(4);
                        add(1);
                        add(8);
                        add(3);
                    }
                });
            }
        };
        Exercise31 exe = new Exercise31();
        System.out.println(exe.minimumTotal(triangle));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        int rows = triangle.size();
        int columns = triangle.get(rows - 1).size();
        int[][] values = new int[rows][columns];
        values[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            ArrayList<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer cur = list.get(j);
                if (j == 0) {
                    values[i][j] = cur + values[i - 1][j];
                } else if (j == list.size() - 1) {
                    values[i][j] = cur + values[i - 1][j - 1];
                } else {
                    values[i][j] = cur + Math.min(values[i - 1][j - 1], values[i - 1][j]);
                }
            }
        }
        int[] totals = values[rows - 1];
        int total = totals[0];
        for (int i = 1; i < totals.length; i++) {
            total = Math.min(total, totals[i]);
        }
        return total;
    }


    public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
        int line = triangle.size() - 1;
        ArrayList<Integer> list = triangle.get(line);
        int total = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            total = Math.min(total, minimumTotal1(triangle, line, i));
        }
        return total;
    }

    public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle, int row, int index) {
        if (row < 0 || index < 0) {
            return Integer.MAX_VALUE;
        }
        ArrayList<Integer> list = triangle.get(row);
        if (row == 0) {
            return list.get(0);
        }
        if (index > list.size() - 1) {
            return Integer.MAX_VALUE;
        }
        return list.get(index) + Math.min(minimumTotal1(triangle, row - 1, index - 1), minimumTotal1(triangle, row - 1, index));
    }
}
