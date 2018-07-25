package leetcode.greedy;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Exercise64 {

    public static void main(String[] args) {
        Exercise64 exe = new Exercise64();
        char[][] matrix = {{0}};
        System.out.println(exe.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] h = new int[n];
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push( -1);
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    h[j] += 1;
                } else {
                    h[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                while (stack.peek() != -1 && h[j] < h[stack.peek()]) {
                    int top = stack.pop();
                    max = Math.max(max, (j - 1 - stack.peek() * h[top]));
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                int top = stack.pop();
                max = Math.max(max, (n - 1 - stack.peek()) * h[top]);
            }
        }
        return max;

    }

}
