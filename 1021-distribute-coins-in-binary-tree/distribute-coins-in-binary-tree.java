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
    private int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;
        minmove(root);
        return moves;
    }
    private int minmove(TreeNode root){
        if(root== null)return 0;

        int left=minmove(root.left);
        int right=minmove(root.right);

        int totalways=left + right + root.val -1;

        moves += Math.abs(left) + Math.abs(right);

        return totalways;
    }
}