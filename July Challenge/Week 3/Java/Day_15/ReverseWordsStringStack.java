// Problem :https://leetcode.com/problems/reverse-words-in-a-string/submissions/
// Solution:
class Solution {
    class Pair{        
        int start;
        int end;
        Pair(int s,int e){
            this.start=s;
            this.end=e;
        }
    }
    
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        String res = "";
        Stack<Pair> stack = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' ') continue;
            int start = i;
            while((i<s.length())&&(s.charAt(i)!=' '))
                i++;
            int end=i;
            stack.push(new Pair(start,end));
        }
        int size = stack.size();
        while(!stack.isEmpty()){
            Pair collect = stack.pop();
            size-=1;
            res+= s.substring(collect.start,collect.end);
            if(size>0) res+=" ";
        }
        return res;
    }
}
