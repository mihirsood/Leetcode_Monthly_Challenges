// Problem : https://leetcode.com/problems/valid-parenthesis-string/
// Solution:
class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int count=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else if(count>0){
                    count--;
                }else{
                    return false;
                }
            }else{
                count++;
                if(!stack.isEmpty()){
                    stack.pop();
                    count++;
                }
            }
        }
        return stack.isEmpty();
    }
}
