package leetcode.greedy;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class Exercise65 {

    public static void main(String[] args) {
        Exercise65 exe = new Exercise65();
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(exe.largestRectangleArea(height));
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[i] < height[stack.peek()]) {
                int top = stack.pop();
                max = Math.max(max, (i - 1 - stack.peek()) * height[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, (height.length - stack.peek() - 1) * height[top]);
        }
        return max;
    }

}
