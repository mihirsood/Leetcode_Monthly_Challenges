// Problem : https://leetcode.com/problems/longest-palindrome/
// Solution:

class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1) return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0 ;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int count1=0;
        
        for(Character key : map.keySet()){
            int val = map.get(key);
            if(val%2==0){
                result+= val;
            }else{
                result+=val-1;
                count1++;
            }
        }
        return (count1>0)?result+1:result;
    }
}
