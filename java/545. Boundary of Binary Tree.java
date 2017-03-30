public class Solution {
    private List<TreeNode> getLeftBoundry(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
            result.add(cur);
            if (cur == root || cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return result;
    }
    
    private List<TreeNode> getRightBoundry(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
            result.add(cur);
            if (cur == root || cur.right != null)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return result;
    }
    
    private List<TreeNode> getLeaveNodes(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        TreeNode cur = null;
        while(!nodeStack.empty()) {
            cur = nodeStack.pop();
            if (cur.left == null && cur.right == null)
                result.add(cur);
            else {
                if (cur.right != null)
                    nodeStack.push(cur.right);
                if (cur.left != null)
                    nodeStack.push(cur.left);
            }
        }
        return result;
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
            
        List<TreeNode> leftBoundry = null;
        List<TreeNode> rightBoundry = null;
        List<TreeNode> leaveNodes = null;
        
        leftBoundry = getLeftBoundry(root);
        rightBoundry = getRightBoundry(root);
        leaveNodes = getLeaveNodes(root);
        
        for (int i = 0; i < leftBoundry.size(); i++)
            result.add(leftBoundry.get(i).val);
        if (leaveNodes.get(0) == leftBoundry.get(leftBoundry.size() - 1))
            result.remove(result.size() - 1);
        for (int i = 0; i < leaveNodes.size(); i++)
            result.add(leaveNodes.get(i).val);
        for (int i = rightBoundry.size() - 1; i >= 1; i--) {
            if (i == rightBoundry.size() - 1) {
                if (rightBoundry.get(i) != leaveNodes.get(leaveNodes.size() - 1))
                    result.add(rightBoundry.get(i).val);
            }
            else
                result.add(rightBoundry.get(i).val);
        }

        return result;
    }
}