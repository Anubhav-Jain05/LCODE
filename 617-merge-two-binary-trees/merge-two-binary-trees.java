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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       return mergeNode(root1,root2);
    }
    private TreeNode mergeNode(TreeNode root1,TreeNode root2){
        if(root1 == null)return root2;
        if(root2 == null)return root1;

        TreeNode newNode= new TreeNode(root1.val + root2.val);
        newNode.left=mergeNode(root1.left,root2.left);
        newNode.right= mergeNode(root1.right,root2.right);
        return newNode;
    }
}