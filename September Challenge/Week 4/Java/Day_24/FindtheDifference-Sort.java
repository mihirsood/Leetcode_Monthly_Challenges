// Problem : https://leetcode.com/problems/find-the-difference/
// Solution:
class Solution {
    public char findTheDifference(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for(int i=0;i<sa.length;i++){
            if(sa[i]!=ta[i]){
                return ta[i];
            }
        }
        return ta[ta.length-1];
    }
}
