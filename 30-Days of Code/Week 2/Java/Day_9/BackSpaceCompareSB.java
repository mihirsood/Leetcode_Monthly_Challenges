// Problem : https://leetcode.com/problems/backspace-string-compare/
// Solution:
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return mod(S).equals(mod(T));
    }
    private String mod(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c!='#')
                sb.append(c);
            else if(sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
