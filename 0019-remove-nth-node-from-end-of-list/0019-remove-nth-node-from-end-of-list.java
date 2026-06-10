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
        ListNode curr=head;
        int c=0;

        if(curr.next==null && n==1){
            return null;
        }
        while(curr!=null){
            c++;
            curr=curr.next;
        }

        curr=head;
        ListNode prev=null;
        int co=1;

        if(co==(c-n+1)){
            return head.next;
        }

        while(curr!=null){
            co++;
            if(co==(c-n+1)){
                prev=curr;
               prev.next=prev.next.next;
                break;
            }
            curr=curr.next;
        }

        return head;
    }
}