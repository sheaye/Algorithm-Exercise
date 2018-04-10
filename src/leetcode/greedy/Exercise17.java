package leetcode.greedy;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
public class Exercise17 {

    public static void main(String[] args) {
        Exercise17 exe = new Exercise17();
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        return canCompleteCircuit(gas, cost, sum, 0);
    }

    private int canCompleteCircuit(int[] gas, int[] cost, int sum, int start) {
        int sub = 0;
        for (int i = start; i < gas.length; i++) {
            sub += gas[i] - cost[i];
            if (sub < 0) {
                return canCompleteCircuit(gas, cost, sum + sub, i + 1);
            }
        }
        if (sum + sub >= 0) {
            return start;
        }
        return -1;
    }

}
