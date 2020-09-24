class Solution {
public:

int helper(vector<vector<int>> &A,vector<vector<int>> &B_padded,int xshift,int yshift)
{
    int x=0;
    
    for(int i=0;i<A.size();i++)
    {
        for(int j=0;j<A[0].size();j++)
        {
            x+=A[i][j]*B_padded[i+yshift][j+xshift];
        }
    }
    
    return x;
    
}

int largestOverlap(vector<vector<int>>& A, vector<vector<int>>& B) {
    
    
    int n=A.size();
    
    vector<vector<int>> B_padded(3*n-2,vector<int>(3*n-2,0));
    
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            B_padded[i+n-1][j+n-1]=B[i][j];
        }
    }
    
    int result=0;
    
    for(int xshift=0;xshift<2*n-1;xshift++)
    {
        for(int yshift=0;yshift<2*n-1;yshift++)
        {
            result=max(result,helper(A,B_padded,xshift,yshift));
        }
    }
    
    return result;
    
}
};
