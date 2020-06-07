class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(coins.size()==0){
            return (amount==0)?1:0;
        }
        int n=amount+1;
        int m=coins.size();
        vector<vector<int>> A;
        for(int i=0;i<m;i++){
            vector<int> v(n,0);
            A.push_back(v);
        }

        for(int i=0;i<n;i++){
            A[0][i]=(i%coins.at(0)==0)?1:0;
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(coins.at(i)<=j){
                    A[i][j]= A[i-1][j]+ A[i][j-coins[i]];
                }else{
                    A[i][j]=A[i-1][j];
                }
            }
        }

        return A[m-1][n-1];
    }
};
