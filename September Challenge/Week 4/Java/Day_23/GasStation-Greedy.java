// Problem : https://leetcode.com/problems/gas-station/
// Solution:
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0;
        int index=0;
        int tot=0;
        for(int i=0;i<gas.length;i++){
            int curr=gas[i]-cost[i];
            tot+=curr;
            tank+=curr;
            if(tank<0){
                index=i+1;
                tank=0;
            }
        }
        return tot>=0?index:-1;
    }
}
