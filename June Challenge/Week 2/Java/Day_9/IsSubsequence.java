//Problem:https://leetcode.com/problems/is-subsequence/
//Solution:
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        char a=s.charAt(0);
        for(int i=0;i<t.length();i++){
            if(a==t.charAt(i)){
                s=s.substring(1);
                t=t.substring(i+1);
                return isSubsequence(s,t);
            }
        }
        return false;
    }
}
