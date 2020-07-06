//Problem :https://leetcode.com/problems/plus-one/
//Solution:
class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i = digits.length - 1 ; i>=0 ;i--){
            if(carry==1){
                int sum = digits[i]+carry;
                digits[i]=sum%10;
                carry=(sum>=10)?1:0;
            }
            if(carry==0) break;
        }
        
        if(carry==1){
            int[] res = new int[digits.length+1];
            res[0]=1;
            for(int i=1;i<res.length;i++){
                res[i]=digits[i-1];
            }
            return res;
        }
        return digits;
    }
}
