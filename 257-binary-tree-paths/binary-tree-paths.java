/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> ans=new ArrayList<>();;
        rootLeaf(root,"" + Integer.toString(root.val),ans);
        return ans;
    }
     private void rootLeaf(TreeNode root,String currentNode,List<String>ans){
        if(root.left == null && root.right == null){
            ans.add(currentNode);
            return;
        }
        if(root.left != null){
            rootLeaf(root.left,currentNode + "->"+Integer.toString(root.left.val),ans);
        }
        if(root.right != null){
            rootLeaf(root.right,currentNode + "->"+Integer.toString(root.right.val),ans);
        }
        return;

    }
    
}