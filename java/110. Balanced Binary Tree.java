/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int value = depth(root.left) - depth(root.right);
        if (value < -1 || value > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}