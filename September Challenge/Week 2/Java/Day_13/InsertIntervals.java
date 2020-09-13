// Problem : https://leetcode.com/problems/insert-interval/
// Solution:

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int sr=newInterval[0];
        int er=newInterval[1];
        
        for(int i=0;i<intervals.length;i++){
            int cs = intervals[i][0];
            int ce = intervals[i][1];
            
            if(ce<sr){
                res.add(intervals[i]);
            }else if(er<cs){
                res.add(new int[]{sr,er});
                sr=cs;
                er=ce;
            }else{
                sr=Math.min(sr,cs);
                er=Math.max(er,ce);
            }
        }
        res.add(new int[]{sr,er});
        return res.toArray(new int[res.size()][]);
    }
}
