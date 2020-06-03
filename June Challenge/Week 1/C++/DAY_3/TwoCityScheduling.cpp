
bool diff(vector<int> i , vector<int> j){
    return (i[0]-i[1])<(j[0]-j[1]);
}

class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {

        sort(costs.begin(),costs.end(),diff);

        int len = costs.size()/2;
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=costs[i][0];
        }
        for(int j=len;j<costs.size();j++){
            sum+=costs[j][1];
        }
        return sum;
    }
};
