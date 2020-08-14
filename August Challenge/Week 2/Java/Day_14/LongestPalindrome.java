// Problem : https://leetcode.com/problems/longest-palindrome/
// Solution:

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for(char c : s.toCharArray()){
            arr[(int)c]++;
        }
        int result=0;
        for(int i : arr){
            result+=(i%2==0)? i:i-1;
        }
        return (result==s.length())?result:result+1;
    }
}
