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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseLinkedListKgroup(head,k);
    }
    private ListNode reverseLinkedListKgroup(ListNode head,int k){
        if(head == null)return null;
        Boolean check=validate(head,k);
        if(check){
            ListNode current=head;
            int currentLength=1;
            while(current.next!= null && currentLength < k){
                currentLength+=1;
                current=current.next;
            }
            ListNode tempNode =current.next;
            current.next=null;
            ListNode reverseList=reverseLL(head);
            head.next=reverseLinkedListKgroup(tempNode,k);
            return reverseList;
        }else{
            return head;
        }
    }
    private boolean validate(ListNode head,int k){
        ListNode current=head;
        int currentLength=1;
        while(current.next != null && currentLength < k){
            currentLength+=1;
            current=current.next;
        }
        return currentLength == k;
    }
    private ListNode reverseLL(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        while(current != null){
            ListNode tempNode=current.next;
            current.next=prev;
            prev=current;
            current=tempNode;
        }
        return prev;
    }
}