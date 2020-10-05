// Problem : https://leetcode.com/problems/k-diff-pairs-in-an-array/
// Solution:

class Solution {
    public int findPairs(int[] nums, int k) {
        int res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Integer key : map.keySet()){
            if(k==0){
                if(map.get(key)>=2){
                    res++;
                }
            }else{
                if(map.containsKey(key+k))
                    res++;
            }
        }
        return res;
    }
}