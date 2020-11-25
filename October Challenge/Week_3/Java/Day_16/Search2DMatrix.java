// Problem : https://leetcode.com/problems/search-a-2d-matrix/
// Solution:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int m=matrix.length;
        
        if(m==1){
            return binary(matrix[0],target);
        }
        
        for(int i=0;i<m-1;i++){
            if(matrix[i][0]<=target && matrix[i+1][0]>target){
                return binary(matrix[i],target);
            }
        }
        
        return binary(matrix[m-1],target);
    }
    
    private boolean binary(int[] nums, int target){
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return false;
    }
}