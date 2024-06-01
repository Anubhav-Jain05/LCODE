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
    public List<Integer> inorderTraversal(TreeNode root) {
      Stack<TreeNode> stack= new Stack<>();
      List<Integer>ans= new ArrayList<>();
      if(root == null){
        return ans;
      }
      addsubTreeNode(root,stack);

      while(!stack.isEmpty()){
        TreeNode currNode = stack.pop();
        ans.add(currNode.val);

        if(currNode.right != null){
            addsubTreeNode(currNode.right,stack);
        }
      }
       return ans;
    }
    private void addsubTreeNode(TreeNode currentNode,Stack<TreeNode> stack){
        stack.push(currentNode);

        while(currentNode.left != null){
            stack.push(currentNode.left);
            currentNode=currentNode.left;
        }
        // return;
    }
}