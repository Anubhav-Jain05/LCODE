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
    public String smallestFromLeaf(TreeNode root) {
        return smallestStr(root,"");
    }
    private String smallestStr(TreeNode node,String res){
        if(node == null)return res;
        res=(char)('a' + node.val) + res;
        if(node.left == null && node.right == null)return res;
        if(node.left == null)return smallestStr(node.right,res);
        if(node.right == null)return smallestStr(node.left,res);
        String leftStr=smallestStr(node.left,res);
        String rightStr=smallestStr(node.right,res);
        return leftStr.compareTo(rightStr) <= 0 ? leftStr : rightStr;
    }
}