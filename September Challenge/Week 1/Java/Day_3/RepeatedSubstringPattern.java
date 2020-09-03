// Problem : https://leetcode.com/problems/repeated-substring-pattern/
// Solution:

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int len=n/2;len>0;len--){
            if(n%len==0){
                String pattern = s.substring(0,len);
                int i = len;
                int j = len+i-1;
                while(j<n){
                    String curr= s.substring(i,j+1);
                    if(!curr.equals(pattern)) 
                        break;
                    
                    i+=len;
                    j+=len;
                }
                if(i==n) return true;
            }
        }
        return false;
    }
}
