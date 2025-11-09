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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer>sc=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            sc.add(temp.val);
            temp=temp.next;
        }

        Collections.sort(sc);
        temp=head;
        int i=0;
        while(temp!=null){
            temp.val=sc.get(i);
            i++;
            temp=temp.next;

        }
        return head;
    }
}