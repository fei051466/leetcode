import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        int res = 0;
        Stack<TreeNode> my_stack = new Stack<TreeNode>();
        my_stack.push(root);
        while(my_stack.size() != 0){
            TreeNode current_node = my_stack.pop();
            if(current_node.left == null && current_node.right == null){
                count++;
                if(count == k){
                    res = current_node.val;
                    break;
                }
                continue;
            }
            if(current_node.right != null){
                my_stack.add(current_node.right);
            }
            TreeNode replace_node = new TreeNode(current_node.val);
            my_stack.add(replace_node);
            if(current_node.left != null){
                my_stack.add(current_node.left);
            }
        }
        return res;
    }

}