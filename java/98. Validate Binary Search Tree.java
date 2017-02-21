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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode cur = root;
        while (cur != null) {
            nodeStack.add(cur);
            cur = cur.left;
        }
        List<Integer> valList = new ArrayList<Integer>();
        while (nodeStack.size() != 0) {
            cur = nodeStack.pop();
            valList.add(cur.val);
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    nodeStack.add(cur);
                    cur = cur.left;
                }
            }
        }
        int pre = valList.get(0);
        for (int i = 1; i < valList.size(); i++) {
            if (valList.get(i) <= pre)
                return false;
            pre = valList.get(i);
        }
        return true;
    }
}