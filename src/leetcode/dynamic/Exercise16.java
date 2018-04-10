package leetcode.dynamic;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Exercise16 {

    public static void main(String[] args) {
        int[] ratins = {4, 2, 3, 4, 1};
        Exercise16 exe = new Exercise16();
        exe.candy2(ratins);
    }

    public int candy(int[] ratings) {
        int sum = 0;
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            sum += count[i];
            if (ratings[i - 1] > ratings[i] && count[i - 1] <= count[i]) {
                count[i - 1] = count[i] + 1;
            }
        }
        sum += count[0];
        return sum;
    }

    public int candy2(int[] ratings) {
        int sum = 0;
        int len = ratings.length;
        int[] nums = new int[len];
        nums[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else if (ratings[i] <= ratings[i - 1]) {
                int num = nums[i - 1] - 1;
                if (num == 0) {
                    nums[i] = 1;
                    while (i > 0 && nums[i - 1] == nums[i] && ratings[i - 1] > ratings[i]) {
                        nums[i - 1] = nums[i] + 1;
                        i--;
                    }
                } else {
                    nums[i] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
