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
        ListNode curr=head , prev=null , x=head;
        int c=0;

        if(curr==null) return head;
        if(k==0) return head;


        while(curr!=null){
            prev=curr;
            curr=curr.next;
            c++;
        }
        if(k%c==0) return head;

        prev.next=x;
        k=k%c;
        int ptr=c-k;

    
        while(ptr>0){
            prev=prev.next;
            ptr--;
        }
        ListNode tail=prev.next;
        prev.next=null;
        return tail;
        
    }
}