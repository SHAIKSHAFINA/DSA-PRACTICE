class Node{
        int key;
        int val,cnt;
        Node next,prev;
        Node(int _key,int _val){
            key=_key;
            val=_val;
            cnt=1;
        }
    }
    class DoublyLinkedList{
        int size;
        Node head , tail;

        DoublyLinkedList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void addFront(Node node){
            Node temp=head.next;
            node.next=temp;
            node.prev=head;
            head.next=node;
            temp.prev=node;
            size++;
        }
        void removeNode(Node delNode){
            Node prevNode=delNode.prev;
            Node nextNode=delNode.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            size--;
        }
    }
class LFUCache {
    private Map<Integer,Node>keyNode;
    private Map<Integer,DoublyLinkedList>freqListMap;

    private int maxSizeCache;
    private int minFreq;
    private int curSize;


    public LFUCache(int capacity) {
        maxSizeCache=capacity;
        minFreq=0;
        curSize=0;
        keyNode=new HashMap<>();
        freqListMap=new HashMap<>();
    }

    private void updateFreqListMap(Node node){
        keyNode.remove(node.key);
        freqListMap.get(node.cnt).removeNode(node);

        if(node.cnt == minFreq && freqListMap.get(node.cnt).size ==0){
            minFreq++;
        }

        DoublyLinkedList  nextHigherFreqList = new DoublyLinkedList ();

        if(freqListMap.containsKey(node.cnt + 1)){
            nextHigherFreqList = freqListMap.get(node.cnt + 1);
        }

        node.cnt += 1;

        nextHigherFreqList.addFront(node);
        freqListMap.put(node.cnt , nextHigherFreqList);
        keyNode.put(node.key , node);
    }
    
    public int get(int key) {
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            int val=node.val;
            updateFreqListMap(node);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
         if (maxSizeCache == 0) {
            return;
        }
        if (keyNode.containsKey(key)) {
            
            Node node = keyNode.get(key);
            node.val = value;
            updateFreqListMap(node);
        } else {
            if (curSize == maxSizeCache){  
                DoublyLinkedList  list = freqListMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                freqListMap.get(minFreq).removeNode(list.tail.prev);
                curSize--;
            }
          
            curSize++;
            minFreq = 1; 
            DoublyLinkedList  listFreq = new DoublyLinkedList ();
            if (freqListMap.containsKey(minFreq)) {
                listFreq = freqListMap.get(minFreq);
            }

            Node node = new Node(key, value);
            listFreq.addFront(node);
            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */