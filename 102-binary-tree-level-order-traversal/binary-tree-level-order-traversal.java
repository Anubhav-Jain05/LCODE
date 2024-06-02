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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();

        if(root == null)return ans;

        queue.add(root);

        while(!queue.isEmpty()){
            int currentSize=queue.size();
            List<Integer> currentlevel=new ArrayList<>();

            while(currentSize > 0){
                TreeNode currentNode = queue.remove();
                currentlevel.add(currentNode.val);

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }

                currentSize -= 1;
            }
            ans.add(currentlevel);
        }
        return ans;
    }
}