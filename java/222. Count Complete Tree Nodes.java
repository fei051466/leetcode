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
    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return getHeight(root.left) + 1;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int height = getHeight(root);
        int rightHeight = getHeight(root.right);
        if (height == rightHeight + 1) {
            return (1 << height) + countNodes(root.right);
        }
        else {
            return (1 << height - 1) + countNodes(root.left);
        }
    }
}