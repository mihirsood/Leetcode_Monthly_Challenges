//Problem:https://leetcode.com/problems/reverse-string/
//Solution:
class Solution {
    public void reverseString(char[] s) {
        char a;
        int left=0;
        int right=s.length-1;
        while(left<=right){
            a=s[left];
            s[left]=s[right];
            s[right]=a;
            left++;
            right--;
        }
    }
}
