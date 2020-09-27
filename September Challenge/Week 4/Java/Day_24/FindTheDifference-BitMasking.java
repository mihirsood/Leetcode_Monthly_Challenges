// Problem : https://leetcode.com/problems/find-the-difference/
// Solution:

class Solution {
    public char findTheDifference(String s, String t) {
        char mask=t.charAt(t.length()-1);
        
        for(int i=0;i<s.length();i++){
            mask^=s.charAt(i);
            mask^=t.charAt(i);
        }
        
        return mask;
    }
}
