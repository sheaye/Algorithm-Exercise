package leetcode.exhaustion;

import common.Point;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class Exercise3 {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }

    public static class Solution {

        public int maxPoints(Point[] points) {
            if (points == null) {
                return 0;
            }
            if (points.length <= 2) {
                return points.length;
            }
            int max = 2;
            for (int i = 0; i < points.length; i++) {
                int repeatCount = 0;
                int temp = 1;
                for (int j = i + 1; j < points.length; j++) {
                    int abX = points[i].x - points[j].x;
                    int abY = points[i].y - points[j].y;
                    if (abX == 0 && abY == 0) {
                        repeatCount++;
                    } else {
                        temp++;
                        for (int k = j + 1; k < points.length; k++) {
                            int bcX = points[j].x - points[k].x;
                            int bcY = points[j].y - points[k].y;
                            if (abX * bcY == bcX * abY) {
                                temp++;
                            }
                        }
                    }
                    if (max < (repeatCount + temp)) {
                        max = repeatCount + temp;
                    }
                    temp = 1;
                }
            }
            return max;
        }
    }

}
