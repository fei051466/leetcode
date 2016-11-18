public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode ancestor = null;
        TreeNode last = null;
        while (!nodeStack.empty() || cur != null) {
            if (cur != null) {
                if (cur == p || cur == q) {
                    if (ancestor == null) {
                        ancestor = cur;
                    } else {
                        return ancestor;
                    }
                }
                nodeStack.add(cur);
                cur = cur.left;
            }
            else {
                TreeNode temp = nodeStack.pop();
                if (temp == last)
                    ancestor = last;
                if (temp == ancestor) {
                    if (nodeStack.empty()) {
                        return temp;
                    }
                    else
                        last = nodeStack.peek();
                }
                cur = temp.right;
            }
        }
        return ancestor;
    }
}