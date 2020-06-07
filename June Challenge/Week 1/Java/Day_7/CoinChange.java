//problem:https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/

class Solution {
    public int change(int amount, int[] coins) {
        int[] strg= new int[amount+1];
        strg[0]=1;
        
        for(int i=0;i<coins.length;i++){
            //iterates over the coins to be used
            for(int val=1;val<strg.length;val++){
                //checks which possible ways to attain a total of val
                if((val-coins[i])<0){
                    continue;
                }
                strg[val]=strg[val]+strg[val-coins[i]];
            }
        }
        
        return strg[amount];
    }
}
//Time Complexity:O(total*n)
//Space Complexity:O(total)
//where n=coins.length
