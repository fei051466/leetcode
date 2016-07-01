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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return hasPathSumS(root, sum, 0);
    }
    private boolean hasPathSumS(TreeNode root, int sum, int current){
        current += root.val;
        if (root.left==null && root.right==null && current == sum)
            return true;
        else if (root.left==null && root.right==null && current != sum)
            return false;
        if (root.left!=null && root.right!=null)
            return hasPathSumS(root.left, sum, current) || hasPathSumS(root.right, sum, current);
        else if (root.left!=null && root.right==null)
            return hasPathSumS(root.left, sum, current);
        else
            return hasPathSumS(root.right, sum, current);
    }
}