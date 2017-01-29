public class Solution {
    public int[] constructRectangle(int area) {
        int[] result = {1, 1};
        if (area == 1) return result;
        int i = 1;
        int j = area;
        int min = Integer.MAX_VALUE;
        while (i <= area / 2) {
            if (area % i == 0) {
                j = area / i;
                if (i + j < min) {
                    min = i + j;
                    result[0] = j;
                    result[1] = i;
                }
            }
            i++;
        }

        return result;
    }