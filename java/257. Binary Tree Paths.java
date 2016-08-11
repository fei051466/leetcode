public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null)
            return result;
        binaryTreePathsS(root, root, result, "");
        return result;

    }
    void binaryTreePathsS(TreeNode root, TreeNode current, List<String> result, String path){
       if(current == root){
           path += Integer.toString(root.val);
           if(current.left == null && current.right==null){
               result.add(path);
               return;
           }
           binaryTreePathsS(root, current.left, result, path);
           binaryTreePathsS(root, current.right, result, path);
       }
       else if(current != null){
           path = path + "->" + Integer.toString(current.val);
           if(current.left == null && current.right == null)
               result.add(path);
           else {
               binaryTreePathsS(root, current.left, result, path);
               binaryTreePathsS(root, current.right, result, path);
           }
       }
       }

}