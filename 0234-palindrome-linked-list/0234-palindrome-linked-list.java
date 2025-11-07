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
    ListNode mid=middle(curr);
    ListNode rev = reverse(mid);

       while(rev!=null){
            if(curr.val!=rev.val){
                return false;
            }
            curr=curr.next;
            rev=rev.next;
       }
       return true;
    }

    ListNode middle(ListNode head){
        
        ListNode slow=head;
        ListNode fast=head;
         
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
        

    ListNode reverse(ListNode head){
        ListNode curr=head , prev=null , temp=null;
            while(curr!=null){
                temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }

        return prev;   
    }
}