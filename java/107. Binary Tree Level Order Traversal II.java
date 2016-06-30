/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> temp_result = new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrderBottomRec(temp_result, root, 0);
        for (int i=temp_result.size()-1; i>=0; i--)
            result.add(temp_result.get(i));
        return result;
    }
    private void levelOrderBottomRec(List<List<Integer>> r, TreeNode root, Integer level){
        if (root == null)
            return;
        List<Integer> current = new ArrayList<Integer>();
        if (r.size()-1 >= level) {
            current = r.get(level);
            current.add(root.val);
        }
        else
        {
            current.add(root.val);
            r.add(current);
        }
        levelOrderBottomRec(r, root.left, level+1);
        levelOrderBottomRec(r, root.right, level+1);



    }
}