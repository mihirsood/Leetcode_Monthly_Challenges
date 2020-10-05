// Problem : https://leetcode.com/problems/complement-of-base-10-integer/
// Solution:

class Solution {
    public int bitwiseComplement(int N) {
        if(N==0) return 1;
        
        int count=0;
        int n=N;
        while(n>0){
            count++;
            n=n>>1;
        }
        n=0;
        while(count>0){
            n=n<<1|1;
            count--;
        }
        return n-N;
    }
}