// Problem : https://leetcode.com/problems/remove-duplicate-letters/
// Solution:

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch){
            count[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for(char c : ch){
            count[c-'a']--;
            if(visited[c-'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>c && count[stack.peek()-'a']>0){
                visited[stack.peek()-'a']=false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a']=true;
        }
        StringBuilder res = new StringBuilder();
        for(char c:stack){
            res.append(c);
        }
        return res.toString();
    }
}