public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        boolean leftToRight = true;
        while (!nodeStack.empty()) {
            Stack<TreeNode> nextNodeStack = new Stack<TreeNode>();
            List<Integer> curNodeList = new ArrayList<Integer>();
            while (!nodeStack.empty()) {
                TreeNode curNode = nodeStack.pop();
                curNodeList.add(curNode.val);
                if (!leftToRight) {
                    if (curNode.right != null)
                        nextNodeStack.push(curNode.right);
                    if (curNode.left != null)
                        nextNodeStack.push(curNode.left);
                }
                else {
                    if (curNode.left != null)
                        nextNodeStack.push(curNode.left);
                    if (curNode.right != null)
                        nextNodeStack.push(curNode.right);
                }
            }
            res.add(curNodeList);
            nodeStack = nextNodeStack;
            leftToRight = !leftToRight;
        }
        return res;
    }
}