// Problem: https://leetcode.com/problems/add-binary/
// Solution:
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        
        while(i>=0 || j>=0){
            int a1=0,b1=0;
            if(i>=0) a1 = a.charAt(i--)-'0';
            if(j>=0) b1 = b.charAt(j--)-'0';
            int sum = a1 + b1 + carry;
            carry = sum/2;
            sum = sum%2;
            sb.append(sum);
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}
