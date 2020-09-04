// Problem : https://leetcode.com/problems/partition-labels/
// Solution:

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        
        int[] last = new int[26];
        for(int i = 0; i<S.length();i++){
            last[S.charAt(i)-'a'] = i;
        }
        
        int prev = -1;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<S.length();i++){
            char ch = S.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }
            if(i==last[ch-'a']){
                set.remove(ch);
            }
            if(set.size()==0){
                res.add(i-prev);
                prev = i;
            }
        }
        return res;
    }
}
