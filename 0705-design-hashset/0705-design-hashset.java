class MyHashSet {
    HashSet<Integer>sc;

    public MyHashSet() {
        sc=new HashSet<>();
    }
    
    public void add(int key) {
        sc.add(key);
    }
    
    public void remove(int key) {
        sc.remove(key);
    }
    
    public boolean contains(int key) {
        if(sc.contains(key)) return true;

        return false;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */