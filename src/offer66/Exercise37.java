package offer66;

import common.ProgramTimer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Exercise37 {

    public static void main(String[] args) {
        Exercise37 exe = new Exercise37();
        int[] array = {1, 2, 2, 2, 3, 3, 4, 4, 5};
        System.out.println(exe.GetNumberOfK1(array, 2));
        System.out.println(exe.GetNumberOfK(array, 2));
        System.out.println(exe.GetNumberOfK2(array, 2));

        int times = Integer.MAX_VALUE/5;
        // 采用计数累加：
        ProgramTimer.timing("GetNumberOfK1", times, () -> {
            exe.GetNumberOfK1(array, 2);
        });

        // 采用lastIndex-firstIndex+1，firstIndexOfK()方法和lastIndexOfK()方法都用while循环：
        ProgramTimer.timing("GetNumberOfK while:", times, () -> {
            exe.GetNumberOfK(array, 2);
        });

        // 采用lastIndex-firstIndex+1，firstIndexOfK()方法和lastIndexOfK()方法都用递归：
        ProgramTimer.timing("GetNumberOfK2 递归：", times, () -> {
            exe.GetNumberOfK2(array, 2);
        });

    }

    /*****************************************计数累加*********************************************************/

    public int GetNumberOfK1(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return numberOfK(array, k, 0, array.length - 1);
    }

    private int numberOfK(int[] array, int k, int start, int end) {
        if (array[start] > k || array[end] < k) {
            return 0;
        }
        if (start >= end && array[start] == k) {
            return 1;
        }
        int mid = (start + end) / 2;
        if (array[mid] > k) {
            return numberOfK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return numberOfK(array, k, mid + 1, end);
        } else {
            return numberOfK(array, k, start, mid) + numberOfK(array, k, mid + 1, end);
        }
    }

    /************************************************while循环*********************************************************/
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstIndex = firstIndexOfK(array, k, 0, array.length - 1);
        if (firstIndex < 0) {
            return 0;
        }
        return lastIndexOfK(array, k, 0, array.length - 1) - firstIndex + 1;
    }

    private int firstIndexOfK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid > 0 && array[mid - 1] == k) {
                start = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int lastIndexOfK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid < array.length - 1 && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /************************************************递归*********************************************************/
    public int GetNumberOfK2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstIndex = firstIndexOfK2(array, k, 0, array.length - 1);
        if (firstIndex < 0) {
            return 0;
        }
        return lastIndexOfK2(array, k, 0, array.length - 1) - firstIndex + 1;
    }

    private int firstIndexOfK2(int[] array, int k, int start, int end) {
        if (array[start] > k || array[end] < k) {
            return -1;
        }
        if (start >= end && array[start] == k) {
            return start;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return firstIndexOfK2(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return firstIndexOfK2(array, k, mid + 1, end);
        } else if (mid > 0 && array[mid - 1] == k) {
            return firstIndexOfK2(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    private int lastIndexOfK2(int[] array, int k, int start, int end) {
        if (array[start] > k || array[end] < k) {
            return -1;
        }
        if (start >= end && array[start] == k) {
            return start;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return lastIndexOfK2(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return lastIndexOfK2(array, k, mid + 1, end);
        } else if (mid < array.length-1 && array[mid + 1] == k) {
            return lastIndexOfK2(array, k, mid+1, end);
        } else {
            return mid;
        }
    }



}
