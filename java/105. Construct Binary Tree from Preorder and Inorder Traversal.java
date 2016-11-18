public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 && preorder.length == 0) {
            return null;
        }
        else if (inorder.length == 1 && preorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        else {
            int rootValue = preorder[0];
            TreeNode root = new TreeNode(rootValue);
            int rootIndex = 0;
            while (inorder[rootIndex] != rootValue) rootIndex++;
            int[] leftInorder = new int[rootIndex];
            System.arraycopy(inorder, 0, leftInorder, 0, rootIndex);
            int[] leftPreorder = new int[rootIndex];
            System.arraycopy(preorder, 1, leftPreorder, 0, rootIndex);
            int[] rightInorder = new int[preorder.length - 1 - rootIndex];
            System.arraycopy(inorder, rootIndex+1, rightInorder, 0, rightInorder.length);
            int[] rightPreorder = new int[preorder.length - 1 - rootIndex];
            System.arraycopy(preorder, rootIndex+1, rightPreorder, 0, rightPreorder.length);
            TreeNode leftRoot = buildTree(leftPreorder, leftInorder);
            TreeNode rightRoot = buildTree(rightPreorder, rightInorder);
            root.left = leftRoot;
            root.right = rightRoot;
            return root;
        }
    }
}