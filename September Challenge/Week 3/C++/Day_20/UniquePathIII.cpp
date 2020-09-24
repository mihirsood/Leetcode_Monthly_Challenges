class Solution {
public:
    int sx, sy, ex, ey, numsZero = 0, n, m, res = 0;
    vector<vector<bool>> vis;
    
    vector<int> x = {1, 0, -1, 0};
    vector<int> y = {0, 1, 0, -1};
    
    void helper(vector<vector<int>>& grid, int r, int c, int val){
        if(r == ex && c == ey){
           if(val == numsZero+1) res++;
            return;
        }
        
        for(int i=0;i<4;i++){
            int xx = r+x[i];
            int yy = c+y[i];
            
            if(xx>=0 && xx<n && yy>=0 && yy<m && !vis[xx][yy] && grid[xx][yy] != -1){
                vis[xx][yy] = true;
                helper(grid, xx, yy, val+1);
                vis[xx][yy] = false;
            }
        }
        
        return;
    }
    
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        n = grid.size();
        m = grid[0].size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) numsZero++;
                else if(grid[i][j] == 1){
                    sx = i, sy = j;
                }
                else if(grid[i][j] == 2){
                    ex = i, ey = j;
                }
            }
        }
        
        
        vis.resize(n, vector<bool>(m, 0));
        
        vis[sx][sy] = 1;
        helper(grid, sx, sy, 0);
        
        return res;
    }
};
