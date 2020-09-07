// Problem : https://leetcode.com/problems/word-pattern/
// Solution:

class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(str==null || pattern == null || pattern.length()==0 || str.length()==0) return false;
        String[] s = str.split(" ");
        if(s.length!=pattern.length())  return false;
        HashMap<Character,String> map = new HashMap<>();
        
        for(int i=0;i<s.length;i++ ){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                if(!map.containsValue(s[i]))
                    map.put(ch,s[i]);
                else
                    return false;
            }else{
                if(!map.get(ch).equals(s[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
