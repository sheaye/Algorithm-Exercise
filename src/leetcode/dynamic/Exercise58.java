package leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise58 {

    /**
     * Given a collection of integers that might contain duplicates, S, return all possible subsets.
     * Note:
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * For example,
     * If S =[1,2,2], a solution is:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        ArrayList<Integer> item;
        for (int i = 0; i < num.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> oldItem = result.get(j);
                item = new ArrayList<>(oldItem);
                item.add(num[i]);
                if (!result.contains(item)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Exercise58 exe = new Exercise58();
        int[] array = {4,1,10};
        ArrayList<ArrayList<Integer>> result = exe.subsetsWithDup(array);
        System.out.println(result.toString());
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = num.length - 1; i >= 0; i--) {
            ArrayList<ArrayList<Integer>> listItem = new ArrayList<>();
            for (ArrayList<Integer> list : result) {
                ArrayList<Integer> newItem = new ArrayList<>(list);
                newItem.add(0, num[i]);
                listItem.add(newItem);
            }
            for (ArrayList<Integer> item : listItem) {
                if (result.contains(item)) {
                    result.remove(item);
                }
            }
            result.addAll(1, listItem);
        }
        return result;
    }


}
