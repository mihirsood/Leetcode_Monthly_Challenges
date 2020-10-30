// Problem : https://leetcode.com/problems/first-unique-character-in-a-string/
// Solution:

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for(char c:arr){
            freq[c-'a']++;
        }
        
        for(int i=0;i<arr.length;i++){
            if(freq[arr[i]-'a']==1)
                return i;
        }
        return -1;
    }
}
