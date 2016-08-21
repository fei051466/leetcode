public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int head=0, tail=numbers.length-1; head<tail;){
            int sum = numbers[head] + numbers[tail];
            if(sum == target){
                res[0] = head + 1;
                res[1] = tail + 1;
                break;
            }
            else if(sum < target){
                head++;
            }
            else{
                tail--;
            }
        }
        return res;
    }
}