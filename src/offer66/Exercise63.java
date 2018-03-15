package offer66;

import java.util.*;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Exercise63 {

    public static void main(String[] args) {
        Exercise63 exe = new Exercise63();
        int[] arr = {1, 7, 8, 2, 4, 3, 5, 6};
        /*ProgramTimer.timing("1", 10000, new ProgramTimer.Runner() {
            @Override
            public void run2() {
                for (int i = 0; i < arr.length; i++) {
                    exe.Insert(arr[i]);
                }
                exe.GetMedian();
            }
        });

        ProgramTimer.timing("2", 10000, new ProgramTimer.Runner() {
            @Override
            public void run2() {
                for (int i = 0; i < arr.length; i++) {
                    exe.Insert2(arr[i]);
                }
                exe.GetMedian2();
            }
        });*/

        for (int i = 0; i < arr.length; i++) {
            exe.Insert2(arr[i]);
        }
        exe.GetMedian2();

    }

    private LinkedList<Integer> list = new LinkedList<>();

    public void Insert(Integer num) {
        int size = list.size();
        if (size < 1 || num > list.get(size - 1)) {
            list.add(num);
            return;
        }
        if (num < list.get(0)) {
            list.add(0, num);
            return;
        }
        insert(num, 0, size - 1);

    }

    private void insert(int num, int start, int end) {
        if (start >= end) {
            Integer value = list.get(start);
            list.add(num > value ? start + 1 : start, num);
            return;
        }
        int midIndex = (start + end) / 2;
        int midValue = list.get(midIndex);
        if (num > midValue) {
            insert(num, midIndex + 1, end);
        } else if (num < midValue) {
            insert(num, 0, midIndex - 1);
        } else {
            list.add(midIndex + 1, num);
        }
    }

    public Double GetMedian() {
        if (list.size() < 1) {
            return 0d;
        }
        int mid = list.size() / 2;
        if (list.size() % 2 != 0) {
            return Double.valueOf(list.get(mid));
        } else {
            return (double) (list.get(mid) + list.get(mid - 1)) / 2;
        }
    }

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert2(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int maxMid = maxHeap.poll();
            minHeap.offer(maxMid);
        } else {
            minHeap.offer(num);
            int minMid = minHeap.poll();
            maxHeap.offer(minMid);
        }
        System.out.println("count = " + count);
        System.out.println("maxHeap:" + Arrays.toString(maxHeap.toArray()));
        System.out.println("minHeap:" + Arrays.toString(minHeap.toArray()));
        System.out.println();
        count++;
    }

    public Double GetMedian2() {
        if (count % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return Double.valueOf(minHeap.peek());
        }
    }

}
