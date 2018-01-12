package jianzhioffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Exercise1 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
//        int[][] array = {{}};
        System.out.print(find2(7, array));
    }

    public static boolean find1(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int[] arr = array[i];
            if (arr == null || arr.length == 0) {
                continue;
            }
            int v1 = arr[0];
            if (target < v1) {
                return false;
            } else if (target > v1) {
                int v2 = arr[arr.length - 1];
                if (target > v2) {
                    continue;
                } else if (target < v2) {
                    for (int j = 1; j < arr.length; j++) {
                        if (target == arr[j]) {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean find2(int target, int[][] array) {
        for (int i = array.length - 1, j = 0; i >= 0 && j < array[0].length; ) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]) {
                i--;
                j = 0;
            }else {
                return true;
            }
        }
        return false;
    }

}
