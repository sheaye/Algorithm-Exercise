package leetcode.simulation;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Exercise33 {

    public static void main(String[] args) {
        Exercise33 exe = new Exercise33();
        System.out.println(exe.generate(5).toString());
    }


    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(1);
        result.add(list0);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> pre = result.get(i - 1);
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(j, pre.get(j) + pre.get(j - 1));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }

}
