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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removenode(root,target);
    }
    private TreeNode removenode(TreeNode root,int target){
        if(root == null)return null;
        root.left=removenode(root.left,target);
        root.right=removenode(root.right,target);

        if(root.left == null && root.right == null && root.val==target)return null;

        return root;
    }

}