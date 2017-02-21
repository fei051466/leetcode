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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode fake = new TreeNode(-1);
        fake.left = root;
        TreeNode pre = fake;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == key) {
                break;
            }
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            if (pre.left == cur) {
                pre.left = null;
            }
            else {
                pre.right = null;
            }
            return fake.left;
        }
        
        if (cur.right != null) {
            TreeNode rightNode = cur.right;
            TreeNode rightPre = cur;
            while (rightNode.left != null) {
                rightPre = rightNode;
                rightNode = rightNode.left;
            }
            if (rightPre != cur) {
                rightPre.left = rightNode.right;
                rightNode.left = cur.left;
                rightNode.right = cur.right;
            }
            else {
                rightNode.left = cur.left;
            }
            if (pre.left == cur) {
                pre.left = rightNode;
            }
            else {
                pre.right = rightNode;
            }
        }
        else{
            TreeNode leftNode = cur.left;
            TreeNode leftPre = cur;
            while (leftNode.right != null) {
                leftPre = leftNode;
                leftNode = leftNode.right;
            }
            if (leftPre != cur) {
                leftPre.right = leftNode.left;
                leftNode.left = cur.left;
                leftNode.right = cur.right;
            }
            else {
                leftNode.right = cur.right;
            }
            if (pre.left == cur) {
                pre.left = leftNode;
            }
            else {
                pre.right = leftNode;
            }
        }
        return fake.left;
    }
}