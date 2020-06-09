
class Solution {
public:
    bool isSubsequence(string s, string t) {

        int m= s.length()+1;
        int n= t.length() +1;

        vector<vector<int>> A;
        for(int i=0;i<m;i++){
            vector<int> v(n,0);
            A.push_back(v);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(t[j-1]==s[i-1]){
                    A[i][j]=A[i-1][j-1]+1;
                }else{
                    A[i][j]=max(A[i-1][j],A[i][j-1]);
                }
            }
        }
        if(A[m-1][n-1]==s.length()){
            return true;
        }else{
            return false;
        }
    }
};
