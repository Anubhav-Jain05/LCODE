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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>leaves1=new ArrayList<>();
        List<Integer>leaves2= new ArrayList<>();
        findleaves(root1,leaves1);
        findleaves(root2,leaves2);
        return leaves1.equals(leaves2);
    }
    private void findleaves(TreeNode root,List<Integer>leave){
        if(root== null)return;
        if(root.left== null && root.right==null){
            leave.add(root.val);
            return;
        }
        findleaves(root.left,leave);
        findleaves(root.right,leave);
        return;
    }
}