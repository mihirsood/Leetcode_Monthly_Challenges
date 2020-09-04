// Problem : https://leetcode.com/problems/partition-labels/
// Solution:

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        
        int[] last = new int[26];
        for(int i = 0; i<S.length();i++){
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = 0;

        for(int i=0; i<S.length();i++){
            end = Math.max(end,last[S.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}
