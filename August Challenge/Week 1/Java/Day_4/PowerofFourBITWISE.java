// Problem :https://leetcode.com/problems/power-of-four/
// Solution:
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        for(int i = 0;i<32;i+=2){
            if((num^(1<<i))==0)  return true;
        }
        return false;
    }
}
