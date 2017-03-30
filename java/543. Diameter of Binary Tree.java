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
    int maxLength = 0; 
    
    private int postOrder(TreeNode node) {
        int leftLength = 0;
        int rightLength = 0;
        if (node == null)
            return 0;
        leftLength = postOrder(node.left);
        rightLength = postOrder(node.right);
        if (leftLength + rightLength + 1 > maxLength) 
            maxLength = leftLength + rightLength + 1;
        return Math.max(leftLength, rightLength) + 1;
    }
        
    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return maxLength == 0 ? 0 : maxLength - 1;
    }
}