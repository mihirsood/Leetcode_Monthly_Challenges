// Problem : https://leetcode.com/problems/sort-array-by-parity/
// Solution:

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int s = 0;
        int e = res.length-1;
        for(int a : A){
            if(a%2==0){
                res[s]=a;
                s++;
            }else{
                res[e]=a;
                e--;
            }
        }
        return res;
    }
}
