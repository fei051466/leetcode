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
    private int curVal = 0;
    private int curCount = 0;
    private int maxCount = 0;

    private int[] modes;
    private int modeCount = 0;


    private void handleNode(int val) {
        if (curVal != val) {
            curVal = val;
            curCount = 0;
        }
        curCount++;
        if (curCount > maxCount) {
            maxCount = curCount;
            modeCount = 1;
        }
        else if (curCount == maxCount) {
            if (modes != null) {
                modes[modeCount] = curVal;
            }
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        // morris traversal
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.left == null) {
                handleNode(curNode.val);
                curNode = curNode.right;
            }
            else {
                TreeNode pre = curNode.left;
                while (pre.right != null && pre.right != curNode)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = curNode;
                    curNode = curNode.left;
                }
                else {
                    pre.right = null;
                    handleNode(curNode.val);
                    curNode = curNode.right;
                }
            }
        }
    }
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        curCount = 0;
        inorder(root);
        
        return modes;
    }
}