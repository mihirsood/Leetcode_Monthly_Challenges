//Problem:https://leetcode.com/problems/arranging-coins/
//Solution:
class Solution {
    public int arrangeCoins(int n) {
        long l = 0,r=n;
        long m,val;
        while(l<=r){
            m=l+(r-l)/2;
            val=m*(m+1)/2;
            
            if(val==n) return (int)m;
            
            if(val<n) l = m + 1;
            else r = m - 1;
        }
        return (int)r;
    }
}
