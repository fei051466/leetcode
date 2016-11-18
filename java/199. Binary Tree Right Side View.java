import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> store = new ArrayList<List<Integer>>();
        rec(store, root, 0);
        List<Integer> res = new ArrayList<Integer>();
        for(List<Integer> cur: store){
            res.add(cur.get(cur.size()-1));
        }
        return res;
    }
    private void rec(List<List<Integer>> store, TreeNode root, int level){
        if(root == null){
            return;
        }
        List<Integer> current;
        if(store.size() <= level){
            current = new ArrayList<Integer>();
            store.add(current);
        }
        current = store.get(level);
        current.add(root.val);
        rec(store, root.left, level+1);
        rec(store, root.right, level+1);
    }

}