/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        while(head == null || head.next==null)return null;
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;

        for(int i=0;i<n;i++)
            slow=slow.next;
            ListNode node=dummy;
        while(slow.next!=null){
            slow=slow.next;
            node=node.next;
        }
        node.next=node.next.next;
        
        
        return dummy.next;
        

    }
}