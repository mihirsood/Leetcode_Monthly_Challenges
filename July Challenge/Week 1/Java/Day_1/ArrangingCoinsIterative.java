//Problem:https://leetcode.com/problems/arranging-coins/
//Solution:
class Solution {
    public int arrangeCoins(int n) {
        if(n==0) return 0;
        int initial = 1;
        int res = 1;
        n--; // as we added 1 to the result
        while(n>=0){
            res=initial;
            
            initial++;
            n-=initial;
        }
        return res;
    }
}
