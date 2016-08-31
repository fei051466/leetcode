/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = robS(root);
        return Math.max(res[0], res[1]);

    }
    private int[] robS(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            return res;
        }
        int[] left = robS(root.left);
        int[] right = robS(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}