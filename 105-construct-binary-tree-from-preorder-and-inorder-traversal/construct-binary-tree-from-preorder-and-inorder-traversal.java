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
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int[] preIndex={0};
//         return constructBT(preorder,inorder,preIndex,0,inorder.length-1);
//     }
//     private TreeNode constructBT(int[] preorder,int[] inorder,int[] preIndex,int instart,int inend){
//         if(preIndex[0] >= preorder.length || instart > inend){
//             return null;
//         }
//         int currentVal=preorder[preIndex[0]];
//         TreeNode currentNode=new TreeNode(currentVal);
//         preIndex[0] += 1;

//         int i=-1;
//         for(i=instart;i<inend;i++){
//             if(inorder[i]==currentVal){
//                 break;
//             }
//         }
//         currentNode.left=constructBT(preorder,inorder,preIndex,instart,i-1);
//         currentNode.right=constructBT(preorder,inorder,preIndex,i+1,inend);
//         return currentNode;
//     }
// }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex={0};
        HashMap<Integer,Integer>inorderMap=buildMap(inorder);
        return constructBT(preorder,inorder,preIndex,0,inorder.length-1,inorderMap);
    }
    private TreeNode constructBT(int[] preorder,int[] inorder,int[] preIndex,int instart,int inend,
     HashMap<Integer,Integer>inorderMap){
        if(preIndex[0] >= preorder.length || instart > inend){
            return null;
        }
        int currentVal=preorder[preIndex[0]];
        TreeNode currentNode=new TreeNode(currentVal);
        preIndex[0] += 1;

       int i=inorderMap.get(currentVal);
        currentNode.left=constructBT(preorder,inorder,preIndex,instart,i-1,inorderMap);
        currentNode.right=constructBT(preorder,inorder,preIndex,i+1,inend,inorderMap);
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