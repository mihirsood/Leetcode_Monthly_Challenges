class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& inte) {
        
        set<vector<int>> s;
        for(int i=0;i<inte.size();i++){
            int c=inte[i][0];
            int d=inte[i][1];
            bool value=true;
            for(int j=0;j<inte.size();j++){
                if(i==j){
                    continue;
                }else{
                    int a=inte[j][0];
                    int b=inte[j][1];
                    if(c>=a && d<=b){
                        value=false;
                    }
                }
            }
            if(value){
                s.insert(inte[i]);
            }
        }
        return s.size();
        
    }
};
