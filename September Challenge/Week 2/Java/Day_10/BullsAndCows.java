// Problem : https://leetcode.com/problems/bulls-and-cows/
// Solution:

class Solution {
    public String getHint(String secret, String guess) {
        int bull=0;
        int cows=0;
        char[] s=secret.toCharArray();
        char[] g=guess.toCharArray();
        int[] arr = new int[10]; 
        for(int i=0;i<s.length;i++){
            if(s[i]==g[i]){
                bull++;
            }else{
                if(arr[s[i]-'0']++ < 0) cows++;
                if(arr[g[i]-'0']-- > 0) cows++;
            }
        }
        return bull+"A"+cows+"B";
    }
}
