// Problem : https://leetcode.com/problems/backspace-string-compare/
// Solution:
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();
        
        for(int i = 0;i<S.length();i++){
            char c = S.charAt(i);
            if(c!='#')
                s1.push(c);
            else{
                if(s1.isEmpty())
                    continue;
                s1.pop();
            }
        }
        
        for(int i = 0;i<T.length();i++){
            char c = T.charAt(i);
            if(c!='#')
                t1.push(c);
            else{
                if(t1.isEmpty())
                    continue;
                t1.pop();
            }
        }
        if(s1.size()!=t1.size()) return false;
        while(!s1.isEmpty()){
            if(s1.pop()!=t1.pop()) return false;
        }
        return true;
    }
}
