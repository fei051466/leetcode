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
    private List<TreeNode> divideRec(int min, int max) {
        if (min > max)
            return null;
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = divideRec(min, i - 1);
            List<TreeNode> rights = divideRec(i + 1, max);
            if (lefts != null && rights != null) {
                for (TreeNode left: divideRec(min, i - 1)) {
                    for (TreeNode right: divideRec(i + 1, max)) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
            else if (lefts != null) {
                for (TreeNode left: lefts) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    result.add(root);
                }
            }
            else if (rights != null) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    result.add(root);
                }
            }
            else {
                TreeNode root = new TreeNode(i);
                result.add(root);
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (n == 0) {
            return result;
        }
        result = divideRec(1, n);
        return result;
    }
}