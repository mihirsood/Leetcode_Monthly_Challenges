// Problem : https://leetcode.com/problems/number-complement/
// Solution:

class Solution {
    public int findComplement(int num) {
        int count=0;
        
        int n = num;
        while(n>0){
            count++;
            n=n>>1;
        }
        
        while(count>0){
            n=n<<1|1;
            count--;
        }
        return n-num;
    }
}
