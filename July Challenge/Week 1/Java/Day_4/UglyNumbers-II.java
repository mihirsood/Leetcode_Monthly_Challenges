// Problem:https://leetcode.com/problems/ugly-number-ii/
//Solution:
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0]=1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<n;i++){
            ugly[i] = Math.min(ugly[i2]*2,Math.min(ugly[i3]*3,ugly[i5]*5));
            
            if(ugly[i]==ugly[i2]*2) i2++;
            if(ugly[i]==ugly[i3]*3) i3++;
            if(ugly[i]==ugly[i5]*5) i5++;
        }
        return ugly[n-1];
    }
}
