// Problem :https://leetcode.com/problems/top-k-frequent-elements/
//Solution :
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // Variable/Count
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        
        for(int key:map.keySet()) heap.add(key);
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i]=heap.poll();
        }
        
        return ans;
    }
}
