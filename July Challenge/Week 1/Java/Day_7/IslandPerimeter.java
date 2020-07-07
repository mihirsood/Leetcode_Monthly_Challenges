// Problem:https://leetcode.com/problems/island-perimeter/
//Solution:
class Solution {
    public int islandPerimeter(int[][] grid) {
        // if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res=0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]==1){
                    res+=4;
                    if(i > 0 && grid[i-1][j] == 1) res-=2;
                    if(j > 0 && grid[i][j-1] == 1) res-=2;
                }
            }
        }
        return res;
    }
}
