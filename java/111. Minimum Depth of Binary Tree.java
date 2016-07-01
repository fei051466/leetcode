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
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        minDepthS(root, 1);
        return res;
    }
    private void minDepthS(TreeNode root, int level){
        if (root == null){
            return;
        }
        else if (root.left==null && root.right==null){
            if (level < res)
                res = level;
        }
        else{
            minDepthS(root.left, level+1);
            minDepthS(root.right, level+1);
        }
    }
}