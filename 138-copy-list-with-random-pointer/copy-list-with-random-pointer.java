/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// public class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null) return null;
        
//         HashMap<Node, Node> oldToNew = new HashMap<>();
        
//         Node curr = head;
//         while (curr != null) {
//             oldToNew.put(curr, new Node(curr.val));
//             curr = curr.next;
//         }
        
//         curr = head;
//         while (curr != null) {
//             oldToNew.get(curr).next = oldToNew.get(curr.next);
//             oldToNew.get(curr).random = oldToNew.get(curr.random);
//             curr = curr.next;
//         }
        
//         return oldToNew.get(head);
//     }
// }
public class Solution {
    public Node copyRandomList(Node head) {
       if(head==null)return null;
       HashMap<Node ,Node> hs= new HashMap<>();
       //loop 1 copy all the nodes
        Node curr=head;
        while(curr != null){
            hs.put(curr, new Node(curr.val));
            curr=curr.next;
        }
        //loop 2 assign next and random pointers
        curr=head;
        while(curr != null){
            hs.get(curr).next=hs.get(curr.next);
            hs.get(curr).random=hs.get(curr.random);
            curr=curr.next;
        }
        return hs.get(head);

    }
}