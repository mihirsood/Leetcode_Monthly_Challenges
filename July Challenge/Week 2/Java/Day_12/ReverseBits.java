// Problem:https://leetcode.com/problems/reverse-bits/
//Solution:
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==0) return 0;
        int result=0;
        for(int i = 0;i<32;i++){
            result=result<<1;
            if((n&1)==1)
                result++;
            n=n>>1;
        }
        return result;
    }
}
