public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i;
        int temp;
        int min = 1;
        List<Integer> result = new ArrayList<Integer>();
        for (;;)
        {
            i = min;
            while (i <= nums.length && (nums[i - 1] == 0 || nums[i - 1] == -1)) i++;
            min = i + 1;
            if (i > nums.length){
                break;
            }
            else{
                temp = nums[i - 1];
                nums[i - 1] = 0;
                i = temp;
            }
            for (;;){
                if (nums[i - 1] == -1)
                {
                    result.add(i);
                    break;
                }
                else if (nums[i - 1] == 0)
                {
                    nums[i - 1] = -1;
                    break;
                }
                else
                {
                    temp = nums[i - 1];
                    nums[i - 1] = -1;
                    i = temp;
                }
            }
        }

        return result;
    }
}