public class Solution {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                result += duration;
            }
            else {
                result += timeSeries[i + 1] - timeSeries[i];
            }
        }
        result += duration;
        return result;
    }
}