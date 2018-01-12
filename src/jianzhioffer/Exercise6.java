package jianzhioffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * Created by yexinyan on 2017/11/14.
 */
public class Exercise6 {

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        int targetIndex = 40000000;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (i < targetIndex) {
                arr[i] = len - targetIndex + i;
            } else {
                arr[i] = i - targetIndex;
            }
        }
        System.out.println();
        ProgramTimer.timing("minNumberInRotateArray1", new ProgramTimer.Runner() {
            @Override
            public void run() {
                minNumberInRotateArray1(arr);
            }
        });

        ProgramTimer.timing("minNumberInRotateArray2", new ProgramTimer.Runner() {
            @Override
            public void run() {
                minNumberInRotateArray2(arr);
            }
        });

    }

    public static int minNumberInRotateArray1(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (high > low) {
            int mid = (high + low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return array[high];
    }

    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] - array[i + 1] > 0) {
                return array[i + 1];
            }
        }
        return 0;
    }
}
