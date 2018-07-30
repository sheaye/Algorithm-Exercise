package leetcode.search;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Exercise72 {

    public static void main(String[] args) {
        Exercise72 exe = new Exercise72();
        System.out.println(exe.combine(5, 3));
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (k > n) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combine(n, 1, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int n, int n0, int k0, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
        if (k0 == 0) {
            result.add(item);
            return;
        }
        if (n0 > n - k0 + 1) {
            return;
        }
        for (int i = n0; i < n - k0 + 2; i++) {
            ArrayList<Integer> item0 = new ArrayList<>(item);
            item0.add(i);
            combine(n, i + 1, k0 - 1, item0, result);
        }
    }


}
