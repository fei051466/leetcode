public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Stack<TreeLinkNode> nodeStack = new Stack<TreeLinkNode>();
        Stack<TreeLinkNode> tmpStack = new Stack<TreeLinkNode>();
        nodeStack.push(root);
        TreeLinkNode pre = null;
        while (!nodeStack.empty()) {
            TreeLinkNode cur = nodeStack.pop();
            cur.next = pre;
            pre = cur;
            if (cur.right != null) {
                tmpStack.push(cur.right);
            }
            if (cur.left != null) {
                tmpStack.push(cur.left);
            }
            if (nodeStack.empty()) {
                while (!tmpStack.empty()) {
                    nodeStack.push(tmpStack.pop());
                }
                pre = null;
            }
        }
    }
}