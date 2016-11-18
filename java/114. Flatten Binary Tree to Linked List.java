public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode head = new TreeNode(0);
        TreeNode last = head;
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            TreeNode cur = nodeStack.pop();
            last.right = cur;
            last = cur;
            if (cur.right != null) {
                nodeStack.push(cur.right);
            }
            if (cur.left != null) {
                nodeStack.push(cur.left);
            }
            cur.left = null;
        }
    }
}