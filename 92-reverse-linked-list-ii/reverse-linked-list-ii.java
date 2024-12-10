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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(1);
        dummy.next=head;
        ListNode current=dummy;
        ListNode prev=null;

        for(int i=0;i<left;i++){
            prev=current;
            current=current.next;
        }
        prev.next=reverse(current,right-left + 1);
        return dummy.next;
    }
    private ListNode reverse(ListNode l,int n){
        ListNode current=l;
        ListNode prev=null;
        for(int i=0;i<n;i++){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        l.next=current;
        return prev;
    }
}