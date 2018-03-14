package offer66;


import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Exercise64 {

    public static void main(String[] args) {
        Exercise64 exe = new Exercise64();
        int[] num = {10, 14, 12, 11};
        System.out.println(exe.maxInWindows(num, 0));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0 || num == null || num.length < size) {
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Integer value = num[i];
            queue.offer(value);
            maxHeap.offer(value);
        }
        list.add(maxHeap.peek());
        for (int i = size; i < num.length; i++) {
            if (queue.poll() == maxHeap.peek()) {
                maxHeap.poll();
            }
            queue.offer(num[i]);
            maxHeap.offer(num[i]);
            list.add(maxHeap.peek());
        }
        return list;
    }

}
