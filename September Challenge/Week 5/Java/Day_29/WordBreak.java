// Problem : https://leetcode.com/problems/word-break/
// Solution:

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] dp = new boolean[len+1];
        dp[0]=true;
        HashSet<String> set=new HashSet<>();
        set.addAll(wordDict);
        
        for(int i=1;i<=len;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}