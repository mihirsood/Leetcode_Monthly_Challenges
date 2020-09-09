class Solution {
public:
    int compareVersion(string version1, string version2) {
        string token;
        stringstream s(version1);
        vector<long long int> v1;
        while(getline(s , token , '.')){
            v1.push_back(stoll(token));
        }
        stringstream s2(version2);
        vector<long long int> v2;
        while(getline(s2 , token , '.')){
            v2.push_back(stoll(token));
        }
        
        // cout<<endl;
        if(v1.size()!=v2.size()){
            while(v1.size()!=v2.size()){
                if(v1.size()>v2.size()){
                    v2.push_back(0);
                }else
                if(v1.size()<v2.size()){
                    v1.push_back(0);
                }
            }
        }
        
        // for(auto c:v1){
        //     cout<<c<<" ";
        // }
        // cout<<endl;
        // for(auto c:v2){
        //     cout<<c<<" ";
        // }
        for(int i=0;i<v1.size();i++){
            if(v1[i]>v2[i]){
                return 1;
            }else
            if(v2[i]>v1[i]){
                return -1;
            }
        }
        
        return 0;
    }
};