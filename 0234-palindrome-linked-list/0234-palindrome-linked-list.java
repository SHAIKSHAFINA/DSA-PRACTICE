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
        ListNode curr=head;
        ListNode midd=mid(head);
        ListNode rev=rev(midd);
        while(rev!=null){
            if(curr.val!=rev.val){
                return false;
            }
            curr=curr.next;
            rev=rev.next;
        }
        return true;
    }

    ListNode mid(ListNode head){
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    ListNode rev(ListNode head){
        ListNode curr=head,prev=null,front=null;

        while(curr!=null){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }

        return prev;
    }
}