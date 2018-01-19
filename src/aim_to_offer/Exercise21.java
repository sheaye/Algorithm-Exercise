package aim_to_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Exercise21 {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder2(pushA, popA));
    }


    public static boolean IsPopOrder(int[] pushA, int[] popA) {

        ArrayList<Integer> pushList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[j]) {
                j++;
            } else {
                pushList.add(pushA[i]);
            }
        }
        for (; j < popA.length; j++) {
            int index = pushList.size() - 1;
            if (popA[j] != pushList.get(index)) {
                return false;
            } else {
                pushList.remove(index);
            }
        }

        return true;
    }

    public static boolean IsPopOrder2(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0, i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

}
