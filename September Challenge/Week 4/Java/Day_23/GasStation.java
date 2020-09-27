// Problem : https://leetcode.com/problems/gas-station/
// Solution:
public class Solution {
           public int canCompleteCircuit(int[] gas, int[] cost) {
            for (int i=0; i<gas.length; i++) {
                if (canCompleteCircuit(i, gas, cost)) {
                    return i;
                }
            }
            return -1;
        }
    
        private boolean canCompleteCircuit(int start, int[] gas, int[] cost) {
            int gasRemaining = gas[start];
            int currDest = start;
            int nextDest = (start+1) % gas.length;
    
            while (nextDest != start) {
                if (gasRemaining < cost[currDest]) {
                    return false;
                } else {
                    gasRemaining -= cost[currDest];
                    currDest = nextDest;
                    nextDest = (nextDest+1) % gas.length;
                    gasRemaining += gas[currDest];
                }
            }
    
            return gasRemaining >= cost[currDest];
        }
}
