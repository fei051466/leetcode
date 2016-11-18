public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int i = 0;
        int sum = 0;
        int start = 0;
        boolean isOnce = false;
        boolean isStart = true;
        while (true) {
            if (i == length - 1)
                isOnce = true;
            if (sum + gas[i] < cost[i]) {
                sum = 0;
                start = (i + 1 + length) % length;
                isStart = true;
                if (isOnce)
                    return -1;
            }
            else {
                isStart = false;
                sum = sum + gas[i] - cost[i];
            }
            i = (i + 1 + length) % length;
            if (i == start && !isStart)
                break;
        }
        return start;
    }
}