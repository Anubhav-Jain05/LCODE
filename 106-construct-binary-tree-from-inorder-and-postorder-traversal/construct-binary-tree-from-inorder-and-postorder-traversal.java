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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int[] postIndex={postorder.length-1};
        HashMap<Integer,Integer>inorderMap=buildMap(inorder);
        return constructBT(postorder,inorder,postIndex,0,inorder.length-1,inorderMap);
    }
    private TreeNode constructBT(int[] postorder,int[] inorder,int[] postIndex,int instart,int inend,
     HashMap<Integer,Integer>inorderMap){
        if(postIndex[0] < 0 || instart > inend){
            return null;
        }
        int currentVal=postorder[postIndex[0]];
        TreeNode currentNode=new TreeNode(currentVal);
        postIndex[0] -= 1;

       int i=inorderMap.get(currentVal);
         currentNode.right=constructBT(postorder,inorder,postIndex,i+1,inend,inorderMap);
        currentNode.left=constructBT(postorder,inorder,postIndex,instart,i-1,inorderMap);
      
        return currentNode;
    }
    private HashMap<Integer,Integer>buildMap(int[] inorder){
        HashMap<Integer,Integer> inorderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }
}