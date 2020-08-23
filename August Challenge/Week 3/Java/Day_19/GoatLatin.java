// Problem : https://leetcode.com/problems/goat-latin/
// Solution:

class Solution {
    public String toGoatLatin(String S) {
        String[] str = S.split(" ");
        StringBuilder res = new StringBuilder();
        StringBuilder a = new StringBuilder("a");
        for(String s : str){
            
            char ch = s.charAt(0);
            StringBuilder curr = new StringBuilder(s);
            
            if(!(ch=='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u' || 
               ch =='A' || ch =='E' || ch =='I' || ch =='O' || ch =='U' )){
                curr.deleteCharAt(0);
                curr.append(ch);
            }
            
            curr.append("ma");
            curr.append(a.toString());
            
            res.append(curr.toString()+" ");
            a.append("a");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}
