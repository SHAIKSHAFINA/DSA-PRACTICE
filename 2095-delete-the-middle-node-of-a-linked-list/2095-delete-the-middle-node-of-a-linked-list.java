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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr=head;
        
        if(curr==null || curr.next==null) return null;
        ArrayList<ListNode> s= mid(curr);
        ListNode p=s.get(0);
        ListNode c=s.get(1);

         p.next=c.next;

         return curr;

        
    }

    ArrayList<ListNode> mid(ListNode curr){

        ArrayList<ListNode> sc=new ArrayList<>();
        ListNode slow=curr;
        ListNode fast=curr;
        ListNode prev=curr;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        sc.add(prev);
        sc.add(slow);

        return sc;
    }
}