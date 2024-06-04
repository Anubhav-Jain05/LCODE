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
 class Pair{
    TreeNode node;
    boolean left;

    Pair(TreeNode node,boolean left){
        this.node=node;
        this.left=left;
    }
 }
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> queue= new LinkedList<>();
        int total=0;
        queue.add(new Pair(root,false));
        while(!queue.isEmpty()){
            Pair currentPair=queue.remove();
            TreeNode currentNode=currentPair.node;
            boolean isleft=currentPair.left;

            if(currentNode.left == null && currentNode.right == null && isleft){
                total += currentNode.val;
            }
            if(currentNode.left != null){
                queue.add(new Pair(currentNode.left,true));
            }
            if(currentNode.right != null){
                queue.add(new Pair(currentNode.right,false));
            }
        }
        return total;

    }
}