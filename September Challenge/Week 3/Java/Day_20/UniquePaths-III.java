// Problem : https://leetcode.com/problems/unique-paths-iii/
// Solution:

class Solution {
    int res;
    int remain;
    public int uniquePathsIII(int[][] grid) {
        remain=1;
        int start_row=0,start_col=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    remain++;
                }else if(grid[i][j]==1){
                    start_row=i;
                    start_col=j;
                }
            }
        }
        res=0;
        dfs(grid,start_row,start_col);
        return res;
    }
    private void dfs(int[][] grid,int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]<0) 
            return;
        
        if(grid[r][c]==2){
            if(remain==0)
                res++;
            return;
        }
        
        grid[r][c]=-2;
        remain--;
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        grid[r][c]=0;
         remain++;
        
    }
}
