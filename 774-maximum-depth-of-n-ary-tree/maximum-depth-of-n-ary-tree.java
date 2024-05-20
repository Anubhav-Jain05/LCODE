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
    public int maxDepth(Node root) {
        return height(root);
    }
    private int height(Node root){
        if(root == null)return 0;

        int ans=0;
        for(Node currentNode:root.children){
            ans= Math.max(ans,height(currentNode));
        }
        return 1+ans;
    }
}