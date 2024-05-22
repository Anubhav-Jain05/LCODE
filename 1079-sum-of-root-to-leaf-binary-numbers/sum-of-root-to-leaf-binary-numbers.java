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
        if(root == null)return 0;
        return binarySum(root,"");
    }
    private int binarySum(TreeNode root, String currentNode){
        if(root.left == null & root.right == null){
            return Integer.parseInt(currentNode + String.valueOf(root.val),2);
        }
        int left=0;
        int right=0;
        if(root.left != null){
            left = binarySum(root.left,currentNode + String.valueOf(root.val));
        }
        if(root.right != null){
            right= binarySum(root.right,currentNode + String.valueOf(root.val));
        }
        return left + right;
    }
}