// Problem :https://leetcode.com/problems/reverse-words-in-a-string/
// Solution:
class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length-1;i>=0;i--){
            if(str[i].length()==0) continue;
            sb.append(str[i].trim());
            if(i!=0) sb.append(" ");
        }
        return sb.toString().trim();
    }
}
