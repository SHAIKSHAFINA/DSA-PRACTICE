class LRUCache {
    class Node{
        int key;
        int val;
        Node next,prev;
        Node(int _key,int _val){
            key=_key;
            val=_val;
        }
    }

    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    HashMap<Integer,Node>mp=new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }

    void addNode(Node newNode){
        Node temp=head.next;
        newNode.next=temp;
        newNode.prev=head;
        head.next=newNode;
        temp.prev=newNode;
    }

    void deleteNode(Node delNode){
        Node delPrev=delNode.prev;
        Node delNext=delNode.next;
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }
    
    public int get(int key_) {
        if(mp.containsKey(key_)){
            Node resNode=mp.get(key_);
            int res=resNode.val;

            mp.remove(key_);
            deleteNode(resNode);
            addNode(resNode);
            mp.put(key_,head.next);
            return res;
        }
        return -1;
    }
    
    public void put(int key_, int value) {
        if(mp.containsKey(key_)){
            Node del=mp.get(key_);
            mp.remove(key_);
            deleteNode(del);
        }

        if(mp.size()==cap){
            mp.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key_,value));
        mp.put(key_,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */