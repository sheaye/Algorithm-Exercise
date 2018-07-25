package leetcode.search;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class Exercise68 {

    public static void main(String[] args) {
        Exercise68 exe = new Exercise68();
        System.out.println(exe.search(new int[]{1, 3}, 3));
    }

    public boolean search(int[] A, int target) {
        if (A == null || A.length < 1) {
            return false;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[left] < A[right]) {
                if (target < A[left] || target > A[right]) {
                    return false;
                }
                if (target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[left] < A[mid]) {// left-mid有序
                if (target >= A[left] && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[mid] < A[right]) {// mid-right有序
                if (target > A[mid] && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


}
