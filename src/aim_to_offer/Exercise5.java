package aim_to_offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Created by yexinyan on 2017/11/14.
 */
public class Exercise5 {

    public static void main(String[] args) {
        Exercise5 sequence = new Exercise5();
        for (int i = 0; i < 10; i++) {
            sequence.push(i);
        }
        while (sequence.stack2.size() > 0) {
            System.out.print(sequence.pop());
        }
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
