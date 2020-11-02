// Problem : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Solution:

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0) return 0;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int res=1;
        int posn=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=posn){
                continue;
            }
            res++;
            posn=points[i][1];
        }
        return res;
    }
}