// Problem : https://leetcode.com/problems/teemo-attacking/
// Solution:

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = 0;
        int end=0;
        int time=0;
        for(int t : timeSeries){
            if(end<=t){
                time+=end-start;
            }else{
                time+=t-start;
            }
            start=t;
            end=t+duration;
        }
        time+=end-start;
        return time;
    }
}
