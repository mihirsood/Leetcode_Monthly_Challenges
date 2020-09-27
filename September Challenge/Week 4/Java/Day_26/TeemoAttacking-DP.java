// Problem : https://leetcode.com/problems/teemo-attacking/
// Solution:

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries==null || timeSeries.length==0) return 0;
        int totalTime = 0;
        for(int i = 0; i < timeSeries.length - 1; i++)
            totalTime += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        return totalTime + duration;
    }
}
