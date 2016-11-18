public class Solution {
    private int res;

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        addRes(root, 0);
        return res;
    }

    private void addRes(TreeNode root, int last){
        if(root.left == null && root.right == null){
            res += last * 10 + root.val;
            return;
        }
        if(root.left != null)
            addRes(root.left, last * 10 + root.val);
        if(root.right != null)
            addRes(root.right, last * 10 + root.val);
    }
}