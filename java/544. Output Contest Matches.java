public class Solution {
    private String construct(int[] resultArray, int start, int end) {
        if (end - start == 1) {
            return "(" + resultArray[start] + "," + resultArray[end] + ")";
        }
        else {
            return "(" + construct(resultArray, start, (end - start) / 2 + start) + "," + construct(resultArray, (end - start) / 2 + start + 1, end) + ")";
        }
    }

    public String findContestMatch(int n) {
        int[] index = new int[n];
        index[0] = 0;
        index[1] = 1;
        int count = 2;
        while (count < n) {
            for (int i = 0; i < count * 2; i++) {
                if (i < count) {
                    index[i] *= 2;
                }
                else {
                    index[i] = index[count * 2 - 1 - i] + 1;
                }
            }
            count *= 2;
        }
        int[] resultArray = new int[n];
        for (int i = 0; i < index.length; i++) {
            resultArray[index[i]] = i + 1;
        }
        return construct(resultArray, 0, n - 1);
    }
}