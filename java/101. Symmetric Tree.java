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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isEqual(root.left, root.right);

    }
    private boolean isEqual(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

}