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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        levelOrderInsert(result, root, 0);
        return result;
    }
    private void levelOrderInsert(List<List<Integer>> result, TreeNode root, int level){
        if (root == null)
            return;
        if (level == result.size()){
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            result.add(current);
        }
        else{
            List<Integer> current = result.get(level);
            current.add(root.val);
        }
        levelOrderInsert(result, root.left, level+1);
        levelOrderInsert(result, root.right, level+1);
    }
}