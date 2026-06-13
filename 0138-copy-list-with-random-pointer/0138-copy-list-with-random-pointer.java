/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        HashMap<Node,Node> mp=new HashMap<>();
        Node curr=head,newNode=null,prev=null;

        while(curr!=null){
            Node temp=new Node(curr.val);
            mp.put(curr,temp);

            if(newNode==null){
                newNode = temp;
                prev=newNode;
            }
            else{
                prev.next=temp;
                prev=temp;
            }

            curr=curr.next;
        }

        curr=head;
        Node newCurr=newNode;

        while(curr!=null && newCurr!=null){
            if(curr.random==null){
                newCurr.random=null;
            }
            else{
                newCurr.random=mp.get(curr.random);
            }

            curr=curr.next;
            newCurr=newCurr.next;
        }

        return newNode;
    }
}