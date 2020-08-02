// Problem :https://leetcode.com/problems/design-hashset/
// Solution:

class MyHashSet {
    private int numbucket = 15000;
    List<Integer>[] buckets;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=new LinkedList[numbucket];
    }
    private int hash(int key){
        return key%numbucket;
    }
    
    public void add(int key) {
        int i = hash(key);
        if(buckets[i]==null) buckets[i]=new LinkedList<>();
        if(buckets[i].indexOf(key)==-1)
            buckets[i].add(key);
    }
    
    public void remove(int key) {
        int i = hash(key);
        if(buckets[i]==null) return;
        if(buckets[i].indexOf(key)!=-1) buckets[i].remove(buckets[i].indexOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hash(key);
        if(buckets[i]==null || buckets[i].indexOf(key)==-1) return false;
        return true;        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
