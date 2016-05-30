public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        else if (root.left == null && root.right == null)
        {
            return 1;
        }
        else
        {
            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;
            return leftDepth>rightDepth?leftDepth:rightDepth;
        }
    }
}