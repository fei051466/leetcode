public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        if(nums.length == 2){
            TreeNode root = new TreeNode(nums[1]);
            root.left = new TreeNode(nums[0]);
            return root;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        int[] left = new int[nums.length/2];
        int[] right = new int[nums.length - nums.length/2 - 1];
        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, nums.length/2+1, right, 0, right.length);
        TreeNode left_root = sortedArrayToBST(left);
        TreeNode right_root = sortedArrayToBST(right);
        root.left = left_root;
        root.right = right_root;
        return root;
    }
}