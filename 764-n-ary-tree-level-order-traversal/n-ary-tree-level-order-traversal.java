/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<Node> queue= new LinkedList<>();

        if(root == null)return ans;

        queue.add(root);

        while(!queue.isEmpty()){
            int currentSize=queue.size();
            List<Integer> currentlevel=new ArrayList<>();

            while(currentSize > 0){
                Node currentNode = queue.remove();
                currentlevel.add(currentNode.val);

                for(Node currentChild:currentNode.children){
                    queue.add(currentChild)
;                }
                currentSize -= 1;
            }
            ans.add(currentlevel);
        }
        return ans;
    }
}