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
        Stack<Node> stack=new Stack<>();
        if(root == null){
            return ans;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            Node currentNode =stack.pop();
            ans.add(currentNode.val);

          List<Node>children=currentNode.children;

          for(int i=0;i<children.size();i++){
            Node currentChild=children.get(i);
            stack.push(currentChild);
          }
        }
        Collections.reverse(ans);
        return ans;
    }
}