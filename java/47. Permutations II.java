public class Solution {
    private void addListToSet(int[] nums, int[] count, List<Integer> curList, List<List<Integer>> result) {
        if (curList.size() == nums.length) {
            List<Integer> storeList = new ArrayList<Integer>(curList);
            result.add(storeList);
            return;
        }
        int index;
        HashSet<Integer> used = new HashSet<Integer>();
        for (index = 0; index < nums.length; index++) {
            if (count[index] == 0)
                continue;
            if (used.contains(nums[index]))
                continue;
            curList.add(nums[index]);
            used.add(nums[index]);
            count[index] = 0;
            addListToSet(nums, count, curList, result);
            count[index] = 1;
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (length == 0) return result;

        int[] count = new int[length];
        int index;

        for (index = 0; index < length; index++) {
            count[index] = 1;
        }

        List<Integer> curList = new ArrayList<Integer>();
        addListToSet(nums, count, curList, result);

        return result;
    }
}