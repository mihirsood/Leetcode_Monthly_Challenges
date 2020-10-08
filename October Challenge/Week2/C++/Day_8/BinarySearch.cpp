
class Solution {
public:
    
int binarySearch(vector<int> nums , int s , int e , int target){
    if(s>=e){
        if(s==e){
            if(nums[s]==target){
                return s;
            }
        }
        return -1;
    }
    int mid = (s+e)/2;
    if(nums[mid]==target){
        return mid;
    }else
        if(nums[mid]>target){
            return binarySearch(nums , s , mid , target);
        }else
            if(nums[mid]<target){
                return binarySearch(nums , mid+1 , e , target);
            }else{
                return -1;
            }
}

    int search(vector<int>& nums, int target) {
        return binarySearch(nums,0,nums.size()-1 , target);
    }
};
