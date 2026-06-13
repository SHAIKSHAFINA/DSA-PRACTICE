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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }

        int l=1;
        ListNode temp=head;

        while(temp.next!=null){
             l++;
             temp=temp.next;
        }

        k=k%l;

        if(k==0){
            return head;
        }
        temp.next=head;

        int rem=l-k-1;
        ListNode newTemp=head;

        for(int i=0;i<rem;i++){
            newTemp=newTemp.next;
        }

        ListNode newHead=newTemp.next;
        newTemp.next=null;

        return newHead;
    }
}