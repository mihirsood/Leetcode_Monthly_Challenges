class Solution {
public:
    int rob(vector<int>& nums) {
        int sum1 = 0,sum2 = 0;
        for(int i=0;i<nums.size();i++){
            if(!(i&1))sum1=max(sum1+nums[i],sum2);
            else sum2 = max(sum2+nums[i],sum1);
        }
        return max(sum1,sum2);
    }
};
