// Problem : https://leetcode.com/problems/excel-sheet-column-number/
// Solution:
class Solution {
    public int titleToNumber(String s) {
        int res=0;
        for(int i = 0; i<s.length() ; i++){
            res=res*26 + (int)(s.charAt(i)-'A'+1);
        }
        return res;
    }
}
