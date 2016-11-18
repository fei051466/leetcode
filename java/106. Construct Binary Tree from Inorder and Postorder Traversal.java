public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0) {
            return null;
        }
        else if (inorder.length == 1 && postorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        else {
            int rootValue = postorder[postorder.length - 1];
            TreeNode root = new TreeNode(rootValue);
            int rootIndex = 0;
            while (inorder[rootIndex] != rootValue) rootIndex++;
            int[] leftInorder = new int[rootIndex];
            System.arraycopy(inorder, 0, leftInorder, 0, rootIndex);
            int[] leftPostorder = new int[rootIndex];
            System.arraycopy(postorder, 0, leftPostorder, 0, rootIndex);
            int[] rightInorder = new int[postorder.length - 1 - rootIndex];
            System.arraycopy(inorder, rootIndex+1, rightInorder, 0, rightInorder.length);
            int[] rightPostorder = new int[postorder.length - 1 - rootIndex];
            System.arraycopy(postorder, rootIndex, rightPostorder, 0, rightPostorder.length);
            TreeNode leftRoot = buildTree(leftInorder, leftPostorder);
            TreeNode rightRoot = buildTree(rightInorder, rightPostorder);
            root.left = leftRoot;
            root.right = rightRoot;
            return root;
        }
    }
}