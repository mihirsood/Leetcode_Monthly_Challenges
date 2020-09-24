class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        vector<int> array(1000,0);
        for(auto c:trips){
            array[c.at(1)-1]+=c.at(0);
            array[c.at(2)-1]-=c.at(0);
        }
        long long int sum=0;
        for(auto c:array){
            sum+=c;
            if(sum>capacity){
                return false;
            }
        }
        return true;
    }
};
