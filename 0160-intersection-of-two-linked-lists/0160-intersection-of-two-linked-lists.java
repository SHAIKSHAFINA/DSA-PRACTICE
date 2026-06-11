/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null){
            return null;
        }

        ListNode curr=headA;

        while(curr.next!=null){
            curr=curr.next;
        }

        curr.next=headB;

        ListNode slow=headA,fast=headA;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){

                slow=headA;

                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                curr.next=null;
                return slow;
            }
        }

        curr.next=null;
        return null;
    }
}