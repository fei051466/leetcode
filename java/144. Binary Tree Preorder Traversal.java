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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> node_stack = new Stack<TreeNode>();
        node_stack.push(root);
        while(!node_stack.empty()){
            TreeNode current_node = node_stack.pop();
            res.add(current_node.val);
            if(current_node.right != null)
                node_stack.push(current_node.right);
            if(current_node.left != null)
                node_stack.push(current_node.left);
        }
        return res;
    }
}