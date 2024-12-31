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
    public boolean isUnivalTree(TreeNode root) {
        return isTrue(root,root.val);
    }
    private boolean isTrue(TreeNode root,int val){
        if(root == null)return true;
        if(root.val != val)return false;
        Boolean left=isTrue(root.left,val);
        Boolean right= isTrue(root.right,val);
        return left && right;
    }
}