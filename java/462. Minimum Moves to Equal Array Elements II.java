public class Solution {
    public int minMoves2(int[] nums) {
        /*
        example:
        input: [1, 2, 3]
        return: 2
         */
        int moveCount = 0;
        List<Integer> numsList = new ArrayList<Integer>();
        for (int num: nums){
            numsList.add(num);
        }
        Collections.sort(numsList);
        int target;
        if (nums.length % 2 == 0)
            target = numsList.get(nums.length / 2 - 1);
        else
            target = numsList.get(nums.length / 2);
        for (int num: nums){
            if (target > num)
                moveCount += target - num;
            else
                moveCount += num - target;
        }

        return moveCount;
    }
}