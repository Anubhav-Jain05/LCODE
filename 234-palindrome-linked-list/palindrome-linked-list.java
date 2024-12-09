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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode midNode=middleNode(head);
        ListNode righthalf=midNode.next;
        midNode.next=null;
        ListNode lefthalf=head;
        return compare(lefthalf,reverseLL(righthalf));
    }
    private boolean compare(ListNode leftHalf,ListNode rightHalf){
        ListNode l1=leftHalf;
        ListNode l2=rightHalf;
        while(l1 != null && l2 != null){
            if(l1.val != l2.val)return false;
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
    private ListNode middleNode(ListNode head) {
        if(head==null)return null; 
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next != null && fast.next.next != null){
            
            slow=slow.next;
            fast=fast.next.next;
        }
        // if(fast.next != null){
        //     return slow.next;
        // }
        return slow;
    }
    private ListNode reverseLL(ListNode head){
        ListNode prev=null;
        ListNode temp=null;
        ListNode curr=head;
        while(curr != null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}