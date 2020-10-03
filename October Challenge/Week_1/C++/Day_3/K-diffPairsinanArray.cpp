class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        set<pair<long long int,long long int>> s;
        sort(nums.begin(),nums.end());
    
        for(int i=0;i<nums.size()-1;i++){
            for(int j=i+1;j<nums.size();j++){
                long long int val = nums.at(j)-nums.at(i);
                if(val==k){
                    s.insert({nums.at(i),nums.at(j)});
                }else
                    if(val>k){
                        break;
                    }
            }
        }
        // for(auto c: s){
        //     cout<<c.first<<" "<<c.second<<endl;
        // }
        return s.size();
    }
};
