// Problem : https://leetcode.com/problems/perform-string-shifts/
// Solution:

class Solution {
    public String stringShift(String s, int[][] shift) {
        int tot = 0;
        int len = s.length();
        for(int[] arr: shift){
            if(arr[0]==0){
                tot-=arr[1];
            }else{
                tot+=arr[1];
            }
        }
        tot=tot%len;
        if(tot==0){
            return s;
        }
        int pivot=0;
        
        if(tot>0)
            pivot=len-tot;
        else
            pivot=-tot;
        return s.substring(pivot)+s.substring(0,pivot);
    }
}
