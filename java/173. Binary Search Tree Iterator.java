/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BSTIterator {

    public Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            nodeStack.add(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = nodeStack.pop();
        TreeNode right = cur.right;
        while(right != null){
            nodeStack.add(right);
            right = right.left;
        }
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */