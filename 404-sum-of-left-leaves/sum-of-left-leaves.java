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
    public int sumOfLeftLeaves(TreeNode root) {
     Queue<TreeNode> q=new LinkedList<>();
     if(root == null)return 0;
     q.add(root);
     int sum =0;
     while(!q.isEmpty()){
        int cnt=q.size();
        for(int i=0;i<cnt;i++){
            TreeNode node = q.poll();
            if(node.left!= null && node.left.left == null && node.left.right == null){
                sum += node.left.val;      
            }
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    
     }   
         return sum;
    }
}