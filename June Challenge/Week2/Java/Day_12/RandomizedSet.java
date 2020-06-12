//Problem:https://leetcode.com/problems/insert-delete-getrandom-o1/
//Solution:
class RandomizedSet {
    ArrayList<Integer> arr ;
    HashMap<Integer,Integer> map ;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        arr.add(val);
        map.put(val,arr.size()-1);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int i = map.get(val);
        int n = arr.size()-1;
        int ele = arr.get(n);
        Collections.swap(arr,i,n);
        
        map.put(ele,i);
        map.remove(val);
        
        arr.remove(n);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int i = r.nextInt(arr.size());
        return arr.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
