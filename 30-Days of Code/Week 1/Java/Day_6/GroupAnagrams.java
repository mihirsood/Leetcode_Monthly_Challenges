// Problem : https://leetcode.com/problems/group-anagrams/
// Solution:
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = String.valueOf(arr);
            if(!map.containsKey(ns))
                map.put(ns,new ArrayList<String>());
            map.get(ns).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
