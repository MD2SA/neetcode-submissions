class MyHashSet {

    private boolean[] list;

    public MyHashSet() {
        list = new boolean[1000001];
    }
    
    public void add(int key) {
        list[key] = true;
    }
    
    public void remove(int key) {
        list[key] = false;
    }
    
    public boolean contains(int key) {
        return list[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */