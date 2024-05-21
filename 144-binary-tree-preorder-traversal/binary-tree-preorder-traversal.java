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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root,ans);
        return ans;
    }
    private void preOrder(TreeNode root,List<Integer>ans){
        if(root== null)return;

        ans.add(root.val); // first add the root node in ans 

        preOrder(root.left,ans); // after add the root node in ans we want to traversal from left;
        preOrder(root.right,ans);

        return;
    }
}