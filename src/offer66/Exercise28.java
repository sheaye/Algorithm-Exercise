package offer66;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Exercise28 {

    public static void main(String[] args) {
        Exercise28 exe = new Exercise28();
        System.out.println(exe.MoreThanHalfNum_Solution2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int length = array.length;
        int halfLength = length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int item = array[i];
            Integer count = map.get(item);
            if (count != null) {
                count++;
            } else {
                count = 1;
            }
            if (count > halfLength) {
                return item;
            } else {
                map.put(item, count);
            }
        }
        return 0;
    }

    //  对数组排序，如果存在超过一半数量的数，那么中位数肯定是该数。
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array == null) {
            return 0;
        }
        int len = array.length;
        if (len < 1) {
            return 0;
        }
        Arrays.sort(array);
        int mid = array[len / 2];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == mid) {
                count++;
            }
        }
        if (count > len / 2) {
            return mid;
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution3(int[] array) {

        if (array == null || array.length < 1) {
            return 0;
        }

//      找出数量最多的元素
        int temp = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp == array[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                temp = array[i];
                count = 1;
            }
        }

//      计最多元素的个数
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp == array[i]) {
                count++;
            }
        }
        return count > array.length / 2 ? temp : 0;

    }

}
