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
    private void rec(List<List<Integer>> result, List<Integer> cur, TreeNode root, int sum, int curSum) {
        System.out.println(curSum);
        if (root.left == null && root.right == null && root.val + curSum == sum) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            tmp.add(root.val);
            result.add(tmp);
            return;
        }
        cur.add(root.val);
        if (root.left != null) {
            rec(result, cur, root.left, sum, curSum + root.val);
        }
        if (root.right != null) {
            rec(result, cur, root.right, sum, curSum + root.val);
        }
        cur.remove(cur.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        List<Integer> cur = new ArrayList<Integer>();
        rec(result, cur, root, sum, 0);
        return result;
    }
}