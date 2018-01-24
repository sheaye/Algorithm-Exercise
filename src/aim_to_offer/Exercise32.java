package aim_to_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3, 32, 321}，则打印出这三个数字能排成的最小数字为321323。
 * {3, 5, 1, 4, 2}
 */
public class Exercise32 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.PrintMinNumber(new int[]{3, 32, 321}));
    }

    public static class Solution1 {
        public String PrintMinNumber(int[] numbers) {
            if (numbers == null || numbers.length < 1) {
                return "";
            }
            for (int i = 0; i < numbers.length - 1; i++) {
                int min = numbers[i];
                for (int j = i + 1; j < numbers.length; j++) {
                    if (compare(min, numbers[j]) > 0) {
                        min = numbers[j];
                        swap(numbers, i, j);
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                builder.append(numbers[i]);
            }
            return builder.toString();
        }

        private int compare(int num1, int num2) {
            Stack<Integer> stack1, stack2;
            // 检查stack1和stack2,始终保持stack1的长度>=stack2的长度
            if (num1 < num2) {
                stack1 = getNumStack(num2);
                stack2 = getNumStack(num1);
            } else {
                stack1 = getNumStack(num1);
                stack2 = getNumStack(num2);
            }
            int pop1;
            int pop2 = stack2.pop();
            do {
                pop1 = stack1.pop();
                if (pop1 > pop2) {
                    return num1 - num2;
                } else if (pop1 < pop2) {
                    return num2 - num1;
                }
                if (!stack2.empty()) {
                    pop2 = stack2.pop();
                }

            } while (!stack1.empty());

            return 0;
        }

        private Stack<Integer> getNumStack(int num) {
            Stack<Integer> stack = new Stack<>();
            while (num != 0) {
                stack.push(num % 10);
                num /= 10;
            }
            return stack;
        }

        private void swap(int[] array, int i1, int i2) {
            int temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }
    }

    public static class Solution2 {

        public String PrintMinNumber(int[] numbers) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                List<Integer> list = new ArrayList<>();
                lists.add(getNumberList(list, numbers[i]));
            }
            for (int i = 0; i < lists.size(); i++) {
                List min = lists.get(i);
                for (int j = i + 1; j < numbers.length; j++) {
                    if (compare(min, lists.get(j)) > 0) {
                        min = lists.get(j);
                        lists.set(j, lists.get(i));
                        lists.set(i, min);
                        swap(numbers, i, j);
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                builder.append(numbers[i]);
            }
            return builder.toString();
        }

        private List<Integer> getNumberList(List<Integer> list, int num) {
            if (num / 10 != 0) {
                getNumberList(list, num / 10);
            }
            list.add(num % 10);
            return list;
        }

        private int compare(List<Integer> list1, List<Integer> list2) {
            int num1 = list1.get(0), num2 = list2.get(0);
            for (int i = 0, j = 0; i < list1.size() || j < list2.size(); ) {
                if (num1 < num2) {
                    return -1;
                } else if (num1 > num2) {
                    return 1;
                }
                if (++i < list1.size()) {
                    num1 = list1.get(i);
                }
                if (++j < list2.size()) {
                    num2 = list2.get(j);
                }
            }
            return 0;
        }

        private void swap(int[] array, int i1, int i2) {
            int temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }

    }

}
