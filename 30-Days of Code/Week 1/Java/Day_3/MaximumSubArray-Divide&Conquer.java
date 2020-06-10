class Solution {
    public int maxSubArray(int[] nums) {
        return maxSub(nums,0,nums.length-1);
    }
    private int maxSub(int[] arr, int left, int right){
        if(left==right){
            return arr[left];
        }
        
        int lm=Integer.MIN_VALUE;
        int rm=Integer.MIN_VALUE;
        
        int sum=0;
        int mid=(left+right)/2;
        
        for(int i=mid;i>=left;i--){
            sum+=arr[i];
            if(sum>lm){
                lm=sum;
            }
        }
        
        sum=0;
        for(int i=mid+1;i<=right;i++){
            sum+=arr[i];
            if(sum>rm){
                rm=sum;
            }
        }
        int lsa=maxSub(arr,left,mid);
        int rsa=maxSub(arr,mid+1,right);
        
        return Integer.max(lm+rm,Integer.max(lsa,rsa));
    }
}
