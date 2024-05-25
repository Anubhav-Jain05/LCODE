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
    public List<Integer> postorder(Node root) {
       List<Integer> ans = new ArrayList<>();
       npostOrder(root,ans);
       return ans;
    }
    private void npostOrder(Node root,List<Integer> ans){
        if(root == null)return;

        for(Node child : root.children){
            npostOrder(child,ans);
        }
        ans.add(root.val);
        return;
    }
}