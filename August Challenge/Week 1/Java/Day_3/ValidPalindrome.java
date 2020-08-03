// Problem :https://leetcode.com/problems/valid-palindrome/
// Solution:

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        while(start<end){
            while(start<arr.length && !(Character.isLetter(arr[start])) && !(Character.isDigit(arr[start]))){
                start++;
            }
            while(end>=0 && !(Character.isLetter(arr[end])) && !(Character.isDigit(arr[end]))){
                end--;
            }
            if(start>end) break;
            if(Character.toLowerCase(arr[start])!=Character.toLowerCase(arr[end])) return false;
            start++;
            end--;
        }
        return true;
    }
}
