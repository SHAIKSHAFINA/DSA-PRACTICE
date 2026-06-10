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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1=list1 , curr2=list2;
        if(curr1==null && curr2==null){
            return null;
        }

        if(curr1==null){
            return curr2;
        }

        if(curr2==null){
            return curr1;
        }

        ListNode head=null;
        ListNode curr=head;

        if(curr1.val<curr2.val){
            head=curr1;
            curr1=curr1.next;
            curr=head;
        }
        else{
            head=curr2;
            curr2=curr2.next;
            curr=head;
        }

        while(curr1!=null && curr2!=null){
            if(curr1.val>curr2.val){
                head.next=curr2;
                head=head.next;
                curr2=curr2.next;
            }
            else{
                head.next=curr1;
                head=head.next;
                curr1=curr1.next;
            }
        }

        while(curr1!=null){
            head.next=curr1;
            head=head.next;
            curr1=curr1.next;
        }

        while(curr2!=null){
             head.next=curr2;
             head=head.next;
            curr2=curr2.next;
        }

        return curr;
    }
}