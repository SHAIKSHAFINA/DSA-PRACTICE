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
    public int pairSum(ListNode head) {
        ListNode curr=head;
        ListNode middle=mid(curr);
        ListNode reverse=rev(middle);
        int sum=0,max=0;

        while(reverse!=null){
            sum=curr.val+reverse.val;
            max=Math.max(max,sum);
            curr=curr.next;
            reverse=reverse.next;
        }

        return max;
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
        ListNode curr=head,front=null,prev=null;

        while(curr!=null){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }

        return prev;
    }
}