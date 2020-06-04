//Problem:https://leetcode.com/submissions/detail/348472476/
//Solution:
class Solution {
    public int twoCitySchedCost(int[][] costs) {
       int n = costs.length/2;
       int[] diff = new int[2*n];
        int tot=0;
        for(int i=0;i<costs.length;i++){
            diff[i]=costs[i][1]-costs[i][0];
            tot+=costs[i][0];
        }
        Arrays.sort(diff);
        for(int i=0;i<n;i++){
            tot+=diff[i];
        }
        return tot;
    }
}
