package leetcode.simulation;

import java.util.ArrayList;

/**
 * Given an index k, return the k th row of the Pascal's triangle.
 * For example, given k = 3,
 * Return[1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Exercise32 {

    public static void main(String[] args) {
        Exercise32 exe = new Exercise32();
        System.out.println(exe.getRow(3));
    }

    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 1) {
            ArrayList<Integer> result = new ArrayList<>();
            if (rowIndex == 0) {
                result.add(1);
            }
            return result;
        }
        ArrayList<Integer> result = getRow(rowIndex - 1);
        for (int i = result.size() - 1; i > 0; i--) {
            result.set(i, result.get(i) + result.get(i - 1));
        }
        result.add(1);
        return result;
    }

    public ArrayList<Integer> getRow1(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }

    public ArrayList<Integer> getRow2(int rowIndex) {
        ArrayList<Integer> preResult = new ArrayList<>();
        preResult.add(1);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = 1; j < i; j++) {
                result.set(j, preResult.get(j - 1) + preResult.get(j));
            }
            result.add(1);
            preResult = (ArrayList<Integer>) result.clone();
        }
        return result;
    }

}
