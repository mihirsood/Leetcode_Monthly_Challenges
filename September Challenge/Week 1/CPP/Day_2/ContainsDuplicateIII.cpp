class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {        
        if (k<=0) return false;
        if (k>=nums.size()) k = nums.size()-1;
        set<long long> s;
        for (int i=0; i<nums.size(); i++) {
            if(i > k) s.erase(nums[i-k-1]);
            auto pos1 = s.lower_bound((long long)nums[i]-t);     // cond 1
            //auto pos2 = s.lower_bound((long long)nums[i]+t);  // cond 2
			/* Above line and corresponding condition below are commented because they are not required.
			 * Reason: Range: [n-t .... n .... n+t]
			 * If a number greater than or equal to n-t is found in set and it satisfies the absolute difference in check, we don't need to separately check for n+t.  cond1 is a super-set of cond2
			*/
            if ((pos1 != s.end() && abs(*pos1-nums[i]) <= t)/* || (pos2 != s.end() && abs(*pos2-nums[i]) <= t)*/)
                return true;
            s.insert(nums[i]);
        }
        return false;
    }
}; 

