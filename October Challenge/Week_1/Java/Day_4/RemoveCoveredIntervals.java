// Problem: https://leetcode.com/problems/remove-covered-intervals/
//Solution:

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
        int count=0;
        int s=0;
        int f=1;
        int n=intervals.length;
        while(s<n && f<n){
            while(f<n && ((intervals[s][0]<=intervals[f][0]) && (intervals[s][1]>=intervals[f][1]))){
                f++;
                count++;
            }
            s=f;
            f++;
        }
        return n-count;
    }
}