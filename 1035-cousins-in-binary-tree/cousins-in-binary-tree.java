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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parent=new int[2];
        int[] level=new int[2];
        isParentLevel(root,new TreeNode(-1),0,x,y,parent,level);
        return parent[0] != parent[1] && level[0]==level[1];
    }
    public void isParentLevel(TreeNode root,TreeNode currentparent,int currentlevel,
    int x,int y,int  [] parent,int[] level){
        if(root==null)return;
        if(root.val == x){
            parent[0]=currentparent.val;
            level[0]=currentlevel;
        }
        if(root.val == y){
            parent[1]=currentparent.val;
            level[1]=currentlevel;
        }
        isParentLevel(root.left,root,currentlevel + 1,x,y,parent,level);
        isParentLevel(root.right,root,currentlevel + 1,x,y,parent,level);
        return;

    }
}