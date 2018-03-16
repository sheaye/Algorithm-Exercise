package leetcode.stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Exercise2 {

    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String value = tokens[i];
            switch (value) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-(stack.pop() - stack.pop()));
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int v1 = stack.pop();
                    int v2 = stack.pop();
                    stack.push(v2 / v1);
                    break;
                default:
                    stack.push(Integer.valueOf(value));
                    break;
            }
        }
        return stack.pop();
    }
}
