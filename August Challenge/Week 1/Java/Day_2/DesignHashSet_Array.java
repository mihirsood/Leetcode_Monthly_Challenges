// Problem :https://leetcode.com/problems/design-hashset/
// Solution:

class MyHashSet {
    boolean[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key]=true;
    }
    
    public void remove(int key) {
        arr[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arr[key])
            return true;
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
