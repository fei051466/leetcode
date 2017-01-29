public class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

        while (!nodeStack.empty()) {
            TreeNode curNode = nodeStack.pop();
            int val = curNode.val;
            if (count.containsKey(val)) {
                count.put(val, count.get(val) + 1);
            }
            else {
                count.put(val, 1);
            }
            if (curNode.left != null) {
                nodeStack.add(curNode.left);
            }
            if (curNode.right != null) {
                nodeStack.add(curNode.right);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int counting: count.values()) {
            if (counting > max) {
                max = counting;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int key: count.keySet()) {
            if (count.get(key) == max) {
                result.add(key);
            }
        }
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int val: result) {
            resultArray[index++] = val;
        }
        return resultArray;
    }
}