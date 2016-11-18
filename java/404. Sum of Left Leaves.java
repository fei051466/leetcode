public class Solution {
    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        getRes(root, root);
        return res;
    }

    private void getRes(TreeNode cur, TreeNode parrent) {
        if (cur.left == null && cur.right == null && parrent.left == cur) {
            res += cur.val;
        }
        else {
            if (cur.left != null)  getRes(cur.left, cur);
            if (cur.right != null) getRes(cur.right, cur);
        }
    }

}