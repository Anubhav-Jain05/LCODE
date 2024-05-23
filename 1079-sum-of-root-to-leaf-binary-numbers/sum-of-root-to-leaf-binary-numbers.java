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
    public int sumRootToLeaf(TreeNode root) {
        int[] ans={0};
        rootLeaf(root,"" + Integer.toString(root.val),ans);
        return ans[0];
    }
    private void rootLeaf(TreeNode root,String currentNode,int[]ans){
        if(root.left == null && root.right == null){
            ans[0] += Integer.parseInt(currentNode,2);
            return;
        }
        if(root.left != null){
            rootLeaf(root.left,currentNode + Integer.toString(root.left.val),ans);
        }
        if(root.right != null){
            rootLeaf(root.right,currentNode + Integer.toString(root.right.val),ans);
        }
        return;

    }
}