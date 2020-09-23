// Problem : https://leetcode.com/problems/length-of-last-word/
// Solution:

class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null) return 0;
        String[] arr = s.split(" ");
        if(arr.length==0) return 0;
        return arr[arr.length-1].length();
    }
}
