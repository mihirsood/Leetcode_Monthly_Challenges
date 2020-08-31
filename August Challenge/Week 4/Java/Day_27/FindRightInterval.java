// Problem : https://leetcode.com/problems/find-right-interval/
// Solution:
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        
        int[] initial = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<n;i++){
            initial[i]=intervals[i][0];
            map.put(initial[i],i);
        }
        
        Arrays.sort(initial);
        for(int i = 0; i < n ; i++ ){
            int k=binsrch(initial,map,intervals[i][1]);
            if(k==n){
                res[i]=-1;
            }else if(k==0){
                if(intervals[i][1]<=initial[0]) // found at 0
                    res[i]=map.get(initial[0]);
                else
                    res[i]=-1;
            }else
                res[i]=map.get(initial[k]);
        }
        return res;
    }
    private int binsrch(int[] start, HashMap<Integer,Integer> map, int key){
        int s = 0;
        int e = start.length -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(start[mid]<key){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return s;
    }
}
