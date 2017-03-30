public class Solution {
    private int sum = 0;

    private void handle(TreeNode node) {
        int nextSum = sum + node.val;
        node.val += sum;
        sum = nextSum;
    }

    private void reverseInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            reverseInorder(node.right);
        }
        handle(node);
        if (node.left != null) {
            reverseInorder(node.left);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
}