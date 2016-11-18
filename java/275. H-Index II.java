public class Solution {
    public int hIndex(int[] citations) {
        int head = 0;
        int tail = citations.length-1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (mid == 0) {
                if (citations[mid] >= citations.length)
                    return citations.length;
                else
                    head = mid + 1;
            }
            else {
                if (citations[mid] >= citations.length - mid && citations[mid-1] <= citations.length - mid)
                    return citations.length - mid;
                else if (citations[mid] < citations.length - mid)
                    head = mid + 1;
                else
                    tail = mid - 1;
            }
        }
        return 0;
    }
}