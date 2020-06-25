class Solution {
public:
    int findDuplicate(vector<int>& nums) {

        for(auto i: nums){
            nums.at(i%nums.size())+=nums.size();
        }

        int maxV=0 , maxIn=0;
        for(int i=0;i<nums.size();i++){
            if(nums.at(i)>maxV){
                maxV=nums.at(i);
                maxIn=i;
            }
        }
        for(int i=0;i<nums.size();i++){
            nums.at(i)%=nums.size();
        }
        return maxIn;
        return 0;
    }
};
