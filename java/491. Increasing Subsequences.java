public class Solution {
     private boolean judge(List<Integer> curList) {
        if (curList.size() < 2)
            return false;
        int pre= curList.get(0);
        for (int val: curList) {
            if (val < pre)
                return false;
            pre = val;
        }
        return true;
    }

    private void dfs(int[] nums, List<Integer> curList, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            if (!judge(curList))
                return;
            List<Integer> tmpList = new ArrayList<Integer>(curList);
            result.add(tmpList);
            return;
        }
        dfs(nums, curList, result, nums.length);
        Set<Integer> used = new HashSet<Integer>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i]))
                continue;
            curList.add(nums[i]);
            dfs(nums, curList, result, i + 1);
            curList.remove(curList.size() - 1);
            used.add(nums[i]);
        }

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        dfs(nums, curList, result, 0);
        return result;
    }
}