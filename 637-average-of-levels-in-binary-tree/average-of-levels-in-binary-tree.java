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
    public List<Double> averageOfLevels(TreeNode root) {
          Queue<TreeNode> queue= new LinkedList<>();
        List<Double> ans= new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int currentLevel=queue.size();
            int count=currentLevel;
            double sum=0;

            while(currentLevel > 0){
                TreeNode currentNode =queue.remove();
                sum += currentNode.val;

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                currentLevel -= 1;
            }
            ans.add(sum / count);
        }

        return ans;
    }
}