public class Solution {
    public void nextPermutation(int[] nums) {
        int descIndex = nums.length - 1;
        while (descIndex != 0 && nums[descIndex] <= nums[descIndex - 1])
            descIndex--;

        int reverseStartIndex;
        int reverseEndIndex = nums.length - 1;
        // max permutation, turn it to min permutation, so startIndex = 0, endIndex = nums.length - 1
        if (descIndex == 0) {
            reverseStartIndex = 0;
        }
        // first find two nums exchange
        // then reverse remain nums
        // example: input 1 2 5 7 6 4 3
        // first exchange 5 and 6, become 1 2 6 7 5 4 3
        // then  reverse 7 -> 3, become 1 2 6 3 4 5 7
        else {
            int exchange1 = nums[descIndex - 1];
            int exchange2Index = nums.length - 1;
            while (nums[exchange2Index] <= exchange1) {
                exchange2Index--;
            }
            nums[descIndex - 1] = nums[exchange2Index];
            nums[exchange2Index] = exchange1;
            reverseStartIndex = descIndex;
        }
        while (reverseStartIndex < reverseEndIndex) {
            int tmp = nums[reverseStartIndex];
            nums[reverseStartIndex] = nums[reverseEndIndex];
            nums[reverseEndIndex] = tmp;
            reverseStartIndex++;
            reverseEndIndex--;
        }
    }
}