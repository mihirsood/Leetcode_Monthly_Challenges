//Problem:https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
//Solution

class Solution {
    public Random r;
    public int[] csum;

    public Solution(int[] w) {
        csum=w.clone();
        r=new Random();
        
        for(int i=1;i<w.length;i++){
            csum[i]+=csum[i-1];
        }
        
    }
    
    public int pickIndex() {
        int rn=r.nextInt(csum[csum.length-1])+1;
        int left=0;
        int right=csum.length-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            if(rn==csum[mid]){
                return mid;
            }else if(rn<csum[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return left;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
