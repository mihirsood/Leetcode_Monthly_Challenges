//Problem : https://leetcode.com/problems/single-number-ii/
//Solution:
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key)==1)
                return key;
        }
        return -1;
    }
}
