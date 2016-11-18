public class Solution {
    public int hIndex(int[] citations) {
        int[] counter = new int[citations.length + 1];
        for (int citation : citations) {
            citation = citation > citations.length?citations.length:citation;
            counter[citation]++;
        }
        int sum = 0;
        for (int i=counter.length-1; i>=0; i--){
            sum += counter[i];
            if (sum >= i)
                return i;
        }
        return 0;
    }
}