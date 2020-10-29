// Problem : https://leetcode.com/problems/jewels-and-stones/
// Solution:

class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[256];
        for(char c:J.toCharArray()){
            jewels[c]=true;
        }
        int count=0;
        for(char c:S.toCharArray()){
            if(jewels[c])
                count++;
        }
        return count;
    }
}
