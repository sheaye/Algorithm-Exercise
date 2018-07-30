package leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S =[1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
 */
public class Exercise71 {

    public static void main(String[] args) {
        Exercise71 exe = new Exercise71();
        System.out.println(exe.subsets(new int[]{3, 2, 4, 1}));
//        [[],[1],[2],[3],[4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4],[1,2,3],[1,2,4],[1,3,4],[2,3,4],[1,2,3,4]]
    }

    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (S == null || S.length < 1) {
            return result;
        }
        ArrayList<Integer> item;
        for (int i = 0; i < S.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                item = new ArrayList<>(result.get(j));
                item.add(S[i]);
                result.add(item);
            }
        }
        return result;
    }

    /*public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (S == null || S.length < 1) {
            return result;
        }
        Arrays.sort(S);
        ArrayList<Integer> item;
        int resultIndex = 0;
        int sIndex = 0;
        int count;
        for (int i = 0; i < S.length; i++) {
            int size = result.size();
            System.out.println(resultIndex + "-->" + (size - 1));
            count = 0;
            for (int j = resultIndex; j < size; j++) {
                for (int k = 0; k < S.length; k++) {
                    ArrayList<Integer> old = result.get(j);
                    if (old.size() > 0 && old.get(old.size() - 1) > S[k] - 1) {
                        continue;
                    }
                    item = new ArrayList<>(old);
                    item.add(S[k]);
                    result.add(item);
                    count++;
                }
            }
            sIndex++;
            resultIndex += result.size() - count;
            System.out.println("count = " + count);
        }
        return result;
    }*/

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> part = new ArrayList<>();
        part.add(new ArrayList<>());
        if (S == null || S.length < 1) {
            return part;
        }
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(part);
        ArrayList<ArrayList<Integer>> newPart;
        ArrayList<Integer> item;

        for (int i = 0; i < S.length; i++) {
            newPart = new ArrayList<>();
            for (ArrayList<Integer> arr : part) {
                for (int j = 0; j < S.length; j++) {
                    if (arr.size() > 0 && arr.get(arr.size() - 1) > S[j] - 1) {
                        continue;
                    }
                    item = new ArrayList<>(arr);
                    item.add(S[j]);
                    newPart.add(item);
                }
            }
            part = newPart;
            result.addAll(part);
        }
        return result;

    }

}
