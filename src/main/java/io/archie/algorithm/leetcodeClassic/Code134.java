package io.archie.algorithm.leetcodeClassic;

public class Code134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
        int g = gas.length;

        int start = 0;
        while (start < g) {
            int step = 0;
            int leaveGas = 0;
            while (step < g) {
                int next = (start + step) % g;
                leaveGas = leaveGas + gas[next] - cost[next];
                if (leaveGas < 0) {
                    break;
                }
                step++;
            }
            if (step == g) return start;
            start += step + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5, 5, 70};
        int[] cost = {2, 3, 4, 3, 9, 6, 2};
        System.out.println(canCompleteCircuit(gas, cost));
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas1, cost1));
    }
}
