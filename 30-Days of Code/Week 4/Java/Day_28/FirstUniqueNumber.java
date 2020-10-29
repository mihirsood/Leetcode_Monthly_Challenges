// Problem : https://leetcode.com/problems/first-unique-number/
// Solution:

class FirstUnique {

    private Queue<Integer> queue ;
    private HashMap<Integer, Boolean> unique;
    
    public FirstUnique(int[] nums) {
        queue=new ArrayDeque<>();
        unique=new HashMap<>();
        
        for(int n: nums){
            this.add(n);
        }
    }
    
    public int showFirstUnique() {
        while(!queue.isEmpty() && !unique.get(queue.peek())){
            queue.remove();
        }
         if(queue.isEmpty()){
             return -1;
         }
        return queue.peek();
    }
    
    public void add(int value) {
        if(!unique.containsKey(value)){
            unique.put(value,true);
            queue.add(value);
        }else{
            unique.put(value,false);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
