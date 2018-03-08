package offer66;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入：{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
 * 输出：2519
 */
public class Exercise35 {

    public static void main(String[] args) {
        Exercise35 exe = new Exercise35();
        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(exe.InversePairs(array));
    }

    public int InversePairs(int[] array) {
        if (array.length < 1) {
            return 0;
        }
        return (int) (inversePairs(array, 0, array.length - 1) % 1000000007);
    }

    private long inversePairs(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        long count = 0;
        count += inversePairs(array, start, mid);
        count += inversePairs(array, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int cur = temp.length - 1;
        int i = mid, j = end;
        for (; i >= start && j >= mid + 1; ) {
            if (array[i] > array[j]) {
                count += j - mid;
                temp[cur--] = array[i--];
            } else {
                temp[cur--] = array[j--];
            }
        }
        while (i >= start) {
            temp[cur--] = array[i--];
        }
        while (j >= mid + 1) {
            temp[cur--] = array[j--];
        }
        for (int k = 0; k < temp.length; k++) {
            array[start + k] = temp[k];
        }
        return count;
    }

}
